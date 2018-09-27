package com.fangshuo.codefactory.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fangshuo.codefactory.cfg.CodeGeneratorConfig;
import com.fangshuo.codefactory.enums.CodeType;
import com.fangshuo.dbinfo.model.Entity;
import com.fangshuo.dbinfo.model.TemplateInfo;
import com.fangshuo.dbinfo.model.Table;
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
	 * 根据数据表的信息进行代码生成;
	 * 
	 * @param tables:将要进行代码生成的数据表的集合;
	 */
	public void generateCodeByTable(List<Table> tables) {
		for (Table tableEle : tables) {
			generateCodeByTabAndType(tableEle, CodeType.MODEL_TYPE.getTypeName());
			generateCodeByTabAndType(tableEle, CodeType.PARAMETER_TYPE.getTypeName());
			generateCodeByTabAndType(tableEle, CodeType.CONTROLLER_TYPE.getTypeName());
			generateCodeByTabAndType(tableEle, CodeType.SERVICE_TYPE.getTypeName());
			generateCodeByTabAndType(tableEle, CodeType.SERVICE_IMPL_TYPE.getTypeName());
			generateCodeByTabAndType(tableEle, CodeType.MAPPER_TYPE.getTypeName());
			generateCodeByTabAndType(tableEle, CodeType.X_MAPPER_TYPE.getTypeName());
		}
	}

	/**
	 * 根据数据表信息和代码类型生成代码;
	 * 
	 * @param tableEle:数据表的实体;
	 * @param codeType:将要生成的代码类型的归属;
	 */
	public void generateCodeByTabAndType(Table tableEle, String codeType) {
		if (codeType.equals(CodeType.MODEL_TYPE.getTypeName())) {
			codeProducing(tableEle, codeType);
		}else if (codeType.equals(CodeType.PARAMETER_TYPE.getTypeName())) {
			codeProducing(tableEle, codeType);
		} else if (codeType.equals(CodeType.CONTROLLER_TYPE.getTypeName())) {
			codeProducing(tableEle, codeType);
		} else if (codeType.equals(CodeType.SERVICE_TYPE.getTypeName())) {
			codeProducing(tableEle, codeType);
		} else if (codeType.equals(CodeType.SERVICE_IMPL_TYPE.getTypeName())) {
			codeProducing(tableEle, codeType);
		} else if (codeType.equals(CodeType.MAPPER_TYPE.getTypeName())) {
			codeProducing(tableEle, codeType);
		}else if (codeType.equals(CodeType.X_MAPPER_TYPE.getTypeName())) {
			codeProducing(tableEle, codeType);
		}
	}

	/**
	 * 代码生成的方法;
	 * 
	 * @param tableEle:数据表的实体;
	 * @param codeType:将要生成的代码类型的归属;
	 */
	public void codeProducing(Table tableEle, String codeType) {
		TemplateInfo templateInfo = new TemplateInfo();
		Table source = tableEle;
		Entity target = new Entity();
		DBUtils.copyTabToEntity(source, target);
		templateInfo.setEntity(target);
		templateInfo.setTable(source);
		
		Configuration cfg = CfgUtils.getFreemarkerConfiguration();

		// 页面相关;
		String entityName = target.getEntityName();//实体名称;
		String modulePackName = SYS_SEPARATOR + entityName + SYS_SEPARATOR;// 模块代码分属的包名;
		String serviceImplExPath = SYS_SEPARATOR + "Impl" + SYS_SEPARATOR;// ServiceImpl类型代码的扩展路径;
		Map<String, Object> data = initCommonInfos(templateInfo); // 生成代码中的公用信息;

		// 生成文件相关;
		String codeTypeUpperCamel = StringUtils.toUpperCaseFirstOne(codeType);// 首字母大写的codeType;
		String codeTypeLowerCamel = StringUtils.toLowerCaseFirstOne(codeType);// 首字母小写的codeType;
		String codeCategory = codeTypeUpperCamel;// 代码归属类别;
		
		// 针对codeType的特例进行调整;
		codeCategory = CodeType.MAPPER_TYPE.getTypeName().equals(codeCategory) ? DAO_LEVEL_NAME: codeCategory;// 将Mapper更正为Dao;
		codeCategory = CodeType.SERVICE_IMPL_TYPE.getTypeName().equals(codeCategory) ? codeCategory.substring(0, codeCategory.length() - 4)
				: codeCategory;// 更新代类别;
		String codeCategoryWithSeparator = SYS_SEPARATOR + codeCategory + SYS_SEPARATOR;// 带系统分隔符的代码归属类别;
		String filePathPrefix = PROJECT_PATH + JAVA_PATH + COMMON_CODE_PATH + codeCategoryWithSeparator
				+ modulePackName;
		String serviceImplFilePathPrefix = PROJECT_PATH + JAVA_PATH + COMMON_CODE_PATH + codeCategoryWithSeparator
				+ modulePackName + serviceImplExPath;
		filePathPrefix = CodeType.SERVICE_IMPL_TYPE.getTypeName().equals(codeType) ? serviceImplFilePathPrefix : filePathPrefix;// 适配生成文件的存储路径;
		String fileSuffix = JAVA_FILE_SUFFIX;//文件后缀;
		fileSuffix = CodeType.X_MAPPER_TYPE.getTypeName().equals(codeType) ? XML_FILE_SUFFIX : fileSuffix;//调增文件类型为xml;
		
		codeTypeUpperCamel = CodeType.PARAMETER_TYPE.getTypeName().equals(codeType) ? FILTER_CODE_TYPE_UPPERCAMEL : codeTypeUpperCamel;// 适配Filter生成文件格式;
		
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
			cfg.getTemplate(templateFileName).process(data, new FileWriter(codeFile));
			Logger.info(fileName + "生成成功!");
		} catch (Exception e) {
			throw new RuntimeException(fileName + "生成失败!", e);
		}

	}

	/**
	 * 预置页面所需的公共数据;
	 * 
	 * @param tableEle:将要进行代码生成的目标数据表格； @return：页面展示需要的信息;
	 */
	private Map<String, Object> initCommonInfos(TemplateInfo templateInfo) {
		String codeDes = "A Java file created by CodingRoboter!";// 代码描述的默认值;
		String defaultVersion = "v1.0.0";// 代码的默认版本号;
		String company = "FangShuo";

		Map<String, Object> data = new HashMap<>();
		data.put("date", DATE);
		data.put("author", AUTHOR);
		data.put("basePackage", BASE_PACKAGE);
		data.put("codeDes", codeDes);
		data.put("codeVersion", defaultVersion);
		data.put("company", company);
		
		//页面所需的数据表和实体的动态信息;
		data.put("templateInfo", templateInfo);
		return data;
	}
	
}
