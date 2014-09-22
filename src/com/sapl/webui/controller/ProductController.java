package com.sapl.webui.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Product;
import com.sapl.services.user.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
    private Validator validator;
	@Autowired
	private ReloadableResourceBundleMessageSource validationMessages;



	@RequestMapping(value="/secure/product/list", method = RequestMethod.GET)
	public void list(Model model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is list");
		model.addAttribute("action", "list");
		try {
			List<Product> products = productService.getProducts();
			model.addAttribute("products", products);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("message", "This is hello world annotation");
	}

	@RequestMapping(value="/secure/product/create", method = RequestMethod.GET)
	public String create(@ModelAttribute("product") Product product, BindingResult bindingResult, Model model){
		System.out.println("This is create");
		model.addAttribute("action", "create");
		//model.addAttribute("product", new Product());
		return "/secure/product/form";
	}

	@RequestMapping(value="/secure/product/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("objectId") String objectId, ModelMap model) throws SaplCntlException{
		System.out.println("This is delete");
		if(objectId != null && !objectId.equals("")){
			System.out.println("Delete here");
			try {
				int productId = Integer.parseInt(objectId);
				Product product = productService.getProduct(productId);
				productService.deleteProduct(product);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		model.addAttribute("action", "delete");
		return "redirect:/secure/product/list.htm";
	}

	@RequestMapping(value="/secure/product/view", method = RequestMethod.POST)
	public String view(@RequestParam("objectId") String objectId, @ModelAttribute("product") Product product, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		if(objectId != null && !objectId.equals("")){
			try {
				int productId = Integer.parseInt(objectId);
				product = productService.getProduct(productId);
				List<Product> products = productService.getProducts();
				model.addAttribute("products", products);
				model.addAttribute("product", product);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/product/list";
	}

	@RequestMapping(value="/secure/product/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("objectId") String objectId, @ModelAttribute Product product, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "edit");
		if(objectId != null && !objectId.equals("")){
			try {
				int productId = Integer.parseInt(objectId);
				product = productService.getProduct(productId);
				model.addAttribute("product", product);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/product/form";
	}

	@RequestMapping(value="/secure/product/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("product") Product product, Model model)throws SaplCntlException{
		System.out.println("This is update");
		model.addAttribute("action", "view");
		try {
			productService.updateProductDependencies(product);
			productService.updateProduct(product);
			model.addAttribute("message", "Product is updated!!");
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		return "redirect:/secure/product/list.htm";
	}

	@RequestMapping(value="/secure/product/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("product") Product product, BindingResult br, ModelMap model) throws SaplCntlException{
		System.out.println("This is save");
		model.addAttribute("action", "save");
		Set<ConstraintViolation<Product>> errors = validator.validate(product);
		if(errors.size()> 0){
			model.addAttribute("product", product);
			model.addAttribute("action", "create");
			for (ConstraintViolation<Product> error : errors) {
		        br.addError(new ObjectError("product", error.getMessage()));
			}
			return "/secure/product/form";
		}else{
			System.out.println("got the value---"+product.getType().getId());
			try {
				productService.updateProductDependencies(product);
				productService.saveNewProduct(product);
			} catch (SaplDaoException e) {
				e.printStackTrace();
				throw new SaplCntlException(e);
			}
			model.addAttribute("action", "list");
			return "redirect:/secure/product/list.htm";
		}
	}


	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}
