package com.swuorange.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.swuorange.activemq.ActiveMQProducter;
import com.swuorange.cache.SessionCache;
import com.swuorange.data.ResultData;
import com.swuorange.dto.BaseDTO;
import com.swuorange.dto.BaseDelDTO;
import com.swuorange.dto.BaseSearchDTO;
import com.swuorange.po.Base;
import com.swuorange.po.User;
import com.swuorange.dto.PageBean;
import com.swuorange.dto.Result;
import com.swuorange.dto.Staff;
import com.swuorange.service.BaseService;



@RequestMapping("base")
@RestController
public class BaseController {
	
	private static Logger logger = Logger.getLogger(BaseController.class);

	@Autowired
	private BaseService baseService;
	
	@Autowired
	private ActiveMQProducter activeMQProducter;
	/*
	 * 
	* @Description: 该方法 根据搜索条件,以及page的搜索条件搜索基地列表
	*
	* @param search 包含基地名字-起始时间-截止时间
	* @param page 分页对象根据传入的参数进行查询
	* @return 返回分页对象,里面的list里面包含有查询出来的数据
	* @return：返回值描述
	* @version: v1.0.0
	* @author: Randy
	* @date: 2019年3月9日 下午1:45:57
	 */
	@RequestMapping("getBaseList")
	public PageBean<BaseDTO> getBaseList(HttpSession session,BaseSearchDTO search){
		
		PageBean<BaseDTO>  page = new PageBean<BaseDTO>();
		page.setNowPage(search.getNowPage());
		
		//查询当前登录用户
		User loginUser = (User) session.getAttribute("loginUser");
		search.setUserId(loginUser.getUserId());
		List<BaseDTO> baseList = baseService.queryBaseList(search,page);
		page.setList(baseList);
		
		return page;
		
	}
	
	/*
	 * 
	* @Description: 该方法根据前端上传的base id数组进行删除基地信息;
	*
	* @param session
	* @param delBase 接收前端上传的数据对象
	* @return
	* @return：返回值描述
	* @version: v1.0.0
	* @author: Randy
	* @date: 2019年3月10日 下午10:47:48
	 */
	
	@RequestMapping("delBaseList")
	public Result delBaseList(HttpSession session,BaseDelDTO delBase){
		//存放session
		SessionCache.sessionCache.put(session.getId(), session);
		//调用Mq进行删除操作
		JSONObject json = new JSONObject(); 
		json.put("obj", delBase); 
		json.put("objType", "Base");
		json.put("opeartion", "del"); 
		json.put("sid", session.getId());
		activeMQProducter.sendMessage(json.toString());
		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		result.setMsg("系统正在处理请稍后!");
		return result ;
	}
	/*
	 * 
	* @Description: 该方法用于保存或者更新base信息
	*
	* @param session
	* @param base
	* @return
	* @return：返回值描述
	* @version: v1.0.0
	* @author: Randy
	* @date: 2019年3月10日 下午11:25:07
	 */
	@RequestMapping("updateOrInsert")
	public Result updateOrInsert(HttpSession session,Base base){
		logger.error(base);
		SessionCache.sessionCache.put(session.getId(), session);
		//如果为更新的话则原来的company_infoId不为空
		//但是如果为新增的话则需要手动设置
		if(base.getBaseId()==null){
			User loginUser = (User) session.getAttribute("loginUser");
			base.setCompanyinfoId(loginUser.getCompanyinfoId());
		}
		JSONObject json = new JSONObject(); 
		json.put("obj", base); 
		json.put("objType", "Base");
		json.put("opeartion", "updateOrInsert"); 
		json.put("sid", session.getId());
		activeMQProducter.sendMessage(json.toString());
		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		result.setMsg("系统正在处理请稍后!");
		return result ;
	}
	
	/*
	 * 
	* @Description: 该方法 根据名字模糊查询员工
	*
	* @param session
	* @param staff
	* @return
	* @return：返回值描述
	* @version: v1.0.0
	* @author: Randy
	* @date: 2019年3月11日 下午3:12:36
	 */
	@RequestMapping("getStaff")
	public Result getStaff(HttpSession session,Staff staff) {
		User loginUser = (User) session.getAttribute("loginUser");
		staff.setCompanyinfoId(loginUser.getCompanyinfoId());
		logger.error(staff);
		List<Staff> list = baseService.getStaffsByLike(staff);
		Result result=new Result();
		result.setObj(list);
		return result;
		
	}
	
	

}
