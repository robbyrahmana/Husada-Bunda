package com.cinovation.web.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Tracker extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger.getLogger(Tracker.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		logger.info(String.format("%-10d%-10d%-10s%s",
				response.getStatus(),
				(System.currentTimeMillis() - startTime),
				request.getMethod(),
				request.getRequestURI().toString()
				));
	}
}
