package com.fangshuo.dbinfo.model.database;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ERObject.java
 * @Description: 实体关系的载体类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月19日 上午10:15:20
 */
public class ERObject {
	private String columnName;// 列名;
	private String propertyName;// 实体的属性名称;
	
	public ERObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ERObject(String columnName, String propertyName) {
		super();
		this.columnName = columnName;
		this.propertyName = propertyName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
}
