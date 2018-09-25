package com.fangshuo.dbinfo.model;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: TabInfo.java
 * @Description: 数据表基础信息的实体类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月21日 下午3:50:59
 */
public class TabInfo {
	private String id;// 数据表中列的id;
	private String tableName;// 数据表的名称;
	private String columnName;// 列名;
	private String ordinalPosition;// 数据列在表中的序号;
	private String columnDefault;// 数据列的默认值;
	private String isNullAble;// 是否允许为空;
	private String dataType;// 数据类型：
	private String characterMaxiMumLength;// 字符的最大长度;
	private String columnType;// 列的数据类型，带长度描述;
	private String columnKey;// 键的类型,PRI Or FK;
	private String columnComment;// 列的注释;
	
	/*id,tableName,columnName,ordinalPosition,columnDefault,isNullAble,dataType,
    * characterMaxiMumLength,columnType,columnKey,columnComment*/	
	
	/*private String baseColumn = "id,TABLE_NAME,COLUMN_NAME,ORDINAL_POSITION,COLUMN_DEFAULT,IS_NULLABLE,DATA_TYPE"
			+ "CHARACTER_MAXIMUM_LENGTH,COLUMN_TYPE,COLUMN_KEY,COLUMN_COMMENT";*/
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getOrdinalPosition() {
		return ordinalPosition;
	}

	public void setOrdinalPosition(String ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

	public String getColumnDefault() {
		return columnDefault;
	}

	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}

	public String getIsNullAble() {
		return isNullAble;
	}

	public void setIsNullAble(String isNullAble) {
		this.isNullAble = isNullAble;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getCharacterMaxiMumLength() {
		return characterMaxiMumLength;
	}

	public void setCharacterMaxiMumLength(String characterMaxiMumLength) {
		this.characterMaxiMumLength = characterMaxiMumLength;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	@Override
	public String toString() {
		return "TabInfo [id=" + id + ", tableName=" + tableName + ", columnName=" + columnName + ", ordinalPosition="
				+ ordinalPosition + ", columnDefault=" + columnDefault + ", isNullAble=" + isNullAble + ", dataType="
				+ dataType + ", characterMaxiMumLength=" + characterMaxiMumLength + ", columnType=" + columnType
				+ ", columnKey=" + columnKey + ", columnComment=" + columnComment + "]";
	}
}
