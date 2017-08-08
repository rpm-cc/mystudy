package com.rpm.demo.spring.beans;

/**
 * Created by gc-rise on 2017/7/27.
 * 进行log的组装。进行格式化。为日后的进行分析提比较容易的分析形式。
 */
public class LogBean {

    String msg;

    public LogBean(String msg) {
         this.msg=msg;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "LogBean{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
