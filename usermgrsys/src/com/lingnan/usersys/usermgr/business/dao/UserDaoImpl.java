package com.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lingnan.usersys.common.exception.DAOException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserDaoImpl implements UserDao{
	
	/**
	 * 数据库连接
	 */
	private Connection conn;
	
	/**
	 * 构造方法
	 * @param conn 数据库连接
	 */
	public UserDaoImpl(Connection conn) {
		//给属性赋初始值
		this.conn=conn;	
	}
	
	public UserVO login(String id,String password) {
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam=null;
		//声明用户对象变量，用于保存从结果集提取出来的数据
		UserVO user=null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam=conn.prepareStatement("select * from myuser where ID=? and PASS=? and status='1'");
			//调用预编译对象的setXXX方法，给？号赋值
			pstam.setString(1, id);
			pstam.setString(2, password);
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs=pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
			if(rs.next())
			{
				//创建一个新用户对象，赋值给用户对象变量
				user=new UserVO();
				/*
				 * 调用结果集对象的getXXX方法，取出各个字段的值，
				 * 然后再调用用户对象的setXXX方法，给属性赋值
				 * 最后新创建的对象中包含了查询结果集中的所有字段的值
				 */
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setNex(rs.getString(3));
				user.setPass(rs.getString(4));
				user.setPower(rs.getString(5));
				user.setStatus(rs.getString(6));
				user.setBirth(rs.getDate(7));
				user.setMail(rs.getString(8));
			}
			
		} catch (Exception e) {

			throw new DAOException("提取数据失败!",e);
			
		}
		
		finally
		{
			DBUtils.closeStatement(rs, pstam);
		}
		return user;
		
	}

}
