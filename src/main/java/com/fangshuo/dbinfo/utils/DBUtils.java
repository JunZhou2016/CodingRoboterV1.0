package com.fangshuo.dbinfo.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fangshuo.codefactory.utils.StringUtils;
import com.fangshuo.dbinfo.model.database.Column;
import com.fangshuo.dbinfo.model.database.Database;
import com.fangshuo.dbinfo.model.database.Table;
import com.fangshuo.dbinfo.model.project.Entity;
import com.fangshuo.dbinfo.model.project.Project;
import com.fangshuo.dbinfo.model.project.Property;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: DBUtils.java
 * @Description: 数据库信息操作相关的工具集合;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月27日 上午9:52:01
 */
public class DBUtils extends StringUtils {

	/**
	 * 复制数据库信息到项目实体中；
	 * 
	 * @param source:源数据库的数据;
	 * @param target:目标项目实体对象;
	 */
	public static void copyDBToProject(Database source, Project target) {
		try {
			
			String dataBaseName = source.getDbName();
			String	proJectName = DBUtils.underScoreCase2CamelCase(dataBaseName);
			target.setProJectName(proJectName);//项目名称;
			
			List<Table>  sourceTableList = source.getTableSet();//数据库中数据表的集合;
			List<Entity> targetEntityList = new ArrayList<Entity>();//项目中实体的集合;
			
			//复制表格信息道实体中;
			copyTabToEntity(sourceTableList,targetEntityList);
			
			//挂载数据到集合;
			target.setEntitySet(targetEntityList);
		} catch (Exception e) {
			throw new RuntimeException("########表数据迁移失败!########", e);
		}
	}
	
	/**
	 * 复制表格信息道实体中;
	 * @param sourceTable:源表格集合;
	 * @param targetEntity:目标实体对象的集合;
	 */
	public static void copyTabToEntity(List<Table> sourceTableList, List<Entity> targetEntityList) {
		try {
			for (Table source : sourceTableList) {
				Entity target = new Entity();
				
				String tableName = source.getTableName();// 数据库表名称;
				String entityName = getEntityNameByTabName(tableName);// 实体名称,首字母大写;
				target.setEntityName(entityName);
				
				String tableComment = source.getTableComment();//数据库中表的注释;
				String entityDes = tableComment;//实体描述;
				target.setEntityDes(entityDes);

				List<Column> columnSet = new ArrayList<Column>();// 数据表的列集合;
				columnSet.addAll(source.getColumnSet());
				List<Property> propertySet = castColumnSet2PropertySet(columnSet);// 实体的属性集合;
				target.setPropertySet(propertySet);

				//获取实体的toString()字符串;
				String entityStrirng = DBUtils.entityToString(target);
				target.setEntityStrirng(entityStrirng);
				
				//挂载数据到集合中;
				targetEntityList.add(target);
			}
		} catch (Exception e) {
			throw new RuntimeException("########表数据迁移失败!########", e);
		}
	}

	/**
	 * 
	 * @param columnSet:数据表的列集合;
	 * @return:转化后的实体的属性集合;
	 */
	public static List<Property> castColumnSet2PropertySet(List<Column> columnSet) {
		List<Property> propertySet = new ArrayList<Property>();
		for (Column columnEle : columnSet) {
			Property propertyEle = new Property();
			String columnName = columnEle.getColumnName();// 列名称;
			String propertyName = DBUtils.underScoreCase2CamelCase(columnName);// 实体的属性名称;
			String propertyNameUpperCamel = DBUtils.toUpperCaseFirstOne(propertyName);// 首字母大写的实体属性名称;
			String columnComment = columnEle.getColumnComment();// 列的注释信息;
			String dataType = columnEle.getDataType();// 列的类型和长度;
			String isNullAble = columnEle.getIsNullAble();// 列值是否允许为空;

			propertyEle.setPropertyName(propertyName);
			propertyEle.setPropertyNameUpperCamel(propertyNameUpperCamel);
			propertyEle.setPropertyComment(columnComment);
			propertyEle.setPropertyLengthAndType(dataType);
			propertyEle.setIsNullAble(isNullAble);

			propertySet.add(propertyEle);
		}
		return propertySet;
	}

	/**
	 * 
	 * @param sourceStr:源数据字符串;
	 * @return:转换后的字符串;
	 */
	public static String getEntityNameByTabName(String sourceStr) {
		sourceStr = DBUtils.underScoreCase2CamelCase(sourceStr);// 将下划线转化成驼峰命名;
		sourceStr = DBUtils.toUpperCaseFirstOne(sourceStr);// 首字母转化为大写;
		return sourceStr;
	}

	/**
	 * 获取实体的toString()字符串，提供Model模板中的toString数据;
	 * 
	 * @param entity:带转化的实体对象;
	 * @return:数据表列集合格式化字符串;
	 */
	public static String entityToString(Entity entity) {
		List<Property> propertyList = entity.getPropertySet();
		Iterator<Property> it = propertyList.iterator();
		String entityString = null;
		if (propertyList.isEmpty()) {
			return "\"[]\"";
		} else {
			String entityName = entity.getEntityName();
			StringBuilder buffer = new StringBuilder(16);
			buffer.append("\"" + entityName + "[");
			while (it.hasNext()) {
				Property propertyEle = it.next();
				buffer.append(propertyEle.getPropertyName() + "=\"+" + propertyEle.getPropertyName() + "+\",");
			}
			int lastIndexOfComma = buffer.lastIndexOf(",");
			entityString = buffer.substring(0, lastIndexOfComma);
			entityString = entityString + "]\"";
		}
		return entityString;
	}
	
	/**
	 * 获取数据表列的格式化字符串，提供Model模板中的toString数据;
	 * @param columnList:数据表的列集合;
	 * @return:数据表列集合格式化字符串;
	 */
	public static String tableToString(Table table) {
		List<Column> columnList = table.getColumnSet();
		Iterator<Column> it = columnList.iterator();
		String tableString = null;
		if (columnList.isEmpty()) {
		     return "";
		   }else {
			   StringBuilder buffer = new StringBuilder(16);
			   while(it.hasNext()) {
				   Column columnEle = it.next();
				   buffer.append(columnEle.getColumnName()+"," );
			   }
			   int lastIndexOfComma = buffer.lastIndexOf(",");
			   tableString = buffer.substring(0, lastIndexOfComma);
		   }
		return tableString;
	}
}
