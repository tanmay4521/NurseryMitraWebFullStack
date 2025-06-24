package com.nurserymitra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nurserymitra.Entity.Bill;
import com.nurserymitra.Services.BillService;

@Controller
public class BillController 
{
	@Autowired
	BillService b1;
	
	@GetMapping("/bills")
	public String showCreateBillForm(Model model) {
	    model.addAttribute("bill", new Bill());
	    return "bills";
	}
	@GetMapping("/bills/view-bills")
	public String viewBillPage(Model m)
	{
		List<Bill> list=b1.getAllBills();
		m.addAttribute("bills",list);
		return "view-bills";
	}
	@PostMapping("/bills")
	public String billForm(@ModelAttribute("bill") Bill bill)
	{
		b1.generateBills(bill);
		return "redirect:/billAlert";
	}
	@GetMapping("/billAlert")
	public String billAlert()
	{
		return "billAlert";
	}
}
