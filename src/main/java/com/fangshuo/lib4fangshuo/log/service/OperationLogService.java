package com.fangshuo.lib4fangshuo.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangshuo.lib4fangshuo.log.dao.OperationLogMapper;
import com.fangshuo.lib4fangshuo.model.OperationLog;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: OperationLogService.java
 * @Description: 操作日志记录的业务逻辑集合;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月6日 下午10:24:12
 */
@Service
public class OperationLogService {

	@Autowired
	private OperationLogMapper operationLogMapper;

	public void insert(OperationLog operLog) {
		// TODO Auto-generated method stub
		operationLogMapper.insert(operLog);
	}

}
