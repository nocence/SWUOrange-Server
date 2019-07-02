package com.swuorange.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.swuorange.data.ActiveMQData;

/**
 * MQ生产者类,用于发送消息,需要时直接注入.
 * 
 * @author Randy
 *
 */
@Service
public class ActiveMQProducter {
	@Autowired
	private JmsMessagingTemplate jmsTemplate;

	/**
	 * MQ通用发送方法
	 * 
	 * @param destination
	 *            发送到的队列
	 * @param message
	 *            需要发送的消息字串
	 */

	public void sendMessage(String message) {
		jmsTemplate.convertAndSend(ActiveMQData.desrination, message);
	}
}
