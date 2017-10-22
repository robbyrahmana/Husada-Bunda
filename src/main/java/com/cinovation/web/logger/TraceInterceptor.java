package com.cinovation.web.logger;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;

public class TraceInterceptor extends CustomizableTraceInterceptor {

	private static final long serialVersionUID = -5897441461281333151L;
	
	private static final Logger logger = Logger.getLogger(TraceInterceptor.class);

	protected void writeToLog(Log l, String message, Throwable ex) {
		if(message.startsWith("enterMessage")) {
		     // do nothing
		} else {
			if (ex != null) {
				// do nothing
			} else {
				logger.info(message);
			}
		}
	}

	protected boolean isInterceptorEnabled(MethodInvocation invocation, Log l) {
		return true;
	}
}
