package com.swuorange.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swuorange.data.ResultData;
import com.swuorange.dto.Result;
import com.swuorange.po.Admin;
import com.swuorange.service.AdminService;
import com.swuorange.util.MD5;

/**
*@Description: 后台管理员的增删改查
*
*@version: v1.0.0
*@author: Yiming
*@date: 2019年3月7日 下午6:45:08 
*/


@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	/**
	 *@Description 后台管理员的登录验证
	 *@return Result,传回前端的数据，根据该数据判定登陆情况
	 *@param Admin ,HttpSession
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月8日 上午9:30:37
	 *
	 */
	@RequestMapping("login")
	public Result adminLogin(Admin admin,HttpSession session){
		Result res = new Result();
		
		if(admin==null || admin.getAdminName()==null || admin.getPassWord()==null){
			//用户名或密码错误
			res.setCode("400");
		} else if(admin!=null){
			//对用户密码加密，对用户密码加密,暂时库里只有一个，后期增加之后启用加密
			admin.setPassWord(MD5.convert32(admin.getPassWord()));
			Admin queryAdminByName = adminService.queryAdminByName(admin);
			if(queryAdminByName==null){
				//未注册
				res.setCode("401");
				return res;
			}
			//校验成功
			
			//queryAdminByName.setPassWord("");
			session.setAttribute("loginAdmin", queryAdminByName);
			res.setCode("200");
			res.setObj(queryAdminByName);
		}
		return res;
	}
	/**
	 * 
	 *@Description 后台管理员新增管理员的请求
	 *@return Result,传回前端的数据
	 *@param Admin,HttpSession
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月8日 上午9:33:52
	 *
	 */
	@RequestMapping("addAdmin")
	public Result adminAdd(Admin admin , HttpSession session){
		Result res = new Result();
		if(admin.getAdminName()==null || admin.getPassWord()==null ||
				admin.getEmail()==null || admin.getTel()==null || 
				admin.getRealName()==null || admin.getRegistTime()==null
				){
			res.setCode(ResultData.FAIL_CODE);
			res.setMsg("请完整填写相关信息！");
			return res;
		}
		if(adminService.queryAdminByName(admin)!=null || adminService.queryAdminByRealName(admin)!=null){
			res.setCode(ResultData.FAIL_CODE);
			res.setMsg("账户已存在，请勿重复添加！");
		}else{
			admin.setPassWord(MD5.convert32(admin.getPassWord()));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			admin.setRegistTime(df.format(new Date()));
			adminService.addAdmin(admin);
			res.setCode(ResultData.SUCCESS_CODE);
			res.setMsg("添加成功！");
		}
		return res;
	}
	/**
	 *@Description 查询所有管理员返回给前端
	 *@return Result:返回不同的状态码用于前端判定
	 *			List:查询到的所有管理员列表，通过Result传回前端
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月8日 下午3:26:07
	 *
	 */
	@RequestMapping("showAll")
	public Result allAdminShow(){
		Result res = new Result();
		List<Admin> allAdmins = adminService.showAllAdmins();
		if(allAdmins!=null){
			res.setCode(ResultData.SUCCESS_CODE);
			res.setObj(allAdmins);
		}else{
			res.setCode(ResultData.FAIL_CODE);
		}
		return res;
	}
	/**
	 * 
	 *
	 *@Description 根据真实名字查询管理员
	 *@return Result:返回不同的状态码用于前端判定
	 *			adminByRealName:查询到的管理员，传回前端
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月8日 下午4:38:24
	 *
	 */
	@RequestMapping("showOne")
	public Result oneAdminShow(Admin admin){
		Result res = new Result();
		Admin adminByRealName = adminService.queryAdminByRealName(admin);
		
		if(adminByRealName!=null){
			res.setCode(ResultData.SUCCESS_CODE);
			List<Admin> list = new ArrayList<Admin>();
			list.add(adminByRealName);
			res.setObj(list);
		}else{
			res.setCode(ResultData.FAIL_CODE);
		}
		return res;
	}
	/**
	 * 
	 *
	 *@Description 用户获取修改用户信息弹出的模态框的数据
	 *@return 返回值描述
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月9日 上午10:36:08
	 *
	 */
	@RequestMapping("updateOne")
	public Result updateShow(Admin admin){
		Result res = new Result();
		Admin adminByRealName = adminService.queryAdminByRealName(admin);
		System.out.println("根据真名查询的管理员："+adminByRealName);
		if(adminByRealName!=null){
			res.setCode(ResultData.SUCCESS_CODE);
			res.setObj(adminByRealName);
		}else{
			res.setCode(ResultData.FAIL_CODE);
		}
		return res;
	}
	/**
	 * 
	 *
	 *@Description 根据真实姓名修改管理员部分数据
	 *@return Integer:adminId,用返回的ID判定是否修改成功
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月9日 上午11:45:24
	 *
	 */
	@RequestMapping("updateByRealName")
	public Result updateByRealName(Admin admin){
		Result res = new Result();
		Integer adminId = adminService.updateAdminByRealName(admin);
		if(adminId!=null){
			res.setCode(ResultData.SUCCESS_CODE);
		}else{
			res.setCode(ResultData.FAIL_CODE);
		}
		return res;
	}
	/**
	 * 
	 *
	 *@Description 根据真实姓名删除某个管理员
	 *@return void
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月9日 下午2:56:34
	 *
	 */
	@RequestMapping("deleteByRealName")
	public Result deleteByRealName(Admin admin){
		Result res = new Result();
		try{
			adminService.deleteByRealName(admin);
			res.setCode(ResultData.SUCCESS_CODE);
		}catch(Exception e){
			res.setCode(ResultData.FAIL_CODE);
		}
		return res;
	}
	/**
	 * 
	 *
	 *@Description 根据当前登录的管理员真实姓名修改管理员密码
	 *@return 返回值描述
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月10日 上午12:12:50
	 *
	 */
	@RequestMapping("updatePass")
	public Result updatePassByRealName(Admin admin){
		Result res = new Result();
		if(admin.getPassWord()!=null){
			admin.setPassWord(MD5.convert32(admin.getPassWord()));
			Integer changedId = adminService.updateAdminByRealName(admin);
			if(changedId!=null){
				res.setCode(ResultData.SUCCESS_CODE);
			}else{
				res.setCode(ResultData.FAIL_CODE);
			}
		}else{
			res.setCode(ResultData.FAIL_CODE);
		}
		
		return res;
	}
}

