package com.lingnan.usersys.common.exception;

/**
 * 
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
