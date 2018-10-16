package com.fangshuo.codefactory.utils;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: StringUtils.java
 * @Description: 字符串操作常用方法集
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月27日 上午10:00:03
 */
public class StringUtils {

	/**
	 * 对象是否为无效值
	 * 
	 * @param obj 要判断的对象
	 * @return 是否为有效值(不为null 和 ""字符串)
	 */
	public static boolean isNullOrEmpty(Object obj) {
		return obj == null || "".equals(obj.toString());
	}

	/**
	 * 将字符串的第一位转为小写
	 * 
	 * @param str 需要转换的字符串
	 * @return 转换后的字符串
	 */
	public static String toLowerCaseFirstOne(String str) {
		if (Character.isLowerCase(str.charAt(0))) {
			return str;
		} else {
			char[] chars = str.toCharArray();
			chars[0] = Character.toLowerCase(chars[0]);
			return new String(chars);
		}
	}

	/**
	 * 将字符串的第一位转为大写
	 * 
	 * @param str 需要转换的字符串
	 * @return 转换后的字符串
	 */
	public static String toUpperCaseFirstOne(String str) {
		if (Character.isUpperCase(str.charAt(0))) {
			return str;
		} else {
			char[] chars = str.toCharArray();
			chars[0] = Character.toUpperCase(chars[0]);
			return new String(chars);
		}
	}

	/**
	 * 下划线命名转为驼峰命名
	 * 
	 * @param str 下划线命名格式
	 * @return 驼峰命名格式
	 */
	public static String underScoreCase2CamelCase(String str) {
		if (!str.contains("_")) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		char[] chars = str.toCharArray();
		boolean flag = false;
		for (int i = 0; i < chars.length; i++) {
			char ch = chars[i];
			if (ch == '_') {
				flag = true;
			} else {
				if (flag) {
					sb.append(Character.toUpperCase(ch));
					flag = false;
				} else {
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 驼峰命名转为下划线命名
	 * 
	 * @param str 驼峰命名格式
	 * @return 下划线命名格式
	 */
	public static String camelCase2UnderScoreCase(String str) {
		StringBuilder sb = new StringBuilder();
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char ch = chars[i];
			if (Character.isUpperCase(ch)) {
				sb.append("_").append(Character.toLowerCase(ch));
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	/**
	 * <p>
	 * Gets a substring from the specified String avoiding exceptions.
	 * </p>
	 *
	 * <p>
	 * A negative start position can be used to start/end {@code n} characters from
	 * the end of the String.
	 * </p>
	 *
	 * <p>
	 * The returned substring starts with the character in the {@code start}
	 * position and ends before the {@code end} position. All position counting is
	 * zero-based -- i.e., to start at the beginning of the string use
	 * {@code start = 0}. Negative start and end positions can be used to specify
	 * offsets relative to the end of the String.
	 * </p>
	 *
	 * <p>
	 * If {@code start} is not strictly to the left of {@code end}, "" is returned.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.substring(null, *, *)    = null
	 * StringUtils.substring("", * ,  *)    = "";
	 * StringUtils.substring("abc", 0, 2)   = "ab"
	 * StringUtils.substring("abc", 2, 0)   = ""
	 * StringUtils.substring("abc", 2, 4)   = "c"
	 * StringUtils.substring("abc", 4, 6)   = ""
	 * StringUtils.substring("abc", 2, 2)   = ""
	 * StringUtils.substring("abc", -2, -1) = "b"
	 * StringUtils.substring("abc", -4, 2)  = "ab"
	 * </pre>
	 *
	 * @param str   the String to get the substring from, may be null
	 * @param start the position to start from, negative means count back from the
	 *              end of the String by this many characters
	 * @param end   the position to end at (exclusive), negative means count back
	 *              from the end of the String by this many characters
	 * @return substring from start position to end position, {@code null} if null
	 *         String input
	 */
	public static String substring(final String str, int start, int end) {
		if (str == null) {
			return null;
		}

		// handle negatives
		if (end < 0) {
			end = str.length() + end; // remember end is negative
		}
		if (start < 0) {
			start = str.length() + start; // remember start is negative
		}

		// check length next
		if (end > str.length()) {
			end = str.length();
		}

		// if start is greater than end, return ""
		if (start > end) {
			return "";
		}

		if (start < 0) {
			start = 0;
		}
		if (end < 0) {
			end = 0;
		}

		return str.substring(start, end);
	}
}
