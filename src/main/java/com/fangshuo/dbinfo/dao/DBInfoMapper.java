package com.fangshuo.dbinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fangshuo.dbinfo.model.DBInfo;

@Mapper
public interface DBInfoMapper {

	List<DBInfo> getDbInfos();

}
