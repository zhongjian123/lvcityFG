package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.sound.midi.VoiceStatus;
import javax.swing.text.AbstractDocument.BranchElement;

import com.lingnan.usersys.common.util.check;
import com.lingnan.usersys.usermgr.business.service.UserService;
import com.lingnan.usersys.usermgr.business.service.UserServiceImpl;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class IndexFrame implements BaseFrame {
	//声明缓冲处理流对象，用于接收控制台输入的数据
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc=new Scanner(System.in);
	static UserVO myVO=new UserVO();
	static UserController con=new UserController();

	@Override
	public void show() {
		//循环操作
		while(true){
			//用户登录和注册界面
			System.out.println("欢迎使用AI的用户管理系统");
			System.out.println("===========================");
			System.out.println("1===================用户登录");
			System.out.println("2===================用户注册");
			System.out.println("3===================退出程序");
			int i=-1;
			while(true){
				try {
					//读取用户输入操作选项的数字，同时转换int型
					i=Integer.parseInt(br.readLine());
					//终端该循环，进入下一步操作：i值判断
					break;
					
				} catch (Exception e) {
					//出现异常时，提示错误信息，再重新输入
					System.out.println("输入错误，只能输入1~3的数字。");
					System.out.println("请你重新输入");
				}
			}
			switch (i) {
			case 1:
				this.loginShow();
				break;
			case 2:
				this.addShow("注册");
				break;
			case 3:
				System.out.println("感谢你的使用，再会！");
				//退出当前界面
				System.exit(0);

			default:
				System.out.println("你输入的操作不正确，请重新输入！");
				break;
			}
		}
	}

	/**
	 * 用户登录方法
	 */
	public void loginShow() {
		String id;
		String password;
		try {
			System.out.println("用户登录界面");
			System.out.println("===========================");
			System.out.println("请输入账号：");
			id=br.readLine();
			System.out.println("请输入密码：");
			password=br.readLine();
			myVO=this.con.doLogin(id, password);
			if (myVO!=null) {
				System.out.println("登录成功！");
				if(myVO.getPower().equals("1"))
				{
					AdminFrame af=new AdminFrame();
					af.show();
				}
				else {
					NormalFrame nf=new NormalFrame();
					nf.show();
				}
				
			}
			else System.out.println("登录失败，请重新登录！");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 用户注册界面
	 */
	@Override
	public void addShow(String type) {
		try {
			System.out.println("用户注册界面");
			System.out.println("===========================");
			UserVO vo=new UserVO();
			System.out.println("请输入账号：");
			String zh=br.readLine();
			vo=con.doSearchById(zh);
			if(vo!=null) {
				System.out.println("此账号已经被注册，请重新输入");
			}
			else
			{
			vo=new UserVO();
			vo.setId(zh);
			System.out.println("请输入密码：");
			vo.setPass(br.readLine());
			System.out.println("请输入姓名：");
			vo.setName(br.readLine());
			System.out.println("请输入性别：");
			vo.setNex(br.readLine());
			System.out.println("请输入邮件：");
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
			System.out.println("请输入生日");
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
			 boolean flag=this.con.addUser(vo);
			 if(flag) System.out.println("用户注册成功！");
			 else System.out.println("用户注册失败！");
			}
			
			
		} catch (IOException e) {
			 System.out.println("注册异常");
		}
		
		
		
	}

	@Override
	public void searchShow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateShow(UserVO vo) {
		// TODO Auto-generated method stub
		
	}


}
