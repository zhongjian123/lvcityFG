package com.lingnan.usersys.usermgr.view;

import com.lingnan.usersys.usermgr.domain.UserVO;

public interface BaseFrame {
	/**
	 * 页面显示
	 */
	public void show();
	
	/**
	 * 增加用户页面显示
	 * @param type 类型
	 */
	public void addShow(String type);
	
	/**
	 * 查询
	 */
	public void searchShow();
	
	/**
	 * 更新
	 * @param vo 用户信息
	 */
	public void updateShow(UserVO vo);
}
