package com.fangshuo.tempTest.graphicverification;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ImageUtil;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: GraphicVer.java
 * @Description: 图形验证码的相关测试类;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月10日 下午3:23:04
 */
public class GraphicVer {
	public static void main(String[] args) {
		// 定义图形验证码的长和宽
		LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

		// 图形验证码写出，可以写出到文件，也可以写出到流
		lineCaptcha.write("d:/line.png");
		// 输出code
		Console.log(lineCaptcha.getCode());
		// 验证图形验证码的有效性，返回boolean值
		lineCaptcha.verify("1234");

		// 重新生成验证码
		lineCaptcha.createCode();
		lineCaptcha.write("d:/line.png");
		// 新的验证码
		Console.log(lineCaptcha.getCode());
		// 验证图形验证码的有效性，返回boolean值
		lineCaptcha.verify("1234");

		// 图片缩放;
		File imageFile = new File("d:/line.png");
		BufferedImage srcImg = ImageUtil.read(imageFile);
		BufferedImage imgAfterScale = (BufferedImage) ImageUtil.scale(srcImg, 10000, 10000);
		try {
			ImageIO.write(imgAfterScale, "png", imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
