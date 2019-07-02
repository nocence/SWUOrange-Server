package com.swuorange.dto;

import java.io.Serializable;

public class SubbaseDelDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	//接收需要删除的id数组
	
	private String list;

	public void setList(String list) {
		this.list = list;
	}

	public String getList() {
		return list;
	}

}
