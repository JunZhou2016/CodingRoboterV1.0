package com.fangshuo.dbinfo.model.database;

import java.util.List;

import com.fangshuo.codefactory.cfg.CodeGeneratorConfig;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: DBInfo.java
 * @Description: 数据库基础信息；
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月21日 下午3:50:52
 */
public class Database {
	private String id;// 数据表的id;
	private String dbName = CodeGeneratorConfig.JDBC_DB_NAME;// 数据库名称;
	//private String tableName;// 数据表的名称;//
	//private String tableComment;// 数据表的注释;//
	private String tableNameSet;//数据库中数据表名称的集合;
	private List<Table> tableSet;// 数据库中的数据表的集合;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/*public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
*/
	

	public List<Table> getTableSet() {
		return tableSet;
	}

	public void setTableSet(List<Table> tableSet) {
		this.tableSet = tableSet;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	public String getTableNameSet() {
		return tableNameSet;
	}

	public void setTableNameSet(String tableNameSet) {
		this.tableNameSet = tableNameSet;
	}
	
	@Override
	public String toString() {
		return "DBInfo [id=" + id + "]";
	}
}
