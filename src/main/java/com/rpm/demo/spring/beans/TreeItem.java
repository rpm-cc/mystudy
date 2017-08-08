package com.rpm.demo.spring.beans;

import com.rpm.demo.spring.commons.JsonUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gc-rise on 2017/7/28.
 */
public class TreeItem implements Serializable{


    private static final long serialVersionUID = -3275991052463441200L;
    String name;
    String type;
    Map<String,List<TreeItem>> additionalParameters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, List<TreeItem>> getAdditionalParameters() {
        return additionalParameters;
    }

    public void setAdditionalParameters(Map<String, List<TreeItem>> additionalParameters) {
        this.additionalParameters = additionalParameters;
    }



    public static void main(String[] args) {
        TreeItem father = new TreeItem();
        father.setName("scale");
        father.setType("folder");
        Map<String,List<TreeItem>> para = new HashMap<String, List<TreeItem>>();
        List<TreeItem> list = new ArrayList<TreeItem>();
        TreeItem child = new TreeItem();
        child.setName("child1");
        child.setType("item");
        list.add(child);
        list.add(child);
        para.put("children",list);

        father.setAdditionalParameters(para);

        System.out.println(JsonUtil.toJson(father));

    }
}
