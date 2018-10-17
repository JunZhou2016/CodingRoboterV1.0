package com.fangshuo.lib4fangshuo.mongo.model.repository.primary;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: PrimaryMongoObject.java
* @Description: PrimaryMongoObject实体类，最终被映射为collection_"first_mongo";
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年10月17日 下午9:06:58
 */
@Document(collection = "first_mongo")
public class PrimaryMongoObject {

	public PrimaryMongoObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrimaryMongoObject(String id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	private String id;

	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "PrimaryMongoObject{" + "id='" + id + '\'' + ", value='" + value + '\'' + '}';
	}
}
