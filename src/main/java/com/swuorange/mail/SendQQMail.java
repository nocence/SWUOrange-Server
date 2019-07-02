package com.swuorange.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
/*
 * 
* @Description: 该类的描述 用于发送qq邮件使用时直接注入使用
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年2月28日 下午10:42:39
 */
@Service
public class SendQQMail {
	@Autowired
	private JavaMailSender mailSender;

	/*
	 * 
	* @Description: 该方法发送邮件
	*
	* @param msg 需要发送的完整信息
	* @param sendTo 收件人邮箱
	* @param subject 邮件主题
	* @throws Exception 邮件发送异常
	* @return：返回值描述 无
	* @version: v1.0.0
	* @author: Randy
	* @date: 2019年2月28日 下午10:43:15
	 */
	public void sendSimpleMail(String msg, String sendTo, String subject) throws Exception {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("755014673@qq.com");
		message.setTo(sendTo);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
	}
}
