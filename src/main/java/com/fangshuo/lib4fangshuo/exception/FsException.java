package com.fangshuo.lib4fangshuo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fangshuo.lib4fangshuo.exception.code.ErrorCode;

/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: FsException.java
* @Description: 方硕异常信息的载体，运行时异常;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年9月29日 下午2:20:30
 */
public class FsException extends RuntimeException{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4202715784002019309L;
	
	protected static final Logger log = LoggerFactory.getLogger(FsException.class.getName());
	
	public ErrorCode errorCode;
	
	public FsException(ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	public  FsException log() {
		log.info(errorCode.getErrDesc());
		return this;
	}
}
