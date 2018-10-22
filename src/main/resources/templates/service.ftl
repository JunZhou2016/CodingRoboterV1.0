package ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Service;
import com.fangshuo.base.mode.ReqObject;
import com.fangshuo.base.mode.ReqQuery;
import com.fangshuo.base.mode.ResList;

import ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Model.${entityInfo.entityName};
import ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Parameter.${entityInfo.entityName}Filter;
/**
* 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: ${entityInfo.entityName}Service.java
* @Description: ${codeDes}
* 
* @version: ${codeVersion}
* @author: ${author}
* @Email: 1769676159@qq.com
* @Company: ${company}
* @date: ${date}
*/
public interface ${entityInfo.entityName}Service {

	${entityInfo.entityName} save(ReqObject<${entityInfo.entityName}> ${entityInfo.localVariableName});
	
	Integer deleteByCondition(ReqObject<${entityInfo.entityName}Filter> filter);

	Integer updateByCondition(ReqObject<${entityInfo.entityName}> ${entityInfo.localVariableName});
	
	ResList<${entityInfo.entityName}> queryByCondition(ReqQuery<${entityInfo.entityName}Filter> queryCondition);
}
