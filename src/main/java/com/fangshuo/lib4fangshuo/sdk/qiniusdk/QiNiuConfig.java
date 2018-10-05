package com.fangshuo.lib4fangshuo.sdk.qiniusdk;
/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: QiNiuConfig.java
* @Description: 七牛云存储的系统配置属性;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年10月1日 下午8:04:02
 */
public class QiNiuConfig {
	protected static final String AK = "lEZ6Ht3bp6NAcVRCk06ufHIvxQVcU3b1Hn-aNpwH";
	protected static final String SK = "DKJKiwHNy95KN3rnnTTl6D89is_gNSEzohpDYOKk";
	protected static final String BUCKETNAME = "storage4zj";
	protected static final String DEFAULT_DOMAIN = "ouuy81imh.bkt.clouddn.com";// 外链默认域名

	protected static String getAk() {
		return AK;
	}

	protected static String getSk() {
		return SK;
	}

	protected static String getBucketname() {
		return BUCKETNAME;
	}

	protected static String getDefaultDomain() {
		return DEFAULT_DOMAIN;
	}
}
