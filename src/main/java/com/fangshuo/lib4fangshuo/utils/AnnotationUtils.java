package com.fangshuo.lib4fangshuo.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.fangshuo.lib4fangshuo.annotation.JobNote;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: AnnotationScanner.java
 * @Description: 注解相关的工具集合;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月9日 下午3:39:48
 */

public class AnnotationUtils {
	/**
	 * 要扫描的包的路径;
	 * eg:---com.fangshuo.tempTest.reflexTest.User---
	 * @param packageName
	 * @return
	 */
	public static List<String> getRequestMappingValue(String packageName) {

		// 第一个class类的集合
		List<Class<?>> classes = new ArrayList<Class<?>>();

		// 是否循环迭代
		boolean recursive = true;

		// 获取包的名字 并进行替换
		String packageDirName = packageName.replace('.', '/');

		// 定义一个枚举的集合 并进行循环来处理这个目录下的文件
		Enumeration<URL> dirs;
		try {
			// 读取指定package下的所有class
			dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
			while (dirs.hasMoreElements()) {
				URL url = dirs.nextElement();
				// 得到协议的名称
				String protocol = url.getProtocol();
				// 判断是否以文件的形式保存在服务器上
				if ("file".equals(protocol)) {
					// 获取包的物理路径
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					filePath = filePath.substring(1);
					// 以文件的方式扫描整个包下的文件 并添加到集合中
					findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> stringList = new ArrayList<String>();

		for (Class<?> clazz : classes) {
			// 循环获取所有的类
			Class<?> classEle = clazz;
			// 获取类的所有方法
			/*Method[] methods = c.getMethods();
			for (Method method : methods) {
				// 获取RequestMapping注解
				// com.fangshuo.lib4fangshuo.annotation.JobNote
				JobNote annotation = method.getAnnotation(JobNote.class);
				if (annotation != null) {
					// 获取注解的value值
					String value = annotation.name();
					System.out.println("-------anoValue--------" + value);
				}
			}*/
			JobNote annotation = classEle.getAnnotation(JobNote.class);
			if (annotation != null) {
				// 获取注解的value值
				String value = annotation.name();
				System.out.println("-------anoValue--------" + value);
			}
		}
		return stringList;
	}

	/**
	 * 
	 * @param packageName:包的名称;
	 * @param packagePath:包的路径;
	 * @param recursive:是否查询子级;
	 * @param classes:class数组;
	 */
	public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive,
			List<Class<?>> classes) {
		// packagePath = packagePath.trim().substring(1);
		// 获取此包的目录 建立一个File
		File dir = new File(packagePath);
		// 如果不存在或者 也不是目录就直接返回
		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}
		// 如果存在 就获取包下的所有文件 包括目录
		File[] dirfiles = dir.listFiles(new FileFilter() {
			// 自定义过滤规则 如果可以循环(且包含子目录) 或者是以.class结尾的文件(编译好的java类文件)
			public boolean accept(File file) {
				return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
			}
		});
		// 循环所有文件
		for (File file : dirfiles) {
			// 如果是目录 则继续扫描
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive,
						classes);
			} else {
				// 如果是java类文件 去掉后面的.class 只留下类名
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					// 添加到集合中去
					classes.add(
							Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("--------HELLO WORD---------");
	}
}