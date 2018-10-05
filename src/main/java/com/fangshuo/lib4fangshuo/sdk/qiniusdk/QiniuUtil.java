package com.fangshuo.lib4fangshuo.sdk.qiniusdk;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.fangshuo.codefactory.utils.Logger;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: QiniuUtil.java
 * @Description: 七牛云存储的工具类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月1日 下午4:11:08
 */
public class QiniuUtil extends QiNiuConfig {

	/**
	 * 获取七牛云存储的授权信息;
	 * 
	 * @return
	 */
	public static Auth getAuth() {
		String accessKey = QiNiuConfig.AK; // AccessKey的值
		String secretKey = QiNiuConfig.SK; // SecretKey的值
		Auth auth = Auth.create(accessKey, secretKey);
		return auth;
	}

	/**
	 * 根据七牛的配置信息获取文件上传的token;
	 * 
	 * @param qiNiuConfig
	 * @return
	 */
	public static String getUpToken() {
		String bucket = QiNiuConfig.BUCKETNAME; // 存储空间名
		Auth auth = getAuth();
		StringMap putPolicy = new StringMap();
		//putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
		putPolicy.put("returnBody",new ImgInfo4QN().toJson());
		//String upToken = auth.uploadToken(bucket);
		long expireSeconds = 3600;//默认3600;
		String upToken = auth.uploadToken(bucket, null, expireSeconds, putPolicy);
		
		return upToken;
	}

	/**
	 * 获取下载文件路径；
	 * 
	 * @return ：downloagURL;
	 */
	public static String getDownloadUrl(String targetUrl) {
		Auth auth = getAuth();
		String downloadUrl = auth.privateDownloadUrl(targetUrl);
		return downloadUrl;
	}

	/**
	 * 读取字节输入流内容
	 * 
	 * @param is：字节输入流;
	 * @return
	 */
	private static byte[] readInputStream(InputStream is) {
		ByteArrayOutputStream writer = new ByteArrayOutputStream();
		byte[] buff = new byte[1024 * 2];
		int len = 0;
		try {
			while ((len = is.read(buff)) != -1) {
				writer.write(buff, 0, len);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer.toByteArray();
	}

	/**
	 * 从七牛云服务器上下载文件;
	 * 
	 * @param imgAccessLink:图片的访问链接/访问外链;
	 * @param savePath:文件在本地的默认存储路径;
	 * @return
	 */
	public static void downFileFromQiNiu(String imgAccessLink, String savePath) {
		Auth auth = getAuth();
		String downloadUrl = auth.privateDownloadUrl(imgAccessLink);

		OkHttpClient client = new OkHttpClient();
		Request req = new Request.Builder().url(downloadUrl).build();
		okhttp3.Response resp = null;
		try {
			resp = client.newCall(req).execute();
			System.out.println(resp.isSuccessful());
			if (resp.isSuccessful()) {
				ResponseBody body = resp.body();
				InputStream is = body.byteStream();
				byte[] data = readInputStream(is);
				File imgFile = new File(savePath + "_ZJ.png"); // 下载到本地的图片命名
				FileOutputStream fops = new FileOutputStream(imgFile);
				fops.write(data);
				fops.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unexpected code " + resp);
		}

	}

	/**
	 * 上传本地图片到七牛服务器，测试使用的方法;
	 */
	public static void uploadImgToQiNiu() {
		Configuration cfg = new Configuration(Zone.zone1()); // zong1() 代表华北地区
		UploadManager uploadManager = new UploadManager(cfg);
		String upToken = getUpToken();
		String localFilePath = "D:\\temp\\picture\\pictureFileName.mp4"; // 上传图片路径
		String key = "201810011614_zj_qn.mp4"; // 在七牛云中图片的命名
		try {
			Response response = uploadManager.put(localFilePath, key, upToken);
			// 解析上传成功的结果
			ImgInfo4QN imgInfo = new Gson().fromJson(response.bodyString(), ImgInfo4QN.class);
			//Logger.info(returnBody.key + "---" + returnBody.hash);
			Logger.info(imgInfo.toJson());
		} catch (QiniuException ex) {
			Response r = ex.response;
			System.err.println(r.toString());
			try {
				System.err.println(r.bodyString());
			} catch (QiniuException ex2) {
				// ignore
			}
		}

	}
}