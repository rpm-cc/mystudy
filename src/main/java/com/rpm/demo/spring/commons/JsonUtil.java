package com.rpm.demo.spring.commons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonToken;

public class JsonUtil {
	private static final Logger logger = Logger.getLogger(JsonUtil.class);
	public static Gson gson;
	static {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder = gsonBuilder.enableComplexMapKeySerialization();// 支持Map的key为复杂对象的形式
		// gsonBuilder =
		// gsonBuilder.excludeFieldsWithoutExposeAnnotation();//不导出实体中没有用@Expose注解的属性
		gsonBuilder = gsonBuilder.serializeNulls();
		gsonBuilder = gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss:SSS");// 时间转化为特定格式
		// gsonBuilder = gsonBuilder.setPrettyPrinting();
		gsonBuilder = gsonBuilder.setVersion(1.0);
		gsonBuilder.disableHtmlEscaping();
		gson = gsonBuilder.create();
	}

	/* 将对象转化为json格式,主要可以转化List,Map等对象 */
	public static String toJson(Object obj) {
		if (obj == null) {
			return null;
		}

		String json = "";
		try {
			json = gson.toJson(obj);
		} catch (Exception e) {
			logger.error("toJson(Object)", e);
			logger.error("toJson=" + obj);
			e.printStackTrace();
		}

		return json;
	}

	/* 将json字符串转为某种对象,对象类型由第二个参数指定 */
	public static <T> T format(String json, Class<T> c) {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		Object t = null;
		try {
			t = gson.fromJson(json, c);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (T) t;
	}

	/**
	 * json字符串转list或者map
	 *
	 * @param json
	 * @param typeToken
	 * @return
	 */
	public static <T> T fromJson(String json, TypeToken<T> typeToken) {
		Gson gson = new GsonBuilder()
		/**
		 * 重写map的反序列化
		 */
		.registerTypeAdapter(new TypeToken<Map<String, Object>>() {
		}.getType(), new MapTypeAdapter()).create();
		// MapTypeAdapter是继承了TypeAdapter类，并单独处理Map类型的反序列化。注意：目前只绑定了Map类型，其子类（HashMap）的处理没有变化。具体代码见本文最后或GitHub（发布后会给出地址）。
		return gson.fromJson(json, typeToken.getType());
	}

	public static class MapTypeAdapter extends TypeAdapter<Object> {

		@Override
		public Object read(JsonReader in) throws IOException {
			JsonToken token = in.peek();
			switch (token) {
			case BEGIN_ARRAY:
				List<Object> list = new ArrayList<Object>();
				in.beginArray();
				while (in.hasNext()) {
					list.add(read(in));
				}
				in.endArray();
				return list;

			case BEGIN_OBJECT:
				Map<String, Object> map = new LinkedTreeMap<String, Object>();
				in.beginObject();
				while (in.hasNext()) {
					map.put(in.nextName(), read(in));
				}
				in.endObject();
				return map;

			case STRING:
				return in.nextString();

			case NUMBER:
				/**
				 * 改写数字的处理逻辑，将数字值分为整型与浮点型。
				 */
				double dbNum = in.nextDouble();

				// 数字超过long的最大值，返回浮点类型
				if (dbNum > Long.MAX_VALUE) {
					return dbNum;
				}

				// 判断数字是否为整数值
				long lngNum = (long) dbNum;
				if (dbNum == lngNum) {
					return lngNum;
				} else {
					return dbNum;
				}

			case BOOLEAN:
				return in.nextBoolean();

			case NULL:
				in.nextNull();
				return null;

			default:
				throw new IllegalStateException();
			}
		}

		@Override
		public void write(JsonWriter out, Object value) throws IOException {
			// 序列化无需实现
		}

	}

	public static void main(String[] args) {
		Map map = new HashMap<String, Object>();
		map.put("a", "<input>");
		System.out.print(toJson(map));

	}
}