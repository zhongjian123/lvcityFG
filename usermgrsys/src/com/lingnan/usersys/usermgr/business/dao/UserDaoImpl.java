package com.lingnan.usersys.usermgr.business.dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.lingnan.usersys.common.exception.DAOException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * UserDao接口的实现类
 * @author 14832
 *
 */
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
	
	/**
	 * 用户登录
	 */
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

	/**
	 * 添加用户方法
	 */
	@Override
	public boolean addUser(UserVO user) {
		PreparedStatement pstam=null;
		ResultSet rs=null;
		boolean flag=false;
		int num;
		//声明用户对象变量，用于保存从结果集提取出来的数据
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam=conn.prepareStatement("insert into myuser values(?,?,?,?,?,?,?,?)");
			//调用预编译对象的setXXX方法，给？号赋值
			pstam.setString(1, user.getId());
			pstam.setString(2, user.getName());
			pstam.setString(3, user.getNex());
			pstam.setString(4, user.getPass());
			pstam.setString(5, user.getPower());
			pstam.setString(6, user.getStatus());
			pstam.setDate(7,new java.sql.Date(user.getBirth().getTime()));    //输入日期
			pstam.setString(8, user.getMail());
			num=pstam.executeUpdate();
			if(num==1) flag=true;
		} catch (Exception e) {
			throw new DAOException("向Oracle数据库添加数据失败!",e);
		}
		finally
		{
			DBUtils.closeStatement(rs,pstam);
		}
		return flag;
	}

	/**
	 * 查询所有用户
	 */
	@Override
	public Vector<UserVO> searchUser() {
		Vector<UserVO> ve=new Vector<UserVO>();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from myuser";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				UserVO vo=new UserVO();
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setNex(rs.getString(3));
				vo.setPass(rs.getString(4));
				vo.setPower(rs.getString(5));
				vo.setStatus(rs.getString(6));
				vo.setBirth(rs.getDate(7));    //输入日期
				vo.setMail(rs.getString(8));
				ve.add(vo);	
			}
		} catch (Exception e) {
			throw new DAOException("向Oracle数据库添加数据失败!",e);
		}
		finally
		{
			DBUtils.closeStatement(rs,stmt);
		}
		return ve;
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public boolean updateUser(UserVO user) {
		PreparedStatement pstam=null;
		ResultSet rs=null;
		boolean flag=false;
		int num;
		//声明用户对象变量，用于保存从结果集提取出来的数据
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam=conn.prepareStatement("update myuser set name=?,nex=?,pass=?,power=?,status=?,birth=?,mail=? where id=?");
			//调用预编译对象的setXXX方法，给？号赋值
			pstam.setString(1, user.getName());
			pstam.setString(2, user.getNex());
			pstam.setString(3, user.getPass());
			pstam.setString(4, user.getPower());
			pstam.setString(5, user.getStatus());
			pstam.setDate(6,new java.sql.Date(user.getBirth().getTime()));    //输入日期
			pstam.setString(7, user.getMail());
			pstam.setString(8, user.getId());
			num=pstam.executeUpdate();
			if(num==1) flag=true;
		} catch (Exception e) {
			throw new DAOException("向Oracle数据库修改数据失败!",e);
		}
		finally
		{
			DBUtils.closeStatement(rs,pstam);
		}
		return flag;
	}

	/**
	 * 按用户id查询用户信息
	 */
	@Override
	public UserVO searchById(String id) {
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam=null;
		//声明用户对象变量，用于保存从结果集提取出来的数据
		UserVO user=null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam=conn.prepareStatement("select * from myuser where ID=?");
			//调用预编译对象的setXXX方法，给？号赋值
			pstam.setString(1, id);
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

			throw new DAOException("按id查询时提取数据失败!",e);
			
		}
		
		finally
		{
			DBUtils.closeStatement(rs, pstam);
		}
		return user;
	}

	/**
	 * 按id删除用户
	 */
	@Override
	public boolean deleteById(String id) {
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam=null;
		//声明用户对象变量，用于保存从结果集提取出来的数据
		boolean flag=false;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam=conn.prepareStatement("update myuser set status='0' where id=?");
			//调用预编译对象的setXXX方法，给？号赋值
			pstam.setString(1, id);
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
			int num=pstam.executeUpdate();
			if(num==1) flag=true;	
		} catch (Exception e) {

			throw new DAOException("按id删除用户时",e);
			
		}
		
		finally
		{
			DBUtils.closeStatement(rs, pstam);
		}
		return flag;
	}

	/**
	 * 分页查询
	 */
	@Override
	public Vector<UserVO> searchByPage(int page) {
		Vector<UserVO> ve=new Vector<UserVO>();
		Statement stmt=null;
		ResultSet rs=null;
		int end = 0,start=0;
		try {
			stmt=conn.createStatement();
			if(page==1)
			{
				start=1;
				end=5;
			}
			else if (page==2) {
				start=6;
				end=10;
			}
			else {
				start=11;
				rs=stmt.executeQuery("select count(*) from myuser");
				if(rs.next()) end=rs.getInt(1);
			}
			String sql="select * from (select myuser.*,rownum rc from myuser where rownum<='"+end+"') a where a.rc>='"+start+"'";
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				UserVO vo=new UserVO();
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setNex(rs.getString(3));
				vo.setPass(rs.getString(4));
				vo.setPower(rs.getString(5));
				vo.setStatus(rs.getString(6));
				vo.setBirth(rs.getDate(7));    //输入日期
				vo.setMail(rs.getString(8));
				ve.add(vo);	
			}
		} catch (Exception e) {
			throw new DAOException("向Oracle数据库添加数据失败!",e);
		}
		finally
		{
			DBUtils.closeStatement(rs,stmt);
		}
		return ve;
	}

	/**
	 * 模糊查询
	 */
	@Override
	public Vector<UserVO> searchVague(String str) {
		Vector<UserVO> ve=new Vector<UserVO>();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from myuser where id like '%"+str+"%' or name like '%"+str+"%' or nex like '%"+str+"%'";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				UserVO vo=new UserVO();
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setNex(rs.getString(3));
				vo.setPass(rs.getString(4));
				vo.setPower(rs.getString(5));
				vo.setStatus(rs.getString(6));
				vo.setBirth(rs.getDate(7));    //输入日期
				vo.setMail(rs.getString(8));
				ve.add(vo);	
			}
		} catch (Exception e) {
			throw new DAOException("向Oracle数据库添加数据失败!",e);
		}
		finally
		{
			DBUtils.closeStatement(rs,stmt);
		}
		return ve;
	}

}
