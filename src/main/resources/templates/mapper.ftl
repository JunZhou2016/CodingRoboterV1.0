package ${templateInfo.projectStruct}.Dao.${templateInfo.entity.entityName};

import java.util.List;

import com.fangshuo.output.Model.${templateInfo.entity.entityName}.${templateInfo.entity.entityName};

public interface ${templateInfo.entity.entityName}Mapper {

	void save(${templateInfo.entity.entityName} ${templateInfo.entity.localVariableName});

	void deleteById(Integer id);

	void update(${templateInfo.entity.entityName} ${templateInfo.entity.localVariableName});

	${templateInfo.entity.entityName} findById(Integer id);

	List<${templateInfo.entity.entityName}> findAll();

}
