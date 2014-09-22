package com.sapl.webui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.sapl.services.user.UserInfoService;

public class LoginController extends SimpleFormController{
	private UserInfoService userInfoService;

	@Override
	protected ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		System.out.println("This is showForm() method");
		return new ModelAndView(getFormView());
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		System.out.println("This is onSubmit() method");
		return super.onSubmit(request, response, command, errors);
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}


	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
}
