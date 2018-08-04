package com.lingnan.usersys.usermgr.business.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;



import java.util.Date;

import org.junit.Test;

import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserServiceImplTest {

	@Test
	public void testAddUser() {
		boolean flag;
		UserService us=UserServiceImpl.getInstance();
		UserVO vo=new UserVO();
		vo=us.login("s04", "bbb");
		vo.setId("666");
		
		
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		String st="2018/12/18";
		java.util.Date ud = null;
		try {
			ud = sdf.parse(st);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        java.sql.Date sd=new java.sql.Date(ud.getTime());
		vo.setBirth(sd);	
		System.out.println("sd:   "+sd);
		flag=us.addUser(vo);

		System.out.println("结果："+flag);

	}

	@Test
	public void testLogin() {
		UserService us=UserServiceImpl.getInstance();
		UserVO vo=new UserVO();
		vo=us.login("s01", "aaa");
		System.out.println("名字: "+vo.getName()+"     "+vo.getBirth());
	}

}
