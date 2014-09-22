package com.sapl.webui.aop;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

public class ThrowsLogAdvice implements ThrowsAdvice {

	/**
	 * Log for debugging
	 */
	private Log log = null;
	
	/**
	 * @param method
	 * @param args
	 * @param target
	 * @param ex
	 * @throws Exception
	 */
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex)  throws Exception {
		log = LogFactory.getLog(target.getClass());
		log.error(method.getName() + ":EXCEPTION", ex);
		
		StackTraceElement elements[] = ex.getStackTrace();
	    for (int i = 0, n = elements.length; i < n; i++) {
			log.error(elements[i].getFileName() + ":" 
                    + elements[i].getLineNumber() 
                    + ">> " 
                    + elements[i].getMethodName() + "()");
	    }

	}
	
}
