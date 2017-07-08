package com.chinasofti.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.chinasofti.pageModel.UserInfo;

public class ToolUtil {

	public static String userId(HttpSession session) {
		return session.getAttribute("userInfo") == null ? "" : ((UserInfo) session.getAttribute("userInfo")).getUserId();
	}

	public static String userName(HttpSession session) {
		return session.getAttribute("userInfo") == null ? "" : ((UserInfo) session.getAttribute("userInfo")).getUserName();
	}

	public static String user(HttpSession session) {
		return userId(session) + "/" + userName(session);
	}

	public static boolean isEmpty(String args) {
		return args == null || args.equals("") ? true : false;
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.indexOf("0:") != -1) {
			ip = "本地";
		}
		return ip;
	}

}
