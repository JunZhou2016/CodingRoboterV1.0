package com.fangshuo.tempTest.graphicverification;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.WeightRandom;
import cn.hutool.core.lang.WeightRandom.WeightObj;
import cn.hutool.core.util.ImageUtil;
import cn.hutool.core.util.RandomUtil;
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
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
	    //源文件;
		File srcImgFile = new File("d:/qrcode.jpg");
		///BufferedImage srcImage = ImageUtil.read(srcImgFile);
		
		//水印文件;
		File tarImgFile = new File("d:/ice.png");
		//BufferedImage pressImg = ImageUtil.read(tarImgFile);
		Font font = new Font("宋体",Font.BOLD,20);
		ImageUtil.pressText(srcImgFile, tarImgFile, "无锡隆正", Color.RED,font,-20,150, 0.8f);
		
		@SuppressWarnings("rawtypes")
		WeightObj[] wightObjs = new WeightObj[5];
		/**
		 * 取样范围;
		 */
		wightObjs[0] = new WeightObj<Integer>(new Integer(1),2.0f);
		wightObjs[1] = new WeightObj<Integer>(new Integer(2),2.0f);
		wightObjs[2] = new WeightObj<Integer>(new Integer(3),2.0f);
		wightObjs[3] = new WeightObj<Integer>(new Integer(4),2.0f);
		wightObjs[4] = new WeightObj<Integer>(new Integer(5),2.0f);
		WeightRandom<Integer>  res = RandomUtil.weightRandom(wightObjs);
		res.toString();
		
		try {
			//ImageIO.write(imgAfterPress, "png", srcImgFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
