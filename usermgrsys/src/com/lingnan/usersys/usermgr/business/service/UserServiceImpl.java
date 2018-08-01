package com.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;
import java.util.Vector;

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
	
	/**
	 * 向数据库添加数据
	 */
	@Override
	public boolean addUser(UserVO user) {		
		Connection conn=null;
		boolean flag;
		try {
			//声明数据库连接对象，用于保存数据库连接对象
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并且赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao=(UserDao)Daofactory.getDao(conn, EnumType.USER_DAO);
			//开始事务
			DBUtils.beginTransaction(conn);
			//调用dao中的login方法，进行登陆操作，结果赋值给登陆结果变量
			flag=userMgrDao.addUser(user);
			//提交事务
			DBUtils.commit(conn);
		} catch (Exception e) {
			//回滚事务
			DBUtils.rollback(conn);
			// 将异常封装成自定义异常类并且抛出
			throw new ServiceException("向数据库添加数据失败错误",e);
		}
		finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return flag;
	}
	
	
	/**
	 * 登录操作
	 */
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
			DBUtils.beginTransaction(conn);
			user=userMgrDao.login(id, password);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollback(conn);
			// 将异常封装成自定义异常类并且抛出
			throw new ServiceException("用户登录错误",e);
		}
		finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return user;
	}
	
	/**
	 * 查询所有用户信息
	 */
	@Override
	public Vector<UserVO> searchUser() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		Vector<UserVO> vo=new Vector<UserVO>();
		try {
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并且赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao=(UserDao)Daofactory.getDao(conn, EnumType.USER_DAO);
			//开始事务
			DBUtils.beginTransaction(conn);
			//调用dao中的login方法，进行登陆操作，结果赋值给登陆结果变量
			vo=userMgrDao.searchUser();
			DBUtils.commit(conn);
			
		} catch (Exception e) {
			DBUtils.rollback(conn);
			// 将异常封装成自定义异常类并且抛出
			throw new ServiceException("查询用户错误",e);
		}
		finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return vo;
	}
	
	/**
	 * 更新用户信息
	 */
	@Override
	public boolean updateUser(UserVO user) {
		Connection conn=null;
		boolean flag;
		try {
			//声明数据库连接对象，用于保存数据库连接对象
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并且赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao=(UserDao)Daofactory.getDao(conn, EnumType.USER_DAO);
			//开始事务
			DBUtils.beginTransaction(conn);
			//调用dao中的update方法，进行登陆操作，结果赋值给登陆结果变量
			flag=userMgrDao.updateUser(user);
			//提交事务
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollback(conn);
			// 将异常封装成自定义异常类并且抛出
			throw new ServiceException("向数据库添加数据失败错误",e);
		}
		finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return flag;
	}
	
	/**
	 * 按照用户id查询
	 */
	@Override
	public UserVO searchById(String id) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		UserVO user=null;
		try {
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并且赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao=(UserDao)Daofactory.getDao(conn, EnumType.USER_DAO);
			DBUtils.beginTransaction(conn);
			//调用dao中的searchById方法，进行查询操作，结果赋值给登陆结果变量
			user=userMgrDao.searchById(id);
			DBUtils.commit(conn);
			
		} catch (Exception e) {
			DBUtils.rollback(conn);
			// 将异常封装成自定义异常类并且抛出
			throw new ServiceException("按id查询时service层异常",e);
		}
		finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return user;
	}
	
	/**
	 * 按id删除用户
	 */
	@Override
	public boolean deleteById(String id) {
		Connection conn=null;
		boolean flag;
		try {
			//声明数据库连接对象，用于保存数据库连接对象
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并且赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao=(UserDao)Daofactory.getDao(conn, EnumType.USER_DAO);
			//开始事务
			DBUtils.beginTransaction(conn);
			//调用dao中的deleteById方法，进行登陆操作，结果赋值给登陆结果变量
			flag=userMgrDao.deleteById(id);
			//提交事务
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollback(conn);
			// 将异常封装成自定义异常类并且抛出
			throw new ServiceException("按id删除用户信息",e);
		}
		finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return flag;
	}
	
	/**
	 * 分页查询
	 */
	@Override
	public Vector<UserVO> searchByPage(int page) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		Vector<UserVO> vo=new Vector<UserVO>();
		try {
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并且赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao=(UserDao)Daofactory.getDao(conn, EnumType.USER_DAO);
			//开始事务
			DBUtils.beginTransaction(conn);
			//调用dao中的login方法，进行登陆操作，结果赋值给登陆结果变量
			vo=userMgrDao.searchByPage(page);
			DBUtils.commit(conn);
			
		} catch (Exception e) {
			DBUtils.rollback(conn);
			// 将异常封装成自定义异常类并且抛出
			throw new ServiceException("查询用户错误",e);
		}
		finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return vo;
	}
	/**
	 * 模糊查询
	 */
	@Override
	public Vector<UserVO> searchVague(String str) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		Vector<UserVO> ve=new Vector<UserVO>();
		try {
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并且赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			//调用dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao=(UserDao)Daofactory.getDao(conn, EnumType.USER_DAO);
			//开始事务
			DBUtils.beginTransaction(conn);
			//调用dao中的login方法，进行登陆操作，结果赋值给登陆结果变量
			ve=userMgrDao.searchVague(str);
			DBUtils.commit(conn);
			
		} catch (Exception e) {
			DBUtils.rollback(conn);
			// 将异常封装成自定义异常类并且抛出
			throw new ServiceException("查询用户错误",e);
		}
		finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return ve;		
	}

}
