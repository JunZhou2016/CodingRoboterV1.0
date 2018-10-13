package com.fangshuo.lib4fangshuo.doc.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fangshuo.codefactory.utils.CfgUtils;
import com.fangshuo.codefactory.utils.Logger;
import com.fangshuo.lib4fangshuo.doc.word.model.Word;
import com.fangshuo.lib4fangshuo.utils.FileUtil;

import freemarker.template.Configuration;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: WordUtils.java
 * @Description: Word操作相关的工具类,考虑到word和excel的差别较大，word和excel并未合并;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月13日 下午12:54:51
 */
public class WordUtils {
	/**
	 * 
	 * 根据ftl模板生成复杂的word文件
	 * 
	 * 注意：导出的格式都是*.doc,不要生成*.docx,由xml生成的docx microsoft和wps都打不开;
	 * 
	 * @param word     页面展示和生成的必须信息;
	 * @param request
	 * @param response
	 */
	public static void generateComplexWordlByFtlTemplate(Word word, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> data = word.getWordVO().getWordVo();
		// 获取FreeMarker的配置信息;
		Configuration cfg = CfgUtils.getFreemarkerConfiguration();
		try {
			File codeFile = new File(word.getWordTemplate().getResFilePath());
			if (!codeFile.getParentFile().exists()) {
				codeFile.getParentFile().mkdirs();
			}
			// 文件生成;
			cfg.getTemplate(word.getWordTemplate().getTemplateFilePath()).process(data, new FileWriter(codeFile));
			// 转化为输出流;
			File resFile = new File(word.getWordTemplate().getResFilePath());
			InputStream inputStream = new FileInputStream(resFile);
			FileUtil.downFileFromStream(word.getWordTemplate().getResFileName(), inputStream, request, response);
			Logger.info(word.getWordTemplate().getResFileName() + "生成成功!");
		} catch (Exception e) {
			throw new RuntimeException(word.getWordTemplate().getResFileName() + "生成失败!", e);
		}
	}

}
