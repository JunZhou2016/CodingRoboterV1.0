package com.fangshuo.tempTest.graphicverification;

import java.awt.Color;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: QrGenerator.java
 * @Description: 二维码生成;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月10日 下午4:19:42
 */
public class QrGenerator {
	public static void main(String[] args) {
		QrConfig config = new QrConfig(400, 400);
		// 设置边距，既二维码和背景之间的边距
		//config.setMargin(3);
		// 设置前景色，既二维码颜色（青色）
		config.setForeColor(Color.BLACK.getRGB());
		// 设置背景色（灰色）
		config.setBackColor(Color.WHITE.getRGB());
		//边距;
		//config.setMargin(5);
		//缩放比例;
		//config.setRatio(5);
		/*File imageFile = new File("d:/line.png");
		BufferedImage imgFile = ImageUtil.read(imageFile);
		config.setImg(imgFile);*/
		// 生成二维码到文件，也可以到流
		QrCodeUtil.generate("https://junzhou2016.github.io/", config, FileUtil.file("d:/xunlei.jpg"));
	}
}
