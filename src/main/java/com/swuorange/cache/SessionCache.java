package com.swuorange.cache;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpSession;
/*
 * 
* @Description: 用于缓存用户的session
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年2月27日 下午10:12:41
 */
public class SessionCache {
	public static Map<String, HttpSession> sessionCache = new Hashtable<String, HttpSession>();
}
