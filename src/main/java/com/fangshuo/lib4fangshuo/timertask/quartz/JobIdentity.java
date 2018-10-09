package com.fangshuo.lib4fangshuo.timertask.quartz;

import org.quartz.Job;
import org.quartz.TriggerKey;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: JobIdentity.java
 * @Description: 定时任务job的识别和开启信息;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月9日 上午11:30:51
 */
public class JobIdentity {
	/**
	 * 当前对象的Class对象;
	 */
	private Class<Job> jobClazz;
	/**
	 * 触发器识别标志;
	 */
	private TriggerKey triggerKey;
	/**
	 * 定时表达式;
	 */
	private String cronExpression;

	protected TriggerKey getTriggerKey() {
		return triggerKey;
	}

	protected void setTriggerKey(TriggerKey triggerKey) {
		this.triggerKey = triggerKey;
	}

	protected String getCronExpression() {
		return cronExpression;
	}

	protected void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	protected Class<Job> getJobClazz() {
		return jobClazz;
	}

	protected void setJobClazz(Class<Job> jobClazz) {
		this.jobClazz = jobClazz;
	}
}
