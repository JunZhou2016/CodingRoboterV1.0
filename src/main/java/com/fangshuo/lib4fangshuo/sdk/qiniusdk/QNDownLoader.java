package com.fangshuo.lib4fangshuo.sdk.qiniusdk;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: QNDownLoader.java
 * @Description: 七牛文件下载器;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月1日 下午5:25:52
 */
public class QNDownLoader extends QiniuUtil{
	/**
	 * 上从七牛云存储上下载文件;
	 */
	public static void downFileFromQN() {
		String imgAccessLink = "http://ouuy81imh.bkt.clouddn.com/00002.jpg";
		String savePath = "D:\\temp\\picture\\";
		downFileFromQiNiu(imgAccessLink, savePath);
	}
}
