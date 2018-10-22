package com.fangshuo.codefactory.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
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
		// 复制数据库概要信息到项目对象中;
		Database source = dbInfo;
		Project target = new Project();
		DBUtils.copySimpleDBToProject(source, target);

		projectPageInfo.setDatabase(source);
		projectPageInfo.setProject(target);

		// 代码生成;
		List<Table> tableList = dbInfo.getTableSet();
		generateCodeByTableAndPageData(tableList, projectPageInfo);

		// 代码整理和迁移;
		String projectName = target.getProJectName();
		fileDealAndMigrate(projectName);
	}

	/**
	 * 根据数据表的信息和页面初始化数据进行代码生成;
	 * 
	 * @param          dbInfo:数据库基本信息;
	 * @param pageData 页面初始化所需的信息;
	 */
	public void generateCodeByTableAndPageData(List<Table> tableList, ProjectPageInfo pageData) {
		for (Table tableEle : tableList) {
			generateCodeByTabAndTypeWithPageData(tableEle, pageData, CodeType.MODEL_TYPE.getTypeName(),
					CodeType.MODEL_TYPE.getTypeCode());
			generateCodeByTabAndTypeWithPageData(tableEle, pageData, CodeType.PARAMETER_TYPE.getTypeName(),
					CodeType.PARAMETER_TYPE.getTypeCode());
			generateCodeByTabAndTypeWithPageData(tableEle, pageData, CodeType.CONTROLLER_TYPE.getTypeName(),
					CodeType.CONTROLLER_TYPE.getTypeCode());
			generateCodeByTabAndTypeWithPageData(tableEle, pageData, CodeType.SERVICE_TYPE.getTypeName(),
					CodeType.SERVICE_TYPE.getTypeCode());
			generateCodeByTabAndTypeWithPageData(tableEle, pageData, CodeType.SERVICE_IMPL_TYPE.getTypeName(),
					CodeType.SERVICE_IMPL_TYPE.getTypeCode());
			generateCodeByTabAndTypeWithPageData(tableEle, pageData, CodeType.MAPPER_TYPE.getTypeName(),
					CodeType.MAPPER_TYPE.getTypeCode());
			generateCodeByTabAndTypeWithPageData(tableEle, pageData, CodeType.X_MAPPER_TYPE.getTypeName(),
					CodeType.X_MAPPER_TYPE.getTypeCode());
		}
	}

	/**
	 * 根据数据表信息和代码类型以及页面初始化数据生成代码;
	 * 
	 * @param          tableEle:数据库表基本信息;
	 * @param pageData 页面初始化所需的信息;
	 * @param          codeType:将要生成的代码类型的归属;
	 */
	public void generateCodeByTabAndTypeWithPageData(Table tableEle, ProjectPageInfo pageData, String codeType,
			String typeCode) {
		codeProducing(tableEle, pageData, codeType, typeCode);
	}

	/**
	 * 代码生成的方法;
	 * 
	 * @param tableEle:数据表的实体;
	 * @param codeType:将要生成的代码类型的归属;
	 */
	public void codeProducing(Table source, ProjectPageInfo pageData, String codeType, String typeCode) {
		// 获取FreeMarker的配置信息;
		Configuration cfg = CfgUtils.getFreemarkerConfiguration();

		// 复制表格信息到对应的数据实体中;
		Entity target = new Entity();
		DBUtils.copyTabToEntity(source, target);
		Database dataBase = new Database();// 表容器；
		Project project = new Project();// 实体容器;
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
		codeTypeLowerCamel = (CodeType.X_MAPPER_TYPE.getTypeName().equals(codeType)
				&& typeCode.equals(CodeType.X_MAPPER_TYPE.getTypeCode())) ? XML_TEMPLATE_NAME : codeTypeLowerCamel;
		String codeCategory = codeTypeUpperCamel;// 代码归属类别;

		// 针对codeType的特例进行调整;
		codeCategory = CodeType.MAPPER_TYPE.getTypeName().equals(codeCategory) ? DAO_LEVEL_NAME : codeCategory;// 将Mapper更正为Dao;
		codeCategory = CodeType.SERVICE_IMPL_TYPE.getTypeName().equals(codeCategory)
				? codeCategory.substring(0, codeCategory.length() - 4)
				: codeCategory;// 更新代类别;
		String codeCategoryWithSeparator = SYS_SEPARATOR + codeCategory + SYS_SEPARATOR;// 带系统分隔符的代码归属类别;
		String outputPath = PROJECT_PATH + JAVA_PATH + COMMON_CODE_PATH;// 生成源码的输出路径;
		String filePathPrefix = outputPath + modulePackName + codeCategoryWithSeparator;
		String serviceImplFilePathPrefix = outputPath + modulePackName + codeCategoryWithSeparator + serviceImplExPath;
		filePathPrefix = CodeType.SERVICE_IMPL_TYPE.getTypeName().equals(codeType) ? serviceImplFilePathPrefix
				: filePathPrefix;// 适配生成文件的存储路径;
		String fileSuffix = JAVA_FILE_SUFFIX;// 文件后缀;
		fileSuffix = (CodeType.X_MAPPER_TYPE.getTypeName().equals(codeType)
				&& typeCode.equals(CodeType.X_MAPPER_TYPE.getTypeCode())) ? XML_FILE_SUFFIX : fileSuffix;// 调整文件类型为xml;
		codeTypeUpperCamel = CodeType.PARAMETER_TYPE.getTypeName().equals(codeType) ? FILTER_CODE_TYPE_UPPERCAMEL
				: codeTypeUpperCamel;// 适配Filter生成文件格式;

		String fileName = entityName + codeTypeUpperCamel + fileSuffix;// 生成代码的名称;
		String modelFileName = entityName + fileSuffix;// 生成的实体类的代码名称;
		fileName = CodeType.MODEL_TYPE.getTypeName().equals(codeCategory) ? modelFileName : fileName;// 调整Model类的名称;

		String templateFileName = codeTypeLowerCamel + FTL_FILE_SUFFIX;// 对应的模板文件的名称;

		String filePath = filePathPrefix + fileName;// 生成文件的存储路径;
		FileWriter fileWriter = null;
		try {
			File codeFile = new File(filePath);
			if (!codeFile.getParentFile().exists()) {
				codeFile.getParentFile().mkdirs();
			}
			fileWriter = new FileWriter(codeFile);
			cfg.getTemplate(templateFileName).process(pageInfo, fileWriter);
			Logger.info(fileName + "生成成功!");
		} catch (Exception e) {
			throw new RuntimeException(fileName + "生成失败!", e);
		} finally {// 关闭文件输出流;
			try {
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 预置页面所需的共数据;
	 * 
	 * @param pageInfo:页面展示需要的信息;；
	 * @return
	 */
	private Map<String, Object> initCommonInfos(ProjectPageInfo projectInfo) {
		String codeDes = "A Java file created by CodingRoboter!";// 代码描述的默认值;
		String defaultVersion = "v1.0.0";// 代码的默认版本号;
		String company = "FangShuo";

		List<Table> tableSet = projectInfo.getDatabase().getTableSet();
		List<Entity> entitySet = projectInfo.getProject().getEntitySet();

		Map<String, Object> data = new HashMap<>();

		if ((tableSet != null && tableSet.size() > 0) && (entitySet != null && entitySet.size() > 0)) {
			Table tableInfo = tableSet.get(0);
			Entity entityInfo = entitySet.get(0);
			data.put("tableInfo", tableInfo);
			data.put("entityInfo", entityInfo);
		}
		
		data.put("projectInfo", projectInfo);
		
		data.put("date", DATE);
		data.put("author", AUTHOR);
		data.put("basePackage", BASE_PACKAGE);
		data.put("codeDes", codeDes);
		data.put("codeVersion", defaultVersion);
		data.put("company", company);
		
		return data;
	}

	/**
	 * 
	 * 对生成后的文件进行整理和迁移;
	 * 
	 * @param projectName:项目名称;
	 */
	private void fileDealAndMigrate(String projectName) {
		if (null == projectName || "".equals(projectName)) {
			projectName = "codingroboter";// 项目名称;
		}
		String targetPath = TEMP_GENERATOR_FILE_PATH + "\\output";// 生成工具的输出路径;
		String resultPath = TEMP_GENERATOR_APP_PATH + "/" + projectName + ".zip";// 压缩文件的名称;
		String reallyTargetPath = StringUtils.getFilePathByWindowsPath(targetPath);// 特殊字符转义;
		String reallyResultPath = StringUtils.getFilePathByWindowsPath(resultPath);// 特殊字符转义;
		String zipFilePath = reallyResultPath;
		// 压缩生成工具输出目录下的代码到目标文件夹下;
		ZipUtil.zip(reallyTargetPath, reallyResultPath);
		// 解压目标目录下的压缩文件;
		ZipUtil.unzip(zipFilePath);
		// 删除工具输出目录下的生成文件;
		FileUtil.del(reallyTargetPath);
		// 删除文件移动后的zip文件;
		FileUtil.del(reallyResultPath);
	}

}
