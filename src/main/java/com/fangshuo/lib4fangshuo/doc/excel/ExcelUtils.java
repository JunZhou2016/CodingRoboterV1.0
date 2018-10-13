package com.fangshuo.lib4fangshuo.doc.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fangshuo.codefactory.cfg.CodeGeneratorConfig;
import com.fangshuo.codefactory.utils.CfgUtils;
import com.fangshuo.codefactory.utils.Logger;
import com.fangshuo.lib4fangshuo.doc.excel.model.Excel;
import com.fangshuo.lib4fangshuo.utils.FileUtil;

import freemarker.template.Configuration;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ExcelUtils.java
 * @Description:Excel操作相关的工具类,考虑到word和excel的差别较大，word和excel并未合并;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月12日 下午12:45:04
 */
public class ExcelUtils extends CodeGeneratorConfig {
	/**
	 * 根据ftl模板生成复杂的excel文件; 带图片的excel生成是没有必要的,该工具类生成的excel会缺失图片;
	 * 
	 * 注意：导出的格式都是*.xls,不要生成*.xlsx,由xml生成的xlsx microsoft打不开;
	 * 
	 * @param          excel页面展示和生成的必须信息;
	 * @param request
	 * @param response
	 */
	public static void generateComplexExcelByFtlTemplate(Excel excel, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> data = excel.getExcelVO().getExcelVo();
		// 获取FreeMarker的配置信息;
		Configuration cfg = CfgUtils.getFreemarkerConfiguration();
		try {
			File codeFile = new File(excel.getExcelTemplate().getResFilePath());
			if (!codeFile.getParentFile().exists()) {
				codeFile.getParentFile().mkdirs();
			}
			// 文件生成;
			cfg.getTemplate(excel.getExcelTemplate().getTemplateFilePath()).process(data, new FileWriter(codeFile));
			// 转化为输出流;
			File resFile = new File(excel.getExcelTemplate().getResFilePath());
			InputStream inputStream = new FileInputStream(resFile);
			FileUtil.downFileFromStream(excel.getExcelTemplate().getResFileName(), inputStream, request, response);
			Logger.info(excel.getExcelTemplate().getResFileName() + "生成成功!");
		} catch (Exception e) {
			throw new RuntimeException(excel.getExcelTemplate().getResFileName() + "生成失败!", e);
		}
	}

}
