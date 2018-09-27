package com.fangshuo.lib4fangshuo.model;

import java.io.Serializable;

import com.fangshuo.lib4fangshuo.annotation.FieldNote;

public class ReqMangoObject<T> implements Serializable 
{
	private static final long serialVersionUID = 201704070101009001L;

	@FieldNote(desc = "一级对象查询条件")
	private String filter = "";

	@FieldNote(desc = "二级对象查询条件")
	private String filter2 = "";

	@FieldNote(desc = "三级对象查询条件")
	private String filter3 = "";

	@FieldNote(desc = "四级对象查询条件")
	private String filter4 = "";

	@FieldNote(desc = "请求数据")
	private T object = null;

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getFilter2() {
		return filter2;
	}

	public void setFilter2(String filter2) {
		this.filter2 = filter2;
	}

	public String getFilter3() {
		return filter3;
	}

	public void setFilter3(String filter3) {
		this.filter3 = filter3;
	}

	public String getFilter4() {
		return filter4;
	}

	public void setFilter4(String filter4) {
		this.filter4 = filter4;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

}


