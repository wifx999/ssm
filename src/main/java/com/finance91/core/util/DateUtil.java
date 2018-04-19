package com.finance91.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 根据传入的时间返回不包含时分秒的date
	 * @param date
	 * @return
	 */
	public static Date truncateTime(Date date) {
		return parseDate(formatDate(date, "yyyy-MM-dd"), "yyyy-MM-dd");
	}
	
	/**
	 * 根据pattern将date转换为相应字符串
	 * @param d
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date d, String pattern) {
		if(d==null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(d);
	}
	
	/**
	 * 根据字符串date和pattern生成一个date
	 * @param ds
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(String ds, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			Date d = sdf.parse(ds);
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 得到date的年份
	 * @param date
	 * @return
	 */
	 public static int getYear(Date date){
		 Calendar c = Calendar.getInstance();
		 c.setTime(date);
		 return c.get(Calendar.YEAR);
	 }
	 
	 /**
	  * 得到date的月份
	  * @param date
	  * @return
	  */
	 public static int getMonth(Date date){
		 Calendar c = Calendar.getInstance();
		 c.setTime(date);
		 return c.get(Calendar.MONTH) + 1;
	 }
	 
	 /**
	  * 得到date的日
	  * @param date
	  * @return
	  */
	 public static int getDay(Date date){
		 Calendar c = Calendar.getInstance();
		 c.setTime(date);
		 return c.get(Calendar.DAY_OF_MONTH);
	 }
	 
	 /**
	  * 得到date的小时
	  * @param date
	  * @return
	  */
	 public static int getHour(Date date){
		 Calendar c = Calendar.getInstance();
		 c.setTime(date);
		 return c.get(Calendar.HOUR_OF_DAY);
	 }

}
