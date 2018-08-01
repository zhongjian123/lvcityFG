package com.lingnan.usersys.common.exception;

/**
 * 数据异常类
 * @author 14832
 *
 */
public class DateException extends DAOException{
	public DateException()
	{
		super();
	}
	public DateException(Throwable e)
	{
		super(e);
	}
	public DateException(String message)
	{
		super(message);
	}
	public DateException(String message,Throwable e)
	{
		super(message,e);
	}


}
