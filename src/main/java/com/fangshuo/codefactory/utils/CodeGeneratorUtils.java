package com.fangshuo.codefactory.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import com.fangshuo.codefactory.cfg.CodeGeneratorConfig;
import com.fangshuo.codefactory.enums.CodeType;
import com.google.common.base.CaseFormat;

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
public class CodeGeneratorUtils extends CodeGeneratorConfig{
	/**
	 * 根据代码类型生成代码;
	 * @param modelName:模块名称;
	 * @param codeType:将要生成的代码类型的归属;
	 */
	public void generateCodeByType(String modelName,String codeType) {
		if(codeType.equals(CodeType.CONTROLLER_TYPE.getTypeName())) {
			genCode(modelName,codeType);
		}
	}
	
	/**
	 * 
	 * @param modelName:模块名称;
	 * @param codeType:将要生成的代码类型的归属;
	 */
	public void genCode(String modelName,String codeType) {
		Configuration cfg = CfgUtils.getFreemarkerConfiguration();
		String modulePackName = "/" + StringUtils.toLowerCaseFirstOne(modelName) + "/";//模块代码归属的包名;
		String modelNameUpperCamel = modelName;//模块名称的大写样式;
		Map<String, Object> data = initCommonInfos(modelNameUpperCamel); //生成代码中的公用信息;
		
		try {
			File controllerFile = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER+ modulePackName
						 + modelNameUpperCamel + "Controller.java");
	        if (!controllerFile.getParentFile().exists()) {
	        	controllerFile.getParentFile().mkdirs();
	        }
	        cfg.getTemplate("controller.ftl").process(data, new FileWriter(controllerFile));
			Logger.info(modelNameUpperCamel + "Controller.java 生成成功!");
		} catch (Exception e) {
			throw new RuntimeException("Controller 生成失败!", e);
		}
		
	}
	
	
	/**
	 * 预置页面所需数据
	 * @param tableName 表名
	 * @param modelName 自定义实体类名, 为null则默认将表名下划线转成大驼峰形式
	 * @param sign 区分字段, 规定如表 gen_test_demo, 则 test 即为区分字段
	 * @param modelNameUpperCamel 首字为大写的实体类名
	 * @return
	 */
	private Map<String, Object> initCommonInfos(String modelNameUpperCamel) {
		Map<String, Object> data = new HashMap<>();
		data.put("date", DATE);
        data.put("author", AUTHOR);
        data.put("baseRequestMapping", StringUtils.toLowerCaseFirstOne(modelNameUpperCamel));
        data.put("modelNameUpperCamel", modelNameUpperCamel);
        data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
        data.put("basePackage", BASE_PACKAGE);
		return data;
	}

}
