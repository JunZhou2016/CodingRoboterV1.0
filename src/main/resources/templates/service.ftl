package com.fangshuo.output.Service.${modelNameUpperCamel};

import java.util.List;

import com.fangshuo.output.Model.${modelNameUpperCamel}.${modelNameUpperCamel};
/**
* 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: CodeGeneratorController.java
* @Description: ${codeDes}
* 
* @version: ${codeVersion}
* @author: ${author}
* @Email: 1769676159@qq.com
* @Company: ${company}
* @date: ${date}
*/
public interface ${modelNameUpperCamel}Service {

	void save(${modelNameUpperCamel} ${modelNameLowerCamel});

	void deleteById(Integer id);

	void update(${modelNameUpperCamel} ${modelNameLowerCamel});

	${modelNameUpperCamel} findById(Integer id);

	List<${modelNameUpperCamel}> findAll();

}
