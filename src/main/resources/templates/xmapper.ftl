<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Dao.${entityInfo.entityName}Mapper">
  <resultMap id="BaseResultMap" type="${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Model.${entityInfo.entityName}">
    <!--
      WARNING - @mbg.generated
    -->
    <!--基本数据列映射关系-->
    <id column="uuid" jdbcType="VARCHAR" property="uuid" />
    <#list tableInfo.columnSet as column>
	    <#if column.columnName != "uuid">
    <result column="${column.columnName}" jdbcType="VARCHAR" property="${column.propertyNameFormCloumn}" />
		 </#if>
	</#list> 
  </resultMap>
  
  	<!--基本字段-->
  <sql id="Base_Column_List">
	 ${tableInfo.tabColString}
  </sql>
  
  	<!--对象增加-->
  <insert id="save" parameterType="${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Model.${entityInfo.entityName}">
			insert into ${tableInfo.tableName}
		(${tableInfo.tabColString})
			values
		(<#list tableInfo.erList as erEle>
			<#if erEle_has_next>
					<#noparse>#</#noparse>{${erEle.propertyName},jdbcType=VARCHAR},<#else>					<#noparse>#</#noparse>{${erEle.propertyName},jdbcType=VARCHAR}
			</#if>
	 	</#list>)
	</insert>
	
  <!--对象删除-->
	<delete id="deleteByCondition" parameterType="${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Parameter.${entityInfo.entityName}Filter">
		delete from ${tableInfo.tableName}
		<where>
			
			<#list tableInfo.erList as erEle>
				<if test="${erEle.propertyName} != null and ${erEle.propertyName} != ''">
					and ${erEle.columnName} = <#noparse>#</#noparse>{${erEle.propertyName}, jdbcType=VARCHAR}
				</if>
	 	    </#list>
		</where>
	</delete>
	
  <!--对象修改-->
  <update id="updateByCondition"
		parameterType="${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Model.${entityInfo.entityName}">
		update ${tableInfo.tableName}
		<set>
			<#list tableInfo.erList as erEle>
				<#if erEle_has_next>
			 <if test="${erEle.propertyName} != null and ${erEle.propertyName} != ''">
			 	${erEle.columnName} = <#noparse>#</#noparse>{${erEle.propertyName}, jdbcType=VARCHAR}
			 </if>
				<#else>
			 <if test="${erEle.propertyName} != null and ${erEle.propertyName} != ''">
				${erEle.columnName} = <#noparse>#</#noparse>{${erEle.propertyName}, jdbcType=VARCHAR}
			 </if>
				</#if>
			</#list>
		</set>
		where uuid = <#noparse>#</#noparse>{uuid,jdbcType=VARCHAR}
	</update>
  
  <!--对象列表查找-->
  <select id="queryByCondition" resultMap="BaseResultMap"
		parameterType="${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Parameter.${entityInfo.entityName}Filter">
		select
		<include refid="Base_Column_List" />
		from ${tableInfo.tableName}
		<where>
			<#list tableInfo.erList as erEle>
				<if test="${erEle.propertyName} != null and ${erEle.propertyName} != ''">
					and ${erEle.columnName} = <#noparse>#</#noparse>{${erEle.propertyName}, jdbcType=VARCHAR}
				</if>
			</#list>
		</where>
		order by uuid
	</select>
  
  <!-- 查询数据库的基础信息; -->
	<select id="findAll" resultMap="BaseResultMap">
		select
		<include refid="Base_Column_List" />
		from ${tableInfo.tableName}
		GROUP BY(${tableInfo.primaryKey})
	</select>
</mapper>