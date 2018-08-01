package com.lingnan.usersys.common.exception;

/**
 * 邮件地址异常类
 * @author 14832
 *
 */
public class EmailException extends DAOException{
	public EmailException()
	{
		super();
	}
	public EmailException(Throwable e)
	{
		super(e);
	}
	public EmailException(String message)
	{
		super(message);
	}
	public EmailException(String message,Throwable e)
	{
		super(message,e);
	}

}
