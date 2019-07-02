package com.swuorange.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 
* @Description: 日期类型工具类
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年2月28日 下午9:43:48
 */
public class DateUtil {
	/*
	 * 
	 * @Description: 返回当前时间yyyy-MM-dd HH:mm:ss的时间字符串
	 *
	 * @return String
	 * 
	 * @return：返回值当前时间的yyyy-MM-dd HH:mm:ss的字符串
	 * 
	 * @version: v1.0.0
	 * 
	 * @author: Randy
	 * 
	 * @date: 2019年2月28日 下午9:44:10
	 */
	public static String getFormatCurrentTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

}