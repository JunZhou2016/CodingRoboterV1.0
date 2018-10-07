package com.fangshuo.lib4fangshuo.task;

import java.util.TimerTask;

import org.springframework.stereotype.Service;

import com.fangshuo.lib4fangshuo.log.service.OperationLogService;
import com.fangshuo.lib4fangshuo.model.OperationLog;
import com.fangshuo.lib4fangshuo.utils.SpringUtils;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: LogInsertTask.java
 * @Description: 日志异步插入的定时任务;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月7日 上午10:21:21
 */
@Service
public class LogInsertTask extends TaskBase {
	/**
	 * 
	 * 定时任务具体业务逻辑执行的方法;
	 * 
	 * @return:定时任务的对象;
	 */
	@Override
	public TimerTask taskExecutor() {
		return new TimerTask() {
			@Override
			public void run() {
				SpringUtils.getBean(OperationLogService.class).insert((OperationLog) parameter);
			}
		};
	}
}
