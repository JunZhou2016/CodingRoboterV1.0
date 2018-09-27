package com.fangshuo.lib4fangshuo.exception;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class LzErrException extends LzException
{
	private static final long serialVersionUID = 201001110101004002L;

	public LzErrException( String errCode, String errDesc, Throwable cause ) 
	{
		super(errCode, errDesc, cause);
		
		if( cause instanceof MySQLIntegrityConstraintViolationException ){
			this.errCode = "999990";
			this.setMessage( "操作数据库时记录重复" );
		}
	}
	
	public LzErrException( String errCode, String errDesc ) 
	{
		super(errCode, errDesc);
	}

	public LzErrException( String errDesc, Throwable cause ) 
	{
		super(errDesc, cause);
	}
	
	public LzErrException( String errDesc ) 
	{
		super(errDesc);
	}
	
	public int getLevel() 
	{
		return ERROR;    
	}
}
