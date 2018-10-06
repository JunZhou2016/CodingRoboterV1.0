package com.fangshuo.lib4fangshuo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: OperationLog.java
 * @Description: 操作日志描述的实体类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月6日 下午9:31:13
 */
public class OperationLog implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 日志Id;
	 */
	private String uuid;

	/**
	 * 日志类型
	 */
	private String logtype;
	/**
	 * 日志名称
	 */
	private String logname;
	/**
	 * 用户id
	 */
	private Integer userid;
	/**
	 * 方法名称
	 */
	private String method;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 是否成功
	 */
	private String status;
	/**
	 * 备注
	 */
	private String message;

	/**
	 * 操作参数
	 */
	private String operParams;

	/**
	 * 操作url
	 */
	private String operUrl;

	public String getOperUrl() {
		return operUrl;
	}

	public void setOperUrl(String operUrl) {
		this.operUrl = operUrl;
	}

	public String getOperParams() {
		return operParams;
	}

	public void setOperParams(String operParams) {
		this.operParams = operParams;
	}

	public String getLogtype() {
		return logtype;
	}

	public void setLogtype(String logtype) {
		this.logtype = logtype;
	}

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "OperationLog [uuid=" + uuid + ", logtype=" + logtype + ", logname=" + logname + ", userid=" + userid
				+ ", method=" + method + ", createtime=" + createtime + ", status=" + status + ", message=" + message
				+ ", operParams=" + operParams + ", operUrl=" + operUrl + "]";
	}

}
