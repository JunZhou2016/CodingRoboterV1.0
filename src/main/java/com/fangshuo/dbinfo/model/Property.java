package com.fangshuo.dbinfo.model;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: Property.java
 * @Description: 实体属性信息描述载体;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月27日 上午9:47:52
 */
public class Property {
	private String propertyName;// 实体的属性名称;
	private String propertyNameUpperCamel;// 首字母大写的实体属性名称;
	private String propertyComment;// 实体的属性的注释;
	private String propertyLengthAndType;;// 实体的属性的长度和类型;
	private String isNullAble;// 是否允许为空;

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyNameUpperCamel() {
		return propertyNameUpperCamel;
	}

	public void setPropertyNameUpperCamel(String propertyNameUpperCamel) {
		this.propertyNameUpperCamel = propertyNameUpperCamel;
	}

	public String getPropertyComment() {
		return propertyComment;
	}

	public void setPropertyComment(String propertyComment) {
		this.propertyComment = propertyComment;
	}

	public String getPropertyLengthAndType() {
		return propertyLengthAndType;
	}

	public void setPropertyLengthAndType(String propertyLengthAndType) {
		this.propertyLengthAndType = propertyLengthAndType;
	}

	public String getIsNullAble() {
		return isNullAble;
	}

	public void setIsNullAble(String isNullAble) {
		this.isNullAble = isNullAble;
	}
}
