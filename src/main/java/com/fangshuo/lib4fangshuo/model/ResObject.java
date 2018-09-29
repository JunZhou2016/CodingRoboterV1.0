package com.fangshuo.lib4fangshuo.model;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fangshuo.lib4fangshuo.annotation.FieldNote;
import com.fangshuo.lib4fangshuo.annotation.PojoNote;

@PojoNote(desc = "返回对象")
public class ResObject<T> implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2509069727449399221L;

	protected static final Logger log = LoggerFactory.getLogger(ResObject.class.getName());

	
	@FieldNote(desc = "Http请求对象;")
	private HttpServletRequest request;
	
	@FieldNote(desc = "响应头信息")
	private ResHeader resHeader;
	
	@FieldNote(desc = "返回信息")
	private T object;
	
	public ResObject(HttpServletRequest request) {
		super();
		this.request = request;
	}
	
	public ResObject( T obj,HttpServletRequest request) {
		resHeader = new ResHeader(null,request);
		object = obj;
	}
	
	public ResObject(ReqObject<?> req, T obj,HttpServletRequest request) {
		resHeader = new ResHeader(req,request);
		object = obj;
	}
	
	public ResObject(ReqObject<?>  req, Exception e,HttpServletRequest request) {
		
		object = null;
		resHeader = new ResHeader(req,e,request);
		String errDesc = resHeader.getErrDesc();
		log.info(errDesc, e);
	}
	
	public ResObject(Exception e,HttpServletRequest request) {
		
		object = null;
		resHeader = new ResHeader(null,e,request);
		String errDesc = resHeader.getErrDesc();
		log.info(errDesc, e);
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public ResHeader getResHeader() {
		return resHeader;
	}

	public void setResHeader(ResHeader resHeader) {
		this.resHeader = resHeader;
	}

}
