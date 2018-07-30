package com.lingnan.usersys.common.exception;

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
