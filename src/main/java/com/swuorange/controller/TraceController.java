package com.swuorange.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.swuorange.activemq.ActiveMQProducter;
import com.swuorange.dao.TraceMapper;
import com.swuorange.data.ResultData;
import com.swuorange.dto.ProductDTO;
import com.swuorange.dto.Result;
import com.swuorange.dto.SubbaseSearchDTO;
import com.swuorange.dto.TraceCheckDTO;
import com.swuorange.dto.TraceDTO;
import com.swuorange.po.Admin;
import com.swuorange.po.Subbase;
import com.swuorange.po.User;
import com.swuorange.util.TraceApplyKey;
import com.swuorange.util.TraceKey;

@RestController
@RequestMapping("trace")
public class TraceController {
	
	@Autowired
	private ActiveMQProducter activeMQProducter;
	@Autowired
	private TraceMapper traceMapper;
	
	
	/**
	 * vue查询二级基地
	 * 
	 * return 二级基地信息
	 */
	@RequestMapping("searchTrace")
	@ResponseBody
	public List<TraceDTO> searchSubbase(HttpSession session){
		System.out.println("基地列表请求进来了");
		List<TraceDTO> traces = new ArrayList<TraceDTO>();
		//从session中获取登陆用户的公司id
		User loginUser = (User) session.getAttribute("loginUser");
		int companyinfoId = loginUser.getCompanyinfoId();
		//从数据库查询出所有的二级基地
		traces = traceMapper.queryTraces(companyinfoId);
		System.out.println(traces);
		return traces;
	}
	
	//根据userId查找申请人真实姓名
	@RequestMapping("searchRealname")
	@ResponseBody
	public String searchRealname(HttpSession  session){
		
		User loginUser = (User) session.getAttribute("loginUser");
		String realname = traceMapper.querySearchName(loginUser.getAccount());
		return realname;

	}
	
	
	//模糊查询二级基地，场地
	@RequestMapping("searchTraceBlur")
	@ResponseBody
	public List<TraceDTO> searchSubbaseBlur(HttpSession session,TraceDTO search){
		System.out.println("模糊查询溯源申请请求进来了");
		String bacthId = search.getBacthId();
		//从数据库查询出所有的二级基地
		List<TraceDTO> traces = traceMapper.queryTraceBlur(bacthId);
		return traces;
		
	}
	
	//将申请溯源信息插入表中
	@RequestMapping("insert")
	@ResponseBody
	public Result insert(TraceDTO trace,HttpSession session){
		System.out.println("溯源申请进来了");
		Result result = new Result();
		User loginUser = (User) session.getAttribute("loginUser");
		//设置溯源申请码
		String applicationCode = TraceApplyKey.getTraceApplyCode("SWUO", traceMapper.queryLastCode().substring(4));
		trace.setApplicationCode(applicationCode);
		//查找场地id
		Integer subbaseId = traceMapper.querySubbaseId(trace.getSubbaseName());
		trace.setType(1);
		//查询申请人id
		Integer userId = traceMapper.queryUserId(loginUser.getAccount());
		trace.setUserId(userId);
		//查询产品id
		Integer varietyId = traceMapper.queryVarietyId(trace.getVariety());
		trace.setVarietyId(varietyId);
		trace.setCompanyinfoId(loginUser.getCompanyinfoId());
		JSONObject json = new JSONObject();
		json.put("obj", trace);
		json.put("objType", "trace");
		json.put("opeartion", "insert");
		json.put("sid", session.getId());
		activeMQProducter.sendMessage(json.toString());
		result.setCode(ResultData.SUCCESS_CODE);
		result.setMsg("已提交请稍后");
		return result;
	
	}
	
	//根据溯源码查询产品信息
	@RequestMapping("searchTraceSource")
	@ResponseBody
	public ProductDTO queryProductMsg(TraceDTO search){
		//得到溯源码
		System.out.println("溯源码请求进来了");
		String traceSource = search.getTraceSource();
		ProductDTO productDTO = traceMapper.queryProductMsg(traceSource);
		System.out.println(productDTO);
		return productDTO;

	}
	
	//查询要审批的溯源申请
	@RequestMapping("searchTraceCheck")
	@ResponseBody
	public List<TraceCheckDTO> searchTraceCheck(HttpSession session){
		System.out.println("审查溯源请求进来了");
		List<TraceCheckDTO> traces = new ArrayList<TraceCheckDTO>();
		//从数据库查询出所有的溯源申请
		traces = traceMapper.queryTraceCheck();
		return traces;
	}
	
	//审批溯源申请
	@RequestMapping("checkTrace")
	@ResponseBody
	public Result checkTrace(TraceCheckDTO trace,HttpSession session){
		
		System.out.println("审批溯源申请请求进来了");
		Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
		trace.setManagerId(loginAdmin.getAdminId());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		trace.setReviewTime(df.format(new Date()));
		trace.setTraceSource(TraceKey.getTraceCode(20));
		JSONObject json = new JSONObject();
		json.put("obj", trace);
		json.put("objType", "trace");
		json.put("opeartion", "update");
		json.put("sid", session.getId());
		activeMQProducter.sendMessage(json.toString());
		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		return result;
	}

}
