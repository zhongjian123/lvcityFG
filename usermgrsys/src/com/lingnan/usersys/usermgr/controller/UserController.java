package com.lingnan.usersys.usermgr.controller;

import java.util.Vector;

import com.lingnan.usersys.usermgr.business.service.UserService;
import com.lingnan.usersys.usermgr.business.service.UserServiceImpl;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 控制层类
 * @author 14832
 *
 */
public class UserController {
	//声明用户service接口对象，用于业务处理
	UserService userMgrService=UserServiceImpl.getInstance();
	/**
	 * 用户登录
	 * @param id 账号
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserVO doLogin(String id,String password) {
		UserVO user=null;
		try {
			//调用用户service接口中的login方法，进行用户登录操作
			user=userMgrService.login(id, password);
			
		} catch (Exception e) {
			//显示异常
			System.out.println("用户登录时错误"+e.getMessage());
		}
		return user;
		
	}
	
	/**
	 * 按id查询用户的信息
	 * @param id 用户账号
	 * @return 一条用户记录
	 */
	public UserVO doSearchById(String id) {
		UserVO user=null;
		try {
			//调用用户service接口中的searchById方法，进行用户查询操作
			user=userMgrService.searchById(id);
			
		} catch (Exception e) {
			//显示异常
			System.out.println("用户Id查询时异常"+e.getMessage());
		}
		return user;
		
	}
	
	/**
	 * 添加用户
	 * @param user 用户信息
	 * @return true  or false
	 */
	public boolean addUser(UserVO user)
	{
		boolean flag = false;
		try {
			flag=userMgrService.addUser(user);
		} catch (Exception e) {
			System.out.println("添加用户时，control层异常！"+e.getMessage());
		}
		return flag;
	}
	
	/**
	 * 查询用户信息
	 * @return 用户信息记录
	 */
	public Vector<UserVO> doSearchUser() {
		Vector<UserVO> ve=null;
		try {
			ve=userMgrService.searchUser();
			
		} catch (Exception e) {
			//显示异常
			System.out.println("用户登录时错误"+e.getMessage());
		}
		return ve;
		
	}
	
	/**
	 * 分页查询
	 * @param page 页码
	 * @return 返回用户信息记录
	 */
	public Vector<UserVO> doSearchByPage(int page) {
		Vector<UserVO> ve=null;
		try {
			ve=userMgrService.searchByPage(page);
			
		} catch (Exception e) {
			//显示异常
			System.out.println("用户登录时错误"+e.getMessage());
		}
		return ve;
		
	}
	/**
	 * 模糊查询
	 * @param str 输入模糊姓名、账号、密码
	 * @return 返回用户信息记录
	 */
	public Vector<UserVO> doSearchVague(String str) {
		Vector<UserVO> ve=null;
		try {
			ve=userMgrService.searchVague(str);
			
		} catch (Exception e) {
			//显示异常
			System.out.println("用户登录时错误"+e.getMessage());
		}
		return ve;
		
	}
	
	/**
	 * 更新用户信息
	 * @param user 用户信息
	 * @return true  or false
	 */
	public boolean updateUser(UserVO user)
	{
		boolean flag = false;
		try {
			flag=userMgrService.updateUser(user);
		} catch (Exception e) {
			System.out.println("更新用户信息时，control层错误！");
		}
		return flag;
	}
	
	/**
	 * 按id删除用户信息
	 * @param id 用户账号
	 * @return true or false
	 */
	public boolean doDeleteById(String id)
	{
		boolean flag = false;
		try {
			flag=userMgrService.deleteById(id);
		} catch (Exception e) {
			System.out.println("按id删除用户信息时，control层错误！");
		}
		return flag;
	}
	

}
