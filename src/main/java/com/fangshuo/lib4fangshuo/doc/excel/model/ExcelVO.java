package com.fangshuo.lib4fangshuo.doc.excel.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ExcelVO.java
 * @Description: excel中的数据对象工厂;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月12日 下午3:33:06
 */
@Component
public class ExcelVO {

	private Map<String, Object> excelVo = new HashMap<String, Object>();// excel展示的对象;

	/**
	 * 获取页面展示所需的信息,一个Map对象;
	 * 
	 * @return
	 */
	public Map<String, Object> getExcelVo() {
		return excelVo;
	}

	/**
	 * 设置excel页面展示信息;
	 * 
	 * @param excelVo:一个Map类型的对象,存储页面信息;
	 */
	public void setExcelVo(Map<String, Object> excelVo) {
		this.excelVo = excelVo;
	}

}
