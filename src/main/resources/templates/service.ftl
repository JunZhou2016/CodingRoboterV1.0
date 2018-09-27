package ${templateInfo.projectStruct}.Service.${templateInfo.entity.entityName};

import java.util.List;

import com.fangshuo.output.Model.${templateInfo.entity.entityName}.${templateInfo.entity.entityName};
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
public interface ${templateInfo.entity.entityName}Service {

	void save(${templateInfo.entity.entityName} ${templateInfo.entity.localVariableName});

	void deleteById(Integer id);

	void update(${templateInfo.entity.entityName} ${templateInfo.entity.localVariableName});

	${templateInfo.entity.entityName} findById(Integer id);

	List<${templateInfo.entity.entityName}> findAll();

}
