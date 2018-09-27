package com.fangshuo.lib4fangshuo.exception.code;

public class ErrorMsg
{
	protected String errCode;
	protected String errDesc;
	
	public ErrorMsg( String errCode, String errDesc )
	{
		this.errCode = errCode;
		this.errDesc = errDesc;
	}
	
	public String getErrCode()
	{
		return errCode;
	}

	public String getErrDesc()
	{
		return errDesc;
	}
}
