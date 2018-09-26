package com.fangshuo.output.Dao.${modelNameUpperCamel};

import java.util.List;

import com.fangshuo.output.Model.${modelNameUpperCamel}.${modelNameUpperCamel};

public interface ${modelNameUpperCamel}Mapper {

	void save(${modelNameUpperCamel} ${modelNameLowerCamel});

	void deleteById(Integer id);

	void update(${modelNameUpperCamel} ${modelNameLowerCamel});

	${modelNameUpperCamel} findById(Integer id);

	List<${modelNameUpperCamel}> findAll();

}
