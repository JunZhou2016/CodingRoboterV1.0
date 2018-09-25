package com.fangshuo.codefactory.model;

import java.util.List;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ModuleMsg.java
 * @Description: 项目模块的基础信息类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月25日 下午1:28:45
 */

public class ModuleInfo {
	private String moduleName;// 模块的名称;
	private String moduleReqMapping;// 模块的匹配路径;
	private String autowiredEntityName;// 需要自动注入的实体名;

	private ModuleComment moduleComment;// 模块【类】的注释;
	private List<MethodInfo> methodInfos;// 模块的方法信息集合;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleReqMapping() {
		return moduleReqMapping;
	}

	public void setModuleReqMapping(String moduleReqMapping) {
		this.moduleReqMapping = moduleReqMapping;
	}

	public String getAutowiredEntityName() {
		return autowiredEntityName;
	}

	public void setAutowiredEntityName(String autowiredEntityName) {
		this.autowiredEntityName = autowiredEntityName;
	}

	public ModuleComment getModuleComment() {
		return moduleComment;
	}

	public void setModuleComment(ModuleComment moduleComment) {
		this.moduleComment = moduleComment;
	}

	public List<MethodInfo> getMethodInfos() {
		return methodInfos;
	}

	public void setMethodInfos(List<MethodInfo> methodInfos) {
		this.methodInfos = methodInfos;
	}
}
