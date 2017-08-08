package com.rpm.demo.spring.beans.exception;

public class ParamException extends Exception {
	private static final long serialVersionUID = -8553804854765710736L;
	private String msg = "";
	private String code = "401";
	
	public ParamException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public ParamException(String code, String msg) {
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
