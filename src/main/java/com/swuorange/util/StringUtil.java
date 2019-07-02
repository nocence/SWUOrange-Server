package com.swuorange.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 
* @Description: String的工具类
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年2月28日 下午9:50:03
 */
public class StringUtil {

	/*
	 * 
	* @Description: 该方法生成年月日时分秒毫秒以及一个100-999的一个三位随机数
	*
	* @return
	* @return：返回值描述  20位定长的随机数
	* @version: v1.0.0
	* @author: Randy
	* @date: 2019年2月28日 下午10:07:02
	 */
	public String get20Code() {
		String str = new SimpleDateFormat("yyyyMMddHHmmssS").format(new Date());
		int str1 = (int) Math.random() * 8999 + 1000;
		return str + str1;
	}
}
