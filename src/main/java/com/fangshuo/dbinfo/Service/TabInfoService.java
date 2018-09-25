package com.fangshuo.dbinfo.Service;

import java.util.List;

import com.fangshuo.dbinfo.model.TabInfoSet;

public interface TabInfoService {
	
	List<TabInfoSet> getTabInfoSetByCondition(List<String> tabNames);

}
