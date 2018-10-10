package com.fangshuo.lib4fangshuo.timertask.quartz;

import java.util.List;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fangshuo.lib4fangshuo.annotation.JobNote;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: QuartzApiController.java
 * @Description: 定时任务相关的api；
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月9日 下午1:28:25
 */
@RestController
@RequestMapping("/quartz")
public class QuartzApiController {
	@Autowired
	private QuartzScheduler quartzScheduler;

	@RequestMapping("/startAllJob")
	public void startQuartzJob() {
		List<JobNote> jOB_NOT_ELIST = ApplicationStartQuartzJobListener.JOB_NOT_ELIST;
		quartzScheduler.startAllJob(jOB_NOT_ELIST);
	}

	@RequestMapping("/info")
	public String getQuartzJob(String name, String group) {
		String info = null;
		try {
			info = quartzScheduler.getJobInfo(name, group);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return info;
	}

	@RequestMapping("/modify")
	public boolean modifyQuartzJob(String name, String group, String time) {
		boolean flag = true;
		try {
			flag = quartzScheduler.modifyJob(name, group, time);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@RequestMapping(value = "/pause")
	public void pauseQuartzJob(String name, String group) {
		try {
			quartzScheduler.pauseJob(name, group);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/resume")
	public void resumeQuartzJob(String name, String group) {
		try {
			quartzScheduler.resumeJob(name, group);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/pauseAll")
	public void pauseAllQuartzJob() {
		try {
			quartzScheduler.pauseAllJob();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/resumeAll")
	public void resumeAllQuartzJob(String name, String group) {
		try {
			quartzScheduler.resumeAllJob();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/delete")
	public void deleteJob(String name, String group) {
		try {
			quartzScheduler.deleteJob(name, group);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}