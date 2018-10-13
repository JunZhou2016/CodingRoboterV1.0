package com.fangshuo.lib4fangshuo.doc.excel.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fangshuo.lib4fangshuo.doc.excel.ExcelUtils;
import com.fangshuo.lib4fangshuo.doc.excel.constant.ExcelConstant;
import com.fangshuo.lib4fangshuo.doc.excel.model.Excel;
import com.fangshuo.lib4fangshuo.doc.excel.model.ExcelTemplate;
import com.fangshuo.lib4fangshuo.doc.excel.model.ExcelVO;
import com.fangshuo.lib4fangshuo.utils.UUID;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ExcelController.java
 * @Description: Excel文件下载;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月12日 下午2:51:09
 */
@RequestMapping("/excel/")
@RestController
public class ExcelController {
	// excel信息注入;
	@Autowired
	ExcelVO excelVO;// excel展示的信息;
	@Autowired
	Excel excel;// excel对象;
	@Autowired
	ExcelTemplate excelTemplate;// excel模板对象;

	/**
	 * 复杂excel生成并下载;
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("downloadExcel")
	public void getDBInfosByCondition(HttpServletRequest request, HttpServletResponse response) {
		// 文件路径;
		String templateFilePath = ExcelConstant.SCHEDULE_TAB_EXCEL.getTemplatePath();// 模板文件的路径;
		String resFilePath = ExcelConstant.SCHEDULE_TAB_EXCEL.getResPath();// 生成文件的存储路径【服务器系统的路径】;
		// 文件中的数据;
		List<String> dataArray = new ArrayList<String>(Arrays.asList("zj", "wgx", "dmh", "rbq"));
		Map<String, Object> data = new HashMap<>();
		data.put("nameList", dataArray);
		excelVO.setExcelVo(data);
		excel.setExcelVO(excelVO);
		// 初始化模板信息;
		excelTemplate.setTemplateFilePath(templateFilePath);
		excelTemplate.setResFilePath(resFilePath);
		// 生成文件名初始化;
		String resFileName = UUID.getUUID() + ".xls";
		excelTemplate.setResFileName(resFileName);
		excel.setExcelTemplate(excelTemplate);
		ExcelUtils.generateComplexExcelByFtlTemplate(excel, request, response);
	}
}
