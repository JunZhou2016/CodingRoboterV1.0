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
		QrCodeUtil.generate("My father was a self-taught mandolin player. He was one of the best string instrument players in our town. He could not read music, but if he heard a tune a few times, he could play it. When he was younger, he was a member of a small country music band. They would play at local dances and on a few occasions would play for the local radio station. He often told us how he had auditioned and earned a position in a band that featured Patsy Cline as their lead singer. He told the family that after he was hired he never went back. Dad was a very religious man. He stated that there was a lot of drinking and cursing the day of his audition and he did not want to be around that type of environment.\r\n" + 
				"\r\n" + 
				"　　Occasionally, Dad would get out his mandolin and play for the family. We three children: Trisha, Monte and I, George Jr., would often sing along. Songs such as the Tennessee Waltz, Harbor Lights and around Christmas time, the well-known rendition of Silver Bells. \"Silver Bells, Silver Bells, its Christmas time in the city\" would ring throughout the house. One of Dad's favorite hymns was \"The Old Rugged Cross\". We learned the words to the hymn when we were very young, and would sing it with Dad when he would play and sing. Another song that was often shared in our house was a song that accompanied the Walt Disney series: Davey Crockett. Dad only had to hear the song twice before he learned it well enough to play it. \"Davey, Davey Crockett, King of the Wild Frontier\" was a favorite song for the family. He knew we enjoyed the song and the program and would often get out the mandolin after the program was over. I could never get over how he could play the songs so well after only hearing them a few times. I loved to sing, but I never learned how to play the mandolin. This is something I regret to this day.", config, FileUtil.file("d:/qrcode.jpg"));
	}
}
