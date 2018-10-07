package com.fangshuo.dbinfo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.fangshuo.dbinfo.model.database.Database;
@Mapper
public interface DBInfoMapper {

	Database getDBInfosByCondition(Database dbFilter);

}
