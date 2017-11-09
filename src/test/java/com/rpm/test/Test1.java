package com.rpm.test;

import com.rpm.demo.spring.commons.Signature;
import com.rpm.demo.spring.learn.annotations.Zoo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gc-rise on 2017/8/9.
 */
//首先指定Junit的Runner
@RunWith(SpringJUnit4ClassRunner.class)
//指明配置文件所在
@ContextConfiguration(locations = "classpath:applicationContext.xml")

public class Test1 {
    @Autowired
    Zoo zoo;

    @Test
    public void test() {
        System.out.println(zoo.toString());

    }

    @Test
    public void httptest() {

        BufferedReader in = null;
        String result = "";
        Map<String, String> params=new HashMap<>();
        params.put("accessKey","128");
        String urlString = "http://localhost:8080/request/info";
        //String urlString = "http://www.baidu.com";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            // 设置通用的请求属性
            // conn.setRequestProperty("accept", "*/*");
            // conn.setRequestProperty("connection", "Keep-Alive");
            // conn.setRequestProperty("user-agent",
            //"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");


            conn.setRequestProperty("token",new Signature().postSignature(params.get("accessKey"),Signature.SECRETKEY));
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);

            StringBuffer param = new StringBuffer();
            for (String key : params.keySet()) {
                param.append("&");
                param.append(key).append("=").append(params.get(key));
            }
            conn.getOutputStream().write(param.toString().getBytes());
            conn.getOutputStream().flush();
            conn.getOutputStream().close();

            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }

            System.out.println(result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
