package com.lingnan.usersys.usermgr.domain;

import java.sql.Date;
/**
 * 用户信息类
 * @author 14832
 *
 */
public class UserVO {
	private String id;      //账号
	private String name;    //姓名
	private String nex;     //性别
	private String pass;    //密码
	private String  power;     //权限
	private String status;    //状态
	private Date birth;     //生日
	private String mail;    //邮件
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNex() {
		return nex;
	}
	public void setNex(String nex) {
		this.nex = nex;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
