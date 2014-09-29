package com.sapl.webui.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class HomeController extends MultiActionController{

	public ModelAndView goHome(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Hi Vikash this is goHome() method!!!!");
		return new ModelAndView("/hello");
	}
	
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Hi Vikash this is to login page() method!!!!");
		return new ModelAndView("/index");
	}
}
