package com.swuorange.interceptor;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.swuorange.cache.SessionCache;
import com.swuorange.data.Key;
import com.swuorange.util.RSACodeUtil;

public class RSAIntercepter implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		HttpSession session = request.getSession();
		Map<String, String[]> parameterMap = request.getParameterMap();

		Set<String> keySet = parameterMap.keySet();

		String myKey = request.getParameter("passSign");
		if (myKey == null || "".equals(myKey)) {
			System.out.println("非法请求");
			return false;
		}

		String tokey = RSACodeUtil.decoder2PrivateKey(myKey, Key.PRIVATEKEY);
		String key = tokey.substring(0, tokey.lastIndexOf("|"));
		String timeStr = tokey.substring(tokey.lastIndexOf("|") + 1);
		Long time = Long.parseLong(timeStr);

		if (!Key.KEY.equals(key)) {
			System.out.println("非法请求");
			return false;
		}

		long currentTime = System.currentTimeMillis();
		System.out.println(currentTime - time);
		if (currentTime - time > 10000) {
			System.out.println("请求超时");
			return false;
		}
		SessionCache.sessionCache.put(session.getId(), session);
		return true;
	}

}
