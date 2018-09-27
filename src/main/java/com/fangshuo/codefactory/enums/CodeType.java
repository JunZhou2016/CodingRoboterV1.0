package com.fangshuo.codefactory.enums;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: CodeType.java
 * @Description: 描述代码类型的枚举类; 注意：codeType首字母务必大写;
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月25日 下午10:07:10
 */
public enum CodeType {
	MODEL_TYPE("1", "Model"), // 实体类型;
	CONTROLLER_TYPE("2", "Controller"), // 控制器类型;
	SERVICE_TYPE("3", "Service"), // Service类型;
	SERVICE_IMPL_TYPE("4", "ServiceImpl"), // ServiceImpl类型;
	MAPPER_TYPE("5", "Mapper"), // Mapper类型;
	PARAMETER_TYPE("6", "Parameter"), // Parameter类型;
	X_MAPPER_TYPE("7", "Xmapper");// Xml类型的Mapper文件;

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
