package com.sapl.webui.aop;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

public class MethodAfterLogAdvice implements AfterReturningAdvice {

	/**
	 * Log for debugging
	 */
	private Log log = null;
	
	/* (non-Javadoc)
	 * @see org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	public void afterReturning(Object value, Method method, Object[] objects, Object target) throws Throwable {
		log = LogFactory.getLog(target.getClass());
		log.debug(method.getName() + ":END");
	}
 
	

}