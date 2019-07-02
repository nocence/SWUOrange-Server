package com.swuorange.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.swuorange.dto.RecordDTO;
import com.swuorange.dto.Result;
import com.swuorange.po.Record;
import com.swuorange.po.User;
import com.swuorange.po.UserRole;
import com.swuorange.service.RecordService;
import com.swuorange.service.UserRoleService;
import com.swuorange.util.PageUtil;

/**
*@Description: 用户对生产记录的增删改查
*
*@version: v1.0.0
*@author: Yiming
*@date: 2019年3月15日 下午2:57:58 
*/
@RestController
@RequestMapping("record")
public class RecordController {
	
	@Autowired
	private ActiveMQProducter activeMQProducter;
	
	@Autowired
	private RecordService recordService;
	
	@Autowired
	private UserRoleService userRoleService;
	/**
	 * 
	 *
	 *@Description 根据登陆的身份来查询相关生产记录并分页
	 *@return PageResult，包含分页以及查询出来的List
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月15日 下午3:03:12
	 *
	 */
	@RequestMapping("showRcoeds")
	public PageResult<Record> showRcoeds(HttpSession session,Integer nowPage,Record record){
		PageResult<Record> pageRes = new PageResult<Record>();
		//请求进来先看登陆的用户是生产记录者还是企业用户
		User user = (User)session.getAttribute("loginUser");
		UserRole userRole = new UserRole();
		userRole.setUserId(user.getUserId());
		UserRole role = userRoleService.queryRoleIdByUserId(userRole);
		
		//获取到的roleId为2时是企业用户
		if(role.getRoleId()==2){
			List<Record> recordsByCompanyInfoId = recordService.listRecordsByCompanyInfoId(user, nowPage, record);
			//获取总条数和总页数
			Integer totalData = recordService.allRecordsByCompanyInfoId(user, record);
			Integer totalPage = PageUtil.getTotalPage(PageConstance.DATA_PER_PAGE, totalData);
			
			if(totalPage < nowPage) {	
				//比如，在全查询时，我在第10页，此时如果条件查询，得到的结果如果只有5页，就应该把当前页改为第5页
				nowPage=totalPage;
			}
			if(nowPage == 0) {
				nowPage=1;
			}
			pageRes.setNowPage(nowPage);
			pageRes.setTotalData(totalData);
			pageRes.setTotalPage(totalPage);
			pageRes.setList(recordsByCompanyInfoId);
		}
		//如果获取到的roleID是3，则是生产记录者
		if(role.getRoleId()==3){
			Integer totalData = recordService.allRecordsByUserId(user, record);
			Integer totalPage = PageUtil.getTotalPage(PageConstance.DATA_PER_PAGE, totalData);
			List<Record> recordsByUserId = recordService.listRecordsByUserId(user, nowPage, record);
			pageRes.setNowPage(nowPage);
			pageRes.setTotalData(totalData);
			pageRes.setTotalPage(totalPage);
			pageRes.setList(recordsByUserId);
		}
		
		return pageRes;
	}
	/**
	 *
	 *@Description 用户操作添加生产记录时，拿回批次号返回前端
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月16日 下午4:43:56
	 *
	 */
	@RequestMapping("getRecord")
	public Result getBatchNums(HttpSession session){
		Result res = new Result();
		User user = (User)session.getAttribute("loginUser");
		UserRole userRole = new UserRole();
		userRole.setUserId(user.getUserId());
		UserRole role = userRoleService.queryRoleIdByUserId(userRole);
		//如果是企业用户，提示不能进行操作
		if(role.getRoleId()==2){
			res.setCode("400");
			res.setMsg("您不能进行此项操作！");
		}
		if(role.getRoleId()==3){
			List<Record> batchNumByUserId = recordService.allBatchNumByUserId(user);
			res.setCode("200");
			res.setFirst(batchNumByUserId);
		}
		return res;
	}
	/**
	 *
	 *@Description 根据前端传入的生产批次号返回对应的产品类型和产品名
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月16日 下午4:48:29
	 *
	 */
	@RequestMapping("getDetail")
	public Result getDetailByBatch(Record record){
		Result res = new Result();
		Record detail = recordService.byBatchNum(record);
		res.setObj(detail);
		return res;
	}
	/**
	 * 
	 *@Description 将前端发的添加申请发送到MQ
	 *@return 返回值描述
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月16日 下午8:57:20
	 *
	 */
	@RequestMapping("addRecord")
	public Result insertDetail(HttpSession session,RecordDTO recordDTO){
		Result res = new Result();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		User user = (User)session.getAttribute("loginUser");
		recordDTO.setUsrId(user.getUserId());
		recordDTO.setDateTime(df.format(new Date()));
		JSONObject json = new JSONObject();
		json.put("obj", recordDTO);
		json.put("objType", "RecordDTO");
		json.put("opeartion", "insertDetail");
		json.put("sid", session.getId());
		SessionCache.sessionCache.put(session.getId(), session);
		System.out.println("json-server:"+json.toString());
		activeMQProducter.sendMessage(json.toString());
		res.setCode(ResultData.SUCCESS_CODE);
		return res;
	}
}
