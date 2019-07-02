package com.swuorange.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.swuorange.activemq.ActiveMQProducter;
import com.swuorange.cache.SessionCache;
import com.swuorange.data.ResultData;
import com.swuorange.dto.DemandDTO;
import com.swuorange.dto.DemandSearchDTO;
import com.swuorange.dto.ListDTO;
import com.swuorange.dto.PageBean;
import com.swuorange.dto.Result;
import com.swuorange.dto.SupplyInfoDTO;
import com.swuorange.dto.SupplySearchDTO;
import com.swuorange.po.SupplyInfo;
import com.swuorange.po.User;
import com.swuorange.po.Variety;
import com.swuorange.service.SupplyService;
import com.swuorange.util.FileUtil;

/*
 * 
* @Description: 该类的描述 供应信息Controller
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年3月14日 上午10:07:08
 */
@RestController
@RequestMapping("supply")
public class SupplyInfoController {

	@Autowired
	private SupplyService supplyService;

	@Autowired
	private ActiveMQProducter activeMQProducter;

	@RequestMapping("getSupplyList")
	public PageBean<SupplyInfoDTO> getBaseList(HttpSession session, SupplySearchDTO search) {

		PageBean<SupplyInfoDTO> page = new PageBean<SupplyInfoDTO>();
		page.setNowPage(search.getNowPage());

		// 查询当前登录用户
		User loginUser = (User) session.getAttribute("loginUser");
		// search.setUserId(loginUser.getUserId());
		search.setUserId(1);
		List<SupplyInfoDTO> supplyDTOList = supplyService.getSupplyList(search, page);
		page.setList(supplyDTOList);
		return page;

	}

	@RequestMapping("getVariety")
	public Result getVariety(Integer productId) {
		List<Variety> list = supplyService.getVariety(productId);
		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		result.setObj(list);
		return result;
	}

	@RequestMapping("insertOrUpdate")
	public Result insertOrUpdateSupplyInfo(HttpServletRequest req, HttpSession session, String supplyInfo,
			MultipartFile file) {
		SupplyInfo info = JSON.parseObject(supplyInfo, SupplyInfo.class);
		Result result = new Result();
		String url = "";
		try {
			// 1. 判断是否有文件,如果文件不为空者储存在本地
			if (!file.isEmpty() && info.getUrl() != "") {
				String originalFilename = file.getOriginalFilename();
				String path = req.getServletContext().getRealPath("");
				url = FileUtil.saveFile(originalFilename, path, file);
			}

			User user = (User) session.getAttribute("loginUser");
			info.setUserId(user.getUserId());
			info.setUrl(url);
			JSONObject json = new JSONObject();
			json.put("obj", info);
			json.put("objType", "SupplyInfo");
			json.put("opeartion", "insertOrUpdate");
			json.put("sid", session.getId());
			activeMQProducter.sendMessage(json.toString());
			result.setCode(ResultData.SUCCESS_CODE);
			result.setMsg("已提交请稍后");
			return result;
		} catch (Exception e) {
			result.setCode(ResultData.FAIL_CODE);
			result.setMsg("提交失败");
			return result;
		}
	}

	@RequestMapping("delSupplyList")
	public Result delSupplyList(HttpSession session, ListDTO arr) {

		// 调用Mq进行删除操作
		JSONObject json = new JSONObject();
		json.put("obj", arr);
		json.put("objType", "SupplyInfo");
		json.put("opeartion", "del");
		json.put("sid", session.getId());
		activeMQProducter.sendMessage(json.toString());

		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		result.setMsg("请求已提交,系统正在处理");
		return result;

	}

}
