package com.sapl.webui.aop;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class MethodBeforeLogAdvice implements MethodBeforeAdvice {

	/**
	 * Log for debugging
	 */
	private Log log = null;
	/* (non-Javadoc)
	 * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	public void before(Method method, Object[] objects, Object object) throws Throwable {
		log = LogFactory.getLog(object.getClass());
		log.debug(method.getName() + ":START");
	}

	

}