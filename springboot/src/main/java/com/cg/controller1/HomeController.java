package com.cg.controller1;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.bean.Customer;
import com.cg.service.ICustomerService;

@RestController
public class HomeController {
	@Autowired
	ICustomerService service;

	public ICustomerService getService() {
		return service;
	}

	public void setService(ICustomerService service) {
		this.service = service;
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Customer addCustomer(@RequestBody Customer customer) {

		customer = service.addCustomer(customer);
		return customer;
	}

	@RequestMapping(value = "/getCustomer/{custId}", method = RequestMethod.POST, produces = "application/json")
	public Customer findCustomer(@PathVariable int custId) {
		Customer customer = service.findCustomer(custId);
		return customer;

	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Customer updateCustomer(@RequestBody Customer customer) {
		Customer customer1 = service.updateCustomer(customer);
		return customer1;

	}

	@RequestMapping(value = "/getCustomerList", method = RequestMethod.POST, produces = "application/json")
	public List<Customer> getCustomerList() {
		List<Customer> list = service.getCustomerList();
		return list;

	}

	@RequestMapping(value = "/getCustomer/{custId}", method = RequestMethod.POST, produces = "application/json")
	public Customer deleteCustomer(@PathVariable int custId) {
		Customer customer = service.removeCustomer(custId);
		return customer;

	}
	/*
	 * @Autowired ICustomerService service;
	 * 
	 * // @RequestMapping("/homePage")
	 * 
	 * public String displayHomePage(Model model) { LocalDate date= LocalDate.now();
	 * model.addAttribute("today", date); return "Home"; }
	 * 
	 * 
	 * public ICustomerService getService() { return service; }
	 * 
	 * public void setService(ICustomerService service) { this.service = service; }
	 * 
	 * @RequestMapping(method = RequestMethod.GET, value = "homePage") public
	 * ModelAndView displayHomePage() { LocalDate date = LocalDate.now();
	 * ModelAndView mv = new ModelAndView(); mv.addObject("today", date);
	 * mv.setViewName("Home");// logical view name // or ModelAndView mv= new
	 * ModelAndView("Home","today",date); return mv; }
	 * 
	 * @RequestMapping("showRegistrationForm") public String
	 * showRegistrationForm(Model model) { Customer customer = new Customer();
	 * model.addAttribute("customer", customer); return "CustomerRegistration"; }
	 * 
	 * @RequestMapping("registerUserAction") public String
	 * RegisterCustomerDetails(@Valid @ModelAttribute("customer") Customer customer,
	 * BindingResult result, Model model) { // code to process on customer details
	 * if (result.hasErrors()) { return "CustomerRegistration"; } customer =
	 * service.addCustomer(customer); model.addAttribute("customer", customer);
	 * return "Success"; }
	 * 
	 * @RequestMapping("customerListAction") public String showCustomerList(Model
	 * model) { List<Customer> list = service.getCustomerList();
	 * model.addAttribute("list", list); return "CustomerList"; }
	 * 
	 * @RequestMapping("showUpdatePage") public String showUpdatePage() { return
	 * "GetCustomerId"; }
	 * 
	 * @RequestMapping("findCustomerAction") public String
	 * getCustomerDetails(@RequestParam("custId") int id, Model model) {
	 * 
	 * Customer customer = service.findCustomer(id); if (customer == null) {
	 * model.addAttribute("error", "Customer ID not Found"); return "GetCustomerId";
	 * } model.addAttribute("customer", customer); return "UpdateCustomer"; }
	 * 
	 * @RequestMapping("updateCustomerAction") public String
	 * updateCustomer(@ModelAttribute("customer") Customer customer, Model model) {
	 * customer = service.updateCustomer(customer); model.addAttribute("customer",
	 * customer); return "Success"; }
	 */
}
