package com.swuorange.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.swuorange.activemq.ActiveMQProducter;
import com.swuorange.cache.SessionCache;
import com.swuorange.dao.CompanyinfoMapper;
import com.swuorange.data.ResultData;
import com.swuorange.dto.CompanyinfoDTO;
import com.swuorange.dto.MenuDTO;
import com.swuorange.dto.RegUser;
import com.swuorange.dto.Result;
import com.swuorange.dto.UserDTO;
import com.swuorange.mail.SendSMS;
import com.swuorange.po.User;
import com.swuorange.service.MenuService;
import com.swuorange.service.UserService;
import com.swuorange.util.AuthCodeUtil;
import com.swuorange.util.MD5;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private ActiveMQProducter activeMQProducter;

	@Autowired
	private SendSMS sendSMS;
	
	
	@Autowired
	private UserService userService;
	

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private CompanyinfoMapper companyinfoMapper;
	
	@RequestMapping("/login")
	public Result login(UserDTO loguser, HttpSession session) {
		Result result = new Result();
		// 校验用户的名是否合法
		if (loguser == null || loguser.getAccount() == null || loguser.getPassword() == null) {
			result.setCode(ResultData.FAIL_CODE);
			result.setMsg("用户名或者密码输入错误");
			return result;
		}
		// 校验验证码
		String authcode = (String) session.getAttribute("authCode");
		
		System.out.println("输入-------"+loguser.getAuthcode());
		if (!loguser.getAuthcode().equals(authcode)) {
			result.setCode(ResultData.FAIL_CODE);
			result.setMsg("验证码输入错误");
			return result;
		}
		//用户名和密码基本校验过后将用户的密码进行MD5加密
		loguser.setPassword(MD5.convert32(loguser.getPassword()));
		
		User user = userService.queryUser(loguser);
		
		if(user==null){
			result.setCode(ResultData.FAIL_CODE);
			result.setMsg("您还没有注册,请注册后使用!");
			return result;
		}
		//为了安全设置密码为空
		user.setPassword("");
		session.setAttribute("loginUser", user);
		
		result.setCode(ResultData.SUCCESS_CODE);
		result.setMsg("登录成功!");
		return result;
		
		

	}

	@RequestMapping("/initmenu")
	public Result initMenu(HttpSession session) {
		//通过session获取登录用户
		User loginUser = (User) session.getAttribute("loginUser");
		//查询角色
		UserDTO  userDTO = userService.queryRoleName(loginUser.getUserId());
		//调用service查询他的权限的菜单
		userDTO.setRealname(loginUser.getRealname());
		List<MenuDTO> menus = menuService.queryMenu(loginUser.getUserId());
		//将他说拥有的权限放入session
		session.setAttribute("menus", menus);
		Result result = new Result();
		result.setFirst(menus);
		result.setObj(userDTO);
		return result;
	}
	/**
	*@Description: 用户进行企业认证
	*
	*@version: v1.0.0
	*@author: Yiming
	*@date: 2019年3月6日 下午4:47:08 
	*/
	@RequestMapping("companyRegis")
	public Result companyRegis(CompanyinfoDTO companyinfo,HttpSession session){
		Result res = new Result();
		User loginUser = (User) session.getAttribute("loginUser");
		
		if(loginUser!=null){
			companyinfo.setUserId(loginUser.getUserId());
			companyinfo.setState(1);
			JSONObject json = new JSONObject();
			json.put("obj", companyinfo);
			json.put("objType", "Companyinfo");
			json.put("opeartion", "add");
			json.put("sid", session.getId());
			SessionCache.sessionCache.put(session.getId(), session);
			System.out.println("json-server:"+json.toString());
			activeMQProducter.sendMessage(json.toString());
			res.setMsg("ok");
		}else{
			res.setMsg("no");
		}
		return res;
	}


	@RequestMapping("/test")
	public String test(HttpSession session) {
		if (session.getAttribute("code") != null) {
			System.out.println(session.getAttribute("code"));

		}
		return null;
	}
	
	//用户注册的时候,检查用户是否存在
	@RequestMapping("regNameCheck")
	@ResponseBody
	public Result regNameCheck(RegUser regUser) {
		
		RegUser dbregUser = userService.queryUserName(regUser);
		
		Result res = null;
		if(dbregUser != null){
			//用户存在
			res=new Result(ResultData.SUCCESS_CODE,"用户已存在",dbregUser);
		}else{
			res=new Result(ResultData.FAIL_CODE,"用户不存在"," ");
			
		}	
		return res;
	}
	//将手机验证码发送到用户手机
	@RequestMapping("sendTelCode")
	@ResponseBody
	public Result sendtelCode(RegUser regUser,HttpSession session ) {
		Result res = null;
		//获取用户输入的手机号
		String tel = regUser.getTel();
		//生成一个4位的随机数作为验证码发送给用户
		String rightTelCode = AuthCodeUtil.getAuthCode();
		//将验证码存入redis,key:用户手机号,value:验证码,并设置过期时间3分钟
		redisTemplate.opsForValue().set(tel,rightTelCode,180, TimeUnit.SECONDS);
		//将验证码通过短信发送给用户
		sendSMS.sendSMS(rightTelCode, tel);
		session.setAttribute("rightTelCode", rightTelCode);
		res=new Result(ResultData.SUCCESS_CODE,"验证码发送成功",rightTelCode);
		System.out.println(rightTelCode);
		
		return res;
	}
	
	//用户注册
	@RequestMapping("register")
	@ResponseBody
	public Result register(RegUser regUser,String rePassword,String telCode,HttpServletRequest request,HttpSession session) {
		System.out.println("用户注册的请求进来了");
		Result res = null;
		String tel = regUser.getTel();
		//获取生成的手机验证码
		String rightTelCode = (String)request.getSession().getAttribute("rightTelCode");
		System.out.println(rightTelCode);
		//从redis获取存入的验证码
//		String rightTelCode =(String) redisTemplate.opsForValue().get(tel);
//		if(rightTelCode == null){
//			//验证码过期,或者不存在
//			res=new Result(ResultData.FAIL_CODE,"验证码过期,或者不存在"," ");
//			return res;
//		}
		//判断输入的用户名或者密码是否为空
		if(regUser.getAccount()==null || regUser.getPassword()==null){
			res=new Result(ResultData.FAIL_CODE,"用户名或者不能为空"," ");
			return res;
			
		}
		//判断生成的验证码是否为空
		if(rightTelCode == null||"".equals(rightTelCode)){
			res=new Result(ResultData.FAIL_CODE,"请输入正确的验证码"," ");
			return res;
		}
		//判断获取的验证码是否为空
		if(telCode ==null|| "".equals(telCode)){
			res=new Result(ResultData.FAIL_CODE,"请不要非法操作"," ");
			return res;
		}
		//判断用户输入的验证码和获取的验证码是否一致
		if(!telCode.equals(rightTelCode)){
			res=new Result(ResultData.FAIL_CODE,"验证码不一致"," ");
			return res;
			
		}
		
		//判断用户两次输入的密码是否一致
		if(!regUser.getPassword().equals(rePassword)){
			res=new Result(ResultData.FAIL_CODE,"两次输入的密码不一致"," ");
			return res;
		}
		//查询用户
		RegUser dbregUser = userService.queryUserName(regUser);
		if(dbregUser ==null){
			System.out.println("用户不存在,可以注册");
			//用户不存在,可以注册
			//将用户输入的密码通过MD5加密
			String password = regUser.getPassword();
			password = MD5.convert32(password);
			regUser.setPassword(password);
			System.out.println("加密后的密码"+password);
			JSONObject json = new JSONObject();
			json.put("obj", regUser);
			json.put("objType", "User");
			json.put("opeartion", "add");
			json.put("sid", session.getId());
			SessionCache.sessionCache.put(session.getId(), session);
			System.out.println("将信息发送给mq");
			
			activeMQProducter.sendMessage(json.toString());
			
	
		}else{
			res=new Result(ResultData.FAIL_CODE,"用户存在,注册失败"," ");
		}
		
		
		return res;	
		
	}
	
	
	

}
