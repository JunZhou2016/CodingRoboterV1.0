package com.fangshuo.lib4fangshuo.model;

import java.io.Serializable;

import com.fangshuo.lib4fangshuo.annotation.FieldNote;
import com.fangshuo.lib4fangshuo.annotation.PojoNote;
@PojoNote(desc="请求数据")
public class ReqQuery<T> implements Serializable
{
	private static final long serialVersionUID = 201703190101009002L;
	public static final long totalCount = 10000;
	
	// 分页信息，pageRow>0时分页取数据
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
