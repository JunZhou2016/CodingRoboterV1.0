package com.fangshuo.lib4fangshuo.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fangshuo.lib4fangshuo.annotation.JobNote;
import com.fangshuo.lib4fangshuo.exception.FsException;
import com.fangshuo.lib4fangshuo.exception.constant.ErrMsgConstant;
import com.fangshuo.lib4fangshuo.timertask.quartz.job.BaseJob;

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
@Component
public class AnnotationUtils{

	private static final String EMPTY_JOB_NOTE = "(name=, cron=, des=, bean=, group=)";// 所有属性全为null的JobNote；

	/**
	 * 根据包路径获取指定包下特定注解信息的集合;
	 * 
	 * @param packageName eg:---com.fangshuo.tempTest.reflexTest.User---
	 * @return List<JobNote> ：注解的集合;
	 */
	@SuppressWarnings("static-access")
	public List<JobNote> getAnnotationValueByPackPath(String packageName) {
		// 第一个class类的集合
		List<Class<BaseJob>> classes = new ArrayList<Class<BaseJob>>();
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
					scannerClassInTargetPath(packageName, filePath, recursive, classes);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// job注解的集合;
		List<JobNote> jobNoteList = new ArrayList<JobNote>();
		jobNoteList.clear();
		for (Class<BaseJob> clazz : classes) {
			// 循环获取所有的类
			Class<BaseJob> jobClazz = clazz;
			// 获取类的所有方法
			JobNote jobNote = jobClazz.getAnnotation(JobNote.class);
			if (jobNote != null) {
				String jobNoteStr = jobNote.toString();
				if (!(jobNoteStr.endsWith(EMPTY_JOB_NOTE))) {// 当注解的属性不全为空的时候添加到集合中去;
					String jobName = jobNote.name();
					if (jobName == null || jobName.equals("")) {
						throw new FsException(ErrMsgConstant.JOB_NAME_VER_FAILED).log();
					} else {
						jobNote.clazzSet.put(jobName, (Class<BaseJob>) jobClazz);
						jobNoteList.add(jobNote);
					}
				}
			}
		}
		return jobNoteList;
	}

	/**
	 * 扫描指定路径下的class文件并添加到给定的list中；
	 * 
	 * @param packageName ：包名;
	 * @param             :class文件;
	 * @param recursive   :是否扫描子级包;
	 * @param classes     ：给定的list容器，用于class载体;
	 */
	@SuppressWarnings("unchecked")
	public void scannerClassInTargetPath(String packageName, String packagePath, final boolean recursive,
			List<Class<BaseJob>> classes) {
		File dir = new File(packagePath);// 获取此包的目录 建立一个File
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
				scannerClassInTargetPath(packageName + "." + file.getName(), file.getAbsolutePath(), recursive,
						classes);
			} else {
				// 如果是java类文件 去掉后面的.class 只留下类名
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					// 添加到集合中去
					if (null != className) {
						classes.add((Class<BaseJob>) Thread.currentThread().getContextClassLoader()
								.loadClass(packageName + "." + className));
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
}