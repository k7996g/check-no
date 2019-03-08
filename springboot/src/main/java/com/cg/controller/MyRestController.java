package com.cg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Employee;

@RestController
public class MyRestController {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String displayHello() {
		return "Hello";
	}

	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET, produces = "application/json")
	public Employee getEmployeeDetails() {
		Employee emp = new Employee();
		emp.setFirstName("Kaushal");
		emp.setLastName("Garg");
		emp.setMobileNo("7895764776");
		emp.setEmail("kaushi.garg7996007@gmail.com");
		return emp;

	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@RequestParam("fname") String firstName, @RequestParam("lname") String lastName,
			@RequestParam("mobno") String mobileNo, @RequestParam("email") String email) {
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setMobileNo(mobileNo);
		emp.setEmail(email);
		return "Employee added Successfully";
	}
}
