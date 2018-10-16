package com.fangshuo.lib4fangshuo.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UUID {
	protected static final Logger log = LoggerFactory.getLogger(UUID.class.getName());
	protected final static Object _lock = new Object();

	private static final byte ALPHABET[] = { (byte) '0', (byte) '1', (byte) '2', (byte) '3', (byte) '4', (byte) '5',
			(byte) '6', (byte) '7', (byte) '8', (byte) '9', (byte) 'A', (byte) 'B', (byte) 'C', (byte) 'D', (byte) 'E',
			(byte) 'F', (byte) 'G', (byte) 'H', (byte) 'I', (byte) 'J', (byte) 'K', (byte) 'L', (byte) 'M', (byte) 'N',
			(byte) 'O', (byte) 'P', (byte) 'Q', (byte) 'R', (byte) 'S', (byte) 'T', (byte) 'U', (byte) 'V', (byte) 'W',
			(byte) 'X', (byte) 'Y', (byte) 'Z' };

	// 每天的毫秒
	protected static final int millisPerDay = 86400000;

	// 机器编号
	private static int hostId = 1;
	private static byte hostCode1 = ALPHABET[0];
	private static byte hostCode2 = ALPHABET[1];
	private static byte hostCode3 = ALPHABET[2];

	// 本地的IP地址
	private static final byte emptyIP[] = { (byte) 0, (byte) 0, (byte) 0, (byte) 0 };
	protected static final byte IP[];

	static {
		byte addr[];
		try {
			addr = InetAddress.getLocalHost().getAddress();
		} catch (Exception e) {
			addr = emptyIP;
		}

		IP = addr;

		// hostID
		hostId = createMachineIdentifier();
		hostCode1 = ALPHABET[(hostId >>> 10) & 0X1F];
		hostCode2 = ALPHABET[(hostId >>> 5) & 0X1F];
		hostCode3 = ALPHABET[hostId & 0X1F];
	}

	// 序号
	private static short counter = (short) 1;

	// 日期
	private static long dateCount = 0;
	private static byte dateBuffer[] = null;

	/**
	 * 本机和标准时间的差
	 */
	private static long timeInterval = 0;

	/**
	 * 标准日期
	 */
	private static String currDate = null;

	/**
	 * 服务器唯一编号
	 * 
	 * @return
	 */
	public static int getHostId() {
		return hostId;
	}

	public static void setHostId(int id) {
		hostId = id;
		hostCode1 = ALPHABET[(hostId >>> 4) & 0X0F];
		hostCode2 = ALPHABET[hostId & 0X0F];
	}

	/**
	 * 本机和标准时间的差
	 */
	public static long getTimeInterval() {
		return timeInterval;
	}

	public static void setTimeInterval(long t) {
		timeInterval = t;
	}

	// 生成日期串
	private synchronized static void createDateBuffer(long tt) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(tt);

		int yyyy = cal.get(Calendar.YEAR);
		int y = yyyy - 2000;
		int y1 = (y & 0XF0) >>> 4;
		int y2 = y & 0X0F;
		int m = cal.get(Calendar.MONTH) + 1;
		int d = cal.get(Calendar.DAY_OF_MONTH);

		dateBuffer = new byte[4];
		dateBuffer[0] = ALPHABET[y1];
		dateBuffer[1] = ALPHABET[y2];
		dateBuffer[2] = ALPHABET[m];
		dateBuffer[3] = ALPHABET[d];

		// 标准日期
		currDate = String.valueOf(yyyy * 10000 + m * 100 + d);
	}

	/**
	 * 生成唯一的编号
	 * 
	 * @return
	 */
	public static String getUUID() {
		byte[] uuid = new byte[16];

		// 当前时间，毫秒
		long tt = System.currentTimeMillis() - timeInterval;
		long dd = tt / millisPerDay;
		int ss = (int) (tt % millisPerDay);

		// 日期：YYMD
		if (dateCount != dd) {
			createDateBuffer(tt);
		}

		System.arraycopy(dateBuffer, 0, uuid, 0, 4);

		// 时间
		int d1 = ss >>> 25;
		int d2 = (ss >>> 20) & 0X1F;
		int d3 = (ss >>> 15) & 0X1F;
		int d4 = (ss >>> 10) & 0X1F;
		int d5 = (ss >>> 5) & 0X1F;
		int d6 = ss & 0X1F;
		uuid[4] = ALPHABET[d1];
		uuid[5] = ALPHABET[d2];
		uuid[6] = ALPHABET[d3];
		uuid[7] = ALPHABET[d4];
		uuid[8] = ALPHABET[d5];
		uuid[9] = ALPHABET[d6];

		// 机器编号
		uuid[10] = hostCode1;
		uuid[11] = hostCode2;
		uuid[12] = hostCode3;

		// 序号
		short c;
		synchronized (_lock) {
			if (counter < 1 || counter >= 30000) {
				counter = 1;
			}

			c = counter++;
		}

		int c2 = (c >> 10) & 0X1F;
		int c3 = (c >> 5) & 0X1F;
		int c4 = c & 0X1F;
		uuid[13] = ALPHABET[c2];
		uuid[14] = ALPHABET[c3];
		uuid[15] = ALPHABET[c4];

		// System.out.println( "UUID=" + (new String(uuid)) );
		return new String(uuid);
	}

	/* *********************** 标准日期和时间 ************************* */

	/**
	 * 当前数据库服务器的时间,到毫秒
	 */
	public static long currentTimeMillis() {
		return System.currentTimeMillis() - timeInterval;
	}

	/**
	 * 当前数据库服务器的时间[yyyymmdd]
	 * 
	 * @return
	 */
	public static String currentDate() {
		long tt = System.currentTimeMillis() - timeInterval;
		long dd = tt / millisPerDay;
		if (dateCount != dd) {
			createDateBuffer(tt);
		}

		return currDate;
	}

	/**
	 * 当前数据库服务器的时间[hhMMss]
	 * 
	 * @return
	 */
	public static String currentTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis() - timeInterval);

		long val = cal.get(Calendar.HOUR_OF_DAY) * 10000 + cal.get(Calendar.MINUTE) * 100 + cal.get(Calendar.SECOND);

		if (val < 10000) {
			return "00" + String.valueOf(val);
		} else if (val < 100000) {
			return "0" + String.valueOf(val);
		} else {
			return String.valueOf(val);
		}
	}

	/**
	 * 当前数据库服务器的时间[yyyymmddhhMMss]
	 * 
	 * @return
	 */
	public static String currentDateTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis() - timeInterval);

		// 日期
		long val = cal.get(Calendar.YEAR) * 10000 + (cal.get(Calendar.MONTH) + 1) * 100
				+ cal.get(Calendar.DAY_OF_MONTH);

		// 时间
		long val1 = cal.get(Calendar.HOUR_OF_DAY) * 10000 + cal.get(Calendar.MINUTE) * 100 + cal.get(Calendar.SECOND);

		if (val1 < 10000) {
			return String.valueOf(val) + "00" + String.valueOf(val1);
		} else if (val1 < 100000) {
			return String.valueOf(val) + "0" + String.valueOf(val1);
		} else {
			return String.valueOf(val) + String.valueOf(val1);
		}
	}

	/**
	 * 当前数据库服务器的时间[yyyy-mm-dd hh:MM:ss]
	 * 
	 * @return
	 */
	public static String longDateTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis() - timeInterval);

		int v;
		StringBuilder result = new StringBuilder(32);

		// 年
		v = cal.get(Calendar.YEAR);
		result.append(v);
		result.append("-");

		// 月
		v = cal.get(Calendar.MONTH) + 1;
		if (v < 10) {
			result.append("0");
		}

		result.append(v);
		result.append("-");

		// 日
		v = cal.get(Calendar.DAY_OF_MONTH);
		if (v < 10) {
			result.append("0");
		}

		result.append(v);
		result.append(" ");

		// 时
		v = cal.get(Calendar.HOUR_OF_DAY);
		if (v < 10) {
			result.append("0");
		}

		result.append(v);
		result.append(":");

		// 分
		v = cal.get(Calendar.MINUTE);
		if (v < 10) {
			result.append("0");
		}

		result.append(v);
		result.append(":");

		// 秒
		v = cal.get(Calendar.SECOND);
		if (v < 10) {
			result.append("0");
		}

		result.append(v);

		return result.toString();
	}

	@SuppressWarnings("rawtypes")
	private static int createMachineIdentifier() {
		int machinePiece;

		try {
			StringBuilder sb = new StringBuilder();
			Enumeration e = NetworkInterface.getNetworkInterfaces();
			while (e.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) e.nextElement();
				sb.append(ni.toString());
				byte[] mac = ni.getHardwareAddress();
				if (mac != null) {
					ByteBuffer bb = ByteBuffer.wrap(mac);
					try {
						sb.append(bb.getChar());
						sb.append(bb.getChar());
						sb.append(bb.getChar());
					} catch (BufferUnderflowException ex) {
					}
				}
			}
			machinePiece = sb.toString().hashCode();
		} catch (Throwable t) {
			machinePiece = new SecureRandom().nextInt();
			log.warn("Failed to get machine identifier from network interface, using random number instead");
		}

		machinePiece &= 16777215;
		return machinePiece;
	}

}
