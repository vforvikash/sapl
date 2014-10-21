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
import com.sapl.db.data.Ground;
import com.sapl.services.user.GroundService;

@Controller
public class GroundController {

	@Autowired
	private GroundService groundService;


	@RequestMapping(value="/secure/ground/list", method = RequestMethod.GET)
	public void list(Model model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is list");
		model.addAttribute("action", "list");
		try {
			List<Ground> grounds = groundService.getGrounds();
			model.addAttribute("grounds", grounds);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("message", "This is hello world annotation");
	}

	@RequestMapping(value="/secure/ground/create", method = RequestMethod.GET)
	public String create(Model model, @ModelAttribute("ground") Ground ground, BindingResult bindingResult){
		System.out.println("This is create");
		model.addAttribute("action", "create");
		model.addAttribute("ground", new Ground());
		return "/secure/ground/form";
	}

	@RequestMapping(value="/secure/ground/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("objectId") String objectId, ModelMap model) throws SaplCntlException{
		System.out.println("This is delete");
		if(objectId != null && !objectId.equals("")){
			System.out.println("Delete here");
			try {
				int groundId = Integer.parseInt(objectId);
				Ground ground = groundService.getGround(groundId);
				groundService.deleteGround(ground);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		model.addAttribute("action", "delete");
		return "redirect:/secure/ground/list.htm";
	}

	@RequestMapping(value="/secure/ground/view", method = RequestMethod.POST)
	public String view(@RequestParam("objectId") String objectId, @ModelAttribute("ground") Ground ground, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		if(objectId != null && !objectId.equals("")){
			try {
				int groundId = Integer.parseInt(objectId);
				ground = groundService.getGround(groundId);
				List<Ground> grounds = groundService.getGrounds();
				model.addAttribute("grounds", grounds);
				model.addAttribute("ground", ground);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/ground/list";
	}

	@RequestMapping(value="/secure/ground/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("objectId") String objectId, @ModelAttribute("ground") Ground ground, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "edit");
		if(objectId != null && !objectId.equals("")){
			try {
				int groundId = Integer.parseInt(objectId);
				ground = groundService.getGround(groundId);
				model.addAttribute("ground", ground);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/ground/form";
	}

	@RequestMapping(value="/secure/ground/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("ground") Ground ground, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		try {
			groundService.updateGround(ground);
			model.addAttribute("message", "Ground is updated!!");
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		return "redirect:/secure/ground/list.htm";
	}

	@RequestMapping(value="/secure/ground/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("ground") Ground ground, ModelMap model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is save");
		model.addAttribute("action", "save");
		try {
			groundService.saveNewGround(ground);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("action", "list");
		return "redirect:/secure/ground/list.htm";
	}
	
	@ModelAttribute("module")
    public String getModule() {
		return "GROUND";
    }

	public GroundService getGroundService() {
		return groundService;
	}

	public void setGroundService(GroundService groundService) {
		this.groundService = groundService;
	}
}
