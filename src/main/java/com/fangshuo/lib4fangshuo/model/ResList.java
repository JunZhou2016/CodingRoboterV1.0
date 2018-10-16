package com.fangshuo.lib4fangshuo.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.util.StringUtils;

import com.fangshuo.lib4fangshuo.annotation.FieldNote;
import com.fangshuo.lib4fangshuo.annotation.PojoNote;
import com.fangshuo.lib4fangshuo.exception.FsException;
import com.fangshuo.lib4fangshuo.exception.constant.ErrMsgConstant;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ResList.java
 * @Description: 封装了分页信息的list对象;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月29日 下午5:03:49
 */
@PojoNote(desc = "返回对象")
public class ResList<T> implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4380575270811657466L;

	@FieldNote(desc = "分页信息对象")
	private PageInfo pageInfo;

	@FieldNote(desc = "返回的结果集")
	private List<T> list;

	public ResList() {

	}

	public ResList(PageInfo pageInfo, List<T> list) {
		super();
		this.pageInfo = pageInfo;
		this.list = list;

		if (pageInfo != null && (!StringUtils.isEmpty(pageInfo.getStartPage()))
				&& (!StringUtils.isEmpty(pageInfo.getPageSize()))) {
			pageInfo.totalRow = (list == null) ? 0 : list.size();
		} else {
			throw new FsException(ErrMsgConstant.PAGEINFO_ISREQUEIRED_IN_REQQUERY);
		}
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

}
