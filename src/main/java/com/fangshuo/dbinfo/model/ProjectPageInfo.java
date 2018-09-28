package com.fangshuo.dbinfo.model;

import com.fangshuo.dbinfo.model.database.Database;
import com.fangshuo.dbinfo.model.project.Project;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ERT.java
 * @Description: 模板所需的数据信息；
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月27日 下午12:48:18
 */
public class ProjectPageInfo {
	// private Entity entity;// 实体;
	// private Table table;// 数据表;
	private Database database;// 数据库实体;
	private Project project;// 项目实体;
	private String projectStruct = "com.fangshuo.output";// 项目结构【项目的路径,用于匹配实际项目的结构】<==>basePackage;

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getProjectStruct() {
		return projectStruct;
	}

	public void setProjectStruct(String projectStruct) {
		this.projectStruct = projectStruct;
	}

}
