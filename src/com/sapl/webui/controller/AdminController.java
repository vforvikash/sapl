package com.sapl.webui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/secure/admin")
public class AdminController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView home(ModelMap model){
		model.put("message", "This is admin home page");
		System.out.println("This is admin controller");
		return new ModelAndView("/secure/admin/home");
	}
	
	@ModelAttribute("module")
    public String getModule() {
		return "ADMIN";
    }
}
