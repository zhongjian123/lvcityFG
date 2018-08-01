package com.lingnan.usersys.common.util;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * 测试工具类
 * @author 14832
 *
 */
public class checkTest {

	@Test
	public void testDateToStr() {
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String st="2018-08-08";
			Date t=sdf.parse(st);
			String str=check.dateToStr(t);
			
			java.util.Date ud = sdf.parse(st);   //getFactTime()返回String类型
	        java.sql.Date sd=new java.sql.Date(ud.getTime());
	        System.out.println("日期sd::  "+sd);
			
			System.out.println("日期t::  "+t);
			System.out.println("日期str::  "+str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testStrToDate() {
		Date d=null;
		String str="2016-2-12";
		d=check.strToDate(str);
		System.out.println("日期："+d);
	}

	@Test
	public void testIsEmail() {
		boolean b=check.isEmail("www.14832019@qq.com");
		System.out.println(b);
	}
	
	@Test
	public void testIsNull() {
		boolean b=check.isNull("gh");
		System.out.println(b);
	}

}
