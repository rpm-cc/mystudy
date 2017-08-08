package com.rpm.demo.spring.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gc-rise on 2017/7/28.
 */
public class User implements Serializable{
    private static final long serialVersionUID = 6099515984012798200L;
    //用户id
    int id ;
    //用户名称
    String name;
    //用户登录名
    String userName;
    //电话号码
    String tel;
    //性别，只有1男，2女
    int sex;
    //密码
    String pwd ;
    //用户描述
    String des;
    //用户状态，1可用，2冻结
    int status ;
    //电子邮箱
    String email;
    //注册时间
    Date date;
    //通知标记（立标杆）
    int noticeFlg;
    //失效时间，统一为2099年12月31日 23点59分59秒
    Date expireDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNoticeFlg() {
        return noticeFlg;
    }

    public void setNoticeFlg(int noticeFlg) {
        this.noticeFlg = noticeFlg;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", tel='" + tel + '\'' +
                ", sex=" + sex +
                ", pwd='" + pwd + '\'' +
                ", des='" + des + '\'' +
                ", status=" + status +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", noticeFlg=" + noticeFlg +
                ", expireDate=" + expireDate +
                '}';
    }
}
