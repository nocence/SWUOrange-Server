package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.swuorange.dto.MenuDTO;
import com.swuorange.po.Menu;
import com.swuorange.po.Role;

@Mapper
public interface MenuMapper {

	public List<MenuDTO> queryBaseMenu(int userID);

	public List<Menu> querySubMenu(@Param("userId") int userID,@Param("pid") int pid);

	public List<Menu> queryMenus();

	public List<Menu> queryMenusByRoles(Role r);
}
