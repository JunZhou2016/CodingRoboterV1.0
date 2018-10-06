package com.fangshuo.lib4fangshuo.log.dao;

import com.fangshuo.lib4fangshuo.model.OperationLog;

public interface OperationLogMapper {
	/**
	 * 持久化操作日志的信息到数据库中;
	 * @param operLog
	 */
	void insert(OperationLog operLog);

}
