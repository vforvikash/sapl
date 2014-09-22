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
import com.sapl.db.data.ProductType;
import com.sapl.services.user.ProductTypeService;

@Controller
public class ProductTypeController {

	@Autowired
	private ProductTypeService productTypeService;


	@RequestMapping(value="/secure/productType/list", method = RequestMethod.GET)
	public void list(Model model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is list");
		model.addAttribute("action", "list");
		try {
			List<ProductType> productTypes = productTypeService.getProductTypes();
			model.addAttribute("productTypes", productTypes);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("message", "This is hello world annotation");
	}

	@RequestMapping(value="/secure/productType/create", method = RequestMethod.GET)
	public String create(Model model, @ModelAttribute("productType") ProductType productType, BindingResult bindingResult){
		System.out.println("This is create");
		model.addAttribute("action", "create");
		model.addAttribute("productType", new ProductType());
		return "/secure/productType/form";
	}

	@RequestMapping(value="/secure/productType/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("objectId") String objectId, ModelMap model) throws SaplCntlException{
		System.out.println("This is delete");
		if(objectId != null && !objectId.equals("")){
			System.out.println("Delete here");
			try {
				int productTypeId = Integer.parseInt(objectId);
				ProductType productType = productTypeService.getProductType(productTypeId);
				productTypeService.deleteProductType(productType);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		model.addAttribute("action", "delete");
		return "redirect:/secure/productType/list.htm";
	}

	@RequestMapping(value="/secure/productType/view", method = RequestMethod.POST)
	public String view(@RequestParam("objectId") String objectId, @ModelAttribute("productType") ProductType productType, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		if(objectId != null && !objectId.equals("")){
			try {
				int productTypeId = Integer.parseInt(objectId);
				productType = productTypeService.getProductType(productTypeId);
				List<ProductType> productTypes = productTypeService.getProductTypes();
				model.addAttribute("productTypes", productTypes);
				model.addAttribute("productType", productType);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/productType/list";
	}

	@RequestMapping(value="/secure/productType/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("objectId") String objectId, @ModelAttribute("productType") ProductType productType, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "edit");
		if(objectId != null && !objectId.equals("")){
			try {
				int productTypeId = Integer.parseInt(objectId);
				productType = productTypeService.getProductType(productTypeId);
				model.addAttribute("productType", productType);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/productType/form";
	}

	@RequestMapping(value="/secure/productType/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("productType") ProductType productType, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		try {
			productTypeService.updateProductType(productType);
			model.addAttribute("message", "ProductType is updated!!");
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		return "redirect:/secure/productType/list.htm";
	}

	@RequestMapping(value="/secure/productType/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("productType") ProductType productType, ModelMap model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is save");
		model.addAttribute("action", "save");
		try {
			productTypeService.saveNewProductType(productType);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("action", "list");
		return "redirect:/secure/productType/list.htm";
	}


	public ProductTypeService getProductTypeService() {
		return productTypeService;
	}

	public void setProductTypeService(ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}
}
