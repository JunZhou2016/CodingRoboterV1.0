package ${projectInfo.projectStruct}.${projectInfo.project.proJectName}.${entityInfo.entityName}.Model;
import org.springframework.stereotype.Component;
/**
* 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: ${entityInfo.entityName}.java
* @Description: ${codeDes}
* 
* @version: ${codeVersion}
* @author: ${author}
* @Email: 1769676159@qq.com
* @Company: ${company}
* @date: ${date}
*/
@Component
public class ${entityInfo.entityName} {
	
	<#list entityInfo.propertySet as property>
	  /**
	  * @FieldNote(desc="${property.propertyComment}", lengthAndType=${property.propertyLengthAndType}, notNull=${property.isNullAble})
	  */
	  protected String ${property.propertyName};
	</#list> 
	
	
	<#list entityInfo.propertySet as property>
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
		return ${entityInfo.entityStrirng};
	}
}
