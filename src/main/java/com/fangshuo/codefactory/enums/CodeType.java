package com.fangshuo.codefactory.enums;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: CodeType.java
 * @Description: 描述代码类型的枚举类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月25日 下午10:07:10
 */
public enum CodeType {
	CONTROLLER_TYPE("1", "Controller"), 
	SERVICE_TYPE("2", "Service"), 
	SERVICE_IMPL_TYPE("3", "ServiceImpl"),
	MAPPER_TYPE("4", "Mapper");

	private String typeCode;
	private String typeName;

	private CodeType(String typeCode, String typeName) {
		this.typeCode = typeCode;
		this.typeName = typeName;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
