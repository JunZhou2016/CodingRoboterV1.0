package com.fangshuo.lib4fangshuo.sdk.qiniusdk;

import com.google.gson.Gson;

public class ImgInfo4QN {
	
	public String key = QiNiuConstant.RETURN_BODY_ORIG_NAME.getValue();// 获得文件保存在空间中的资源名。
	public String hash = QiNiuConstant.RETURN_BODY_HASH.getValue();// 文件上传成功后的 HTTPETag。若上传时未指定资源ID，Etag将作为资源ID使用。
	
	public String bucket = QiNiuConstant.RETURN_BODY_BUCKET.getValue();// 获得上传的目标空间名。
	public String fsize = QiNiuConstant.RETURN_BODY_FSIZE.getValue();// 资源尺寸，单位为字节。
	public String fname = QiNiuConstant.RETURN_BODY_FNAME.getValue();// 上传的原始文件名。
	public String mimeType = QiNiuConstant.RETURN_BODY_MIMETYPE.getValue();// 资源类型，例如JPG图片的资源类型为image/jpg。
	public String endUser = QiNiuConstant.RETURN_BODY_ENDUSER.getValue();// 上传时指定的endUser字段，通常用于区分不同终端用户的请求。
	public String ext = QiNiuConstant.RETURN_BODY_EXT.getValue();// 上传资源的后缀名，通过自动检测的mimeType 或者原文件的后缀来获取。
	
	public String uuid = QiNiuConstant.RETURN_BODY_UUID.getValue();// uuid
	
   
	
	public ImgInfo4QN() {
		super();
	}
	
	/**
	 * 将当前对象转化为json；
	 * @return
	 */
	public String toJson() {
		Gson gson = new Gson();
		String json = gson.toJson(this);
		return json;
	}

	protected String getKey() {
		return key;
	}

	protected void setKey(String key) {
		this.key = key;
	}

	protected String getHash() {
		return hash;
	}

	protected void setHash(String hash) {
		this.hash = hash;
	}

	protected String getBucket() {
		return bucket;
	}

	protected void setBucket(String bucket) {
		this.bucket = bucket;
	}

	protected String getFname() {
		return fname;
	}

	protected void setFname(String fname) {
		this.fname = fname;
	}

	protected String getMimeType() {
		return mimeType;
	}

	protected void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	protected String getEndUser() {
		return endUser;
	}

	protected void setEndUser(String endUser) {
		this.endUser = endUser;
	}

	protected String getExt() {
		return ext;
	}

	protected void setExt(String ext) {
		this.ext = ext;
	}

	protected String getUuid() {
		return uuid;
	}

	protected void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
