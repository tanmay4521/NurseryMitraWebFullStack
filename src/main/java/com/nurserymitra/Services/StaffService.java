package com.nurserymitra.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurserymitra.Entity.Staff;
import com.nurserymitra.Repository.StaffRepository;

@Service
public class StaffService 
{
	@Autowired
	StaffRepository s1;

	public void saveStaff(Staff s) 
	{
		s1.save(s);
	}
	public List<Staff> getAllStaff()
	{
		return s1.findAll();
	}
	public Staff getStaffById(int id) {
		return s1.findById(id).orElse(null);
	}
}
