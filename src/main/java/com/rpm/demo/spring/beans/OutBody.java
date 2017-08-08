package com.rpm.demo.spring.beans;

/**
 * Created by gc-rise on 2017/7/13.
 */
public class OutBody {

    String status;
    String msg;
    Object body;
    public OutBody(){
        this.status="200";
        this.msg="success";
        this.body="{}";
    }

    public OutBody(Object data){
        this.status="200";
        this.msg="success";
        this.body = data;
    }

    public OutBody(String status,String msg, Object data){
        this.status = status;
        this.msg = msg;
        this.body = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
