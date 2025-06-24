package com.nurserymitra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nurserymitra.Entity.Staff;
import com.nurserymitra.Services.StaffService;

@Controller
public class StaffController 
{
	@Autowired
	StaffService s1;
	
	@GetMapping("/staff")
	public String staffPage(Model m)
	{
		m.addAttribute("staff", new Staff());
		return "staff";
	}
	@GetMapping("/staff/view-staff")
	public String viewStaffPage(Model m)
	{
		List<Staff> list=s1.getAllStaff();
		m.addAttribute("staffList",list);
		return "view-staff";
	}
	@PostMapping("/staff")
	public String staffForm(@ModelAttribute("staff") Staff s)
	{
		s1.saveStaff(s);
		return "redirect:/staffAlert";
	}
	@GetMapping("/staffAlert")
	public String staffAlert()
	{
		return "staffAlert";
	}
}
