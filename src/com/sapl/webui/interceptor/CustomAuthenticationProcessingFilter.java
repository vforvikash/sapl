package com.sapl.webui.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.Authentication;
import org.acegisecurity.ui.webapp.AuthenticationProcessingFilter;

public class CustomAuthenticationProcessingFilter extends AuthenticationProcessingFilter{
	
	
	protected void onSuccessfulAuthentication(HttpServletRequest req, HttpServletResponse resp, Authentication auth) throws IOException {
        super.onSuccessfulAuthentication(req, resp, auth);
        // Do your logic here
    }
	
	public Authentication attemptAuthentication(HttpServletRequest req){
		System.out.println("\n\n\nHi Vikash you have done it to do the processing==========>"+req.getParameter("gb"));
		return super.attemptAuthentication(req);
	}
	
	
}
