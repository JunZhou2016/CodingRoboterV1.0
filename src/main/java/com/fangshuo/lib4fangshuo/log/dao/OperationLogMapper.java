package com.fangshuo.lib4fangshuo.log.dao;

import org.apache.ibatis.annotations.Mapper;

import com.fangshuo.lib4fangshuo.model.OperationLog;

@Mapper
public interface OperationLogMapper {
	/**
	 * 持久化操作日志的信息到数据库中;
	 * 
	 * @param operLog
	 */
	int insert(OperationLog operLog);

}
