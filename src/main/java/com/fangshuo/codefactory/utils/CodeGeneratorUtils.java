package com.fangshuo.codefactory.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fangshuo.codefactory.cfg.CodeGeneratorConfig;
import com.fangshuo.codefactory.enums.CodeType;
import com.fangshuo.dbinfo.model.ProjectPageInfo;
import com.fangshuo.dbinfo.model.database.Database;
import com.fangshuo.dbinfo.model.database.Table;
import com.fangshuo.dbinfo.model.project.Entity;
import com.fangshuo.dbinfo.model.project.Project;
import com.fangshuo.dbinfo.utils.DBUtils;

import freemarker.template.Configuration;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: CodeGeneratorUtils.java
 * @Description: 代码生成的工具;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月25日 下午1:14:54
 */
public class CodeGeneratorUtils extends CodeGeneratorConfig {

	/**
	 * 根据数据库信息生成代码并初始化页面信息;
	 * 
	 * @param dbInfo:数据库基础信息;
	 */
	public void generateCodeAndInitPageByDB(Database dbInfo) {
		ProjectPageInfo projectPageInfo = new ProjectPageInfo();
		projectPageInfo.setDatabase(dbInfo);
		
		//复制数据库概要信息到项目对象中;
		Database source = dbInfo;
		Project target = new Project();
		DBUtils.copySimpleDBToProject(source, target);

		projectPageInfo.setDatabase(source);
		projectPageInfo.setProject(target);
		// 初始化页面信息;
		//Map<String, Object> pageData = initCommonInfos(projectPageInfo); // 生成代码中的公用信息;

		// 代码生成;
		List<Table> tableList = dbInfo.getTableSet();
		generateCodeByTableAndPageData(tableList, projectPageInfo);
	}

	/**
	 * 根据数据表的信息和页面初始化数据进行代码生成;
	 * 
	 * @param      dbInfo:数据库基本信息;
	 * @param pageData 页面初始化所需的信息;
	 */
	public void generateCodeByTableAndPageData(List<Table> tableList,ProjectPageInfo pageData) {
		for (Table tableEle : tableList) {
			generateCodeByTabAndTypeWithPageData(tableEle, pageData, CodeType.MODEL_TYPE.getTypeName());
			generateCodeByTabAndTypeWithPageData(tableEle, pageData, CodeType.PARAMETER_TYPE.getTypeName());
			generateCodeByTabAndTypeWithPageData(tableEle, pageData, CodeType.CONTROLLER_TYPE.getTypeName());
			generateCodeByTabAndTypeWithPageData(tableEle, pageData, CodeType.SERVICE_TYPE.getTypeName());
			generateCodeByTabAndTypeWithPageData(tableEle, pageData, CodeType.SERVICE_IMPL_TYPE.getTypeName());
			generateCodeByTabAndTypeWithPageData(tableEle, pageData, CodeType.MAPPER_TYPE.getTypeName());
			generateCodeByTabAndTypeWithPageData(tableEle, pageData, CodeType.X_MAPPER_TYPE.getTypeName());
		}
	}

	/**
	 * 根据数据表信息和代码类型以及页面初始化数据生成代码;
	 * 
	 * @param tableEle:数据库表基本信息;
	 * @param pageData 页面初始化所需的信息;
	 * @param codeType:将要生成的代码类型的归属;
	 */
	public void generateCodeByTabAndTypeWithPageData(Table tableEle, ProjectPageInfo pageData, String codeType) {
		if (codeType.equals(CodeType.MODEL_TYPE.getTypeName())) {
			codeProducing(tableEle, pageData, codeType);
		} else if (codeType.equals(CodeType.PARAMETER_TYPE.getTypeName())) {
			codeProducing(tableEle, pageData, codeType);
		} else if (codeType.equals(CodeType.CONTROLLER_TYPE.getTypeName())) {
			codeProducing(tableEle, pageData, codeType);
		} else if (codeType.equals(CodeType.SERVICE_TYPE.getTypeName())) {
			codeProducing(tableEle, pageData, codeType);
		} else if (codeType.equals(CodeType.SERVICE_IMPL_TYPE.getTypeName())) {
			codeProducing(tableEle, pageData, codeType);
		} else if (codeType.equals(CodeType.MAPPER_TYPE.getTypeName())) {
			codeProducing(tableEle, pageData, codeType);
		} else if (codeType.equals(CodeType.X_MAPPER_TYPE.getTypeName())) {
			codeProducing(tableEle, pageData, codeType);
		}
	}

