package com.fangshuo.dbinfo.Service;

import java.util.List;

import com.fangshuo.dbinfo.model.database.Table;
import com.fangshuo.lib4fangshuo.model.ReqQuery;
import com.fangshuo.lib4fangshuo.model.ResList;

public interface TabInfoService {
	
	List<Table> getTabInfoByTableName(List<String> tabNames);

	ResList<Table> getTabInfoByTableName(ReqQuery<List<String>> qryFilter);
}
