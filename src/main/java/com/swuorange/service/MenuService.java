package com.swuorange.service;

import java.util.List;

import com.swuorange.dto.MenuDTO;
import com.swuorange.po.Menu;
import com.swuorange.po.Role;

public interface MenuService {
	
	public List<MenuDTO> queryMenu(int userID);

	public List<Menu> queryMenus();

	public List<Menu> queryMenusByRoles(Role r);

}
