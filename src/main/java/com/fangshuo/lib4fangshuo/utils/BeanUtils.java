package com.fangshuo.lib4fangshuo.utils;

import java.lang.reflect.Field;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: BeanUtils.java
 * @Description: 实体类相关的工具类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月9日 下午9:16:30
 */
public class BeanUtils {
	/**
	 * 判断该对象是否为空: 返回ture表示所有属性为null 返回false表示不是所有属性都是null
	 *
	 * 注意：对默认值不为null的对象，此方法不准确，单并不代表此方法错误;
	 *
	 * @param obj:待校验的对象;
	 * @return
	 * @throws Exception
	 */
	public static boolean isAllFieldNull(Object obj) {
		@SuppressWarnings("rawtypes")
		Class clazz = (Class) obj.getClass();// 得到类对象
		Field[] fs = clazz.getDeclaredFields();// 得到属性集合
		boolean flag = true;
		for (Field f : fs) {// 遍历属性
			f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
			Object val;
			try {
				val = f.get(obj);// 得到此属性的值
				System.out.println("-------------" + val);
				if (val != null && !("".equals(val.toString()))) {// 只要有1个属性不为空,那么就不是所有的属性值都为空
					flag = false;
					break;
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return flag;
	}
}
