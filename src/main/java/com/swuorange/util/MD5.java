package com.swuorange.util;


import java.security.MessageDigest;


/*
 * 
* @Description: 用于密码的加密
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年2月28日 下午9:34:17
 */
public class MD5 {
	static char hexChars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/*
	 * 
	* @Description: 将密码转换为32的MD加密类
	*
	* @param str 需要加密的密码字符串
	* @return：返回值为加密后的密码
	* @version: v1.0.0
	* @author: Randy
	* @date: 2019年2月28日 下午9:35:13
	 */
	public static String convert32(String str) {
		try {
			byte[] bytes = str.getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(bytes);
			bytes = md.digest();
			int j = bytes.length;
			char[] chars = new char[j * 2];
			int k = 0;
			for (int i = 0; i < bytes.length; i++) {
				byte b = bytes[i];
				chars[k++] = hexChars[b >>> 4 & 0xf];
				chars[k++] = hexChars[b & 0xf];
			}
			return new String(chars);
		} catch (Exception e) {
			return null;
		}
	}
	/*
	* 
	* @Description: 将密码转换
	*
	* @param s
	* @return：返回加密后16位长度的密码
	* @version: v1.0.0
	* @author: Randy
	* @date: 2019年2月28日 下午9:37:12
	 */
	public String convert16(String str) {
		String ns = convert32(str).substring(8, 24);
		return ns;
	}

}
