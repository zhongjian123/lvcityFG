package com.lingnan.usersys.common.util;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class checkTest {

	@Test
	public void testDateToStr() {
		Date d =new Date();  
		String str=check.dateToStr(d);
		System.out.println(str);
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
