package com.fangshuo.lib4fangshuo.timertask.quartz;

import java.util.List;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.fangshuo.lib4fangshuo.annotation.JobNote;
import com.fangshuo.lib4fangshuo.utils.AnnotationUtils;

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

	public static List<JobNote> JOB_NOT_ELIST;// 系统中所有定时任务的详细信息列表,将在Spring容器初始化完毕后初始化;

	@Autowired
	private QuartzScheduler quartzScheduler;

	@Autowired
	private AnnotationUtils annotationUtils;

	/**
	 * 初始启动quartz
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// 扫描指定包下的job实现类,多个包下的job可以分多次扫描然后list.addAll拼接;
		String packageName = "com.fangshuo.lib4fangshuo.timertask.quartz.job";
		JOB_NOT_ELIST = annotationUtils.getAnnotationValueByPackPath(packageName);
		quartzScheduler.startAllJob(JOB_NOT_ELIST);

		// 启动所有的定时任务;
		// 添加定时任务的信息到数据库,任务的执行状态默认启动成功为NORMAL;
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