package com.fangshuo.output.Model.${modelNameUpperCamel};
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
public class ${modelNameUpperCamel} {
	
	<#list columnSet as column>
	  /**
	  * @FieldNote(desc="${column.columnComment}", lengthAndType=${column.columnType}, notNull=${column.isNullAble})
	  */
	  protected String ${column.columnName};
	</#list> 
	
	
	<#list columnSet as column>
	  /**
	  * @FieldNote(desc="get${column.columnNameUpperCamel}")
	  */
	 public String get${column.columnNameUpperCamel}() {
		return name;
	}
	
	public void set${column.columnNameUpperCamel}(String ${column.columnName}) {
		this.${column.columnName} = ${column.columnName};
	}
	</#list> 

	@Override
	public String toString() {
		return 
		<#list columnSet as column>
		"Role [id=" + id + ", name=" + name + "]";
		</#list> 
	}
}
