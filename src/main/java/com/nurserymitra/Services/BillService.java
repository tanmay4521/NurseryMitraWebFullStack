package com.nurserymitra.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurserymitra.Entity.Bill;
import com.nurserymitra.Repository.BillRepository;
import java.util.List;

@Service
public class BillService 
{
	@Autowired
	BillRepository b1;

	public void generateBills(Bill bill) 
	{
		b1.save(bill);
	}

	public List<Bill> getAllBills() 
	{
		return b1.findAll();
	}
}
