package com.fangshuo.codefactory.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.fangshuo.codefactory.cfg.CodeGeneratorConfig;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: CfgUtils.java
 * @Description: 配置文件相关的工具类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月25日 下午4:36:29
 */
public class CfgUtils extends CodeGeneratorConfig{
	private static Configuration configuration = null;
	
	static {
		// 初始化配置信息
		init();
	}
	
	/**
	 * 获取 Freemarker 模板环境配置
	 * @return
	 */
	public static Configuration getFreemarkerConfiguration() {
		if (configuration == null) {
			configuration = initFreemarkerConfiguration();
		}
		return configuration;
	}
	
	/**
	 * Freemarker 模板环境配置
	 * @return
	 * @throws IOException
	 */
	private static Configuration initFreemarkerConfiguration() {
		Configuration cfg = null;
		try {
			cfg = new Configuration(Configuration.VERSION_2_3_23);
			cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
		} catch (IOException e) {
			throw new RuntimeException("Freemarker 模板环境初始化异常!", e);
		}
		return cfg;
	}
	
	/**
	 * 包转成路径
	 * eg: com.bigsea.sns ==> com/bigsea/sns
	 * @param packageName
	 * @return
	 */
	public static String packageConvertPath(String packageName) {
		return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
	}
	
	/**
	 * 初始化配置信息
	 */
	@SuppressWarnings("unused")
	public static void init() {
		Properties prop = loadProperties();
		
		JDBC_URL = prop.getProperty("jdbc.url");
		JDBC_USERNAME = prop.getProperty("jdbc.username");
		JDBC_PASSWORD = prop.getProperty("jdbc.password");
		JDBC_DRIVER_CLASS_NAME = prop.getProperty("jdbc.driver.class.name");
		JDBC_DB_NAME = prop.getProperty("jdbc.dbname");
		
		JAVA_PATH = prop.getProperty("java.path");
		RESOURCES_PATH = prop.getProperty("resources.path");
		TEMPLATE_FILE_PATH = PROJECT_PATH + prop.getProperty("template.file.path");
		
		BASE_PACKAGE = prop.getProperty("base.package");
		MODEL_PACKAGE = prop.getProperty("model.package");
		MAPPER_PACKAGE = prop.getProperty("mapper.package");
		SERVICE_PACKAGE = prop.getProperty("service.package");
		SERVICE_IMPL_PACKAGE = prop.getProperty("service.impl.package");
		CONTROLLER_PACKAGE = prop.getProperty("controller.package");
		
		MAPPER_INTERFACE_REFERENCE = prop.getProperty("mapper.interface.reference");
		SERVICE_INTERFACE_REFERENCE = prop.getProperty("service.interface.reference");
		ABSTRACT_SERVICE_CLASS_REFERENCE = prop.getProperty("abstract.service.class.reference");
		
		String servicePackage = prop.getProperty("package.path.service");
		String serviceImplPackage = prop.getProperty("package.path.service.impl");
		String controllerPackage = prop.getProperty("package.path.controller");
		
		PACKAGE_PATH_SERVICE = "".equals(servicePackage) ? packageConvertPath(SERVICE_PACKAGE) : servicePackage;
		PACKAGE_PATH_SERVICE_IMPL = "".equals(serviceImplPackage) ? packageConvertPath(SERVICE_IMPL_PACKAGE) : serviceImplPackage;
		PACKAGE_PATH_CONTROLLER = "".equals(controllerPackage) ? packageConvertPath(CONTROLLER_PACKAGE) : controllerPackage;
		
		COMMON_CODE_PATH = packageConvertPath(BASE_PACKAGE);
		
		AUTHOR = prop.getProperty("author");
		String dateFormat = "".equals(prop.getProperty("date-format")) ? "yyyy/MM/dd" : prop.getProperty("date-format");
		DATE = new SimpleDateFormat(dateFormat).format(new Date());
		
		/*MODEL = CodeType.MODEL_TYPE.getTypeName();// model类型;
		CONTROLLER = CodeType.CONTROLLER_TYPE.getTypeName();// controller类型;
		SERVICE = CodeType.SERVICE_TYPE.getTypeName();// service类型;
		SERVICE_IMPL = CodeType.SERVICE_IMPL_TYPE.getTypeName();// serviceImpl类型;
		MAPPER = CodeType.MAPPER_TYPE.getTypeName();// mapper类型;
		PARAMETER = CodeType.PARAMETER_TYPE.getTypeName();// parameter类型;
		X_MAPPER = CodeType.X_MAPPER_TYPE.getTypeName();// xml-mapper类型;
		*/
	}
	
	/**
	 * 加载配置文件
	 * @return
	 */
	public static Properties loadProperties() {
		Properties prop = null;
		try {
			prop = new Properties();
			InputStream in = CfgUtils.class.getClassLoader().getResourceAsStream("generatorConfig.properties");
			prop.load(in);
		} catch (Exception e) {
			throw new RuntimeException("加载配置文件异常!", e);
		}
		return prop;
	}
}
