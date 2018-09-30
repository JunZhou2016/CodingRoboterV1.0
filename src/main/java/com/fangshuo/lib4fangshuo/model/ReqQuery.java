package com.fangshuo.lib4fangshuo.model;

import java.io.Serializable;

import com.fangshuo.lib4fangshuo.annotation.FieldNote;
import com.fangshuo.lib4fangshuo.annotation.PojoNote;
/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: ReqQuery.java
* @Description: 带分页信息的请求数据对象;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年9月30日 上午9:01:47
 */
@PojoNote(desc="带分页信息的请求数据")
public class ReqQuery<T> implements Serializable
{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3635159271697204175L;

	public static final long totalCount = 10000;
	
	@FieldNote(desc="页大小")
	private int pageRow = 0;
	
	@FieldNote(desc="起始页")
	private int startPage = 0;
	
	@FieldNote(desc="总页数")
	private long totalRow = 0;

	@FieldNote(desc="排序字段")
	private String orderBy = null;
	
	// 查询条件
	@FieldNote(desc="查询条件")
	private T object;

	public ReqQuery()
	{
	}
	
	public ReqQuery(T object)
	{
		this.object=object;
	}

	public int getPageRow()
	{
		return pageRow;
	}

	public void setPageRow(int pageRow) 
	{
		this.pageRow = pageRow;
	}

	public int getStartPage()
	{
		return startPage;
	}

	public void setStartPage(int startPage)
	{
		this.startPage = startPage;
	}

	public long getTotalRow()
	{
		return totalRow;
	}

	public void setTotalRow(long totalRow)
	{
		this.totalRow = totalRow;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public T getObject()
	{
		return object;
	}

	public void setObject(T object)
	{
		this.object = object;
	}
	
}
