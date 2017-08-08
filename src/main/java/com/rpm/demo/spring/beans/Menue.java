package com.rpm.demo.spring.beans;

import java.util.List;

/**
 * Created by gc-rise on 2017/7/25.
 * 记录用户具有的权限。从数据库中获取
 */
public class Menue {


    public int id ;
    public int pid ;
    public String name;
    public String des;
    public String url;
    public String iconCLs;
    public int seq;
    public String type;
    public List<Menue> subMenues;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIconCLs() {
        return iconCLs;
    }

    public void setIconCLs(String iconCLs) {
        this.iconCLs = iconCLs;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Menue> getSubMenues() {
        return subMenues;
    }

    public void setSubMenues(List<Menue> subMenues) {
        this.subMenues = subMenues;
    }
}
