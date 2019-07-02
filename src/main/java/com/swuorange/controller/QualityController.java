package com.swuorange.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
import com.swuorange.dto.Page;
import com.swuorange.dto.PageBean;
import com.swuorange.dto.QualityDTO;
import com.swuorange.dto.QualityInfo;
import com.swuorange.dto.RegUser;
import com.swuorange.dto.Result;
import com.swuorange.dto.ResultList;
import com.swuorange.dto.Staff;
import com.swuorange.dto.SubbaseListDTO;
import com.swuorange.dto.VarietyDTO;
import com.swuorange.po.Subbase;
import com.swuorange.po.User;
import com.swuorange.service.QualityService;
import com.swuorange.service.StaffService;
import com.swuorange.service.SubbaseService;
import com.swuorange.service.UserService;
import com.swuorange.service.VarietyService;
import com.swuorange.util.ClassCompareUtil;
import com.swuorange.util.MD5;
import com.swuorange.util.PagerHelper;





@RestController
@RequestMapping("quality")
public class QualityController {
	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private ActiveMQProducter activeMQProducter;

	@Autowired
	private QualityService qualityService;
	
	
	@Autowired
	private SubbaseService subbaseService;
	
	@Autowired
	private VarietyService varietyService;
	
	
	
	//页面加载数据的请求
	@RequestMapping("queryQuality")
	@ResponseBody
	public Result getQualityList(Integer nowPage,HttpSession session){
		
		Result res = null;
		//通过页码查询quality
		System.out.println("查询质量表的请求进来了"+nowPage);
		if(nowPage == 0){
			//非法请求
			res = new Result(ResultData.FAIL_CODE,"请求不合法","");
			return res;
		}
		//查询当前登录用户
		User loginUser = (User) session.getAttribute("loginUser");
		QualityDTO qualityDTO = new QualityDTO();
		Integer userId = loginUser.getUserId();
		//根据当前申请人的id,查询其质量管理申请
		qualityDTO.setRequesterId(userId);
		//查询出总条数
		Integer totalRow = qualityService.countQuality(qualityDTO);
		
		Integer pageNumber = nowPage;
		PagerHelper pageHelper = new PagerHelper(totalRow,pageNumber,4);
		pageHelper.setRequesterId(userId);
		
		List<QualityInfo> qualityInfoList = qualityService.queryQualityList(pageHelper);		
		if(qualityInfoList != null){
			pageHelper.setList(qualityInfoList);
			res=new Result(ResultData.SUCCESS_CODE,"查询质量表成功",pageHelper);
			
		}else{
			res = new Result(ResultData.FAIL_CODE,"查询质量表失败","");
		}
		return res;


	}
	
	//点击页面的申请按钮
	@RequestMapping("requestQuality")
	@ResponseBody
	public Result queryQuality(HttpSession session){
		Result res = null;
		System.out.println("申请质量表的请求进来了");
		//查询当前登录用户
		User loginUser = (User) session.getAttribute("loginUser");	
		Integer companyinfoId = loginUser.getCompanyinfoId();		
		//根据公司id 和userid不等于0,两表联查

		//查询出所有的品类
		List<VarietyDTO> varietyList = varietyService.query();
		//通过二级基地表查询出当前公司的所有二级基地和生产记录者
		List<SubbaseListDTO> querySubbaseList = subbaseService.querySubbases(companyinfoId);
		ResultList resultList = new ResultList();
		if(varietyList != null ){
			resultList.setaList(varietyList);
			
		}
		if(querySubbaseList != null){
			resultList.setbList(querySubbaseList);
			
		}
		if(resultList != null){
			res= new Result(ResultData.SUCCESS_CODE,"查询质量表成功",resultList);
		}else{
			res = new Result(ResultData.FAIL_CODE,"查询质量表失败","");
		}
		return res;
	
	}
	
	//点击搜索按钮,根据质量检测的名字查询
	@RequestMapping("requestQualityByName")
	@ResponseBody
	public Result queryQualityByName(QualityDTO quality,HttpSession session){
		System.out.println("查询质量检测的名字查询"+quality.getRequestName());
		Result res = null;
		
		List<QualityInfo> queryQualityList = qualityService.queryQualityByName(quality);
		if(queryQualityList.size() != 0){
			
			res=new Result(ResultData.SUCCESS_CODE,"查询质量表成功",queryQualityList);
			
		}else{
			res = new Result(ResultData.FAIL_CODE,"查询质量表失败","");
		}
		return res;

	}
	//根据二级基地的id,查询生产记录者
	@RequestMapping("querySubbase")
	@ResponseBody
	public Result querySubbaseById(Subbase subbase,HttpSession session){
		System.out.println("根据二级基地id查询出二级生产记录者"+subbase.getSubbaseId());
		Integer subbaseId = subbase.getSubbaseId();
		
		Subbase dbsubbase = qualityService.querySubbaseById(subbase);
		Result res = null;
		if(dbsubbase != null){
			
			res=new Result(ResultData.SUCCESS_CODE,"二级生产记录者成功",dbsubbase);
			
		}else{
			res = new Result(ResultData.FAIL_CODE,"二级生产记录者失败","");
		}
		return res;
	
	}
	
	
	
	//新增quality质量检测
	@RequestMapping("addQuality")
	@ResponseBody
	public Result addQuality(QualityDTO quality,HttpSession session){
		Result res = null;
		System.out.println("新增quality质量检测"+quality.toString());
		if(quality.getRequestName() == null){
			res = new Result(ResultData.FAIL_CODE,"质量检测申请失败","");
			return res;
					
		}
		
		User loginUser = (User) session.getAttribute("loginUser");
		QualityDTO qualityDTO = new QualityDTO();
		Integer userId = loginUser.getUserId();
		//根据当前申请人的id,查询其质量管理申请
		qualityDTO.setRequesterId(userId);
		qualityDTO.setIso("/upload");
		qualityDTO.setCac("/upload");
		qualityDTO.setApplyTime(new Timestamp(System.currentTimeMillis()));
		qualityDTO.setReviewTime(new Timestamp(System.currentTimeMillis()));
		qualityDTO.setBatchId(quality.getBatchId());
		qualityDTO.setManagerId(0);
		qualityDTO.setRecorderId(2);
		qualityDTO.setRequestName(quality.getRequestName());
		qualityDTO.setState(0);

		//将信息插入表
		Integer addQuality = qualityService.addQuality(qualityDTO);
		if(addQuality != 0){
			res=new Result(ResultData.SUCCESS_CODE,"质量检测申请成功"," ");

		}else{
			res = new Result(ResultData.FAIL_CODE,"质量检测申请失败","");
		}

		return res;	
		
	}
	
	
	
	//显示详情
	@RequestMapping("showQuality")
	@ResponseBody
	public Result showQuality(QualityDTO qualityDTO,HttpSession session){
		System.out.println("显示详情的请求进来了"+qualityDTO.toString());
		Result res = null;
		User loginUser = (User) session.getAttribute("loginUser");
		Integer userId = loginUser.getUserId();
		//根据当前申请人的id,查询其质量管理申请
		qualityDTO.setRequesterId(userId);
		QualityInfo showQuality = qualityService.showQuality(qualityDTO);
		
		if(showQuality != null){
			
			res=new Result(ResultData.SUCCESS_CODE,"查询详情成功",showQuality);
			
		}else{
			res = new Result(ResultData.FAIL_CODE,"查询详情失败","");
		}
		return res;
		
		
		
	
	}
	
	@InitBinder
	public void init(WebDataBinder binder) {
	binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	
	
}
