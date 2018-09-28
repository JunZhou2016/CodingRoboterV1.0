package com.fangshuo.dbinfo.Service;

import java.util.List;

import com.fangshuo.dbinfo.model.database.Table;

public interface TabInfoService {
	
	List<Table> getTabInfoByTableName(List<String> tabNames);

}
