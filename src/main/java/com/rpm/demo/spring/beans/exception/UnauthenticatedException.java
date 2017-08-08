package com.rpm.demo.spring.beans.exception;

/**
 * Created by gc-rise on 2017/7/13.
 */
public class UnauthenticatedException extends Exception {
    private static final long serialVersionUID = -8058821576166932531L;
    private String msg = "";
    private String code = "401";

    public UnauthenticatedException(){
        super();
    }

    public UnauthenticatedException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public UnauthenticatedException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
