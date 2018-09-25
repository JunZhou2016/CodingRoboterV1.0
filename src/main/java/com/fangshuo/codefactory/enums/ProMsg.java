package com.fangshuo.codefactory.enums;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ProMsg.java
 * @Description: 提示信息的枚举类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月25日 下午1:18:55
 */
public enum ProMsg {
	GENERATE_SUCCESSFULY("0", "代码已经成功生成!"), GENERATE_FAILURE("1", "代码生成失败!");

	private String msgCode;
	private String msgBody;

	private ProMsg(String msgCode, String msgBody) {
		this.msgCode = msgCode;
		this.msgBody = msgBody;
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
}
