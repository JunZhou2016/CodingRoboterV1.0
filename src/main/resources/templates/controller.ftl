package ${templateInfo.projectStruct}.Controller.${templateInfo.entity.entityName};
import ${templateInfo.projectStruct}.Model.${templateInfo.entity.entityName}.${templateInfo.entity.entityName};
import ${templateInfo.projectStruct}.Service.${templateInfo.entity.entityName}.${templateInfo.entity.entityName}Service;

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
@RequestMapping("/${templateInfo.table.tableName}/")
public class ${templateInfo.entity.entityName}Controller {

    @Autowired
    ${templateInfo.entity.entityName}Service ${templateInfo.entity.localVariableName}Service;

    @RequestMapping("add")
    @ResponseBody
    public String add(${templateInfo.entity.entityName} ${templateInfo.entity.localVariableName}) {
        ${templateInfo.entity.localVariableName}Service.save(${templateInfo.entity.localVariableName});
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    ${templateInfo.entity.localVariableName}Service.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(${templateInfo.entity.entityName} ${templateInfo.entity.localVariableName}) {
	    ${templateInfo.entity.localVariableName}Service.update(${templateInfo.entity.localVariableName});
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        ${templateInfo.entity.entityName} ${templateInfo.entity.localVariableName} = ${templateInfo.entity.localVariableName}Service.findById(id);
        return ${templateInfo.entity.localVariableName}.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${templateInfo.entity.entityName}> list = ${templateInfo.entity.localVariableName}Service.findAll();
        PageInfo<${templateInfo.entity.entityName}> pageInfo = new PageInfo<${templateInfo.entity.entityName}>(list);
        System.out.println("#########"+pageInfo+"########");//为了去除黄色警告;
        return list.toString();
    }
}
