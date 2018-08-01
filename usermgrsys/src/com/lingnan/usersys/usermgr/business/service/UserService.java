package com.lingnan.usersys.usermgr.business.service;

import java.util.Vector;

import com.lingnan.usersys.usermgr.domain.UserVO;

public interface UserService {
	
	/**
	 * 注册用户/添加用户
	 * @param user
	 * @return 成功返回true，失败返回false
	 */
	public boolean addUser(UserVO user);
	
	/**
	 * 用户登录
	 * @param id 账号
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserVO login(String id,String password);
	
	/**
	 * 按照用户账号id查询
	 * @param id 用户账号
	 * @return 返回一条记录
	 */
	public UserVO searchById(String id);
	
	/**
	 * 查询所有用户信息
	 */
	public Vector<UserVO> searchUser();
	
	/**
	 * 模糊查询
	 * @param 任意数据
	 * @return 多条记录
	 */
	public Vector<UserVO> searchVague(String str);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUser(UserVO user);
	
	/**
	 * 根据用户id删除
	 * @param id
	 * @return
	 */
	public boolean deleteById(String id);
	
	/**
	 * 分页查询
	 * @param i
	 * @return
	 */
	public Vector<UserVO> searchByPage(int page);

}
