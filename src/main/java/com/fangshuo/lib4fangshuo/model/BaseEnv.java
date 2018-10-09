package com.fangshuo.lib4fangshuo.model;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: BaseEnv.java
* @Description: 基础环境变量信息;
* 参考解决方案：https://blog.csdn.net/ProGram_BlackCat/article/details/80253074
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年10月8日 下午9:53:27
 */
public class BaseEnv implements EnvironmentAware{
	@SuppressWarnings("unused")
	private Environment env;
	@Override
	public void setEnvironment(Environment environment) {
	    this.env = environment;
	}
}
