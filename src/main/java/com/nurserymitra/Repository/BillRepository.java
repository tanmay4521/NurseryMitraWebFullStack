package com.nurserymitra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurserymitra.Entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{

}
