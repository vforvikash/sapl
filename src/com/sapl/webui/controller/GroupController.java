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
import com.sapl.db.data.Group;
import com.sapl.services.user.GroupService;

@Controller
public class GroupController {

	@Autowired
	private GroupService groupService;


	@RequestMapping(value="/secure/group/list", method = RequestMethod.GET)
	public void list(Model model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is list");
		model.addAttribute("action", "list");
		try {
			List<Group> groups = groupService.getGroups();
			model.addAttribute("groups", groups);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("message", "This is hello world annotation");
	}

	@RequestMapping(value="/secure/group/create", method = RequestMethod.GET)
	public String create(Model model, @ModelAttribute("group") Group group, BindingResult bindingResult){
		System.out.println("This is create");
		model.addAttribute("action", "create");
		model.addAttribute("group", new Group());
		return "/secure/group/form";
	}

	@RequestMapping(value="/secure/group/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("objectId") String objectId, ModelMap model) throws SaplCntlException{
		System.out.println("This is delete");
		if(objectId != null && !objectId.equals("")){
			System.out.println("Delete here");
			try {
				int groupId = Integer.parseInt(objectId);
				Group group = groupService.getGroup(groupId);
				groupService.deleteGroup(group);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		model.addAttribute("action", "delete");
		return "redirect:/secure/group/list.htm";
	}

	@RequestMapping(value="/secure/group/view", method = RequestMethod.POST)
	public String view(@RequestParam("objectId") String objectId, @ModelAttribute("group") Group group, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		if(objectId != null && !objectId.equals("")){
			try {
				int groupId = Integer.parseInt(objectId);
				group = groupService.getGroup(groupId);
				List<Group> groups = groupService.getGroups();
				model.addAttribute("groups", groups);
				model.addAttribute("group", group);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/group/list";
	}

	@RequestMapping(value="/secure/group/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("objectId") String objectId, @ModelAttribute("group") Group group, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "edit");
		if(objectId != null && !objectId.equals("")){
			try {
				int groupId = Integer.parseInt(objectId);
				group = groupService.getGroup(groupId);
				model.addAttribute("group", group);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/group/form";
	}

	@RequestMapping(value="/secure/group/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("group") Group group, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		try {
			groupService.updateGroup(group);
			model.addAttribute("message", "Group is updated!!");
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		return "redirect:/secure/group/list.htm";
	}

	@RequestMapping(value="/secure/group/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("group") Group group, ModelMap model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is save");
		model.addAttribute("action", "save");
		try {
			groupService.saveNewGroup(group);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("action", "list");
		return "redirect:/secure/group/list.htm";
	}


	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}
}
