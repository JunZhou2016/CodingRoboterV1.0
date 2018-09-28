package com.fangshuo.lib4fangshuo.Enum;

import com.fangshuo.lib4fangshuo.model.EmptyFilter;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: EmptyFilterSingleton.java
 * @Description: 空参数的实例;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月28日 上午11:26:16
 */
public enum EmptyFilterSingleton {
	INSANCE;
	
	private EmptyFilter emptyFilter;

	public EmptyFilter getEmptyFilter() {
		return emptyFilter;
	}

	public void setEmptyFilter(EmptyFilter emptyFilter) {
		this.emptyFilter = emptyFilter;
	}
}
