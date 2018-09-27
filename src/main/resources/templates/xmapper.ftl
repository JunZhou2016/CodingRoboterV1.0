<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.fangshuo.output.Dao.${templateInfo.entity.entityName}.${templateInfo.entity.entityName}Mapper">
  <resultMap id="BaseResultMap" type="com.fangshuo.output.Model.${templateInfo.entity.entityName}.${templateInfo.entity.entityName}">
    <!--
      WARNING - @mbg.generated
    -->
    <!--基本数据列映射关系-->
    <id column="id" jdbcType="VARCHAR" property="id" />
    <#list templateInfo.table.columnSet as column>
	    <#if column.columnName != "id">
    <result column="${column.columnName}" jdbcType="VARCHAR" property="${column.propertyNameFormCloumn}" />
		 </#if>
	</#list> 
  </resultMap>
  
  <!--对象增加-->
  
  <!--对象删除-->
  
  <!--对象条件查找-->
  
  <!--对象列表查找-->
  
  <!--对象按条件修改-->
  
</mapper>