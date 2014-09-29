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
import com.sapl.db.data.Loom;
import com.sapl.services.user.LoomService;

@Controller
public class LoomController {

	@Autowired
	private LoomService loomService;


	@RequestMapping(value="/secure/loom/list", method = RequestMethod.GET)
	public void list(Model model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is list");
		model.addAttribute("action", "list");
		try {
			List<Loom> looms = loomService.getLooms();
			model.addAttribute("looms", looms);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("message", "This is hello world annotation");
	}

	@RequestMapping(value="/secure/loom/create", method = RequestMethod.GET)
	public String create(Model model, @ModelAttribute("loom") Loom loom, BindingResult bindingResult){
		System.out.println("This is create");
		model.addAttribute("action", "create");
		model.addAttribute("loom", new Loom());
		return "/secure/loom/form";
	}

	@RequestMapping(value="/secure/loom/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("objectId") String objectId, ModelMap model) throws SaplCntlException{
		System.out.println("This is delete");
		if(objectId != null && !objectId.equals("")){
			System.out.println("Delete here");
			try {
				int loomId = Integer.parseInt(objectId);
				Loom loom = loomService.getLoom(loomId);
				loomService.deleteLoom(loom);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		model.addAttribute("action", "delete");
		return "redirect:/secure/loom/list.htm";
	}

	@RequestMapping(value="/secure/loom/view", method = RequestMethod.POST)
	public String view(@RequestParam("objectId") String objectId, @ModelAttribute("loom") Loom loom, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		if(objectId != null && !objectId.equals("")){
			try {
				int loomId = Integer.parseInt(objectId);
				loom = loomService.getLoom(loomId);
				List<Loom> looms = loomService.getLooms();
				model.addAttribute("looms", looms);
				model.addAttribute("loom", loom);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/loom/list";
	}

	@RequestMapping(value="/secure/loom/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("objectId") String objectId, @ModelAttribute("loom") Loom loom, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "edit");
		if(objectId != null && !objectId.equals("")){
			try {
				int loomId = Integer.parseInt(objectId);
				loom = loomService.getLoom(loomId);
				model.addAttribute("loom", loom);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/loom/form";
	}

	@RequestMapping(value="/secure/loom/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("loom") Loom loom, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		try {
			loomService.updateLoom(loom);
			model.addAttribute("message", "Loom is updated!!");
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		return "redirect:/secure/loom/list.htm";
	}

	@RequestMapping(value="/secure/loom/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("loom") Loom loom, ModelMap model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is save");
		model.addAttribute("action", "save");
		try {
			loomService.saveNewLoom(loom);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("action", "list");
		return "redirect:/secure/loom/list.htm";
	}


	public LoomService getLoomService() {
		return loomService;
	}

	public void setLoomService(LoomService loomService) {
		this.loomService = loomService;
	}
}
