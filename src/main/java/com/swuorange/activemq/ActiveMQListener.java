package com.swuorange.activemq;

import javax.servlet.http.HttpSession;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.swuorange.cache.SessionCache;

/**
 * server端用于接收mq端处理的返回结果
 * 
 * @author Randy
 *
 */

@Service
public class ActiveMQListener {

	/*
	 * message 接收到的消息
	 * 
	 * @author Randy
	 */

	@JmsListener(destination = "calback")
	public void receive(String message) {
		//将收到的msg转换成JSONObject对象
		JSONObject json = JSONObject.parseObject(message);
		if (json.getString("rtCode").equals("200")) {
			//获取操作对象的session
			HttpSession session = SessionCache.sessionCache.get(json.getString("sid"));
			//将成功码放在session中
			session.setAttribute("code", json.getString("rtCode"));
		}
	}
}
