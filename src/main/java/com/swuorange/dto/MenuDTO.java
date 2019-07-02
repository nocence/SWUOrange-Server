package com.swuorange.dto;

import java.util.List;

import com.swuorange.po.Menu;

public class MenuDTO {
	
	private Integer menuId;

	private String menuName;

	private String url;
	
	private List<Menu> list;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Menu> getList() {
		return list;
	}

	public void setList(List<Menu> list) {
		this.list = list;
	}
	
	
	
	

}
