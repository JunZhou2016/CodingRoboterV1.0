package com.fangshuo.dbinfo.Service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangshuo.dbinfo.Service.DbInfoService;
import com.fangshuo.dbinfo.dao.DBInfoMapper;
import com.fangshuo.dbinfo.model.database.Database;

@Service
public class DbInfoServiceImpl implements DbInfoService{
	
	@Autowired
	private DBInfoMapper dbInfoMapper;
	
	@Override
	public Database getDBInfosByCondition(Database dbFilter) {
		// TODO Auto-generated method stub
		Map<String,Object> dbFilterMap = new HashMap<String,Object>();
		dbFilterMap.put("tableSet", dbFilter.getTableSet());
		return dbInfoMapper.getDBInfosByCondition(dbFilter);
	}


}
