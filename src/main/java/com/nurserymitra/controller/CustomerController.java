package com.nurserymitra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nurserymitra.Entity.Customers;
import com.nurserymitra.Services.CustomerService;

@Controller
public class CustomerController 
{
	@Autowired
	CustomerService c1;
	
	@GetMapping("/customers")
	public String customerPage(Model m)
	{
		m.addAttribute("customer",new Customers());
		return "customers";
	}
	@GetMapping("/customers/view")
	public String ViewCustomersPage(Model m)
	{
		List<Customers> list=c1.getAllCustomers();
		m.addAttribute("customer",list);
		return "view-customers";
	}
	@GetMapping("/customers/notify")
	public String notifyCustomers(Model m)
	{
		List<Customers> list=c1.getAllCustomers();
		m.addAttribute("customer",list);
		return "notifyCustomers";
	}
	@PostMapping("/customers")
	public String customerForm(@ModelAttribute("customer") Customers cust)
	{
		c1.saveData(cust);
		return "redirect:/customeralert";
	}
	@GetMapping("/customeralert")
	public String alertBox()
	{
		return "customeralert";
	}
	
}
