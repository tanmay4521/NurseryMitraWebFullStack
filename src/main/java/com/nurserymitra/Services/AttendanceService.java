package com.nurserymitra.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurserymitra.Entity.Attendance;
import com.nurserymitra.Repository.AttendanceRepository;

@Service
public class AttendanceService 
{
	@Autowired
	AttendanceRepository a1;

	public void saveAttendance(Attendance a) 
	{
		a1.save(a);
	}


}
