package com.fangshuo.lib4fangshuo.model;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fangshuo.lib4fangshuo.annotation.FieldNote;
import com.fangshuo.lib4fangshuo.annotation.PojoNote;
import com.fangshuo.lib4fangshuo.exception.LzException;
import com.fangshuo.lib4fangshuo.utils.UUID;

@PojoNote(desc = "返回对象")
public class ResObject<T> implements Serializable {
	private static final long serialVersionUID = 201703160101009001L;
	protected static final Logger log = LoggerFactory.getLogger(ResObject.class.getName());

	@FieldNote(desc = "错误代码")
	private String errCode;

	@FieldNote(desc = "错误信息描述")
	private String errDesc;

	@FieldNote(desc = "服务端流水号")
	private String svcFlowNo;

	@FieldNote(desc = "客户端流水号")
	private String cliFlowNo;

	@FieldNote(desc = "返回信息")
	private T object;

	private Exception exception;

	public ResObject(@SuppressWarnings("rawtypes") ReqObject req, T obj) {
		errCode = "000000";
		errDesc = "";
		svcFlowNo = UUID.getUUID();
		this.cliFlowNo = (req == null) ? "1" : req.getFlowNo();

		object = obj;
	}

	public ResObject(@SuppressWarnings("rawtypes") ReqObject req, String errCode, String errDesc) {
		this.errCode = errCode;
		this.errDesc = errDesc;
		svcFlowNo = UUID.getUUID();
		this.cliFlowNo = (req == null) ? "1" : req.getFlowNo();

		if (errCode == null || errCode.isEmpty()) {
			errCode = "999999";
			errDesc = "未知的错误";
		}

		object = null;
	}

	public ResObject(@SuppressWarnings("rawtypes") ReqObject req, Exception e) {
		exception = e;
		if (e instanceof LzException) {
			LzException e2 = (LzException) e;
			this.errCode = e2.getErrCode();
			this.errDesc = e.getMessage();

			if (errCode == null || errCode.isEmpty()) {
				errCode = "999999";
				errDesc = "未知的错误";
			}
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

		svcFlowNo = UUID.getUUID();
		this.cliFlowNo = (req == null) ? "1" : req.getFlowNo();
		object = null;

		log.info("处理错误", e);
	}

	public ResObject() {
		errCode = "000000";
		errDesc = "";
		svcFlowNo = UUID.getUUID();
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

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public Exception acquireException() {
		return exception;
	}

}
