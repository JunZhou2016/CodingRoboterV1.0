package com.fangshuo.dbinfo.Service;

import com.fangshuo.dbinfo.model.database.Database;

public interface DbInfoService {

	Database getDBInfosByCondition(Database dbFilter);

}
