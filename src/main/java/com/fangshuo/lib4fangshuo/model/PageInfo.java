package com.fangshuo.lib4fangshuo.model;

import java.io.Serializable;

import com.fangshuo.lib4fangshuo.annotation.FieldNote;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: PageInfo.java
 * @Description: 分页信息;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月30日 上午9:26:47
 */
public class PageInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5288108925380639352L;

	public static Long totalCount = 10000L;// 默认限制规模为一万;

	@FieldNote(desc = "页面大小")
	public Integer pageSize = 10;// 默认为10;

	@FieldNote(desc = "起始页")
	public Integer startPage = 0;

	@FieldNote(desc = "总页数")
	public int totalRow = 0;

	@FieldNote(desc = "排序字段")
	public String orderBy = "";// 默认不排序;

	public PageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageInfo(Integer pageRow, Integer startPage) {
		super();
		this.pageSize = pageRow;
		this.startPage = startPage;
	}

	public PageInfo(Integer pageRow, Integer startPage, int totalRow, String orderBy) {
		super();
		this.pageSize = pageRow;
		this.startPage = startPage;
		this.totalRow = totalRow;
		this.orderBy = orderBy;
	}

	public PageInfo(Integer pageRow, Integer startPage, int totalRow) {
		super();
		this.pageSize = pageRow;
		this.startPage = startPage;
		this.totalRow = totalRow;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public long getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public static long getTotalcount() {
		return totalCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
