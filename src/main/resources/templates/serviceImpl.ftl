package com.fangshuo.output.Service.${modelNameUpperCamel}.Impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fangshuo.output.Dao.${modelNameUpperCamel}.${modelNameUpperCamel}Mapper;
import com.fangshuo.output.Model.${modelNameUpperCamel}.${modelNameUpperCamel};
import com.fangshuo.output.Service.${modelNameUpperCamel}.${modelNameUpperCamel}Service;

/**
 *
 * Created by JunZhou on 2018/09/26.
 */
@Controller
public class ${modelNameUpperCamel}ServiceImpl implements ${modelNameUpperCamel}Service{
	
	@Autowired
	${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;
	
	@Override
	public void save(${modelNameUpperCamel} ${modelNameLowerCamel}) {
		// TODO Auto-generated method stub
		${modelNameLowerCamel}Mapper.save(${modelNameLowerCamel});
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		${modelNameLowerCamel}Mapper.deleteById(id);
	}

	@Override
	public void update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
		// TODO Auto-generated method stub
		${modelNameLowerCamel}Mapper.update(${modelNameLowerCamel});
	}

	@Override
	public ${modelNameUpperCamel} findById(Integer id) {
		// TODO Auto-generated method stub
		return ${modelNameLowerCamel}Mapper.findById(id);
	}

	@Override
	public List<${modelNameUpperCamel}> findAll() {
		// TODO Auto-generated method stub
		return ${modelNameLowerCamel}Mapper.findAll();
	}
	
}
