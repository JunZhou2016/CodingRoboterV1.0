package com.fangshuo.lib4fangshuo.log;

import java.util.TimerTask;

import com.fangshuo.lib4fangshuo.log.service.OperationLogService;
import com.fangshuo.lib4fangshuo.model.OperationLog;
import com.fangshuo.lib4fangshuo.utils.SpringUtils;

/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: AsyncFactory.java
* @Description: 定时调度任务的集合;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年10月6日 下午10:18:42
 */
public class AsyncFactory {
	/**
     * 操作日志记录
     * <p>
     * 在aop中把给操作日志对象赋值，这里进行保存
     *
     * @param operLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask bussinessLog(final OperationLog operLog) {
        return new TimerTask() {
            @Override
            public void run() {
                // 远程查询操作地点
//                operLog.setOperLocation(AddressUtils.getRealAddressByIP(operLog.getOperIp()));
                // 插入操作日志
                SpringUtils.getBean(OperationLogService.class).insert(operLog);
            }
        };
    }
}
