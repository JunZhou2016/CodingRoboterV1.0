package com.fangshuo.lib4fangshuo.sdk.qiniusdk;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: QiNiuConstant.java
 * @Description: 七牛云存储相关的系统常量;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月1日 下午4:04:02
 */
public enum QiNiuConstant {

	RETURN_BODY_ORIG_NAME("key", "$(key)"), // 上传的原始文件名。
	RETURN_BODY_HASH("hash", "$(etag)"), // 文件上传成功后的 HTTPETag。若上传时未指定资源ID，Etag将作为资源ID使用。
	RETURN_BODY_BUCKET("bucket", "$(bucket)"), // 获得上传的目标空间名。
	RETURN_BODY_FSIZE("fsize", "$(fsize)"), // 资源尺寸，单位为字节。

	RETURN_BODY_FNAME("fname", "$(fname)"), // 上传的原始文件名。
	RETURN_BODY_MIMETYPE("mimeType", "$(mimeType)"), // 资源类型，例如JPG图片的资源类型为image/jpg。
	RETURN_BODY_ENDUSER("endUser", "$(endUser)"), // 上传时指定的endUser字段，通常用于区分不同终端用户的请求。
	RETURN_BODY_IMAGEINFO("imageInfo", "$(imageInfo)"), // 获取所上传图片的基本信息。该变量包含子字段，例如对$(imageInfo.width)取值将得到该图片的宽度。

	RETURN_BODY_EXT("ext", "$(ext)"), // 上传资源的后缀名，通过自动检测的mimeType 或者原文件的后缀来获取。
	RETURN_BODY_UUID("uuid", "$(uuid)");// uuid

	private String key;
	private String value;

	private QiNiuConstant(String key, String value) {
		this.key = key;
		this.value = value;
	}

	protected String getKey() {
		return key;
	}

	protected void setKey(String key) {
		this.key = key;
	}

	protected String getValue() {
		return value;
	}

	protected void setValue(String value) {
		this.value = value;
	}
}
