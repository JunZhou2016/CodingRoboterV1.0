package com.fangshuo.lib4fangshuo.task;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: TaskItem.java
 * @Description: 定时任务的基本描述类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月7日 上午9:59:39
 */
public abstract class TaskBase {
	/**
	 * 定时任务的参数;
	 */
	public Object parameter;
	/**
	 * 日志记录操作延时
	 */
	public int OPERATE_DELAY_TIME = 15;

	/**
	 * 定时单位,默认毫秒;
	 */
	public TimeUnit TIMEUNIT = TimeUnit.MILLISECONDS;

	/**
	 * 
	 * 定时任务具体业务逻辑执行的方法;
	 * 
	 * @return
	 */
	public TimerTask taskExecutor() {
		return new TimerTask() {
			@Override
			public void run() {

			}
		};
	}

	public Object getParameter() {
		return parameter;
	}

	public TaskBase setParameter(Object parameter) {
		this.parameter = parameter;
		return this;
	}

	public int getOPERATE_DELAY_TIME() {
		return OPERATE_DELAY_TIME;
	}

	public TaskBase setOPERATE_DELAY_TIME(int oPERATE_DELAY_TIME) {
		this.OPERATE_DELAY_TIME = oPERATE_DELAY_TIME;
		return this;
	}

	public TimeUnit getTimeUnit() {
		return TIMEUNIT;
	}

	public TaskBase setTimeUnit(TimeUnit timeUnit) {
		this.TIMEUNIT = timeUnit;
		return this;
	}

}
