package ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Model.${entityInfo.entityName};
import ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Parameter.${entityInfo.entityName}Filter;
@Mapper
public interface ${entityInfo.entityName}Mapper {

	void save(${entityInfo.entityName} ${entityInfo.localVariableName});

	Integer deleteByCondition(${entityInfo.entityName}Filter delCondition);

	Integer updateByCondition(${entityInfo.entityName} ${entityInfo.localVariableName});

	List<${entityInfo.entityName}> queryByCondition(${entityInfo.entityName}Filter condition);
}
