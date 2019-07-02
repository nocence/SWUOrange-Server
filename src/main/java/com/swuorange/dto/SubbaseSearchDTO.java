package com.swuorange.dto;

import java.io.Serializable;

public class SubbaseSearchDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String subbaseName;

	public String getSubbaseName() {
		return subbaseName;
	}

	public void setSubbaseName(String subbaseName) {
		this.subbaseName = subbaseName;
	}
	

}
