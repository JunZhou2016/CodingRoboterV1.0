package com.fangshuo.lib4fangshuo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: HttpUtils.java
 * @Description: Http请求相关的工具类;
 * 
 *               参考代码：https://www.cnblogs.com/huangjian2/p/6238236.html
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年9月29日 下午3:44:58
 */
public class HttpUtils {
	
	/**
	 * 根据名称获取请求头的信息;
	 * @param request
	 * @param headerName
	 * @return
	 */
	public static String getReqHeaderByName(HttpServletRequest request, String headerName) {

		return request.getHeader(headerName);
	}

	/**
	 * 根据请求信息或去Ip地址;
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip != null) {
			if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
				int index = ip.indexOf(",");
				if (index != -1) {
					return ip.substring(0, index);
				} else {
					return ip;
				}
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (ip != null) {
			if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}
		ip = request.getHeader("Proxy-Client-IP");
		if (ip != null) {
			if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}
		ip = request.getHeader("WL-Proxy-Client-IP");
		if (ip != null) {
			if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}
		ip = request.getRemoteAddr();
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

	/**
	 * 根据Ip地址获取客户端的Mac地址;
	 * 
	 * @param ip
	 * @return
	 */
	@SuppressWarnings("unused")
	public static String getMacAddrByIp(String ip) {
		String macAddr = null;
		try {
			Process process = Runtime.getRuntime().exec("nbtstat -a " + ip);
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			Pattern pattern = Pattern.compile("([A-F0-9]{2}-){5}[A-F0-9]{2}");
			Matcher matcher;
			for (String strLine = br.readLine(); strLine != null; strLine = br.readLine()) {
				matcher = pattern.matcher(strLine);
				if (matcher.find()) {
					macAddr = matcher.group();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return macAddr;
	}

}
