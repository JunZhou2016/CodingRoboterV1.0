package com.fangshuo.lib4fangshuo.model;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: BaseUser.java
 * @Description: 用户基本信息的描述类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月8日 上午10:29:01
 */
public class BaseUser {
	/**
	 * 用户名;
	 */
	public String userName;
	/**
	 * 用户密码;
	 */
	public String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "BaseUser [userName=" + userName + ", passWord=" + passWord + "]";
	}

}
