package com.fangshuo.lib4fangshuo.doc.excel.model;

import org.springframework.stereotype.Component;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: Excel.java
 * @Description: Excel描述类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月13日 上午9:57:04
 */
@Component
public class Excel {

	private ExcelTemplate excelTemplate;// excel模板对象;
	private ExcelVO excelVO;// excel展示所需的信息;

	public ExcelTemplate getExcelTemplate() {
		return excelTemplate;
	}

	public void setExcelTemplate(ExcelTemplate excelTemplate) {
		this.excelTemplate = excelTemplate;
	}

	public ExcelVO getExcelVO() {
		return excelVO;
	}

	public void setExcelVO(ExcelVO excelVO) {
		this.excelVO = excelVO;
	}

}
