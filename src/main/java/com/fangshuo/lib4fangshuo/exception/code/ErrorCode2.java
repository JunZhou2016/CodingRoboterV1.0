package com.fangshuo.lib4fangshuo.exception.code;

import java.text.MessageFormat;

import com.fangshuo.lib4fangshuo.exception.LzErrException;
import com.fangshuo.lib4fangshuo.exception.LzException;
import com.fangshuo.lib4fangshuo.exception.LzWarnException;


public class ErrorCode2 extends ErrorCode
{
	private MessageFormat format;
	
	public ErrorCode2( String errCode, String errDesc )
	{
		this.errCode = errCode;
		this.format = new MessageFormat(errDesc);
	}

	public ErrorMsg format( String arg1, String arg2 )
	{
		Object args[] = {arg1, arg2};
		return new ErrorMsg(errCode, format.format(args));
	}

	public LzException exception( String arg1, String arg2 )
	{
		Object args[] = {arg1, arg2};
		return new LzErrException( errCode, format.format(args) );
	}
	
	public LzException exception( String arg1, String arg2, Throwable cause )
	{
		Object args[] = {arg1, arg2};
		return new LzErrException( errCode, format.format(args), cause );
	}
	
	public LzException warn( String arg1, String arg2 )
	{
		Object args[] = {arg1, arg2};
		return new LzWarnException( errCode, format.format(args) );
	}
	
	public LzException warn( String arg1, String arg2, Throwable cause )
	{
		Object args[] = {arg1, arg2};
		return new LzWarnException( errCode, format.format(args), cause );
	}
}

