package com.fangshuo.lib4fangshuo.enums;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: AccessLogStatus.java
 * @Description: 操作日志的状态;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月6日 下午9:25:12
 */
public enum AccessLogStatus {
	OTHER("other", "-1"), SUCCESS("success", "0"), FALL("fall", "1");

	private String name;// 状态名称;
	private String statusCode;// 状态代码;

	private AccessLogStatus(String name, String statusCode) {
		this.name = name;
		this.statusCode = statusCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
