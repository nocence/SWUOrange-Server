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
import com.swuorange.dto.BaseSearchDTO;
import com.swuorange.dto.DemandDTO;
import com.swuorange.dto.DemandSearchDTO;
import com.swuorange.dto.ListDTO;
import com.swuorange.dto.PageBean;
import com.swuorange.dto.Result;
import com.swuorange.po.BuyingInfo;
import com.swuorange.po.Product;
import com.swuorange.po.User;
import com.swuorange.service.DemandService;

@RequestMapping("demand")
@RestController
/*
 * 
 * @Description: 该类的描述 用户的供求系统
 *
 * @version: v1.0.0
 * 
 * @author: Randy
 * 
 * @date: 2019年3月12日 下午7:18:33
 */
public class DemandController {
	private static Logger logger = Logger.getLogger(DemandController.class);

	@Autowired
	private DemandService demandService;

	@Autowired
	private ActiveMQProducter activeMQProducter;

	@RequestMapping("getProductType")
	public Result getProductType() {
		List<Product> list = demandService.getProductType();
		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		result.setObj(list);
		return result;
	}

	/*
	 * 
	 * @Description: 该方法储存发布的求购信息
	 *
	 * @param buyInfo
	 * 
	 * @return
	 * 
	 * @return：返回值描述
	 * 
	 * @version: v1.0.0
	 * 
	 * @author: Randy
	 * 
	 * @date: 2019年3月12日 下午9:55:09
	 */
	@RequestMapping("updateOrInsert")
	public Result saveOrUpdateBuyInfo(HttpSession session, BuyingInfo buyInfo) {
		logger.error(buyInfo.toString());
		buyInfo.setUserId(1);
		if (buyInfo.getBuyId() == null) {
			User loginUser = (User) session.getAttribute("loginUser");
			buyInfo.setUserId(loginUser.getUserId());
		}
		// 调用Mq进行删除操作
		JSONObject json = new JSONObject();
		json.put("obj", buyInfo);
		json.put("objType", "BuyingInfo");
		json.put("opeartion", "updateOrInsert");
		json.put("sid", session.getId());
		activeMQProducter.sendMessage(json.toString());
		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		result.setMsg("系统正在处理请稍后!");
		return result;
	}

	/*
	 * 
	 * @Description: 该方法根据前端的请求参数条件查询list
	 *
	 * @param session
	 * 
	 * @param search
	 * 
	 * @return
	 * 
	 * @return：返回值描述
	 * 
	 * @version: v1.0.0
	 * 
	 * @author: Randy
	 * 
	 * @date: 2019年3月13日 上午10:02:18
	 */
	@RequestMapping("getDemandList")
	public PageBean<DemandDTO> getBaseList(HttpSession session, DemandSearchDTO search) {
		logger.error("执行了查询列表的方法");
		PageBean<DemandDTO> page = new PageBean<DemandDTO>();
		page.setNowPage(search.getNowPage());

		// 查询当前登录用户
		User loginUser = (User) session.getAttribute("loginUser");
		search.setUserId(loginUser.getUserId());
		//search.setUserId(1);
		List<DemandDTO> demandDTOList = demandService.DemandBaseList(search, page);
		page.setList(demandDTOList);
		return page;

	}

	@RequestMapping("delBuyList")
	public Result delBuyList(HttpSession session,ListDTO list) {
		// 存放session
		logger.error(list.getArr());
		SessionCache.sessionCache.put(session.getId(), session);
		// 调用Mq进行删除操作
		JSONObject json = new JSONObject();
		json.put("obj", list);
		json.put("objType", "BuyingInfo");
		json.put("opeartion", "del");
		json.put("sid", session.getId());
		activeMQProducter.sendMessage(json.toString());
		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		result.setMsg("系统正在处理请稍后!");
		return result;

	}

}
