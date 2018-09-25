package com.fangshuo.codefactory.model;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: MethodComment.java
 * @Description: 方法上注解的实体类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月25日 下午2:10:58
 */
public class MethodComment {
	private String methodDesc;// 方法的描述;
	private String methodName;// 方法名称;
	private String methodEnName;// 方法名称的英文，必须和方法的实际名称一致，否则部分功能无法实现;

	public String getMethodDesc() {
		return methodDesc;
	}

	public void setMethodDesc(String methodDesc) {
		this.methodDesc = methodDesc;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodEnName() {
		return methodEnName;
	}

	public void setMethodEnName(String methodEnName) {
		this.methodEnName = methodEnName;
	}
}
