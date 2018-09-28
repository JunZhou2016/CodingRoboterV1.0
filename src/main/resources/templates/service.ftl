package ${projectInfo.projectStruct}.${entityInfo.entityName}.Service;

import java.util.List;

import com.fangshuo.output.${entityInfo.entityName}.Model.${entityInfo.entityName};
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

	void save(${entityInfo.entityName} ${entityInfo.localVariableName});

	void deleteById(Integer id);

	void update(${entityInfo.entityName} ${entityInfo.localVariableName});

	${entityInfo.entityName} findById(Integer id);

	List<${entityInfo.entityName}> findAll();

}
