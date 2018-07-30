package com.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;

import com.lingnan.usersys.common.constant.EnumType;
import com.lingnan.usersys.common.dao.Daofactory;
import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.business.dao.UserDao;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * Userservice接口的实现类
 * @author 14832
 *
 */
public class UserServiceImpl implements UserService{
	/**
	 * 用户service类实例，在类的内部创建唯一的实例
	 */
	private static UserService userService =new UserServiceImpl();
	/**
	 * 构造方法私有化
	 */
	private UserServiceImpl() {
		
	}
	/**
	 * 取得用户service实例
	 * 提供对外访问的方法
	 * @return 实例对象
	 */
	public static UserService getInstance() {
		return userService;
		
	}
	@Override
	public boolean addUser(UserVO user) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public UserVO login(String id, String password) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		UserVO user=null;
		try {
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并且赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao=(UserDao)Daofactory.getDao(conn, EnumType.USER_DAO);
			//调用dao中的login方法，进行登陆操作，结果赋值给登陆结果变量
			user=userMgrDao.login(id, password);
			
		} catch (Exception e) {
			// 将异常封装成自定义异常类并且抛出
			throw new ServiceException("用户登录错误",e);
		}
		finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return user;
	}

}
