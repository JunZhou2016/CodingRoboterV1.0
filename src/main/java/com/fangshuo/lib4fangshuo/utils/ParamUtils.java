package com.fangshuo.lib4fangshuo.utils;

import com.fangshuo.lib4fangshuo.Enum.EmptyFilterSingleton;

/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: ParamUtils.java
* @Description: 参数处理相关的工具类;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年9月28日 上午11:15:36
 */
public class ParamUtils{
	/**
	 * 当参数为空的时候返回当前对象的实例;
	 * @param <T>
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T whenNullTenGiveInstance(T currentParameter) {
		if(null == currentParameter) {
			currentParameter = (T) EmptyFilterSingleton.INSANCE;
		}
		return currentParameter;
	}
}
