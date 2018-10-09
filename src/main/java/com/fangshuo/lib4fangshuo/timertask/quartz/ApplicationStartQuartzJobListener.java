package com.fangshuo.lib4fangshuo.timertask.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ApplicationStartQuartzJobListener.java
 * @Description: Spring容器初始化结束后启动所有定时任务;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月9日 下午1:23:51
 */
@Configuration
public class ApplicationStartQuartzJobListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private QuartzScheduler quartzScheduler;

	/**
	 * 初始启动quartz
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		quartzScheduler.startJob();
		System.out.println("任务已经启动...");
	}

	/**
	 * 初始注入scheduler
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	@Bean
	public Scheduler scheduler() throws SchedulerException {
		SchedulerFactory schedulerFactoryBean = new StdSchedulerFactory();
		return schedulerFactoryBean.getScheduler();
	}
}