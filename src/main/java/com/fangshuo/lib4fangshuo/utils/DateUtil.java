package com.fangshuo.lib4fangshuo.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	/**  获取当前时间 
	 *  @return Timestamp
	 */
	public static Timestamp getTimestamp() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		return new Timestamp(date.getTime());
	}
	
	/**
	 * 获取系统当前时间的毫秒数;
	 * @return
	 */
	public static Long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}
	
	/**
	 * 获取系统当前时间的毫秒数字符串;
	 * @return
	 */
	public static String getCurrentTimeMillisStr() {
		return System.currentTimeMillis()+"";
	}
	
	/**
	  * 将毫秒数转化为Date;
	 * @param timeMillis:时间毫秒数;
	 * @return ：转化后的Date;
	 */
	public static Date conversionTimeMillis2Date(Long timeMillis) {
		Date date = new Date();
		date.setTime(timeMillis);
		return date;
	}
	
	/**
	 * 比较两个毫秒数大小;
	 * @param subtracted:被减数;
	 * @param subtract:减数;
	 * @return
	 */
	public static Boolean compareTheTimeMillis(Long subtracted,Long subtract) {
		return subtracted>subtract;
	}
}
