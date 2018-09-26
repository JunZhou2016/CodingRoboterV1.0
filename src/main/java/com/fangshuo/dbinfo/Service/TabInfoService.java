package com.fangshuo.dbinfo.Service;

import java.util.List;

import com.fangshuo.dbinfo.model.Table;

public interface TabInfoService {
	
	List<Table> getTabInfoSetByCondition(List<String> tabNames);

}
