package ${projectInfo.projectStruct}.${entityInfo.entityName}.Controller;
import ${projectInfo.projectStruct}.${entityInfo.entityName}.Model.${entityInfo.entityName};
import ${projectInfo.projectStruct}.${entityInfo.entityName}.Service.${entityInfo.entityName}Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
* 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: ${entityInfo.entityName}Controller.java
* @Description: ${codeDes}
* 
* @version: ${codeVersion}
* @author: ${author}
* @Email: 1769676159@qq.com
* @Company: ${company}
* @date: ${date}
*/
@Controller
@Api(value="${entityInfo.entityDes}",tags = {"${entityInfo.entityName}管理API"})
@RequestMapping("/${tableInfo.tableName}/")
public class ${entityInfo.entityName}Controller {

    @Autowired
    ${entityInfo.entityName}Service ${entityInfo.localVariableName}Service;

    @RequestMapping(value="add",method = RequestMethod.POST)
    @ApiOperation("增加${entityInfo.entityName}")
    @ApiImplicitParams({
        @ApiImplicitParam(
        name="${entityInfo.localVariableName}",
        value = "信息实体${entityInfo.entityName}",
        required = true,
        dataType = "${entityInfo.entityName}")
    })
    @ResponseBody
    public String add(${entityInfo.entityName} ${entityInfo.localVariableName}) {
        ${entityInfo.localVariableName}Service.save(${entityInfo.localVariableName});
        return "";
    }

    @RequestMapping(value="delete",method = RequestMethod.POST)
    @ApiOperation("根据Id删除${entityInfo.entityName}")
    @ApiImplicitParams({
        @ApiImplicitParam(
        name="id",
        value = "记录Id",
        required = true,
        dataType = "Integer")
    })
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    ${entityInfo.localVariableName}Service.deleteById(id);
	    return "";
    }

    @RequestMapping(value="update",method = RequestMethod.POST)
    @ApiOperation("更新${entityInfo.entityName}")
    @ApiImplicitParams({
        @ApiImplicitParam(
        name="${entityInfo.localVariableName}",
        value = "信息实体${entityInfo.entityName}",
        required = true,
        dataType = "${entityInfo.entityName}")
    })
    @ResponseBody
    public String update(${entityInfo.entityName} ${entityInfo.localVariableName}) {
	    ${entityInfo.localVariableName}Service.update(${entityInfo.localVariableName});
	    return "";
    }
	
    @RequestMapping(value="detail",method = RequestMethod.POST)
    @ApiOperation("根据记录Id查询${entityInfo.entityName}")
    @ApiImplicitParams({
        @ApiImplicitParam(
        name="id",
        value = "记录Id",
        required = true,
        dataType = "Integer")
    })
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        ${entityInfo.entityName} ${entityInfo.localVariableName} = ${entityInfo.localVariableName}Service.findById(id);
        return ${entityInfo.localVariableName}.toString();
    }

    @RequestMapping(value="list",method = RequestMethod.POST)
    @ApiOperation("查询${entityInfo.entityName}列表")
    @ApiImplicitParams({
        @ApiImplicitParam(
        name="page",
        value = "当前页码",
        required = true,
        dataType = "Integer"),
        @ApiImplicitParam(
        name="size",
        value = "每页显示的记录条数",
        required = true,
        dataType = "Integer")
    })
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${entityInfo.entityName}> list = ${entityInfo.localVariableName}Service.findAll();
        PageInfo<${entityInfo.entityName}> pageInfo = new PageInfo<${entityInfo.entityName}>(list);
        System.out.println("#########"+pageInfo+"########");//为了去除黄色警告;
        return list.toString();
    }
}
