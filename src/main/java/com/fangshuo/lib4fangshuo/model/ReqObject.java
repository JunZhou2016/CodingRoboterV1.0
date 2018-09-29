package com.fangshuo.lib4fangshuo.model;

import java.io.Serializable;

import com.fangshuo.lib4fangshuo.annotation.FieldNote;
import com.fangshuo.lib4fangshuo.annotation.PojoNote;
import com.fangshuo.lib4fangshuo.exception.FsException;
import com.fangshuo.lib4fangshuo.exception.constant.ErrMsgConstant;
@PojoNote(desc="请求数据")
public class ReqObject<T> implements Serializable
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8172736602106998719L;
	
	//请求头信息
	@FieldNote(desc="请求头信息")
	private ReqHeader reqHeader = null;
	
	// 查询条件
	@FieldNote(desc="请求数据")
	private T object = null;
	
	public ReqObject()
	{
		
	}
	
	public ReqObject(T object)
	{
		this.object=object;
	}

	public T getObject()
	{	
		if(reqHeader == null) {
			reqHeader = new ReqHeader();
		}
		
		if(object == null){
			throw new FsException(ErrMsgConstant.TXN_INPUT_ERROR);
		}
		
		return object;
	}

	public void setObject(T object)
	{
		this.object = object;
	}

	public ReqHeader getReqHeader() {
		return reqHeader;
	}

	public void setReqHeader(ReqHeader reqHeader) {
		this.reqHeader = reqHeader;
	}
	
}
