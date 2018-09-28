package ${projectInfo.projectStruct}.${entityInfo.entityName}.Dao;

import java.util.List;

import com.fangshuo.output.${entityInfo.entityName}.Model.${entityInfo.entityName};

public interface ${entityInfo.entityName}Mapper {

	void save(${entityInfo.entityName} ${entityInfo.localVariableName});

	void deleteById(Integer id);

	void update(${entityInfo.entityName} ${entityInfo.localVariableName});

	${entityInfo.entityName} findById(Integer id);

	List<${entityInfo.entityName}> findAll();

}
