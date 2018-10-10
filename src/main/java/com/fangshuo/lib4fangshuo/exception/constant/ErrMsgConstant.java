package com.fangshuo.lib4fangshuo.exception.constant;

import com.fangshuo.lib4fangshuo.exception.code.ErrorCode;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ErrMsgConstant.java
 * @Description: 错误信息常量的实体类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月29日 下午3:00:32
 */
public class ErrMsgConstant {
	public static final ErrorCode TXN_INPUT_ERROR = new ErrorCode("SYS_REQ000", "参数格式错误,请求体ReqBody为空！");
	public static final ErrorCode FILE_NOT_EXISTS_ERROR = new ErrorCode("SYS_REQ001", "文件不存在！");
	public static final ErrorCode PAGEINFO_ISREQUEIRED_IN_REQQUERY = new ErrorCode("SYS_REQ002", "分页查询中分页信息为必填数据！");
	public static final ErrorCode JOB_NAME_VER_FAILED = new ErrorCode("SYS_REQ003", "定时任务注解的名称校验失败,注解中名称不能为空和NULL！");
}
