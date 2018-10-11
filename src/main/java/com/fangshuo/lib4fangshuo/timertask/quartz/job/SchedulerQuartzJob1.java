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
@JobNote(des = "定时任务一", cron = "0/5 * * * * ?", name = "job1", group = "group1")
public class SchedulerQuartzJob1 implements BaseJob {
	private Logger log = LoggerFactory.getLogger(SchedulerQuartzJob1.class);
	private String name = "SchedulerQuartzJob1";

	@Override
	public void before() {
		// TODO Auto-generated method stub
		log.info("SchedulerQuartzJob1---->starting......" + System.currentTimeMillis());
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		before();
		log.info("SchedulerQuartzJob1---->doing......");
		after();
	}

	@Override
	public void after() {
		// TODO Auto-generated method stub
		log.info("SchedulerQuartzJob1---->end......" + System.currentTimeMillis());
	}

	@Override
	public String toString() {
		return "SchedulerQuartzJob1 [name=" + name + "]";
	}

}
