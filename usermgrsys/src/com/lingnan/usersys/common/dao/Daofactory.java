package com.lingnan.usersys.common.dao;

import java.sql.Connection;

import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.usermgr.business.dao.UserDaoImpl;

public class Daofactory {
	public static BaseDao getDao(Connection conn,String type) {
		//如果传入的dao类型是用户user，就是实例化用户dao实现类
		if("user".equals(type))
		{
			//返回实例化的dao对象
			return new UserDaoImpl(conn);
		}
		else {
			throw new ServiceException("dao工厂方法出差");
		}
		
		
	}
	

}
