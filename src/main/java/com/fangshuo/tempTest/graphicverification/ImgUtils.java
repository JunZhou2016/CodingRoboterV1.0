package com.fangshuo.tempTest.graphicverification;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ImageUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: ImgUtils.java
 * @Description: 图片操作的工具类集合;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月10日 下午5:00:39
 */
public class ImgUtils {
	public static void main(String[] args) throws IOException {
		File tarImgFile = new File("d:/ice.png");
		Font font = new Font("宋体", Font.BOLD, 20);
		String str = ImgConstant.imgTexe;
		ImageOutputStream out = ImageIO.createImageOutputStream(tarImgFile);
		ImageUtil.createImage(str, font, Color.WHITE, Color.BLACK, out);
	}

	public void poiTest() {
		ExcelUtil.readBySax("aaa.xlsx", 0, createRowHandler());
	}

	private RowHandler createRowHandler() {
		return new RowHandler() {
			@Override
			public void handle(int sheetIndex, int rowIndex, List<Object> rowlist) {
				Console.log("[{}] [{}] {}", sheetIndex, rowIndex, rowlist);
			}
		};
	}

}
