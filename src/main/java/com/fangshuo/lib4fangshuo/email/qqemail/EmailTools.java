package com.fangshuo.lib4fangshuo.email.qqemail;

import cn.hutool.extra.mail.MailUtil;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: EmailTools.java
 * @Description: 邮件操作相关的工具类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月13日 下午10:45:54
 */
public class EmailTools {
	public static void main(String[] args) {
		// 纯文本邮件的发送;
		// MailUtil.send("3040237357@qq.com", "测试", "邮件来自JunZhou测试", false);
		// 带附件的文件发送;
		// MailUtil.send("3040237357@qq.com", "测试", "<h1>邮件来自JunZhou测试</h1>", true,
		// FileUtil.file("D:\\doc\\邓明浩开题报告_201712151003.doc"));
		// 邮件群发;

		/*
		 * ArrayList<String> tos = CollUtil.newArrayList( "3040237357@qq.com"//ZJ );
		 * MailUtil.send(tos, "测试123", "邮件来自JunZhou群发测试", false);
		 */

		for (int i = 0; i <= 50; i++) {
			MailUtil.send("3040237357@qq.com", "测试", "邮件来自JunZhou测试", false);
		}

	}
}