package com.fangshuo.lib4fangshuo.timertask.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fangshuo.lib4fangshuo.annotation.JobNote;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: SchedulerQuartzJob1.java
 * @Description: 定时任务一;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月9日 上午11:09:25
 */
@JobNote(bean = "com.fangshuo.lib4fangshuo.timertask.quartz.job.SchedulerQuartzJob3", des = "定时任务三", cron = "0/5 * * * * ?", name = "job3", group = "group3")
public class SchedulerQuartzJob3 implements BaseJob {
	private Logger log = LoggerFactory.getLogger(SchedulerQuartzJob3.class);
	private String name = "SchedulerQuartzJob3";

	@Override
	public void before() {
		// TODO Auto-generated method stub
		log.info("SchedulerQuartzJob3---->starting......" + System.currentTimeMillis());
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		before();
		log.info("SchedulerQuartzJob3---->doing......");
		after();
	}

	@Override
	public void after() {
		// TODO Auto-generated method stub
		log.info("SchedulerQuartzJob3---->end......" + System.currentTimeMillis());
	}

	@Override
	public String toString() {
		return "SchedulerQuartzJob1 [name=" + name + "]";
	}

}
