package com.swuorange.dto;

import java.io.Serializable;
/*
 * 
* @Description: 该类的描述基地删除的传输对象
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年3月10日 下午3:15:01
 */
public class BaseDelDTO implements Serializable {

	private static final long serialVersionUID = -645115161657992827L;
	
	//接收需要删除的id数组
	
	private String list;

	public void setList(String list) {
		this.list = list;
	}

	public String getList() {
		return list;
	}

	
	
	
	
}
