package com.fangshuo.lib4fangshuo.doc.excel.model;

import org.springframework.stereotype.Component;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ExcelTemplate.java
 * @Description: excel模板描述类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月13日 上午9:42:22
 */
@Component
public class ExcelTemplate {
	private String templateFilePath;// 模板文件的路径,模板文件放在resources/templates文件夹下;
	private String resFilePath;// 生成后文件的存储路径,文件名称已经自动添加，不用手动追加了;
	private String resFileName;// 生成后文件名称;

	public String getTemplateFilePath() {
		return templateFilePath;
	}

	public void setTemplateFilePath(String templateFilePath) {
		this.templateFilePath = templateFilePath;
	}

	public String getResFilePath() {
		return resFilePath + resFileName;
	}

	public void setResFilePath(String resFilePath) {
		this.resFilePath = resFilePath;
	}

	public String getResFileName() {
		return resFileName;
	}

	public void setResFileName(String resFileName) {
		this.resFileName = resFileName;
	}
}
