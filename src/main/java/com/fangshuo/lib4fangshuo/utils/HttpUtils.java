package com.fangshuo.lib4fangshuo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
	private static final String LOCAL_HOST_IP = "127.0.0.1";// 本地IP;
	private static final String DEFULT_MAC = "00-00-00-00-00-00";// 默认MAC地址;
	private static final String OTH_MAC = "unknown MAC";// 未知的MAC地址;

	/**
	 * 根据名称获取请求头的信息;
	 * 
	 * @param request
	 * @param headerName
	 * @return
	 */
	public static String getReqHeaderByName(HttpServletRequest request, String headerName) {

		return request.getHeader(headerName);
	}

	/**
	 * 根据请求信息获取Ip地址,可靠性较高;
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
	 * 获取Ip的简单方式，无法保证Ip的真实性;
	 * 
	 * @return
	 */
	public static String getIp() {
		return HttpUtils.getRequest().getRemoteHost();
	}

	/**
	 * 根据IP地址获取对应主机的MAC地址;
	 * 
	 * @param ip:访问的IP，当IP地址是127.0.0.1时无法获取；
	 * @return
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public static String getMacByIP(String ip) {
		NetworkInterface ne;
		StringBuffer sb = new StringBuffer("");
		try {
			ne = NetworkInterface.getByInetAddress(InetAddress.getByName(ip));
			if (LOCAL_HOST_IP.equals(ip)) {
				sb.append(DEFULT_MAC);
			} else {
				byte[] mac = ne.getHardwareAddress();
				if (null != mac) {
					for (int i = 0; i < mac.length; i++) {
						if (i != 0) {
							sb.append("-");
						}
						// 字节转换为整数
						int temp = mac[i] & 0xff;
						String str = Integer.toHexString(temp);
						// System.out.println("每8位:"+str);
						if (str.length() == 1) {
							sb.append("0" + str);
						} else {
							sb.append(str);
						}
					}
				} else {
					sb.append(OTH_MAC);
				}
			}
		} catch (SocketException | UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 获取所有请求的值
	 */
	public static Map<String, String> getRequestParameters() {
		HashMap<String, String> values = new HashMap<>();
		HttpServletRequest request = HttpUtils.getRequest();
		Enumeration<?> enums = request.getParameterNames();
		while (enums.hasMoreElements()) {
			String paramName = (String) enums.nextElement();
			String paramValue = request.getParameter(paramName);
			values.put(paramName, paramValue);
		}
		return values;
	}

	/**
	 * 获取 HttpServletRequest
	 */
	public static HttpServletResponse getResponse() {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		return response;
	}

	/**
	 * 获取 包装防Xss Sql注入的 HttpServletRequest
	 * 
	 * @return request
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;
	}

	/**
	 * 向指定URL发送GET方法的请求
	 *
	 * @param url   发送请求的URL
	 * @param param 请求参数
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, Map<String, String> param) {
		String result = "";
		BufferedReader in = null;
		try {
			StringBuffer query = new StringBuffer();

			for (Map.Entry<String, String> kv : param.entrySet()) {
				query.append(URLEncoder.encode(kv.getKey(), "UTF-8") + "=");
				query.append(URLEncoder.encode(kv.getValue(), "UTF-8") + "&");
			}
			if (query.lastIndexOf("&") > 0) {
				query.deleteCharAt(query.length() - 1);
			}

			String urlNameString = url + "?" + query.toString();
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 *
	 * @param url   发送请求的 URL
	 * @param param 请求参数
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, Map<String, String> param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			String para = "";
			for (String key : param.keySet()) {
				para += (key + "=" + param.get(key) + "&");
			}
			if (para.lastIndexOf("&") > 0) {
				para = para.substring(0, para.length() - 1);
			}
			String urlNameString = url + "?" + para;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}
