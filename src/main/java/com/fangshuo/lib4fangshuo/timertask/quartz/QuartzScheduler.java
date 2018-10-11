package com.fangshuo.lib4fangshuo.timertask.quartz;

import java.util.Date;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fangshuo.lib4fangshuo.annotation.JobNote;
import com.fangshuo.lib4fangshuo.timertask.quartz.job.BaseJob;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: QuartzScheduler.java
 * @Description: 任务调度管理器，封装了对定时任务进行操作的方法集合;
 * 
 *               定时任务的添加时毫无意义的，因为通过可视化界面添加的定时任务无法明确复杂的业务逻辑;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月9日 上午11:25:48
 */
@Configuration
public class QuartzScheduler {
	private Logger log = LoggerFactory.getLogger(QuartzScheduler.class);

	// 任务调度
	@Autowired
	private Scheduler scheduler;

	/**
	 * 开始执行所有任务 采用循环实现;
	 * 
	 * @param jobNoteList启动信息的列表;
	 * @throws SchedulerException
	 */
	public void startAllJob(List<JobNote> jobNoteList) {
		try {
			for (JobNote jobNote : jobNoteList) {
				if (null != jobNote) {
					jobExecutor(jobNote);
				}
			}
			// 启动所有初始化后的任务;
			scheduler.start();
		} catch (ObjectAlreadyExistsException e) {
			// TODO Auto-generated catch block
			log.debug("当前定时任务已经启动", e);
		} catch (SchedulerException e) {
			// TODO: handle exception
			log.debug("定时任务启动失败", e);
		}
	}

	/**
	 * 启动某个定时任务;
	 * 
	 * @param jobNote启动信息;
	 * @throws SchedulerException
	 */
	public void startTargetJob(JobNote jobNote) throws SchedulerException {
		try {
			if (null != jobNote) {
				jobExecutor(jobNote);
			}
			// 启动所有初始化后的任务;
			scheduler.start();
		} catch (ObjectAlreadyExistsException e) {
			// TODO Auto-generated catch block
			log.debug("当前定时任务已经启动", e);
		} catch (SchedulerException e) {
			// TODO: handle exception
			log.debug("定时任务启动失败", e);
		}
	}

	/**
	 * 获取Job信息
	 * 
	 * @param name
	 * @param group
	 * @return
	 * @throws SchedulerException
	 */
	public String getJobInfo(String name, String group) throws SchedulerException {
		TriggerKey triggerKey = new TriggerKey(name, group);
		CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		
		/*JobKey jobKey = new JobKey(name, group);
		JobDetail jobDetail = scheduler.getJobDetail(jobKey);
		TriggerState triggerState = scheduler.getTriggerState(triggerKey);*/
		
		return String.format("time:%s,state:%s", cronTrigger.getCronExpression(),
				scheduler.getTriggerState(triggerKey).name());
		
	}

	/**
	 * 修改某个任务的执行时间
	 * 
	 * @param name
	 * @param group
	 * @param time
	 * @return
	 * @throws SchedulerException
	 */
	public boolean modifyJob(String name, String group, String time) throws SchedulerException {
		Date date = null;
		TriggerKey triggerKey = new TriggerKey(name, group);
		CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		String oldTime = cronTrigger.getCronExpression();
		if (!oldTime.equalsIgnoreCase(time)) {
			CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(time);
			CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group)
					.withSchedule(cronScheduleBuilder).build();
			date = scheduler.rescheduleJob(triggerKey, trigger);
		}
		return date != null;
	}

	/**
	 * 暂停所有任务
	 * 
	 * @throws SchedulerException
	 */
	public void pauseAllJob() throws SchedulerException {
		scheduler.pauseAll();
	}

	/**
	 * 暂停某个任务
	 * 
	 * @param name
	 * @param group
	 * @throws SchedulerException
	 */
	public void pauseJob(String name, String group) throws SchedulerException {
		JobKey jobKey = new JobKey(name, group);
		JobDetail jobDetail = scheduler.getJobDetail(jobKey);
		if (jobDetail == null)
			return;
		scheduler.pauseJob(jobKey);
	}

	/**
	 * 恢复所有任务
	 * 
	 * @throws SchedulerException
	 */
	public void resumeAllJob() throws SchedulerException {
		scheduler.resumeAll();
	}

	/**
	 * 恢复某个任务
	 * 
	 * @param name
	 * @param group
	 * @throws SchedulerException
	 */
	public void resumeJob(String name, String group) throws SchedulerException {
		JobKey jobKey = new JobKey(name, group);
		JobDetail jobDetail = scheduler.getJobDetail(jobKey);
		if (jobDetail == null)
			return;
		scheduler.resumeJob(jobKey);
	}

	/**
	 * 删除某个任务
	 * 
	 * @param name
	 * @param group
	 * @throws SchedulerException
	 */
	public void deleteJob(String name, String group) throws SchedulerException {
		JobKey jobKey = new JobKey(name, group);
		JobDetail jobDetail = scheduler.getJobDetail(jobKey);
		if (jobDetail == null)
			return;
		scheduler.deleteJob(jobKey);
	}

	/**
	 * 定时任务初始化的方法;
	 * 
	 * @param jobIdentity：定时任务初始化的信息载体;
	 * @param targetJobClazz: 目标定时任务的Class对象;
	 * @throws SchedulerException
	 */
	private void jobExecutor(JobNote jobNote) throws SchedulerException {
		String cronExpression = jobNote.cron();// corn表达式;
		String group = jobNote.group();// job所属分组;
		String name = jobNote.name();// job名称;
		@SuppressWarnings({ "static-access", "unchecked" })
		Class<BaseJob> jobClazz = (Class<BaseJob>) jobNote.clazzSet.get(name);// 目标定时任务的Class对象;
		// 通过JobBuilder构建JobDetail实例，JobDetail规定只能是实现Job接口的实例
		// JobDetail 是具体Job实例
		JobDetail jobDetail = JobBuilder.newJob(jobClazz).withIdentity(name, group).build();
		// 基于表达式构建触发器
		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(name, group)// TriggerBuilder 用于构建触发器实例
				.withSchedule(cronScheduleBuilder).build();// CronTrigger表达式触发器 继承于Trigger
		scheduler.scheduleJob(jobDetail, cronTrigger);
	}
}
