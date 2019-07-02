package com.swuorange.mail;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

@Service
public class SendSMS {

	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

	public static boolean sendSMS(String authCode, String tel) {

		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);

		client.getParams().setContentCharset("GBK");
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=GBK");
		String content = new String("您的验证码是：" + authCode + "。请不要把验证码泄露给其他人。");
		
		NameValuePair[] data = {
				// 查看用户名是登录用户中心->验证码短信->产品总览->APIID
				new NameValuePair("account", "C68915414"),
				// 查看密码请登录用户中心->验证码短信->产品总览->APIKEY
				new NameValuePair("password", "89b7f02398c767bd895a6fec21992cb2"), new NameValuePair("mobile", tel),
				new NameValuePair("content", content), };
		method.setRequestBody(data);

		try {
			client.executeMethod(method);
			String SubmitResult = method.getResponseBodyAsString();
			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();
			/*
			 * 2 -提交成功- 15513670414168658246 -短信提交成功
			 */
			String code = root.elementText("code");
			String msg = root.elementText("msg");
			// 短信验证id
			String smsid = root.elementText("smsid");
			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);
			if ("2".equals(code)) {
				System.out.println("短信提交成功");
				return true;
			} else {
				return false;
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return false;
	}

}
