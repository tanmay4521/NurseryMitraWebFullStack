package com.nurserymitra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurserymitra.Entity.Attendance;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> 
{
    List<Attendance> findByStaffId(int staffId);
}
