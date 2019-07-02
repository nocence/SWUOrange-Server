package com.swuorange.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.swuorange.dto.RM;
import com.swuorange.dto.Result;
import com.swuorange.dto.Ztree;
import com.swuorange.dto.ZtreeDTO;
import com.swuorange.po.Menu;
import com.swuorange.po.Role;
import com.swuorange.service.MenuService;
import com.swuorange.service.RMService;
import com.swuorange.service.RoleService;

/*
 * 
* @Description: 该类的描述 用于后台管理用户角色-菜单的管理
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年3月7日 下午4:25:30
 */
@RequestMapping("manager")
@RestController
public class ManagerRoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private MenuService menuService;
	
	
	@Autowired
	private RMService rmService;

	/*
	 * 
	 * @Description: 该方法 查询所有的角色 加载ztree
	 *
	 * @return
	 * 
	 * @return：返回值描述
	 * 
	 * @version: v1.0.0
	 * 
	 * @author: Randy
	 * 
	 * @date: 2019年3月7日 下午4:43:42
	 */
	@RequestMapping("getRolesTree")
	public ZtreeDTO getRolesTree() {
		List<Role> roles = roleService.getRoles();
		
		List<Ztree> t1 = new ArrayList<>();
		List<Ztree> t2 = new ArrayList<>();
		//获取所有用户的角色数,包括没有权限的菜单
		for (Role r : roles) {
			t1.add(new Ztree(r.getId(), 0, r.getRoleName()));
			List<Menu> menus = menuService.queryMenus();
			for (Menu m : menus) {
				if (m.getPid() == 0) {
					t1.add(new Ztree(m.getMenuId() + r.getId() * 100, r.getId(), m.getMenuName()));
				} else {
					t1.add(new Ztree(m.getMenuId() + r.getId() * 1000, m.getPid() + r.getId() * 100, m.getMenuName()));
				}
			}

		}
		
		
		for (Role r : roles) {
			t2.add(new Ztree(r.getId(), 0, r.getRoleName()));
			List<Menu> menus = menuService.queryMenusByRoles(r);
			for (Menu m : menus) {
				if(m.getPid() == 0) {
					t2.add(new Ztree(m.getMenuId()+r.getId()*100, r.getId(), m.getMenuName()));
				}else {
					t2.add(new Ztree(m.getMenuId()+r.getId()*1000, m.getPid()+r.getId()*100, m.getMenuName()));
				}
			}
		}
		ZtreeDTO ztree = new ZtreeDTO();
		ztree.setObj1(t1);
		ztree.setObj2(t2);
		return ztree;
	}

	/*
	 * 
	 * @Description: 该方法 修改对应角色的权限
	 *
	 * @return
	 * 
	 * @return：返回值描述
	 * 
	 * @version: v1.0.0
	 * 
	 * @author: Randy
	 * 
	 * @date: 2019年3月7日 下午4:45:43
	 */
	@RequestMapping(value="/inserRM")
	public Result inserRM(String arrobj) {
		
		JSONArray sss = JSONObject.parseArray(arrobj);
		RM rm = new RM();
		//先将表全部清空
		rmService.emptyRM();
		
		for(int i =0;i<sss.size();i++) {
			JSONObject json =(JSONObject)sss.get(i);
			Integer id = (Integer)json.get("id");
			String name = (String)json.get("name");
			Integer pId = (Integer)json.get("pId");
			
			if (id>100) {
				String id1 = String.valueOf(id);
				Integer roleId = Integer.parseInt(id1.substring(0, 1));
				Integer menuId=null;
				if(id1.endsWith("10")){
					menuId = Integer.parseInt(id1.substring(id1.lastIndexOf("0")-1));
				}else {
					menuId = Integer.parseInt(id1.substring(id1.lastIndexOf("0")));
				}
				
				rm.setRoleid(roleId);
				rm.setMenuid(menuId);
				
				rmService.insertRM(rm);
			}
		}
		
		return null;
	}

}
