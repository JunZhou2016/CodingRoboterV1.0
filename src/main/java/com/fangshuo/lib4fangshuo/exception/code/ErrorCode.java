package com.fangshuo.lib4fangshuo.exception.code;
/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: ErrorCode.java
* @Description: Error信息载体;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年9月29日 下午2:34:03
 */
public class ErrorCode extends BaseErrorCode
{
	/**
	 * 初始化函数;
	 * @param errCode:错误代码;
	 * @param errDesc:错误描述;
	 */
	public ErrorCode(String errCode, String errDesc) {
		super(errCode, errDesc);
		// TODO Auto-generated constructor stub
	}
	
	/*@Override
	public String toString() {
		return "BaseErrorCode [errCode=" + errCode + ", errDesc=" + errDesc + "]";
	}*/

}

