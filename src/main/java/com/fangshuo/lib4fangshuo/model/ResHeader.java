package com.fangshuo.lib4fangshuo.model;

import javax.servlet.http.HttpServletRequest;

import com.fangshuo.lib4fangshuo.annotation.FieldNote;
import com.fangshuo.lib4fangshuo.exception.FsException;
import com.fangshuo.lib4fangshuo.utils.DateUtil;
import com.fangshuo.lib4fangshuo.utils.HttpUtils;
import com.fangshuo.lib4fangshuo.utils.UUID;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ResHeader.java
 * @Description: 响应头信息;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月29日 上午11:44:05
 */
public class ResHeader {

	@FieldNote(desc = "错误代码")
	private String errCode;

	@FieldNote(desc = "错误信息描述")
	private String errDesc;

	@FieldNote(desc = "服务端流水号")
	private String svcFlowNo;

	@FieldNote(desc = "客户端流水号")
	private String cliFlowNo;

	@FieldNote(desc = "用户代理/客户端")
	private String userAgent;

	@FieldNote(desc = "用户代理的Ip地址")
	private String userAgentIP;
	
	@FieldNote(desc = "请求发起的时间")
	private String reqTime;
	
	@FieldNote(desc = "请求参数")
	private Object reqParam;

	public ResHeader() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	public ResHeader(ReqObject<?> req, HttpServletRequest request) {
		super();
		errCode = "000000";
		errDesc = "";
		userAgent = HttpUtils.getReqHeaderByName(request, "user-agent");
		userAgentIP = HttpUtils.getIp(request);
		svcFlowNo = UUID.getUUID();
		reqTime = DateUtil.getTimestamp().toLocaleString();
		reqParam = req;
		this.cliFlowNo = (req == null) ? "1" : req.getReqHeader().getFlowNo();
	}

	@SuppressWarnings("deprecation")
	public ResHeader(ReqObject<?> req, Exception e, HttpServletRequest request) {
		super();
		if (e instanceof FsException) {
			FsException e2 = (FsException) e;
			this.errCode = e2.getErrorCode().getErrCode();
			this.errDesc = e2.getErrorCode().getErrDesc();
			this.userAgent = request.getHeader("user-agent");
			this.reqTime = DateUtil.getTimestamp().toLocaleString();
			this.userAgent = HttpUtils.getReqHeaderByName(request, "user-agent");
			this.userAgentIP = HttpUtils.getIp(request);
		} else {
			String name = e.getClass().getSimpleName();
			if ("DuplicateKeyException".equals(name)) {
				this.errCode = "999990";
				this.errDesc = "操作数据库时记录重复";
			} else {
				this.errCode = "999999";
				this.errDesc = e.getMessage();
			}
		}
		reqParam = req;
		svcFlowNo = UUID.getUUID();
		this.cliFlowNo = (req == null) ? "1" : req.getReqHeader().getFlowNo();
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrDesc() {
		return errDesc;
	}

	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}

	public String getSvcFlowNo() {
		return svcFlowNo;
	}

	public void setSvcFlowNo(String svcFlowNo) {
		this.svcFlowNo = svcFlowNo;
	}

	public String getCliFlowNo() {
		return cliFlowNo;
	}

	public void setCliFlowNo(String cliFlowNo) {
		this.cliFlowNo = cliFlowNo;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getUserAgentIP() {
		return userAgentIP;
	}

	public void setUserAgentIP(String userAgentIP) {
		this.userAgentIP = userAgentIP;
	}

	public String getReqTime() {
		return reqTime;
	}

	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}

	public Object getReqParam() {
		return reqParam;
	}

	public void setReqParam(Object reqParam) {
		this.reqParam = reqParam;
	}

}
