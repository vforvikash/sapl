package com.sapl.webui.interceptor;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sapl.services.user.UserInfoService;
import com.sapl.util.DateTime;
import com.sapl.util.URLUtil;


/**
 * @author Administrator
 *
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter{

	private final transient Log log = LogFactory.getLog(AuthenticationInterceptor.class);
	private Date inTime=null;
	private String subscriptionType = null;
	private String setValue = "";
	private UserInfoService userInfoService;

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("Authentication posthandle---");
		 HttpSession session =  request.getSession(false);
		 if(session==null || session.getAttribute("userInfo") == null)
			 return;

		 //commneted for The current Build...

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object object) throws Exception {
		String action = URLUtil.parseAction(req.getRequestURL().toString());
		HttpSession session =  req.getSession(false);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("Authentication prehandle---"+authentication.isAuthenticated());
		if (authentication == null) {
				resp.sendRedirect(req.getContextPath()+"/index.jsp");
				return false;
		 }else{
			 Object principal = authentication.getPrincipal();
			 Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
			 for (Iterator iterator = authorities.iterator(); iterator.hasNext();) {
				GrantedAuthority grantedAuthority = (GrantedAuthority) iterator.next();
				if(grantedAuthority.getAuthority().equals("ROLE_ANONYMOUS")){
					resp.sendRedirect(req.getContextPath()+"/index.jsp");
					return false;
				}
			}
			System.out.println("auth - "+authentication.toString());
			System.out.println("auth name - "+authentication.getName());
			inTime =  DateTime.getDate();
		 }
		log.debug("remote user: " + req.getRemoteUser());
		return true;
	}

	/**
	 * @return Returns the setValue.
	 */
	public String getSetValue() {
		return setValue;
	}

	/**
	 * @param setValue The setValue to set.
	 */
	public void setSetValue(String setValue) {
		this.setValue = setValue;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
}
