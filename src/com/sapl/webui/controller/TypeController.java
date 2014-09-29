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
import com.sapl.db.data.Type;
import com.sapl.services.user.TypeService;

@Controller
public class TypeController {

	@Autowired
	private TypeService typeService;


	@RequestMapping(value="/secure/type/list", method = RequestMethod.GET)
	public void list(Model model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is list");
		model.addAttribute("action", "list");
		try {
			List<Type> types = typeService.getTypes();
			model.addAttribute("types", types);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("message", "This is hello world annotation");
	}

	@RequestMapping(value="/secure/type/create", method = RequestMethod.GET)
	public String create(Model model, @ModelAttribute("type") Type type, BindingResult bindingResult){
		System.out.println("This is create");
		model.addAttribute("action", "create");
		model.addAttribute("type", new Type());
		return "/secure/type/form";
	}

	@RequestMapping(value="/secure/type/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("objectId") String objectId, ModelMap model) throws SaplCntlException{
		System.out.println("This is delete");
		if(objectId != null && !objectId.equals("")){
			System.out.println("Delete here");
			try {
				int typeId = Integer.parseInt(objectId);
				Type type = typeService.getType(typeId);
				typeService.deleteType(type);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		model.addAttribute("action", "delete");
		return "redirect:/secure/type/list.htm";
	}

	@RequestMapping(value="/secure/type/view", method = RequestMethod.POST)
	public String view(@RequestParam("objectId") String objectId, @ModelAttribute("type") Type type, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		if(objectId != null && !objectId.equals("")){
			try {
				int typeId = Integer.parseInt(objectId);
				type = typeService.getType(typeId);
				List<Type> types = typeService.getTypes();
				model.addAttribute("types", types);
				model.addAttribute("type", type);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/type/list";
	}

	@RequestMapping(value="/secure/type/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("objectId") String objectId, @ModelAttribute("type") Type type, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "edit");
		if(objectId != null && !objectId.equals("")){
			try {
				int typeId = Integer.parseInt(objectId);
				type = typeService.getType(typeId);
				model.addAttribute("type", type);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/type/form";
	}

	@RequestMapping(value="/secure/type/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("type") Type type, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		try {
			typeService.updateType(type);
			model.addAttribute("message", "Type is updated!!");
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		return "redirect:/secure/type/list.htm";
	}

	@RequestMapping(value="/secure/type/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("type") Type type, ModelMap model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is save");
		model.addAttribute("action", "save");
		try {
			typeService.saveNewType(type);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("action", "list");
		return "redirect:/secure/type/list.htm";
	}


	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
}
