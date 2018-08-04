package com.lingnan.usersys.usermgr.view;

import java.io.IOException;
import java.util.Date;

import com.lingnan.usersys.common.util.check;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class NormalFrame extends IndexFrame {
	/**
	 * 普通用户显示
	 */
	public void show() {
		int i=-1;
		//循环操作
		do{
			System.out.println(IndexFrame.myVO.getName()+"你好！"+"你的权限是：普通用户");
			System.out.println("==========================");
			System.out.println("1===================修改自己的信息");
			System.out.println("2===================查询自己的信息");
			System.out.println("3===================返回上一层");
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
			UserVO vo;
			switch (i) {
			case 1:
				System.out.println("你现在的信息是：");
				vo=IndexFrame.myVO;                   
		    	this.print(vo);                  //输出信息
				this.updateShow(vo);
				break;
			case 2:
				System.out.println("账号\t"+"姓名\t"+
						"密码\t"+"性别\t"+"权限\t"+"状态\t"+"生日\t\t"+"邮箱地址");
				vo=IndexFrame.myVO;
		    	this.print(vo);
				break;
			case 3:
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
		}while(i!=3);
	}
	
	/**
	 * 修改自己的信息
	 */
	public void updateShow(UserVO vo)
	{
		try {
			UserController con=new UserController();
			System.out.println("请输入新密码：");
			vo.setPass(br.readLine());
			System.out.println("请输入新的姓名：");
			vo.setName(br.readLine());
			System.out.println("请输入新的性别：");
			vo.setNex(br.readLine());
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
			boolean flag=con.updateUser(vo);
			if(flag) System.out.println("修改用户成功");
			else System.out.println("修改用户信息失败");
		} catch (IOException e) {
			System.out.println("修改个人信息失败！");
			
		}
		
	}
	
	/**
	 * 输出方法
	 * @param vo 用户记录
	 */
	public void print(UserVO vo) {
		System.out.println(vo.getId()+"\t"+vo.getName()+"\t"+vo.getPass()+"\t"+vo.getNex()
				+"\t"+vo.getPower()+"\t"+vo.getStatus()+"\t"+vo.getBirth()+"\t"+vo.getMail());
		
	}

}
