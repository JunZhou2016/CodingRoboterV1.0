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
@PojoNote(desc = "带分页信息的请求数据")
public class ReqQuery<T> extends ReqObject<T> implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3635159271697204175L;

	// 分页信息
	@FieldNote(desc = "分页信息")
	private PageInfo pageInfo;

	public ReqQuery() {
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
}
