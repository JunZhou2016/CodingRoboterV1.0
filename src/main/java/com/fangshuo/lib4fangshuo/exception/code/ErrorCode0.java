package com.fangshuo.lib4fangshuo.exception.code;

import com.fangshuo.lib4fangshuo.exception.LzErrException;
import com.fangshuo.lib4fangshuo.exception.LzException;
import com.fangshuo.lib4fangshuo.exception.LzWarnException;

public class ErrorCode0 extends ErrorCode
{
	public ErrorCode0( String errCode, String errDesc )
	{
		this.errCode = errCode;
		this.errDesc = errDesc;
	}

	public ErrorMsg format( )
	{
		return new ErrorMsg(errCode, errDesc);
	}

	public LzException exception()
	{
		return new LzErrException( errCode, errDesc );
	}
	
	public LzException exception( Throwable cause )
	{
		return new LzErrException( errCode, errDesc, cause );
	}
	
	public LzException warn()
	{
		return new LzWarnException( errCode, errDesc );
	}
	
	public LzException warn( Throwable cause )
	{
		return new LzWarnException( errCode, errDesc, cause );
	}
	

}

