package com.fangshuo.lib4fangshuo.exception.code;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: BaseErrCode.java
 * @Description: 基础异常信息类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月29日 下午2:25:02
 */
public abstract class BaseErrorCode{
	
	protected String errCode;
	protected String errDesc;
	
	public BaseErrorCode(String errCode, String errDesc) {
		super();
		this.errCode = errCode;
		this.errDesc = errDesc;
	}

	public BaseErrorCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getErrCode() {
		return errCode;
	}

	public String getErrDesc() {
		return errDesc;
	}

}
