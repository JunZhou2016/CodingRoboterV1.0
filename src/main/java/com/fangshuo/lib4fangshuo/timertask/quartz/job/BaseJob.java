package com.fangshuo.lib4fangshuo.timertask.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: BaseJob.java
 * @Description: 基本任务实体类，所有的定时任务务必实现这个基类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月9日 上午10:51:56
 */
public interface BaseJob extends Job {

	/**
	 * 定时任务的前置业务逻辑，非必要的；
	 */
	public void before();

	/**
	 * 具体定时任务逻辑的实现方法;
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException;

	/**
	 * 定时任务的后置业务逻辑，非必要的；
	 */
	public void after();

}
