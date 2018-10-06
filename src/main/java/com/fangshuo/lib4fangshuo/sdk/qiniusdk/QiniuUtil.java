package com.fangshuo.lib4fangshuo.sdk.qiniusdk;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

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
		putPolicy.put("returnBody", new ImgInfo4QN().toJson());
		long expireSeconds = 3600;// 默认3600;
		String upToken = auth.uploadToken(bucket, null, expireSeconds, putPolicy);
		return upToken;
	}

	/**
	 * 从七牛云服务器上下载文件;
	 * 
	 * @param imgAccessLink:图片的访问链接/访问外链;
	 * @param savePath:文件在本地的默认存储路径;
	 * @return
	 */
	public static void downFileFromQiNiu(String imgAccessLink,HttpServletRequest request,
			HttpServletResponse response) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		Auth auth = getAuth();
		String downloadUrl = auth.privateDownloadUrl(imgAccessLink);
		String fileName = imgAccessLink.substring(imgAccessLink.lastIndexOf("/") + 1);
		OkHttpClient client = new OkHttpClient();
		Request req = new Request.Builder().url(downloadUrl).build();
		okhttp3.Response resp = null;
		try {
			resp = client.newCall(req).execute();
			if (resp.isSuccessful()) {// 数据流请求成功;

				// 避免文件名称中文乱码;
				request.setCharacterEncoding("UTF-8");
				String agent = request.getHeader("User-Agent").toUpperCase();
				if ((agent.indexOf("MSIE") > 0) || ((agent.indexOf("RV") != -1) && (agent.indexOf("FIREFOX") == -1)))
					fileName = URLEncoder.encode(fileName, "UTF-8");
				else {
					fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
				}
				ResponseBody body = resp.body();
				InputStream is = body.byteStream();
				// 设置响应格式;
				response.setContentType("application/x-msdownload;");
				response.setHeader("Content-disposition", "attachment; filename=" + fileName);
				bis = new BufferedInputStream(is);
				bos = new BufferedOutputStream(response.getOutputStream());
				byte[] buff = new byte[2048];
				int bytesRead;
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length)))
					bos.write(buff, 0, bytesRead);
				bos.flush();
			}
		} catch (Exception e) {
			Logger.info("导出文件失败！");
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (Exception e) {
				Logger.info("导出文件关闭流出错！");
			}
		}

	}

	/**
	 * 
	 * 通过文件流的形式上传图片到七牛服务器，测试使用的方法;
	 *
	 * @param file:MultipartFile类型的文件数据;
	 * @throws IOException
	 */
	public static ImgInfo4QN uploadImgToQiNiu(MultipartFile multipartFile) throws IOException {
		ImgInfo4QN imgInfo = null;
		String originalFilename = multipartFile.getOriginalFilename();
		FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();

		Configuration cfg = new Configuration(Zone.zone1()); // zong1() 代表华北地区
		UploadManager uploadManager = new UploadManager(cfg);
		String upToken = getUpToken();
		String key = originalFilename; // 在七牛云中图片的命名
		try {
			Response response = uploadManager.put(fileInputStream, key, upToken, null, null);
			// 解析上传成功的结果
			imgInfo = new Gson().fromJson(response.bodyString(), ImgInfo4QN.class);
			Logger.info(imgInfo.toJson());
		} catch (QiniuException ex) {
			Response r = ex.response;
			System.err.println(r.toString());
			try {
				System.err.println(r.bodyString());
			} catch (QiniuException ex2) {
			}
		}
		return imgInfo;

	}
}