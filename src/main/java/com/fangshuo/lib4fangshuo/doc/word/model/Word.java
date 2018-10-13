package com.fangshuo.lib4fangshuo.doc.word.model;

import org.springframework.stereotype.Component;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: Word.java
 * @Description: 描述Word文档的实体类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月13日 上午11:37:00
 */
@Component
public class Word {
	private WordTemplate wordTemplate;// word模板对象;
	private WordVO wordVO;// word展示所需的信息;

	public WordTemplate getWordTemplate() {
		return wordTemplate;
	}

	public void setWordTemplate(WordTemplate wordTemplate) {
		this.wordTemplate = wordTemplate;
	}

	public WordVO getWordVO() {
		return wordVO;
	}

	public void setWordVO(WordVO wordVO) {
		this.wordVO = wordVO;
	}

}
