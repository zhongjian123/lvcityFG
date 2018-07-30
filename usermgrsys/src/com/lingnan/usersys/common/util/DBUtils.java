package com.lingnan.usersys.common.util;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lingnan.usersys.common.exception.DAOException;

/**
 * 对数据库操作的基础类
 * @author 14832
 *
 */
public class DBUtils {
	/**
	 * 连接Oracle数据库
	 * @return coon
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");   //加载数据库驱动
		System.out.println("数据库驱动加载成功！");	//输出的信息
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";	//获取连接URL
		String user = "scott"; //连接用户名
		String password = "123456"; //连接密码
		conn = DriverManager.getConnection(url, user, password); //获取数据库连接
		System.out.println("数据库连接成功！");	//输出的信息
		}catch (ClassNotFoundException e) {
			throw new DAOException("加载数据库驱动失败！", e);
		}
		catch (SQLException e) {
			throw new DAOException("获取数据库连接失败！",e);
			
		}
		return conn;
	}
	
	/**
	 * 开始事务
	 * @param conn
	 */
	public static void beginTransaction(Connection conn) {
		try {
			//将事务的自动提交模式设为假
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new DAOException("开始事务失败！",e);
		}
		
	}
	
	/**
	 * 提交事务
	 * @param conn
	 */
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			throw new DAOException("提交事务失败",e);
		}
		
	}
	
	/**
	 * 回滚事务
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			//回滚事务
			conn.rollback();
			//将事务的自动提交模式设为真
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			throw new DAOException("回滚事务失败",e);
		}
		
	}
	
	/**
	 * 关闭数据库连接
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		
		try {
			if(conn!=null)
			{
				//如果数据库连接对象不为空，关闭该对象
				conn.close();
			}
		} catch (SQLException e) {
			throw new DAOException("关闭数据库连接失败",e);
		}
	}
	
	/**
	 * 关闭事务 
	 * @param rs
	 * @param stmt
	 */
    public static void closeStatement(ResultSet rs,Statement stmt) {
    	try {
			if(rs!=null)
			{
				//如果查询结果集不为空，关闭该对象
				rs.close();
			}
			if(stmt!=null)
			{
				//如果声明对象不为空，关闭该对象
				stmt.close();
			}
		} catch (SQLException e) {
			throw new DAOException("关闭事务失败",e);
		}
		
	}
	
}
