package com.lingnan.usersys.usermgr.business.service;

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

}
