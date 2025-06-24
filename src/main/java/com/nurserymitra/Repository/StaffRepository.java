package com.nurserymitra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurserymitra.Entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{

}
