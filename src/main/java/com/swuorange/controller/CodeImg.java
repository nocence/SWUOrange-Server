package com.swuorange.controller;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swuorange.util.AuthCodeUtil;

/*
 * 
* @Description: 该类生成验证码
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年3月6日 下午2:04:37
 */
@Controller
@RequestMapping
public class CodeImg implements Serializable {

	private static final long serialVersionUID = 5633780176793520460L;
	// 图片流
	private BufferedImage authImg;

	public BufferedImage getAuthImg() {
		return authImg;
	}

	public void setAuthImg(BufferedImage authImg) {
		this.authImg = authImg;
	}


	//登陆用验证码
	@RequestMapping("codeImg")
	@ResponseBody
	public void execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			String authCode = AuthCodeUtil.getAuthCode();
			authImg = AuthCodeUtil.getAuthImg(authCode);
			//设置
			request.getSession().setAttribute("authCode", authCode);
			ServletOutputStream outputStream = response.getOutputStream();
			ImageIO.write(authImg, "png", outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//注册用验证码
	@RequestMapping("regCodeImg")
	@ResponseBody
	public void executeimg(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			String regCode = AuthCodeUtil.getAuthCode();
			authImg = AuthCodeUtil.getAuthImg(regCode);
			//设置
			request.getSession().setAttribute("regCode", regCode);
			ServletOutputStream outputStream = response.getOutputStream();
			ImageIO.write(authImg, "png", outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
