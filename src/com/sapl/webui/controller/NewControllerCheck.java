package com.sapl.webui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class NewControllerCheck {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView helloWorld(){
		System.out.println("This is hello world program");
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("helloWorld");
		//mav.addObject("message", "Hello World");
		return new ModelAndView("helloworld", "message", "This is hello world annotation");
	}
}
