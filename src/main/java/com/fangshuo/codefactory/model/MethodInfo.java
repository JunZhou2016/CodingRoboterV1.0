package com.fangshuo.codefactory.model;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: MethodInfo.java
 * @Description: 方法信息的实体类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月25日 下午2:00:36
 */
public class MethodInfo {
	private String methodDes;// 犯法描述;
	private String methodName;// 方法名称;
	private String methodReqMapping;// 方法匹配路径;
	private String resBody;// 方法的响应值;
	private String reqParam;// 方法的参数;
	private MethodComment methodComment;// 方法的注释;

	public String getMethodDes() {
		return methodDes;
	}

	public void setMethodDes(String methodDes) {
		this.methodDes = methodDes;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodReqMapping() {
		return methodReqMapping;
	}

	public void setMethodReqMapping(String methodReqMapping) {
		this.methodReqMapping = methodReqMapping;
	}

	public String getResBody() {
		return resBody;
	}

	public void setResBody(String resBody) {
		this.resBody = resBody;
	}

	public String getReqParam() {
		return reqParam;
	}

	public void setReqParam(String reqParam) {
		this.reqParam = reqParam;
	}

	public MethodComment getMethodComment() {
		return methodComment;
	}

	public void setMethodComment(MethodComment methodComment) {
		this.methodComment = methodComment;
	}

}
