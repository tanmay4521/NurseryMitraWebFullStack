package com.nurserymitra.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nurserymitra.Entity.Attendance;
import com.nurserymitra.Entity.Staff;
import com.nurserymitra.Services.AttendanceService;
import com.nurserymitra.Services.StaffService;

@Controller
public class AttendanceController 
{	
	@Autowired
	AttendanceService a1;
	@Autowired
	StaffService s1;
	
	@GetMapping("/attendance")
	public String AttendancePage(Model m)
	{
		List<Staff> list=s1.getAllStaff();
		m.addAttribute("staffList",list);
		m.addAttribute("attendance", new Attendance());
		return "attendance";
		
	}
	@GetMapping("/attendance/view")
	public String ViewAttendancePage(Model m)
	{
		List<Staff> list=s1.getAllStaff();
		m.addAttribute("staffList",list);
		return "view-attendance";
	}
	@PostMapping("/attendance/add")
	public String attendanceForm(@ModelAttribute Attendance a)
	{
		a.setDate(String.valueOf(LocalDate.now()));
		a1.saveAttendance(a);
		return "redirect:/attendanceAlert";
	}
	@GetMapping("/attendanceAlert")
	public String attendanceAlert()
	{
		return "attendanceAlert";
	}
}
