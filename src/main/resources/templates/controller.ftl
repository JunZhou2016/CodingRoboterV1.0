package ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Controller;
import ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Model.${entityInfo.entityName};
import ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Service.${entityInfo.entityName}Service;
import ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Parameter.${entityInfo.entityName}Filter;

import com.fangshuo.base.mode.ReqObject;
import com.fangshuo.base.mode.ReqQuery;
import com.fangshuo.base.mode.ResList;
import com.fangshuo.base.mode.ResObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
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
        value = "信息实体信息实体${entityInfo.entityName}",
        required = true,
        dataType = "ReqObject<${entityInfo.entityName}>")
    })
    @ResponseBody
    public ResObject<${entityInfo.entityName}> add(@RequestBody ReqObject<${entityInfo.entityName}> ${entityInfo.localVariableName},HttpServletRequest request, HttpServletResponse response) {
        try {
        	${entityInfo.entityName} executeResult = ${entityInfo.localVariableName}Service.save(${entityInfo.localVariableName});
            return new ResObject<${entityInfo.entityName}>(${entityInfo.localVariableName}, executeResult, request);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResObject<${entityInfo.entityName}>(e, request);
		}
    }
    
	
	@RequestMapping(value="deleteByCondition",method = RequestMethod.POST)
    @ApiOperation("根据条件删除${entityInfo.entityName}")
    @ApiImplicitParams({
        @ApiImplicitParam(
        name="filter",
        value = "删除条件filter",
        required = true,
        dataType = "ReqObject<${entityInfo.entityName}Filter>")
    })
    @ResponseBody
    public ResObject<Integer> deleteByCondition(@RequestBody ReqObject<${entityInfo.entityName}Filter> filter,HttpServletRequest request, HttpServletResponse response) {
	    try {
	    	Integer executeResult = ${entityInfo.localVariableName}Service.deleteByCondition(filter);
            return new ResObject<Integer>(filter, executeResult, request);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResObject<Integer>(e, request);
		}
    }
	
	
	@RequestMapping(value="updateByCondition",method = RequestMethod.POST)
    @ApiOperation("根据条件更新${entityInfo.entityName}")
    @ApiImplicitParams({
        @ApiImplicitParam(
        name="data",
        value = "信息实体${entityInfo.entityName}",
        required = true,
        dataType = "ReqObject<${entityInfo.entityName}>")
    })
    @ResponseBody
    public ResObject<Integer> updateByCondition(@RequestBody ReqObject<${entityInfo.entityName}> data,HttpServletRequest request, HttpServletResponse response) {
	    try {
	    	Integer executeResult = ${entityInfo.localVariableName}Service.updateByCondition(data);
            return new ResObject<Integer>(data, executeResult, request);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResObject<Integer>(e, request);
		}
    }
	
	
	@RequestMapping(value="queryByCondition",method = RequestMethod.POST)
    @ApiOperation("根据条件查询${entityInfo.entityName}")
    @ApiImplicitParams({
        @ApiImplicitParam(
        name="queryCondition",
        value = "查询条件",
        required = true,
        dataType = "ReqObject<${entityInfo.entityName}Filter>")
    })
    @ResponseBody
    public ResObject<ResList<${entityInfo.entityName}>> queryByCondition(@RequestBody ReqQuery<${entityInfo.entityName}Filter> queryCondition,HttpServletRequest request, HttpServletResponse response) {
		try {
			ResList<${entityInfo.entityName}> queryResult = ${entityInfo.localVariableName}Service.queryByCondition(queryCondition);
			ResObject<ResList<${entityInfo.entityName}>> resObj = new ResObject<ResList<${entityInfo.entityName}>>(queryCondition, queryResult, request);
			return resObj;
		} catch (Exception e) {
			// TODO: handle exception
			return new ResObject<ResList<${entityInfo.entityName}>>(queryCondition, e, request);
		}
    }

}
