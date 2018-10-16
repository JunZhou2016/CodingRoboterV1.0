package com.fangshuo.tempTest;

import java.util.Date;

import com.fangshuo.lib4fangshuo.enums.AccessLogStatus;
import com.fangshuo.lib4fangshuo.log.LogManager;
import com.fangshuo.lib4fangshuo.model.OperationLog;
import com.fangshuo.lib4fangshuo.timertask.jdktask.LogInsertTask;

public class LogTest {
	public static void main(String[] args) {

		OperationLog operLog = new OperationLog();
		operLog.setStatus(AccessLogStatus.SUCCESS.getStatusCode());
		operLog.setMessage("操作成功");

		operLog.setCreatetime(new Date());
		LogManager.getLoggerManager().taskExecutor(new LogInsertTask().setOPERATE_DELAY_TIME(50).setParameter(operLog));
	}
}
