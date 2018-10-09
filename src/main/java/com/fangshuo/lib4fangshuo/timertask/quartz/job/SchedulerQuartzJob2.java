package com.fangshuo.lib4fangshuo.timertask.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fangshuo.lib4fangshuo.timertask.quartz.JobIdentity;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: SchedulerQuartzJob2.java
 * @Description: 定时任务二;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月9日 上午11:10:19
 */
public class SchedulerQuartzJob2 extends JobIdentity implements BaseJob {
	private Logger log = LoggerFactory.getLogger(SchedulerQuartzJob2.class);

	@Override
	public void before() {
		// TODO Auto-generated method stub
		log.info("SchedulerQuartzJob2---->starting......" + System.currentTimeMillis());
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		before();
		log.info("SchedulerQuartzJob2---->doing......");
		after();
	}

	@Override
	public void after() {
		// TODO Auto-generated method stub
		log.info("SchedulerQuartzJob2---->end......" + System.currentTimeMillis());
	}

}
