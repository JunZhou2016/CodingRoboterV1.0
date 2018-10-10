package com.fangshuo.tempTest.reflexTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fangshuo.lib4fangshuo.annotation.JobNote;
import com.fangshuo.lib4fangshuo.utils.AnnotationUtils;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ReflexTest.java
 * @Description: 反射测试类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月9日 下午3:26:30
 */
public class ReflexTest {
	@Autowired
	private static AnnotationUtils annotationUtils;
	
	@SuppressWarnings("static-access")
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String packageName = "com.fangshuo.lib4fangshuo.timertask.quartz.job";
		List<JobNote> jobNoteList = annotationUtils.getAnnotationValueByPackPath(packageName);
		for (JobNote jobNote : jobNoteList) {
			String jobName = jobNote.name();
			String string = jobNote.clazzSet.get(jobName).newInstance().toString();
			System.out.println("------------" + string);
		}
	}
}
