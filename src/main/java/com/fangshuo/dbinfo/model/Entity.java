package com.fangshuo.dbinfo.model;

import java.util.List;

import com.fangshuo.dbinfo.utils.DBUtils;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: Entity.java
 * @Description: 实体信息描述类，实体的属性名称一般是首字母小写的;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月27日 上午9:34:46
 */
public class Entity {
	private String entityName;// 实体名称;
	private String localVariableName;//实体内的局部变量的名称,实体名称的首字母小写；
	private List<Property> propertySet;//实体的属性集合;
	private String entityStrirng;//实体的格式化字符串信息;
	
	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
		this.setLocalVariableName(entityName);
	}

	public List<Property> getPropertySet() {
		return propertySet;
	}

	public void setPropertySet(List<Property> propertySet) {
		this.propertySet = propertySet;
	}

	public String getEntityStrirng() {
		return entityStrirng;
	}

	public void setEntityStrirng(String entityStrirng) {
		this.entityStrirng = entityStrirng;
	}

	public String getLocalVariableName() {
		return localVariableName;
	}

	public void setLocalVariableName(String localVariableName) {
		this.localVariableName = DBUtils.toLowerCaseFirstOne(localVariableName);
	};
}
