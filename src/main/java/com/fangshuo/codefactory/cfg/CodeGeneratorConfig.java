package com.fangshuo.codefactory.cfg;

import java.io.File;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: CodeGeneratorConfig.java
 * @Description: 代码生成工具的相关配置信息;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月25日 下午4:29:43
 */
public class CodeGeneratorConfig {
	protected static String SYS_SEPARATOR = File.separator;

	// 默认的项目名称;
	protected static String DEFAULT_PROJECT_NAME = "codingroboter";

	// JDBC 相关配置信息
	protected static String JDBC_URL;
	protected static String JDBC_USERNAME;
	protected static String JDBC_PASSWORD;
	protected static String JDBC_DRIVER_CLASS_NAME;
	public static String JDBC_DB_NAME;

	// 文件相关的信息;
	protected static String XML_TEMPLATE_NAME = "xmapper";// XML类型的模板的名称;
	protected static String XML_FILE_SUFFIX = ".xml";// xml文件的后缀;
	protected static String JAVA_FILE_SUFFIX = ".java";// java文件的后缀；
	protected static String FTL_FILE_SUFFIX = ".ftl";// ftl文件的后缀;
	protected static String DAO_LEVEL_NAME = "Dao";// Dao层级的名称;
	protected static String FILTER_CODE_TYPE_UPPERCAMEL = "Filter";// Parameter类型文件的部分后缀;

	// 项目在硬盘上的基础路径
	protected static final String PROJECT_PATH = System.getProperty("user.dir");
	// java文件路径
	protected static String JAVA_PATH;
	// 资源文件路径
	protected static String RESOURCES_PATH;
	// 模板存放位置
	protected static String TEMPLATE_FILE_PATH;

	// 生成代码在磁盘上的临时存储位置;
	protected static String TEMP_GENERATOR_FILE_PATH = "D:\\DevelopmentBox_2017\\CodesBox\\EclipseWP4Photo\\wp_20180725\\CodingRoboterV1.0\\src\\main\\java\\com\\fangshuo";
	// 生成的APP应用在磁盘上的临时存储位置;
	protected static String TEMP_GENERATOR_APP_PATH = "D:\\DevelopmentBox_2017\\CodesBox\\EclipseWP4Photo\\wp_20180725\\SpringBoot_Core\\src\\main\\java\\com\\fangshuo";
	//独立项目压缩打包的路径;
	protected static String PROJECT_ZIP_PATH = "D:\\DevelopmentBox_2017\\CodesBox\\EclipseWP4Photo\\wp_20180725\\SpringBoot_Core";
	//独立项目压缩包文件的读取路径;
	protected static String PROJECT_ZIP_READ_PATH = "D:\\DevelopmentBox_2017\\CodesBox\\EclipseWP4Photo\\wp_20180725\\CRRepository\\SpringBoot\\Core";
	// 项目基础包
	protected static String BASE_PACKAGE;
	// 项目 Model 所在包
	protected static String MODEL_PACKAGE;
	// 项目 Mapper 所在包
	protected static String MAPPER_PACKAGE;
	// 项目 Service 所在包
	protected static String SERVICE_PACKAGE;
	// 项目 Service 实现类所在包
	protected static String SERVICE_IMPL_PACKAGE;
	// 项目 Controller 所在包
	protected static String CONTROLLER_PACKAGE;

	// 生成的 Service 存放路径
	protected static String PACKAGE_PATH_SERVICE;
	// 生成的 Service 实现存放路径
	protected static String PACKAGE_PATH_SERVICE_IMPL;
	// 生成的 Controller 存放路径
	protected static String PACKAGE_PATH_CONTROLLER;
	// 代码存储路径的公共部分;
	protected static String COMMON_CODE_PATH;

	// MyMapper 插件基础接口的完全限定名
	protected static String MAPPER_INTERFACE_REFERENCE;
	// 通用 Service 层 基础接口完全限定名
	protected static String SERVICE_INTERFACE_REFERENCE;
	// 基于通用 MyBatis Mapper 插件的 Service 接口的实现
	protected static String ABSTRACT_SERVICE_CLASS_REFERENCE;

	// 模板注释中 @author
	protected static String AUTHOR;
	// 模板注释中 @date
	protected static String DATE;
}
