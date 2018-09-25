<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.bigsea.sns.dao.mapper.test.StudentMapper">
  <resultMap id="BaseResultMap" type="com.bigsea.sns.model.test.Student">
    <!--
      WARNING - @mbg.generated
    -->
    <id column="id" jdbcType="VARCHAR" property="id" />
    <result column="name" jdbcType="VARCHAR" property="name" />
    <result column="sex" jdbcType="VARCHAR" property="sex" />
    <result column="age" jdbcType="INTEGER" property="age" />
    <result column="sNumber" jdbcType="INTEGER" property="snumber" />
    <custom-ele>Created by ${author} on ${date}.<custom-ele>
  </resultMap>
</mapper>
