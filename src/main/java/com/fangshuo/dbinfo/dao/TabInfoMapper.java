package com.fangshuo.dbinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fangshuo.dbinfo.model.Table;

@Mapper
public interface TabInfoMapper {
	/**
	 * 根据条件查询数据库基础信息;
	 * @param tabNames:数据库名称;
	 * @return:数据库信息集合;
	 */
	List<Table> getTabInfoSetByCondition(List<String> tabNames);

}
