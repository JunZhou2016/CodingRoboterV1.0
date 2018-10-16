package com.fangshuo.tempTest;

import java.util.List;

import cn.hutool.dfa.WordTree;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: DFATest.java
 * @Description: DFA算法测试;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月12日 上午9:05:29
 */
public class DFATest {
	public static void main(String[] args) {
		WordTree tree = new WordTree();
		tree.addWord("大");
		tree.addWord("大土豆");
		tree.addWord("土豆");
		tree.addWord("刚出锅");
		tree.addWord("出锅");

		// 正文
		String text = "我有一颗大土豆，刚出锅的";

		// 匹配到【大】，就不再继续匹配了，因此【大土豆】不匹配
		// 匹配到【刚出锅】，就跳过这三个字了，因此【出锅】不匹配（由于刚首先被匹配，因此长的被匹配，最短匹配只针对第一个字相同选最短）
		List<String> matchAll = tree.matchAll(text, -1, false, false);
		if ("[大, 土豆, 刚出锅]".equals(matchAll.toString())) {
			System.out.println("[大, 土豆, 刚出锅]");
		}

	}
}
