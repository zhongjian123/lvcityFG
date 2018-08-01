package com.lingnan.usersys.common.dao;

import java.sql.Connection;

import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.usermgr.business.dao.UserDaoImpl;

/**
 * 工厂模式类
 * @author 14832 zhi
 *
 */
public class Daofactory {
	/**
	 * 工厂模式获取dao实现类
	 * @param conn 数据库连接
	 * @param type 类型
	 * @return //返回实例化的dao对象
	 */
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
