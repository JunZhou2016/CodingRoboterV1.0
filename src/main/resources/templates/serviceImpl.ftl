package ${templateInfo.projectStruct}.Service.${templateInfo.entity.entityName}.Impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fangshuo.output.Dao.${templateInfo.entity.entityName}.${templateInfo.entity.entityName}Mapper;
import com.fangshuo.output.Model.${templateInfo.entity.entityName}.${templateInfo.entity.entityName};
import com.fangshuo.output.Service.${templateInfo.entity.entityName}.${templateInfo.entity.entityName}Service;

/**
* 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: ${templateInfo.entity.entityName}Service.java
* @Description: ${codeDes}
* 
* @version: ${codeVersion}
* @author: ${author}
* @Email: 1769676159@qq.com
* @Company: ${company}
* @date: ${date}
*/
@Controller
public class ${templateInfo.entity.entityName}ServiceImpl implements ${templateInfo.entity.entityName}Service{
	
	@Autowired
	${templateInfo.entity.entityName}Mapper ${templateInfo.entity.localVariableName}Mapper;
	
	@Override
	public void save(${templateInfo.entity.entityName} ${templateInfo.entity.localVariableName}) {
		// TODO Auto-generated method stub
		${templateInfo.entity.localVariableName}Mapper.save(${templateInfo.entity.localVariableName});
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		${templateInfo.entity.localVariableName}Mapper.deleteById(id);
	}

	@Override
	public void update(${templateInfo.entity.entityName} ${templateInfo.entity.localVariableName}) {
		// TODO Auto-generated method stub
		${templateInfo.entity.localVariableName}Mapper.update(${templateInfo.entity.localVariableName});
	}

	@Override
	public ${templateInfo.entity.entityName} findById(Integer id) {
		// TODO Auto-generated method stub
		return ${templateInfo.entity.localVariableName}Mapper.findById(id);
	}

	@Override
	public List<${templateInfo.entity.entityName}> findAll() {
		// TODO Auto-generated method stub
		return ${templateInfo.entity.localVariableName}Mapper.findAll();
	}
	
}
