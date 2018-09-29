package com.fangshuo.lib4fangshuo.model;

import com.fangshuo.lib4fangshuo.annotation.FieldNote;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ReqHeader.java
 * @Description: 请求头信息;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月29日 上午11:43:40
 */
public class ReqHeader {

	// 客户端流水号
	@FieldNote(desc = "客户端流水号")
	private String flowNo = "";

	@FieldNote(desc = "终端类型")
	private String term = "";

	@FieldNote(desc = "企业编号")
	private String corp = "";

	public ReqHeader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReqHeader(String flowNo, String term, String corp) {
		super();
		this.flowNo = flowNo;
		this.term = term;
		this.corp = corp;
	}

	public String getFlowNo() {
		return flowNo;
	}

	public void setFlowNo(String flowNo) {
		this.flowNo = flowNo;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getCorp() {
		return corp;
	}

	public void setCorp(String corp) {
		this.corp = corp;
	}
}
