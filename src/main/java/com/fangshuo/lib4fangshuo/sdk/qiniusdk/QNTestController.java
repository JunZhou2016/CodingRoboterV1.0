package com.fangshuo.lib4fangshuo.sdk.qiniusdk;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: QNTestController.java
 * @Description: 七牛相关的测试工具类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月6日 下午12:36:26
 */
@RequestMapping("/qn")
@Api(value = "七牛相关的测试请求", tags = { "七牛云存储" })
@RestController
public class QNTestController {
	/**
	 * 根据条件查询数据数据库基础信息的集合; [一次查询多个数据库表的信息]
	 * 
	 * @param tabNameList：数据表名称的集合;
	 * @return:数据库基础信息的集合;
	 */
	@ApiOperation("七牛云存储文件下载")
	@RequestMapping(value = "/get_ImgByURL", method = RequestMethod.GET)
	@ResponseBody
	public void getTabInfoByTableName(HttpServletRequest request, HttpServletResponse response) {
		QiniuUtil.downFileFromQiNiu("http://ouuy81imh.bkt.clouddn.com/2018100111231614_zj_qn.png", request, response);
	}

	/**
	 * 上传文件到七牛云存储
	 * 
	 * @param multipartFile
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public ImgInfo4QN uploadImgQiniu(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		return QiniuUtil.uploadImgToQiNiu(multipartFile);
	}
}
