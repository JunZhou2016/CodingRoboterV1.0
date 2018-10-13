package com.fangshuo.lib4fangshuo.doc.excel.constant;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ExcelConstant.java
 * @Description: Excel相关的常量;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月13日 上午10:43:26
 */
public enum ExcelConstant {
	SCHEDULE_TAB_EXCEL("进度表的excel模板信息", "excel/excel.ftl", "D:/doc/");

	private String fileDes;// 文件描述;
	private String templatePath;// 模板文件的路径;
	private String resPath;// 生成后文件文件在本机的临时存储路径;

	private ExcelConstant(String fileDes, String templatePath, String resPath) {
		this.fileDes = fileDes;
		this.templatePath = templatePath;
		this.resPath = resPath;
	}

	public String getFileDes() {
		return fileDes;
	}

	public void setFileDes(String fileDes) {
		this.fileDes = fileDes;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getResPath() {
		return resPath;
	}

	public void setResPath(String resPath) {
		this.resPath = resPath;
	}

}
