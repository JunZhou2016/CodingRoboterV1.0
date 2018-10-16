package com.fangshuo.dbinfo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangshuo.dbinfo.Service.TabInfoService;
import com.fangshuo.dbinfo.dao.TabInfoMapper;
import com.fangshuo.dbinfo.model.database.Table;
import com.fangshuo.lib4fangshuo.model.PageInfo;
import com.fangshuo.lib4fangshuo.model.ReqQuery;
import com.fangshuo.lib4fangshuo.model.ResList;
import com.github.pagehelper.PageHelper;

@Service
public class TabInfoServiceImpl implements TabInfoService {

	@Autowired
	private TabInfoMapper tabInfoMapper;

	/**
	 * 根据条件查询数据库基础信息;
	 * 
	 * @param tabNames:数据库名称;
	 * @return:数据库信息集合;
	 */
	@Override
	public List<Table> getTabInfoByTableName(List<String> tabNames) {
		// TODO Auto-generated method stub
		return tabInfoMapper.getTabInfoByTableName(tabNames);
	}

	/**
	 * 根据条件查询数据库基础表的信息;
	 * 
	 * @param qryFilter:查询条件;
	 */
	@Override
	public ResList<Table> getTabInfoByTableName(ReqQuery<List<String>> qryFilter) {
		// TODO Auto-generated method stub
		PageInfo pageInfo = qryFilter.getPageInfo();// 分页信息;

		List<String> filter = qryFilter.getObject();
		PageHelper.startPage(pageInfo.getStartPage(), pageInfo.getPageSize());
		List<Table> result = tabInfoMapper.getTabInfoByTableName(filter);
		ResList<Table> queryRes = new ResList<>(pageInfo, result);
		return queryRes;
	}
}
