package com.fangshuo.codefactory.model;

import java.util.List;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ProjectMsg.java
 * @Description: 项目的基础信息类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月25日 下午1:29:32
 */
public class ProjectInfo {
	private String projectPath;// 自定义的项目路径;
	private String projectName;// 项目名称;
	private String projectDes;// 项目描述;

	private List<ModuleInfo> moduleInfos;// 项目的模块信息集合;

	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDes() {
		return projectDes;
	}

	public void setProjectDes(String projectDes) {
		this.projectDes = projectDes;
	}

	public List<ModuleInfo> getModuleInfos() {
		return moduleInfos;
	}

	public void setModuleInfos(List<ModuleInfo> moduleInfos) {
		this.moduleInfos = moduleInfos;
	}
}
