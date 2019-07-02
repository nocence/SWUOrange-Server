package com.swuorange.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.swuorange.activemq.ActiveMQProducter;
import com.swuorange.cache.SessionCache;
import com.swuorange.dao.SubbaseMapper;
import com.swuorange.dto.Staff;
import com.swuorange.dto.SubbaseDTO;
import com.swuorange.dto.SubbaseDelDTO;
import com.swuorange.dto.SubbaseListDTO;
import com.swuorange.dto.SubbaseSearchDTO;
import com.swuorange.dto.BaseDTOsmall;
import com.swuorange.dto.Result;
import com.swuorange.data.ResultData;
import com.swuorange.po.Subbase;
import com.swuorange.po.User;
import com.swuorange.util.MD5;


@RestController
@RequestMapping("subbase")
public class SubbaseController {
	
	
	@Autowired
	private ActiveMQProducter activeMQProducter;
	@Autowired
	private SubbaseMapper subbaseMapper;

	/**
	 * vue查询二级基地
	 * 
	 * return 二级基地信息
	 */
	@RequestMapping("searchSubbase")
	@ResponseBody
	public List<SubbaseListDTO> searchSubbase(HttpSession session){
		System.out.println("基地列表请求进来了");
		List<SubbaseListDTO> subbases = new ArrayList<SubbaseListDTO>();
		//从session中获取登陆用户的公司id
		User loginUser = (User) session.getAttribute("loginUser");
		int companyinfoId = loginUser.getCompanyinfoId();
		//从数据库查询出所有的二级基地
		subbases = subbaseMapper.querySubbases(companyinfoId);
		System.out.println(subbases);
		return subbases;
	}
	
	//查询不是管理层的该公司所有员工
	@RequestMapping("searchStaff")
	@ResponseBody
	public List<Staff> searchStaff(HttpSession session){
		System.out.println("人员请求进来了");
		List<Staff> staffs = new ArrayList<Staff>();
		//从session中获取登陆用户的公司id
		User loginUser = (User) session.getAttribute("loginUser");
		int companyinfoId = loginUser.getCompanyinfoId();
		//查询本公司所有非管理层的员工
		staffs = subbaseMapper.queryStaffName(companyinfoId);
		return staffs;
	}
	
	//查询该公司旗下所有基地
	@RequestMapping("searchBase")
	@ResponseBody
	public List<BaseDTOsmall> searchBase(HttpSession session){
		List<BaseDTOsmall> bases = new ArrayList<BaseDTOsmall>();
		//从session中获取登陆用户的公司id
		User loginUser = (User) session.getAttribute("loginUser");
		int companyinfoId = loginUser.getCompanyinfoId();
		//查询该公司旗下的所有基地
		bases = subbaseMapper.queryBaseName(companyinfoId);
		return bases;
	}
	
	//模糊查询二级基地，场地
	@RequestMapping("searchSubbasesBlur")
	@ResponseBody
	public List<Subbase> searchSubbaseBlur(HttpSession session,SubbaseSearchDTO search){
		System.out.println("模糊查询场地请求进来了");
		User loginUser = (User) session.getAttribute("loginUser");
		int companyinfoId = loginUser.getCompanyinfoId();
		String subbaseName = search.getSubbaseName();
		//从数据库查询出所有的二级基地
		List<Subbase> subbases = subbaseMapper.querySubbasesBlur(subbaseName,companyinfoId);
		System.out.println(subbases.size());
		return subbases;
		
	}
	
	
	//新建场地（二级基地）
	@RequestMapping("insert")
	@ResponseBody
	public Result insert(SubbaseDTO subbase,HttpSession session){
		//从session中获取登陆用户的公司id
		System.out.println("新建场地请求进来了");
		User loginUser = (User) session.getAttribute("loginUser");
		//根据场地负责人查找到staff表中的id
		Integer pcId = subbaseMapper.queryStaffId(subbase.getPrincipal());
		//根据生产记录者查找到staff表中的id
		Integer prId = subbaseMapper.queryStaffId(subbase.getProductionRecorder());
		subbase.setSubbasePCStaffId(pcId);
		subbase.setSubbasePRStaffId(prId);
		subbase.setRoleId(3);
		subbase.setCompanyinfoId(loginUser.getCompanyinfoId());
		subbase.setSubbasePRpwd(MD5.convert32(subbase.getSubbasePRpwd()));
		JSONObject json = new JSONObject();
		json.put("obj", subbase);
		json.put("objType", "Subbase");
		json.put("opeartion", "insert");
		json.put("sid", session.getId());
		activeMQProducter.sendMessage(json.toString());
		SessionCache.sessionCache.put(session.getId(), session);
		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		return result ;
	}
	
	//更新场地（二级基地）
	@RequestMapping("update")
	@ResponseBody
	public Result update(SubbaseDTO subbase,HttpSession session){
		//从session中获取登陆用户的公司id
		System.out.println("更新场地请求进来了");
		//从二级基地关系表中查询userId
		Integer userId = subbaseMapper.querySssUserId(subbase.getSubbaseId());
		subbase.setUserId(userId);
		//根据场地负责人查找到staff表中的id
		Integer pcId = subbaseMapper.queryStaffId(subbase.getPrincipal());
		//根据生产记录者查找到staff表中的id
		Integer prId = subbaseMapper.queryStaffId(subbase.getProductionRecorder());
		subbase.setSubbasePCStaffId(pcId);
		subbase.setSubbasePRStaffId(prId);
		
		JSONObject json = new JSONObject();
		json.put("obj", subbase);
		json.put("objType", "Subbase");
		json.put("opeartion", "update");
		json.put("sid", session.getId());
		activeMQProducter.sendMessage(json.toString());
		SessionCache.sessionCache.put(session.getId(), session);
		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		return result ;
	}
	

	//删除二级基地=场地
	@RequestMapping("deleteSubbase")
	@ResponseBody
	public Result deleteSubbase(SubbaseDTO subbase,HttpSession session){
		System.out.println("删除场地请求进来了");
		//根据场地名称和场地地址查询场地id
		Subbase subbase1 = subbaseMapper.querySubbaseId(subbase.getSubbaseName(),subbase.getSubbaseAddress());
		subbase.setSubbaseId(subbase1.getSubbaseId());
		//根据生产者记录者查询user表中id
		Integer userId = subbaseMapper.queryUserId(subbase.getProductionRecorder());
		subbase.setUserId(userId);
		JSONObject json = new JSONObject();
		json.put("obj", subbase);
		json.put("objType", "Subbase");
		json.put("opeartion", "deleteSubbase");
		json.put("sid", session.getId());
		SessionCache.sessionCache.put(session.getId(), session);
		activeMQProducter.sendMessage(json.toString());
		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		return result;
	}
	
	//批量删除二级基地
	@RequestMapping("deleteSubbases")
	@ResponseBody
	public Result deleteSubbases(SubbaseDelDTO delSubbase,HttpSession session){
		System.out.println("批量删除场地请求进来了");
		JSONObject json = new JSONObject();
		json.put("obj", delSubbase);
		json.put("objType", "Subbase");
		json.put("opeartion", "deleteSubbases");
		json.put("sid", session.getId());
		SessionCache.sessionCache.put(session.getId(), session);
		activeMQProducter.sendMessage(json.toString());
		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		return result;
	}
	

}
