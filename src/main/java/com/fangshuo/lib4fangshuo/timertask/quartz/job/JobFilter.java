package com.fangshuo.lib4fangshuo.timertask.quartz.job;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: JobFilter.java
 * @Description: 定时器过滤信息载体,插入信息到数据库的映射类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月10日 下午12:36:25
 */
public class JobFilter {
	/**
	 * Job的id;
	 */
	private String id;

	/**
	 * 任务描述;
	 */
	private String des;
	/**
	 * Job归属的分组名称;
	 */
	private String group;
	/**
	 * Job名称;
	 */
	private String name;
	/**
	 * 调度Cron表达式;
	 */
	private String cron;
	/**
	 * 任务状态;
	 */
	private String status;
	/**
	 * 任务实现类的Class对象信息;
	 */
	private String beanClass;
	/**
	 * Job创建者;
	 */
	private String creator;
	/**
	 * Job创建时间;
	 */
	private String createTime;
	/**
	 * Job更新者;
	 */
	private String updator;
	/**
	 * Job更新时间;
	 */
	private String updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(String beanClass) {
		this.beanClass = beanClass;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "JobFilter [id=" + id + ", des=" + des + ", group=" + group + ", name=" + name + ", cron=" + cron
				+ ", status=" + status + ", beanClass=" + beanClass + ", creator=" + creator + ", createTime="
				+ createTime + ", updator=" + updator + ", updateTime=" + updateTime + "]";
	}

}
