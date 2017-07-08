package com.chinasofti.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object userInfo = request.getSession().getAttribute("userInfo");
		if (userInfo == null) {
			request.setAttribute("msg","请登录系统");
			request.getRequestDispatcher("/error/noSession.do").forward(request, response);
			return false;
		} else {
			return true;
		}
	}
}
