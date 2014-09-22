package com.sapl.webui.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Sample;
import com.sapl.services.user.UserInfoService;

@Controller
public class SampleController {

	@Autowired
	private UserInfoService userInfoService;


	@RequestMapping(value="/secure/sample/list", method = RequestMethod.GET)
	public void list(Model model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is list");
		model.addAttribute("action", "list");
		try {
			List<Sample> samples = userInfoService.getSamples();
			model.addAttribute("samples", samples);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("message", "This is hello world annotation");
	}

	@RequestMapping(value="/secure/sample/create", method = RequestMethod.GET)
	public String create(Model model, @ModelAttribute("sample") Sample sample, BindingResult bindingResult){
		System.out.println("This is create");
		model.addAttribute("action", "create");
		model.addAttribute("sample", new Sample());
		return "/secure/sample/form";
	}

	@RequestMapping(value="/secure/sample/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("objectId") String objectId, ModelMap model) throws SaplCntlException{
		System.out.println("This is delete");
		if(objectId != null && !objectId.equals("")){
			System.out.println("Delete here");
			try {
				int sampleId = Integer.parseInt(objectId);
				Sample sample = userInfoService.getSample(sampleId);
				userInfoService.deleteSample(sample);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		model.addAttribute("action", "delete");
		return "redirect:/secure/sample/list.htm";
	}

	@RequestMapping(value="/secure/sample/view", method = RequestMethod.POST)
	public String view(@RequestParam("objectId") String objectId, @ModelAttribute("sample") Sample sample, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		if(objectId != null && !objectId.equals("")){
			try {
				int sampleId = Integer.parseInt(objectId);
				sample = userInfoService.getSample(sampleId);
				List<Sample> samples = userInfoService.getSamples();
				model.addAttribute("samples", samples);
				model.addAttribute("sample", sample);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/sample/list";
	}

	@RequestMapping(value="/secure/sample/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("objectId") String objectId, @ModelAttribute("sample") Sample sample, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "edit");
		if(objectId != null && !objectId.equals("")){
			try {
				int sampleId = Integer.parseInt(objectId);
				sample = userInfoService.getSample(sampleId);
				model.addAttribute("sample", sample);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/sample/form";
	}

	@RequestMapping(value="/secure/sample/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("sample") Sample sample, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		try {
			userInfoService.updateSample(sample);
			model.addAttribute("message", "Sample is updated!!");
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		return "redirect:/secure/sample/list.htm";
	}

	@RequestMapping(value="/secure/sample/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("sample") Sample sample, ModelMap model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is save");
		model.addAttribute("action", "save");
		try {
			userInfoService.saveNewSample(sample);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("action", "list");
		return "redirect:/secure/sample/list.htm";
	}


	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
}
