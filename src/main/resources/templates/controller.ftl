package ${basePackage}.Controller.${modelNameUpperCamel};
import ${basePackage}.Model.${modelNameUpperCamel}.${modelNameUpperCamel};
import ${basePackage}.Service.${modelNameUpperCamel}.${modelNameUpperCamel}Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
@Controller
@RequestMapping("/${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {

    @Autowired
    ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @RequestMapping("add")
    @ResponseBody
    public String add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    ${modelNameLowerCamel}Service.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
	    ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return ${modelNameLowerCamel}.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo<${modelNameUpperCamel}> pageInfo = new PageInfo<${modelNameUpperCamel}>(list);
        System.out.println("#########"+pageInfo+"########");//为了去除黄色警告;
        return list.toString();
    }
}
