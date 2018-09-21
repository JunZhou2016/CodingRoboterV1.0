package com.fangshuo.dbinfo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.fangshuo.dbinfo.model.User;

@Mapper
public interface StuMapper {
	User selectById(int id);
}
