package com.fangshuo.dbinfo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangshuo.dbinfo.Service.TabInfoService;
import com.fangshuo.dbinfo.dao.TabInfoMapper;
import com.fangshuo.dbinfo.model.Table;

@Service
public class TabInfoServiceImpl implements TabInfoService{
	
	@Autowired
	private TabInfoMapper tabInfoMapper;
	
	/**
	 * 根据条件查询数据库基础信息;
	 * @param tabNames:数据库名称;
	 * @return:数据库信息集合;
	 */
	@Override
	public List<Table> getTabInfoSetByCondition(List<String> tabNames) {
		// TODO Auto-generated method stub
		return tabInfoMapper.getTabInfoSetByCondition(tabNames);
	}
	
}
