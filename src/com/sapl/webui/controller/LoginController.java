package com.sapl.webui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class LoginController /*extends SimpleFormController*/{

	/*@Override
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
	}*/
	@RequestMapping(value="/", method = RequestMethod.GET)
	public void login(){
		System.out.println("I'm trying to login....");
	}
	
}
