package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import com.lingnan.usersys.common.util.check;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class AdminFrame extends NormalFrame{
	public void show() {
		int i=-1;
		//循环操作
		do{
			//用户登录和注册界面
			System.out.println(IndexFrame.myVO.getName()+"你好！"+"你的权限是：管理员");
			System.out.println("==========================");
			System.out.println("1===================查询用户");
			System.out.println("2===================删除用户");
			System.out.println("3===================修改用户");
			System.out.println("4===================添加用户");
			System.out.println("5===================返回上一层");
			System.out.println("0===================退出程序");
			while(true){
				try {
					//读取用户输入操作选项的数字，同时转换int型
					i=Integer.parseInt(br.readLine());
					//终端该循环，进入下一步操作：i值判断
					break;
					
				} catch (Exception e) {
					//出现异常时，提示错误信息，再重新输入
					System.out.println("输入错误，只能输入1~5的数字。");
					System.out.println("请你重新输入：");
				}
			}
			switch (i) {
			case 1:
				this.searchShow();
				break;
			case 2:
				try {
					System.out.println("请输入你要删除的账号：");
					UserVO vo=this.con.doSearchById(br.readLine());
					if(vo==null) System.out.println("没有此帐号");
					else if (vo.getStatus().equals("0")) System.out.println("此帐号用户信息已经被删除");
					else{
						System.out.println("此帐号的信息："); 
						System.out.println("账号\t"+"姓名\t"+
								"密码\t"+"性别\t"+"权限\t"+"状态\t"+"生日\t\t"+"邮箱地址");
						this.print(vo);
						boolean flag=this.con.doDeleteById(vo.getId());	
						if(flag) System.out.println("成功删除此账号用户信息！");
						else System.out.println("删除失败！");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					System.out.println("请输入你要修改的账号：");
					UserVO vo=this.con.doSearchById(br.readLine());
					if(vo==null) System.out.println("没有此帐号");
					else{
						System.out.println("此帐号现在的信息："); 
						System.out.println("账号\t"+"姓名\t"+
								"密码\t"+"性别\t"+"权限\t"+"状态\t"+"生日\t\t"+"邮箱地址");
						this.print(vo);
						this.updateShow(vo);	 
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				this.addShow("注册");
				break;
			case 5:
				//返回上一层
				break;
			case 0:
				System.out.println("感谢你的使用，再会！");
				//退出程序
				System.exit(0);

			default:
				System.out.println("你输入的操作不正确，请重新输入！");
				break;
			}
		}while(i!=5);
	}
	
	/**
	 * 管理员查询操作
	 */
	public void searchShow()
	{
		int i=-1;
		//循环操作
		do{
			//用户登录和注册界面
			System.out.println("用户查询界面");
			System.out.println("==========================");
			System.out.println("1===================查询所有用户");
			System.out.println("2===================按账号查询用户");
			System.out.println("3===================分页查询用户");
			System.out.println("4===================模糊查询用户");
			System.out.println("5===================返回上一层");
			System.out.println("0===================退出程序");
			while(true){
				try {
					//读取用户输入操作选项的数字，同时转换int型
					i=Integer.parseInt(br.readLine());
					//终端该循环，进入下一步操作：i值判断
					break;
					
				} catch (Exception e) {
					//出现异常时，提示错误信息，再重新输入
					System.out.println("输入错误，只能输入0~5的数字。");
					System.out.println("请你重新输入：");
				}
			}
			Iterator it;
			switch (i) {
			case 1:
				Vector<UserVO> ve=new Vector<UserVO>();
				ve=con.doSearchUser();
				it=ve.iterator();        //迭代器
				System.out.println("账号\t"+"姓名\t"+
						"密码\t"+"性别\t"+"权限\t"+"状态\t"+"生日\t\t"+"邮箱地址");
			    while(it.hasNext())
			    {
			    	UserVO vo=(UserVO)it.next();
			    	this.print(vo);
			    }
				break;
			case 2:
				try {
					System.out.println("请输入你要查找的账号：");
					UserVO vo=this.con.doSearchById(br.readLine());
					if(vo==null) System.out.println("没有此帐号");
					else 
						{
						System.out.println("账号\t"+"姓名\t"+
								"密码\t"+"性别\t"+"权限\t"+"状态\t"+"生日\t\t"+"邮箱地址");
						this.print(vo);
						}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				int page;
				System.out.println("请输入页码:");
				while(true){
					try {
						//读取用户输入操作选项的数字，同时转换int型
						page=Integer.parseInt(br.readLine());
						//终端该循环，进入下一步操作：i值判断
						break;
						
					} catch (Exception e) {
						//出现异常时，提示错误信息，再重新输入
						System.out.println("输入错误，只能输入数字。");
						System.out.println("请你重新输入：");
					}
				}
				Vector<UserVO> vv=new Vector<UserVO>();
				vv=con.doSearchByPage(page);
				it=vv.iterator();             //迭代器
				System.out.println("账号\t"+"姓名\t"+
						"密码\t"+"性别\t"+"权限\t"+"状态\t"+"生日\t\t"+"邮箱地址");
			    while(it.hasNext())
			    {
			    	UserVO vo=(UserVO)it.next();
			    	this.print(vo);
			    }
				break;
			
			case 4:
				System.out.println("请输入账号or姓名or性别的部分信息:");
				String str = null;
				try {
					str=br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Vector<UserVO> vs=new Vector<UserVO>();
				vs=con.doSearchVague(str);
				it=vs.iterator();             //迭代器
				System.out.println("账号\t"+"姓名\t"+
						"密码\t"+"性别\t"+"权限\t"+"状态\t"+"生日\t\t"+"邮箱地址");
			    while(it.hasNext())
			    {
			    	UserVO vo=(UserVO)it.next();
			    	this.print(vo);
			    }
				break;
			case 5:
				//返回上一层
				break;
			case 0:
				System.out.println("感谢亲的使用，再会！");
				//退出程序
				System.exit(0);

			default:
				System.out.println("你输入的操作不正确，请重新输入！");
				break;
			}
		}while(i!=5);
	}
	
	/**
	 * 跟新用户信息（管理员）
	 */
	public void updateShow(UserVO vo)
	{
		try {
			System.out.println("请输入新密码：");
			vo.setPass(br.readLine());
			System.out.println("请输入新的姓名：");
			vo.setName(br.readLine());
			System.out.println("请输入新的性别：");
			vo.setNex(br.readLine());
			System.out.println("请输入新的状态：");
			vo.setStatus(br.readLine());
			System.out.println("请输入新的权限：");
			vo.setPower(br.readLine());
			System.out.println("请输入新的邮箱：");
			while(true){
				String str=br.readLine();
				if(check.isEmail(str)) 
				{
					vo.setMail(str);
					break;
				}
				else
				{
					System.out.println("邮件输入格式错误，请重新输入：");
				}
				
			}
			System.out.println("请输入新的生日：");
			while(true)
			{
				try {
					String str=br.readLine();
					Date date=check.strToDate(str);
					java.sql.Date sd=new java.sql.Date(date.getTime());
					vo.setBirth(sd);
					break;
				} catch (Exception e) {
					System.out.println("日期输入错误！请注意格式: yyyy/MM/dd");
				}
				
			}
			boolean flag=this.con.updateUser(vo);
			if(flag) System.out.println("修改用户成功");
			else System.out.println("修改用户信息失败");
		} catch (IOException e) {
			System.out.println("修改个人信息失败！");
		}
	}
}