	/**
	 * 代码生成的方法;
	 * 
	 * @param tableEle:数据表的实体;
	 * @param codeType:将要生成的代码类型的归属;
	 */
	public void codeProducing(Table source, ProjectPageInfo pageData, String codeType) {

		// 获取FreeMarker的配置信息;
		Configuration cfg = CfgUtils.getFreemarkerConfiguration();
		
		//复制表格信息到对应的数据实体中;
		Entity target = new Entity();
		DBUtils.copyTabToEntity(source, target);
		Database dataBase = new Database();//表容器；
		Project project = new Project();//实体容器;
		List<Table> tableSet = new ArrayList<Table>();
		List<Entity> entitySet = new ArrayList<Entity>();
		tableSet.add(source);
		entitySet.add(target);
		dataBase.setTableSet(tableSet);
		project.setEntitySet(entitySet);
		pageData.setDatabase(dataBase);
		pageData.setProject(project);
		
		// 初始化页面信息;
		Map<String, Object> pageInfo = initCommonInfos(pageData); // 生成代码中的公用信息;
		
		// 页面相关;
		String tableName = source.getTableName();
		String entityName = DBUtils.getEntityNameByTabName(tableName);// 实体名称,首字母大写;

		String modulePackName = SYS_SEPARATOR + entityName + SYS_SEPARATOR;// 模块代码分属的包名;
		String serviceImplExPath = SYS_SEPARATOR + "Impl" + SYS_SEPARATOR;// ServiceImpl类型代码的扩展路径;

		// 生成文件相关;
		String codeTypeUpperCamel = StringUtils.toUpperCaseFirstOne(codeType);// 首字母大写的codeType;
		String codeTypeLowerCamel = StringUtils.toLowerCaseFirstOne(codeType);// 首字母小写的codeType;
		String codeCategory = codeTypeUpperCamel;// 代码归属类别;

		// 针对codeType的特例进行调整;
		codeCategory = CodeType.MAPPER_TYPE.getTypeName().equals(codeCategory) ? DAO_LEVEL_NAME : codeCategory;// 将Mapper更正为Dao;
		codeCategory = CodeType.SERVICE_IMPL_TYPE.getTypeName().equals(codeCategory)
				? codeCategory.substring(0, codeCategory.length() - 4)
				: codeCategory;// 更新代类别;
		String codeCategoryWithSeparator = SYS_SEPARATOR + codeCategory + SYS_SEPARATOR;// 带系统分隔符的代码归属类别;
		String filePathPrefix = PROJECT_PATH + JAVA_PATH + COMMON_CODE_PATH + modulePackName+ codeCategoryWithSeparator;
		String serviceImplFilePathPrefix = PROJECT_PATH + JAVA_PATH + COMMON_CODE_PATH + modulePackName+codeCategoryWithSeparator
			   + serviceImplExPath;
		filePathPrefix = CodeType.SERVICE_IMPL_TYPE.getTypeName().equals(codeType) ? serviceImplFilePathPrefix
				: filePathPrefix;// 适配生成文件的存储路径;
		String fileSuffix = JAVA_FILE_SUFFIX;// 文件后缀;
		fileSuffix = CodeType.X_MAPPER_TYPE.getTypeName().equals(codeType) ? XML_FILE_SUFFIX : fileSuffix;// 调增文件类型为xml;

		codeTypeUpperCamel = CodeType.PARAMETER_TYPE.getTypeName().equals(codeType) ? FILTER_CODE_TYPE_UPPERCAMEL
				: codeTypeUpperCamel;// 适配Filter生成文件格式;

		String fileName = entityName + codeTypeUpperCamel + fileSuffix;// 生成代码的名称;
		String modelFileName = entityName + fileSuffix;// 生成的实体类的代码名称;
		fileName = CodeType.MODEL_TYPE.getTypeName().equals(codeCategory) ? modelFileName : fileName;// 调整Model类的名称;

		String templateFileName = codeTypeLowerCamel + FTL_FILE_SUFFIX;// 对应的模板文件的名称;

		String filePath = filePathPrefix + fileName;// 生成文件的存储路径;
		try {
			File codeFile = new File(filePath);
			if (!codeFile.getParentFile().exists()) {
				codeFile.getParentFile().mkdirs();
			}
			cfg.getTemplate(templateFileName).process(pageInfo, new FileWriter(codeFile));
			Logger.info(fileName + "生成成功!");
		} catch (Exception e) {
			throw new RuntimeException(fileName + "生成失败!", e);
		}

	}

	/**
	 * 预置页面所需的共数据;
	 * 
	 * @param pageInfo:页面展示需要的信息;；
	 *  @return
	 */
	private Map<String, Object> initCommonInfos(ProjectPageInfo projectInfo) {
		String codeDes = "A Java file created by CodingRoboter!";// 代码描述的默认值;
		String defaultVersion = "v1.0.0";// 代码的默认版本号;
		String company = "FangShuo";
		
		List<Table> tableSet = projectInfo.getDatabase().getTableSet();
		List<Entity> entitySet = projectInfo.getProject().getEntitySet();
		
		Map<String, Object> data = new HashMap<>();

		if((tableSet!=null&&tableSet.size()>0)&&(entitySet!=null&&entitySet.size()>0)) {
			Table tableInfo = tableSet.get(0);
			Entity entityInfo = entitySet.get(0);
			data.put("tableInfo", tableInfo);
			data.put("entityInfo", entityInfo);
		}
		
		data.put("date", DATE);
		data.put("author", AUTHOR);
		data.put("basePackage", BASE_PACKAGE);
		data.put("codeDes", codeDes);
		data.put("codeVersion", defaultVersion);
		data.put("company", company);

		data.put("projectInfo", projectInfo);
		return data;
	}

}
