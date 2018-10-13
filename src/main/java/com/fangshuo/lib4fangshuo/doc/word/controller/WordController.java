package com.fangshuo.lib4fangshuo.doc.word.controller;

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

import com.fangshuo.lib4fangshuo.doc.word.WordUtils;
import com.fangshuo.lib4fangshuo.doc.word.constant.WordConstant;
import com.fangshuo.lib4fangshuo.doc.word.model.Word;
import com.fangshuo.lib4fangshuo.doc.word.model.WordTemplate;
import com.fangshuo.lib4fangshuo.doc.word.model.WordVO;
import com.fangshuo.lib4fangshuo.utils.UUID;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: WordController.java
 * @Description: Word操作的控制类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月13日 上午11:35:13
 */
@RequestMapping("/doc/")
@RestController
public class WordController {
	// word信息注入;
	@Autowired
	WordVO wordVO;// word展示的信息;
	@Autowired
	Word word;// word对象;
	@Autowired
	WordTemplate wordTemplate;// word模板对象;

	/**
	 * 复杂word生成并下载;
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("downloadWord")
	public void getDBInfosByCondition(HttpServletRequest request, HttpServletResponse response) {
		// 文件路径;
		String templateFilePath = WordConstant.TASK_BOOK.getTemplatePath();// 模板文件的路径;
		String resFilePath = WordConstant.TASK_BOOK.getResPath();// 生成文件的存储路径【服务器系统的路径】;
		// 文件中的数据;
		List<String> dataArray = new ArrayList<String>(Arrays.asList("zj", "wgx", "dmh", "rbq"));
		Map<String, Object> data = new HashMap<>();
		data.put("nameList", dataArray);
		wordVO.setWordVo(data);
		word.setWordVO(wordVO);
		// 初始化模板信息;
		wordTemplate.setTemplateFilePath(templateFilePath);
		wordTemplate.setResFilePath(resFilePath);
		// 生成文件名初始化;
		String resFileName = UUID.getUUID() + ".doc";
		wordTemplate.setResFileName(resFileName);
		word.setWordTemplate(wordTemplate);
		WordUtils.generateComplexWordlByFtlTemplate(word, request, response);
	}
}
