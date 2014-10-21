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
import com.sapl.db.data.Colour;
import com.sapl.services.user.ColourService;

@Controller
public class ColourController {

	@Autowired
	private ColourService colourService;


	@RequestMapping(value="/secure/colour/list", method = RequestMethod.GET)
	public void list(Model model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is list");
		model.addAttribute("action", "list");
		try {
			List<Colour> colours = colourService.getColours();
			model.addAttribute("colours", colours);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("message", "This is hello world annotation");
	}

	@RequestMapping(value="/secure/colour/create", method = RequestMethod.GET)
	public String create(Model model, @ModelAttribute("colour") Colour colour, BindingResult bindingResult){
		System.out.println("This is create");
		model.addAttribute("action", "create");
		model.addAttribute("colour", new Colour());
		return "/secure/colour/form";
	}

	@RequestMapping(value="/secure/colour/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("objectId") String objectId, ModelMap model) throws SaplCntlException{
		System.out.println("This is delete");
		if(objectId != null && !objectId.equals("")){
			System.out.println("Delete here");
			try {
				int colourId = Integer.parseInt(objectId);
				Colour colour = colourService.getColour(colourId);
				colourService.deleteColour(colour);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		model.addAttribute("action", "delete");
		return "redirect:/secure/colour/list.htm";
	}

	@RequestMapping(value="/secure/colour/view", method = RequestMethod.POST)
	public String view(@RequestParam("objectId") String objectId, @ModelAttribute("colour") Colour colour, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		if(objectId != null && !objectId.equals("")){
			try {
				int colourId = Integer.parseInt(objectId);
				colour = colourService.getColour(colourId);
				List<Colour> colours = colourService.getColours();
				model.addAttribute("colours", colours);
				model.addAttribute("colour", colour);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/colour/list";
	}

	@RequestMapping(value="/secure/colour/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("objectId") String objectId, @ModelAttribute("colour") Colour colour, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "edit");
		if(objectId != null && !objectId.equals("")){
			try {
				int colourId = Integer.parseInt(objectId);
				colour = colourService.getColour(colourId);
				model.addAttribute("colour", colour);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/colour/form";
	}

	@RequestMapping(value="/secure/colour/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("colour") Colour colour, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		try {
			colourService.updateColour(colour);
			model.addAttribute("message", "Colour is updated!!");
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		return "redirect:/secure/colour/list.htm";
	}

	@RequestMapping(value="/secure/colour/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("colour") Colour colour, ModelMap model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is save");
		model.addAttribute("action", "save");
		try {
			colourService.saveNewColour(colour);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("action", "list");
		return "redirect:/secure/colour/list.htm";
	}
	
	@ModelAttribute("module")
    public String getModule() {
		return "COLOUR";
    }


	public ColourService getColourService() {
		return colourService;
	}

	public void setColourService(ColourService colourService) {
		this.colourService = colourService;
	}
}
