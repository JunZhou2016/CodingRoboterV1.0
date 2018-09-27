package com.fangshuo.lib4fangshuo.exception;

public class LzWarnException extends LzException
{
	private static final long serialVersionUID = 201001110101004003L;
	
	public LzWarnException( String errCode, String errDesc, Throwable cause ) 
	{
		super(errCode, errDesc, cause);
	}
	
	public LzWarnException( String errCode, String errDesc ) 
	{
		super(errCode, errDesc);
	}
	
	public int getLevel() 
	{
		return WARN;    
	}
}
