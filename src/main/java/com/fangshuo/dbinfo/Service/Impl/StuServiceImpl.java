package com.fangshuo.dbinfo.Service.Impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fangshuo.dbinfo.Service.StuService;
import com.fangshuo.dbinfo.dao.StuMapper;
import com.fangshuo.dbinfo.model.User;

@Service
public class StuServiceImpl implements StuService, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private StuMapper stuMapper;

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		User user = stuMapper.selectById(id);
		return user;
	}

}
