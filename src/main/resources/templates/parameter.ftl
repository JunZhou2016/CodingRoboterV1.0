package ${templateInfo.projectStruct}.Parameter.${templateInfo.entity.entityName};
/**
* 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: ${templateInfo.entity.entityName}Filter.java
* @Description: ${codeDes}
* 
* @version: ${codeVersion}
* @author: ${author}
* @Email: 1769676159@qq.com
* @Company: ${company}
* @date: ${date}
*/
public class ${templateInfo.entity.entityName}Filter {

	<#list templateInfo.entity.propertySet as property>
	  /**
	  * @FieldNote(desc="${property.propertyComment}", lengthAndType=${property.propertyLengthAndType}, notNull=${property.isNullAble})
	  */
	  protected String ${property.propertyName};
	</#list> 
	
	
	<#list templateInfo.entity.propertySet as property>
	  /**
	  * @FieldNote(desc="get${property.propertyNameUpperCamel}")
	  */
	 public String get${property.propertyNameUpperCamel}() {
		return ${property.propertyName};
	}
	
	public void set${property.propertyNameUpperCamel}(String ${property.propertyName}) {
		this.${property.propertyName} = ${property.propertyName};
	}
	</#list> 

	@Override
	public String toString() {
		return ${templateInfo.entity.entityStrirng};
	}
}
