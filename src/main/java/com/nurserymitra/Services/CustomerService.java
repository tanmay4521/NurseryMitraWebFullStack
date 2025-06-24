package com.nurserymitra.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurserymitra.Entity.Customers;
import com.nurserymitra.Repository.CustomersRepository;

@Service
public class CustomerService 
{
	@Autowired
	CustomersRepository c1;

	public void saveData(Customers cust) 
	{
		c1.save(cust);
	}

	public List<Customers> getAllCustomers() 
	{
		return c1.findAll();
	}
}
