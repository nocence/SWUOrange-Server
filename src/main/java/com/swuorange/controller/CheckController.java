package com.swuorange.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swuorange.data.ResultData;
import com.swuorange.dto.Result;

@Controller
public class CheckController {
	@RequestMapping("check")
	@ResponseBody
	public Result check(HttpSession session) {
		Result res = new Result();
		if (session.getAttribute("code") != null) {
			System.out.println(session.getAttribute("code"));
			res.setCode(ResultData.SUCCESS_CODE);
		}else{
			res.setCode(ResultData.FAIL_CODE);
		}
		return res;
	}
}
