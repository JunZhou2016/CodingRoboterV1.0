package ${projectInfo.projectStruct}.${entityInfo.entityName}.Service.Impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fangshuo.output.${entityInfo.entityName}.Dao.${entityInfo.entityName}Mapper;
import com.fangshuo.output.${entityInfo.entityName}.Model.${entityInfo.entityName};
import com.fangshuo.output.${entityInfo.entityName}.Service.${entityInfo.entityName}Service;

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
@Controller
public class ${entityInfo.entityName}ServiceImpl implements ${entityInfo.entityName}Service{
	
	@Autowired
	${entityInfo.entityName}Mapper ${entityInfo.localVariableName}Mapper;
	
	@Override
	public void save(${entityInfo.entityName} ${entityInfo.localVariableName}) {
		// TODO Auto-generated method stub
		${entityInfo.localVariableName}Mapper.save(${entityInfo.localVariableName});
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		${entityInfo.localVariableName}Mapper.deleteById(id);
	}

	@Override
	public void update(${entityInfo.entityName} ${entityInfo.localVariableName}) {
		// TODO Auto-generated method stub
		${entityInfo.localVariableName}Mapper.update(${entityInfo.localVariableName});
	}

	@Override
	public ${entityInfo.entityName} findById(Integer id) {
		// TODO Auto-generated method stub
		return ${entityInfo.localVariableName}Mapper.findById(id);
	}

	@Override
	public List<${entityInfo.entityName}> findAll() {
		// TODO Auto-generated method stub
		return ${entityInfo.localVariableName}Mapper.findAll();
	}
	
}
