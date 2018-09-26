package com.fangshuo.dbinfo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangshuo.dbinfo.Service.DbInfoService;
import com.fangshuo.dbinfo.dao.DBInfoMapper;
import com.fangshuo.dbinfo.model.Database;

@Service
public class DbInfoServiceImpl implements DbInfoService{
	
	@Autowired
	private DBInfoMapper dbInfoMapper;
	
	@Override
	public List<Database> getDbInfos() {
		// TODO Auto-generated method stub
		return dbInfoMapper.getDbInfos();
	}


}
