package com.fangshuo.lib4fangshuo.model;

import java.io.Serializable;

import com.fangshuo.lib4fangshuo.annotation.FieldNote;
import com.fangshuo.lib4fangshuo.annotation.PojoNote;
import com.fangshuo.lib4fangshuo.exception.code.ErrCodes;
@PojoNote(desc="请求数据")
public class ReqObject<T> implements Serializable
{
	private static final long serialVersionUID = 201703190101009001L;

	// 客户端流水号
	@FieldNote(desc="客户端流水号")
	private String flowNo = "";

	@FieldNote(desc="终端类型")
	private String term = "";

	@FieldNote(desc="企业编号")
	private String corp = "";
	
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

	public String getFlowNo()
	{
		return flowNo;
	}

	public void setFlowNo(String flowNo)
	{
		this.flowNo = flowNo;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getCorp() {
		return corp;
	}

	public void setCorp(String corp) {
		this.corp = corp;
	}

	public T getObject()
	{
		if(object == null){
			throw ErrCodes.TXN_INPUT_ERROR.exception();
		}
		
		return object;
	}

	public void setObject(T object)
	{
		this.object = object;
	}
	
}
