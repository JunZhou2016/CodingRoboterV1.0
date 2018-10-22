package ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Service.Impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import com.fangshuo.base.mode.PageInfo;
import com.fangshuo.base.mode.ReqObject;
import com.fangshuo.base.mode.ReqQuery;
import com.fangshuo.base.mode.ResList;
import com.fangshuo.base.utils.UUID;

import ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Dao.${entityInfo.entityName}Mapper;
import ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Model.${entityInfo.entityName};
import ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Service.${entityInfo.entityName}Service;
import ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Parameter.${entityInfo.entityName}Filter;

/**
* 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: ${entityInfo.entityName}ServiceImpl.java
* @Description: ${codeDes}
* 
* @version: ${codeVersion}
* @author: ${author}
* @Email: 1769676159@qq.com
* @Company: ${company}
* @date: ${date}
*/
@Service
public class ${entityInfo.entityName}ServiceImpl implements ${entityInfo.entityName}Service{
	
	@Autowired
	${entityInfo.entityName}Mapper ${entityInfo.localVariableName}Mapper;
	
	@Override
	public ${entityInfo.entityName} save(ReqObject<${entityInfo.entityName}> data) {
		${entityInfo.entityName} ${entityInfo.localVariableName} = data.getObject();
		//添加必要的数据;
		${entityInfo.localVariableName}.setUuid(UUID.getUUID());
		${entityInfo.localVariableName}Mapper.save(${entityInfo.localVariableName});
		return ${entityInfo.localVariableName};
	}
	
	@Override
	public Integer deleteByCondition(ReqObject<${entityInfo.entityName}Filter> filter) {
		${entityInfo.entityName}Filter delCondition = filter.getObject();
		Integer influencedRow = ${entityInfo.localVariableName}Mapper.deleteByCondition(delCondition);
		return influencedRow;
	}
	
	@Override
	public Integer updateByCondition(ReqObject<${entityInfo.entityName}> data) {
		${entityInfo.entityName} updateCondition = data.getObject();
		Integer influencedRow = ${entityInfo.localVariableName}Mapper.updateByCondition(updateCondition);
		return influencedRow;
	}
	
	@Override
	public ResList<${entityInfo.entityName}> queryByCondition(ReqQuery<${entityInfo.entityName}Filter> queryCondition) {
		//分页信息;
		PageInfo pageInfo = new PageInfo();
		PageInfo reallyPageInfo = queryCondition.getPageInfo();// 真实分页信息;
		pageInfo=reallyPageInfo==null?pageInfo:reallyPageInfo;
		
		//执行查询;
		${entityInfo.entityName}Filter filter = queryCondition.getObject();
		if(pageInfo.getStartPage()==0) {
			List<${entityInfo.entityName}> result = ${entityInfo.localVariableName}Mapper.queryByCondition(filter);
			ResList<${entityInfo.entityName}> queryRes = new ResList<${entityInfo.entityName}>(pageInfo, result);
			return queryRes;
		}else {//分页查找;
			PageHelper.startPage(pageInfo.getStartPage(), pageInfo.getPageSize());
			List<${entityInfo.entityName}> result = ${entityInfo.localVariableName}Mapper.queryByCondition(filter);
			ResList<${entityInfo.entityName}> queryRes = new ResList<${entityInfo.entityName}>(pageInfo, result);
			return queryRes;
		}
	}
}
