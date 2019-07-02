package com.swuorange.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.github.pagehelper.PageHelper;
import com.swuorange.activemq.ActiveMQProducter;
import com.swuorange.cache.SessionCache;
import com.swuorange.data.ResultData;
import com.swuorange.dto.BaseDTO;
import com.swuorange.dto.BaseSearchDTO;
import com.swuorange.dto.Page;
import com.swuorange.dto.PageBean;
import com.swuorange.dto.RegUser;
import com.swuorange.dto.Result;
import com.swuorange.dto.Staff;
import com.swuorange.po.User;
import com.swuorange.service.StaffService;
import com.swuorange.service.UserService;
import com.swuorange.util.ClassCompareUtil;
import com.swuorange.util.MD5;
import com.swuorange.util.PagerHelper;





@RestController
@RequestMapping("staff")
public class StaffController {
	@Autowired
	private RedisTemplate redisTemplate;

	
	@Autowired
	private ActiveMQProducter activeMQProducter;

	@Autowired
	private StaffService staffService;
	
	//员工管理,新增员工
	@RequestMapping("addStaff")
	@ResponseBody
	public Result addStaff(Staff staff,HttpServletRequest request,HttpSession session) {
		Result res = null;
		//要判断新增用户的所有值是否为空,合法性
		System.out.println("添加员工的请求进来了");

		//从session中获取登陆用户的公司id
		User loginUser = (User) session.getAttribute("loginUser");
		int companyinfoId= loginUser.getCompanyinfoId();
		if(companyinfoId == 0){
			//当前登陆用户是普通用户
			res=new Result(ResultData.FAIL_CODE,"当前用户是普通用户,没有权限"," ");
			return res;
		}
		//判断从页面获取用户是否有id
	
		//没有这个用户,将信息新增进数据库

		//将用户输入的密码通过MD5加密
		String staffPassword = staff.getStaffPassword();
		staffPassword = MD5.convert32(staffPassword);
		staff.setStaffPassword(staffPassword);
		staff.setCompanyinfoId(companyinfoId);
		JSONObject json = new JSONObject();
		json.put("obj", staff);
		json.put("objType", "Staff");
		json.put("opeartion", "addStaff");
		json.put("sid", session.getId());
		SessionCache.sessionCache.put(session.getId(), session);
		
		System.out.println("将信息发送给mq");
		
		activeMQProducter.sendMessage(json.toString());
		
		//res=new Result(ResultData.SUCCESS_CODE,"添加员工成功",staff);
		return res;
	}
	
	

	
	
	//查询出用户的分页
	@RequestMapping("getStaffList")
	@ResponseBody
	public Result getStaffList(Integer nowPage,HttpSession session,BaseSearchDTO search){
		Result res = null;
		Staff staff =new Staff();
		PageBean<Staff>  page = new PageBean<Staff>();
		page.setNowPage(nowPage);
		
		//查询当前登录用户
		User loginUser = (User) session.getAttribute("loginUser");
		staff.setCompanyinfoId(loginUser.getCompanyinfoId());
		Integer totalRow = staffService.countStaff(staff);
		System.out.println("总条数"+totalRow);
		Integer pageNumber=nowPage;
		page.setNowPage(nowPage);
		page.setPageRow(4);
		page.setTotalRow(totalRow);
		PagerHelper pageHelper = new PagerHelper(totalRow,pageNumber,4);
		pageHelper.setCompanyinfoId(loginUser.getCompanyinfoId());

		List<Staff> staffList = staffService.queryStaffList(pageHelper);
		page.setList(staffList);
		
		if(staffList != null){
			res=new Result(ResultData.SUCCESS_CODE,"查询员工成功",page);
			
		}else{
			res = new Result(ResultData.FAIL_CODE,"查询员工失败","");
		}
		return res;

		
	}

	
	//用户点击编辑提交员工数据
	@RequestMapping("queryStaff")
	@ResponseBody
	public Result queryStaff(Staff staff,HttpSession session) {
		System.out.println("查询当前员工信息的请求进来了"+staff.getStaffId());
		Result res = null;
		Staff dbstaff = staffService.queryStaff(staff);
		if(dbstaff != null){
			res=new Result(ResultData.SUCCESS_CODE,"用户存在,请修改",dbstaff);		
		}else{
			res = new Result(ResultData.FAIL_CODE,"用户不存在","");
		}
		return res;
	}
	
	
	//用户点击提交员工数据
	@RequestMapping("updateById")
	@ResponseBody
	public Result updateById(Staff staff,HttpSession session) {
		
		Result res = null;
		//从数据库查询出当前需要修改的员工
		Staff dbstaff = staffService.queryStaff(staff);
		//判断员工信息不一样
		boolean flag = ClassCompareUtil.compareObject(staff,dbstaff);
		if(!flag){
			res = new Result(ResultData.FAIL_CODE,"请确认修改以后再提交","");
			return res;
		}	

		Integer result = staffService.updateStaff(staff);
		if(result!=0){
			res=new Result(ResultData.SUCCESS_CODE,"修改成功",result);
		}else{
			res = new Result(ResultData.FAIL_CODE,"修改失败","");
		}
		return res;
		
	}
	
	//用户点击删除单独员工数据
	@RequestMapping("delStaff")
	@ResponseBody
	public Result delStaffById(Staff staff,HttpSession session) {
		System.out.println("删除单个员工的请求进来了"+staff.getStaffId());
		Result res = null;
		Integer result = staffService.delStaff(staff);
		
		if(result != 0){
			res = new Result(ResultData.SUCCESS_CODE,"删除成功",result);
		}else{
			res = new Result(ResultData.FAIL_CODE,"删除失败","");
		}
		return res;
	}

	//查询输入框查询用户
	@RequestMapping("query")
	@ResponseBody
	public Result queryStaffByName(Staff staff,HttpSession session) {
		System.out.println("查询单个员工的请求进来了"+staff.getStaffName());
		Result res = null;
		PageBean<Staff>  page = new PageBean<Staff>();
		Staff dbstaff = staffService.queryStaffByName(staff);
		/*List<Staff> staffs =new  ArrayList<Staff>();
		staffs.add(dbstaff);*/
//		page.setList(staffs);
		
		if(dbstaff != null){
			List<Staff> staffs =new  ArrayList<Staff>();
			staffs.add(dbstaff);
			page.setList(staffs);
			res=new Result(ResultData.SUCCESS_CODE,"查询员工成功",page);
			
		}else{
			res = new Result(ResultData.FAIL_CODE,"查询员工失败"," ");
		}
		return res;

	}
	
	
	//批量删除用户
	@RequestMapping("delStaffs")
	@ResponseBody
	public Result delStaffsById(String list,HttpSession session) {
		System.out.println("批量删除用户请求");
		Result res = null;
		if(list == null){
			res = new Result(ResultData.FAIL_CODE);
			return res;
		}
		//前端string转为list
		List l= (List)JSONObject.parseArray(list);		
		int delnum = staffService.delStaffsById(l);
		System.out.println(delnum);
		if(delnum!=0){//从数据库删除成功
			res=new Result(ResultData.SUCCESS_CODE,"数据删除成功",delnum);
		}else{
			res = new Result(ResultData.FAIL_CODE,"数据删除失败"," ");
		}
		return res;

	}
	
}
