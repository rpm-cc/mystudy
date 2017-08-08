package com.rpm.demo.spring.beans.exception;

public class BusinessException extends Exception {
	private static final long serialVersionUID = -3014950919633340593L;
	private String msg = "系统异常";
	private String code = "500";
	public BusinessException(){
		super();
	}
	
	public BusinessException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public BusinessException(String code, String msg) {
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
