package com.lingnan.usersys.common.exception;

/**
 * service异常类
 * @author 14832
 *
 */
public class ServiceException extends DAOException{
	public ServiceException()
	{
		super();
	}
	public ServiceException(Throwable e)
	{
		super(e);
	}
	public ServiceException(String message)
	{
		super(message);
	}
	public ServiceException(String message,Throwable e)
	{
		super(message,e);
	}

}
