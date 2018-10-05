package com.fangshuo.lib4fangshuo.sdk.qiniusdk;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: QNUpLoader.java
 * @Description: 七牛的文件上传器;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月1日 下午5:26:28
 */
public class QNUpLoader extends QiniuUtil {

	public QNUpLoader() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 上传文件到七牛云存储;
	 */
	public static void uploadImgToQN() {
		uploadImgToQiNiu();
	}

	public static void main(String[] args) {
		uploadImgToQN();
	}

}
