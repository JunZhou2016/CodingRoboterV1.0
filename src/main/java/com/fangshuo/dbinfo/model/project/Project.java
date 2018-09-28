package com.fangshuo.dbinfo.model.project;

import java.util.List;

import com.fangshuo.codefactory.cfg.CodeGeneratorConfig;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: Project.java
 * @Description: 项目信息描述对象;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月28日 下午1:34:31
 */
public class Project {
	private String proJectName = CodeGeneratorConfig.JDBC_DB_NAME;// 项目名称名称;
	private List<Entity> entitySet;// 项目中的实体的集合;
	
	public String getProJectName() {
		return proJectName;
	}

	public void setProJectName(String proJectName) {
		this.proJectName = proJectName;
	}

	public List<Entity> getEntitySet() {
		return entitySet;
	}

	public void setEntitySet(List<Entity> entitySet) {
		this.entitySet = entitySet;
	}
}
