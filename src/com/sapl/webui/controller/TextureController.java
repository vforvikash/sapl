package com.sapl.webui.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.sapl.db.data.Texture;
import com.sapl.services.user.TextureService;

@Controller
public class TextureController {

	@Autowired
	private TextureService textureService;


	@RequestMapping(value="/secure/texture/list", method = RequestMethod.GET)
	public void list(Model model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is list");
		model.addAttribute("action", "list");
		try {
			List<Texture> textures = textureService.getTextures();
			model.addAttribute("textures", textures);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("message", "This is hello world annotation");
	}

	@RequestMapping(value="/secure/texture/create", method = RequestMethod.GET)
	public String create(Model model, @ModelAttribute("texture") Texture texture, BindingResult bindingResult){
		System.out.println("This is create");
		model.addAttribute("action", "create");
		model.addAttribute("texture", new Texture());
		return "/secure/texture/form";
	}

	@RequestMapping(value="/secure/texture/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("objectId") String objectId, ModelMap model) throws SaplCntlException{
		System.out.println("This is delete");
		if(objectId != null && !objectId.equals("")){
			System.out.println("Delete here");
			try {
				int textureId = Integer.parseInt(objectId);
				Texture texture = textureService.getTexture(textureId);
				textureService.deleteTexture(texture);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		model.addAttribute("action", "delete");
		return "redirect:/secure/texture/list.htm";
	}

	@RequestMapping(value="/secure/texture/view", method = RequestMethod.POST)
	public String view(@RequestParam("objectId") String objectId, @ModelAttribute("texture") Texture texture, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		if(objectId != null && !objectId.equals("")){
			try {
				int textureId = Integer.parseInt(objectId);
				texture = textureService.getTexture(textureId);
				List<Texture> textures = textureService.getTextures();
				model.addAttribute("textures", textures);
				model.addAttribute("texture", texture);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/texture/list";
	}

	@RequestMapping(value="/secure/texture/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("objectId") String objectId, @ModelAttribute("texture") Texture texture, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "edit");
		if(objectId != null && !objectId.equals("")){
			try {
				int textureId = Integer.parseInt(objectId);
				texture = textureService.getTexture(textureId);
				model.addAttribute("texture", texture);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/texture/form";
	}

	@RequestMapping(value="/secure/texture/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("texture") Texture texture, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		try {
			textureService.updateTexture(texture);
			model.addAttribute("message", "Texture is updated!!");
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		return "redirect:/secure/texture/list.htm";
	}

	@RequestMapping(value="/secure/texture/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("texture") Texture texture, ModelMap model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is save");
		model.addAttribute("action", "save");
		try {
			textureService.saveNewTexture(texture);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("action", "list");
		return "redirect:/secure/texture/list.htm";
	}


	public TextureService getTextureService() {
		return textureService;
	}

	public void setTextureService(TextureService textureService) {
		this.textureService = textureService;
	}
}
