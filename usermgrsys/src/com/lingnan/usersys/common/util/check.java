package com.lingnan.usersys.common.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lingnan.usersys.common.exception.ServiceException;

/**
 * 使用工具类
 * @author 14832
 *
 */
public class check {
	/**
	 * 日期转字符串
	 * @param t 传入一个日期
	 * @return 返回字符串
	 */
	public static String dateToStr(Date t) {
		String str=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		str=sdf.format(t);
		return str;
	}
	
	/**
	 * 字符串转日期
	 * @param str 输入的字符串
	 * @return 返回日期
	 */
	public static Date strToDate(String str) {
		Date t=null;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			t=(Date) sdf.parse(str);
		} catch (ParseException e) {
			throw new ServiceException("字符串转日期错误",e);
		}
		return t;
	}
	
	/**
	 * 确认字符串是否为email格式
	 *
	 * @param strEmail 邮件地址
	 * @return true or false
	 */
	public static boolean isEmail(String strEmail) {
	    String strPattern = "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
	    Pattern p = Pattern.compile(strPattern);
	    Matcher m = p.matcher(strEmail);
	    return m.matches();
	}
	
	/**
	 * 判断是否为空
	 * @param str 字符串
	 * @return true or false
	 */
	public static boolean isNull(String str) {
		if(str!=null) return true;
		else return false;	
	}

	
}
