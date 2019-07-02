package com.swuorange.dto;

import java.util.List;

public class Result {
	//状态码
	private	String code;
	//信息
	private	String msg;
	//数据对象
	private	Object obj;
	//List对象1
	private List first;
	//List对象2
	private List second;
	
	public Result(){}

	
	public Result(String code) {
		super();
		this.code = code;
	}


	public Result(String code, String msg, Object obj) {
		super();
		this.code = code;
		this.msg = msg;
		this.obj = obj;
	}
	


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public List getFirst() {
		return first;
	}


	public void setFirst(List first) {
		this.first = first;
	}


	public List getSecond() {
		return second;
	}


	public void setSecond(List second) {
		this.second = second;
	}

}
