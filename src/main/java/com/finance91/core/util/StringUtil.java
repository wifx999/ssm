package com.finance91.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	/**
	 * 字符串是否是数字
	 * @param src
	 * @return
	 */
	public static boolean isNumber(String src){
		if(null == src || src.trim().isEmpty()){
			return false;
		}else{
			return src.matches("[0-9]+");
		}
	}
	
	/**
	 * 字符串是否为空
	 * @param src
	 * @return
	 */
	public static boolean isEmpty(String src) {
		return src == null || src.trim().isEmpty();
	}
	
	/**
	 * 字符串是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	
	/**
	 * 字符串是否符合11位mobile格式
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobile(String mobiles){
		if(null == mobiles || mobiles.trim().isEmpty()){
			return false;
		}else{
			String[] mobilesA = mobiles.split(",");
			for(String mobile : mobilesA){
				String r = "^(1)\\d{10}$";
				Matcher m = Pattern.compile(r).matcher(mobile);
				if (!m.find()) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 保留手机号码前三后四位数字,其余替换为*号
	 * @param mobile
	 * @return
	 */
	public static String maskMobile(String mobile) {
		if (StringUtil.isEmpty(mobile)) return "";
		Matcher m = Pattern.compile("(\\d{3})(\\d{4})(\\d{4})").matcher(mobile);
		if (m.find()) {
			return m.group(1) + "****" + m.group(3);
		} else {
			return mobile;
		}
	}

}
