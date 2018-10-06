package com.fangshuo.lib4fangshuo.log;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: LogManager.java
* @Description: 日志管理器，用于一部操作日志信息;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年10月6日 下午10:15:06
 */
public class LogManager {


    /**
     * 日志记录操作延时
     */
    private final int OPERATE_DELAY_TIME = 15;

    /**
     * 异步操作记录日志的线程池
     */
    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

    private LogManager() {
    }

    public static LogManager logManager = new LogManager();

    public static LogManager getLoggerManager() {
        return logManager;
    }

    public void executeLog(TimerTask task) {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }

}
