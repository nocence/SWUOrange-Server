package com.swuorange.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.swuorange.activemq.ActiveMQProducter;
import com.swuorange.cache.SessionCache;
import com.swuorange.common.PageConstance;
import com.swuorange.common.PageResult;
import com.swuorange.data.ResultData;
import com.swuorange.dto.BatchDTO;
import com.swuorange.dto.Result;
import com.swuorange.po.Batch;
import com.swuorange.po.User;
import com.swuorange.po.UserRole;
import com.swuorange.service.BatchService;
import com.swuorange.service.UserRoleService;
import com.swuorange.util.PageUtil;
import com.swuorange.util.StringUtil;


/**
*@Description: 用户对产品批次的增加和查找
*
*@version: v1.0.0
*@author: Yiming
*@date: 2019年3月12日 下午4:26:41 
*/
@RestController
@RequestMapping("batch")
public class BatchController {
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private ActiveMQProducter activeMQProducter;
	/**
	 * 
	 *
	 *@Description 根据登录用户的角色（企业用户、生产记录者）来查询所有生产批号并分页
	 *@return 返回值描述
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月13日 下午12:50:52
	 *
	 */
	@RequestMapping("showBatchs")
	public PageResult<Batch> showBatchs(HttpSession session,Integer nowPage,Batch batch){
		PageResult<Batch> pageResult = new PageResult<Batch>();
		//请求进来先看登陆的用户是生产记录者还是企业用户
		User user = (User)session.getAttribute("loginUser");
		UserRole userRole = new UserRole();
		userRole.setUserId(user.getUserId());
		UserRole role = userRoleService.queryRoleIdByUserId(userRole);
		
		//获取到的roleId为2时是企业用户，获取到的roleId为3时是生产记录者
			//获取总页数和总条数
		Integer totalData = batchService.totalInfoByCompanyinfoId(user,batch);
		Integer totalPage = PageUtil.getTotalPage(PageConstance.DATA_PER_PAGE, totalData);
		if(totalPage < nowPage) {
			//比如，在全查询时，我在第10页，此时如果条件查询，得到的结果如果只有5页，就应该把当前页改为第5页
			nowPage=totalPage;
		}
		if(nowPage == 0) {
			nowPage=1;
		}
		List<Batch> queryListByCompanyinfoId = batchService.queryListByCompanyinfoId(user, nowPage,batch);
		pageResult.setNowPage(nowPage);
		pageResult.setTotalData(totalData);
		pageResult.setTotalPage(totalPage);
		pageResult.setList(queryListByCompanyinfoId);

		
		return pageResult;
	}
	/**
	 *
	 *@Description 给前端返回模态框下拉框的产品类型数据和二级生产基地数据
	 *@return 返回值描述
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月14日 上午10:56:25
	 *
	 */
	@RequestMapping("getTypeAndSubbase")
	public Result getTypeAndSubbase(HttpSession session){
		Result res = new Result();
		//检查登陆用户的身份
		User user = (User)session.getAttribute("loginUser");
		UserRole userRole = new UserRole();
		userRole.setUserId(user.getUserId());
		UserRole role = userRoleService.queryRoleIdByUserId(userRole);
		
		//获取所有产品类型
		List<Batch> allproductType = batchService.allproductType();
		res.setFirst(allproductType);
		//根据用户身份查询基地
		if(role.getRoleId()==2){
			List<Batch> byCompanyinfoId = batchService.allsubbaseNameByCompanyinfoId(user);
			res.setSecond(byCompanyinfoId);
		}
		if(role.getRoleId()==3){
			List<Batch> byuserId = batchService.allsubbaseNameByuserId(user);
			res.setSecond(byuserId);
		}
		
		return res;
		
	}
	/**
	 * 
	 *@Description 根据前端传回的产品类型Id查询产品名列表
	 *@return 返回值描述
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月14日 下午3:30:20
	 *
	 */
	@RequestMapping("getProductName")
	public Result getProductNameByProductTpye(Batch batch){
		Result res = new Result();
		List<Batch> allproductName = batchService.allproductName(batch);
		res.setFirst(allproductName);
		return res;
	}
	/**
	 * 
	 *
	 *@Description 前端发送添加生产批次的请求，这里处理并发送到MQ
	 *@return result,通过设置不同的值给前端，前端根据返回值发送ajax调用MQ监听函数
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月14日 下午4:26:52
	 *
	 */
	@RequestMapping("addBatch")
	public Result add(HttpSession session,BatchDTO batchDTO){
		Result res = new Result();
		//调用工具生成定长Id
		String batchId = new StringUtil().get20Code();
		if(batchDTO!=null){
			batchDTO.setBatchNum(batchId);
			JSONObject json = new JSONObject();
			json.put("obj", batchDTO);
			json.put("objType", "BatchDTO");
			json.put("opeartion", "add");
			json.put("sid", session.getId());
			SessionCache.sessionCache.put(session.getId(), session);
			System.out.println("json-server:"+json.toString());
			activeMQProducter.sendMessage(json.toString());
			
			res.setCode(ResultData.SUCCESS_CODE);
		}else{
			res.setMsg("信息提交失败！");
			res.setCode(ResultData.FAIL_CODE);
		}
		
		return res;
	}
}
