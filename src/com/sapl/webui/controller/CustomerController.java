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
import com.sapl.db.data.Customer;
import com.sapl.services.user.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;


	@RequestMapping(value="/secure/customer/list", method = RequestMethod.GET)
	public void list(Model model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is list");
		model.addAttribute("action", "list");
		try {
			List<Customer> customers = customerService.getCustomers();
			model.addAttribute("customers", customers);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("message", "This is hello world annotation");
	}

	@RequestMapping(value="/secure/customer/create", method = RequestMethod.GET)
	public String create(Model model, @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
		System.out.println("This is create");
		model.addAttribute("action", "create");
		model.addAttribute("customer", new Customer());
		return "/secure/customer/form";
	}

	@RequestMapping(value="/secure/customer/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("objectId") String objectId, ModelMap model) throws SaplCntlException{
		System.out.println("This is delete");
		if(objectId != null && !objectId.equals("")){
			System.out.println("Delete here");
			try {
				int customerId = Integer.parseInt(objectId);
				Customer customer = customerService.getCustomer(customerId);
				customerService.deleteCustomer(customer);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		model.addAttribute("action", "delete");
		return "redirect:/secure/customer/list.htm";
	}

	@RequestMapping(value="/secure/customer/view", method = RequestMethod.POST)
	public String view(@RequestParam("objectId") String objectId, @ModelAttribute("customer") Customer customer, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		if(objectId != null && !objectId.equals("")){
			try {
				int customerId = Integer.parseInt(objectId);
				customer = customerService.getCustomer(customerId);
				List<Customer> customers = customerService.getCustomers();
				model.addAttribute("customers", customers);
				model.addAttribute("customer", customer);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/customer/list";
	}

	@RequestMapping(value="/secure/customer/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("objectId") String objectId, @ModelAttribute("customer") Customer customer, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "edit");
		if(objectId != null && !objectId.equals("")){
			try {
				int customerId = Integer.parseInt(objectId);
				customer = customerService.getCustomer(customerId);
				model.addAttribute("customer", customer);
			} catch (SaplDaoException e) {
				throw new SaplCntlException(e);
			}
		}
		return "/secure/customer/form";
	}

	@RequestMapping(value="/secure/customer/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("customer") Customer customer, Model model)throws SaplCntlException{
		System.out.println("This is view");
		model.addAttribute("action", "view");
		try {
			customerService.updateCustomer(customer);
			model.addAttribute("message", "Customer is updated!!");
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		return "redirect:/secure/customer/list.htm";
	}

	@RequestMapping(value="/secure/customer/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("customer") Customer customer, ModelMap model, HttpServletRequest request) throws SaplCntlException{
		System.out.println("This is save");
		model.addAttribute("action", "save");
		try {
			customerService.saveNewCustomer(customer);
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
		model.addAttribute("action", "list");
		return "redirect:/secure/customer/list.htm";
	}


	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
