package com.lingnan.usersys.common.exception;

/**
 * dao异常类
 * @author 14832
 *
 */
public class DAOException extends RuntimeException{
	public DAOException()
	{
		super();
	}
	public DAOException(Throwable e)
	{
		super(e);
	}
	public DAOException(String message)
	{
		super(message);
	}
	public DAOException(String message,Throwable e)
	{
		super(message,e);
	}
}
