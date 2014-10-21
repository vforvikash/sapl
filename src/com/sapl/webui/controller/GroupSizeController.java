package com.sapl.webui.controller;

import java.util.List;
import java.util.Set;

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
import com.sapl.db.data.GroupSize;
import com.sapl.db.data.Size;
import com.sapl.services.user.GroupSizeService;

@Controller
public class GroupSizeController {

	@Autowired
	private GroupSizeService groupSizeService;


	@RequestMapping(value="/secure/groupSize/list", method = RequestMethod.GET)
	public void list(Model model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is list");
		model.addAttribute("action", "list");
		try {
			List<GroupSize> groupSizes = groupSizeService.getGroupSizes();
			model.addAttribute("groupSizes", groupSizes);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("message", "This is hello world annotation");
	}

	@RequestMapping(value="/secure/groupSize/create", method = RequestMethod.GET)
	public String create(Model model, @ModelAttribute("groupSize") GroupSize groupSize, BindingResult bindingResult){
		System.out.println("This is create");
		model.addAttribute("action", "create");
		model.addAttribute("groupSize", new GroupSize());
		return "/secure/groupSize/form";
	}

	@RequestMapping(value="/secure/groupSize/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("objectId") String objectId, ModelMap model) throws SaplCntlException{
		System.out.println("This is delete");
		if(objectId != null && !objectId.equals("")){
			System.out.println("Delete here");
			try {
				int groupSizeId = Integer.parseInt(objectId);
				GroupSize groupSize = groupSizeService.getGroupSize(groupSizeId);
				groupSizeService.deleteGroupSize(groupSize);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		model.addAttribute("action", "delete");
		return "redirect:/secure/groupSize/list.htm";
	}

	@RequestMapping(value="/secure/groupSize/view", method = RequestMethod.POST)
	public String view(@RequestParam("objectId") String objectId, @ModelAttribute("groupSize") GroupSize groupSize, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		if(objectId != null && !objectId.equals("")){
			try {
				int groupSizeId = Integer.parseInt(objectId);
				groupSize = groupSizeService.getGroupSize(groupSizeId);
				List<GroupSize> groupSizes = groupSizeService.getGroupSizes();
				model.addAttribute("groupSizes", groupSizes);
				model.addAttribute("groupSize", groupSize);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/groupSize/list";
	}

	@RequestMapping(value="/secure/groupSize/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("objectId") String objectId, @ModelAttribute("groupSize") GroupSize groupSize, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "edit");
		if(objectId != null && !objectId.equals("")){
			try {
				int groupSizeId = Integer.parseInt(objectId);
				groupSize = groupSizeService.getGroupSize(groupSizeId);
				model.addAttribute("groupSize", groupSize);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/groupSize/form";
	}

	@RequestMapping(value="/secure/groupSize/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("groupSize") GroupSize groupSize, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		try {
			groupSizeService.updateGroupSize(groupSize);
			model.addAttribute("message", "GroupSize is updated!!");
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		return "redirect:/secure/groupSize/list.htm";
	}

	@RequestMapping(value="/secure/groupSize/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("groupSize") GroupSize groupSize, ModelMap model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is save");
		model.addAttribute("action", "save");
		try {
			Set<Size> sizes = groupSize.getSizes();
			sizes.addAll(groupSize.getSizeList());
			for (Size size : sizes) {
				size.setGroup(groupSize);
			}
			groupSizeService.saveNewGroupSize(groupSize);
		} catch (SaplDaoException e) {
			e.printStackTrace();
			throw new SaplCntlException(e);
		}
		model.addAttribute("action", "list");
		return "redirect:/secure/groupSize/list.htm";
	}
	
	@ModelAttribute("module")
    public String getModule() {
		return "GROUP_SIZE";
    }

	public GroupSizeService getGroupSizeService() {
		return groupSizeService;
	}

	public void setGroupSizeService(GroupSizeService groupSizeService) {
		this.groupSizeService = groupSizeService;
	}
}
