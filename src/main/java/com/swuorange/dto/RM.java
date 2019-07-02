package com.swuorange.dto;

public class RM {
	
	
	
	private int id;
	private int menuid;
	private int roleid;
	
	public RM() {
	}
	public RM(int id, int menuid, int roleid) {
		this.id = id;
		this.menuid = menuid;
		this.roleid = roleid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	
}
