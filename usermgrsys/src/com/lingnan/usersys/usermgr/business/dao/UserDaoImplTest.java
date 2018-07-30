package com.lingnan.usersys.usermgr.business.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserDaoImplTest {

	@Test
	public void testUserDaoImpl() {
		UserDaoImpl aa=new UserDaoImpl(DBUtils.getConnection());
	}
    
	@Test
	public void testLogin() {
		UserDaoImpl aa=new UserDaoImpl(DBUtils.getConnection());
		UserVO vo=new UserVO();
        vo=aa.login("s02", "aaa");
        System.out.println(vo.getName());
	}
}
