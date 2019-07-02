package com.swuorange.service.impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuorange.dao.MenuMapper;
import com.swuorange.dto.MenuDTO;
import com.swuorange.po.Menu;
import com.swuorange.po.Role;
import com.swuorange.service.MenuService;


@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	
	
	@Override
	public List<MenuDTO> queryMenu(int userID) {
		//首先查询一级菜单
		List<MenuDTO> BaseMenu = menuMapper.queryBaseMenu(userID);
		
		//查询他的子菜单
		for (MenuDTO menuDTO : BaseMenu) {
			List<Menu> SubMenu = menuMapper.querySubMenu(userID, menuDTO.getMenuId());
			menuDTO.setList(SubMenu);
		}
		
		return BaseMenu;
	}


	@Override
	public List<Menu> queryMenus() {
		return menuMapper.queryMenus();
	}


	@Override
	public List<Menu> queryMenusByRoles(Role r) {
		return menuMapper.queryMenusByRoles(r);
	}

}
