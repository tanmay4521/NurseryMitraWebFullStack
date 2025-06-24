package com.nurserymitra.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurserymitra.Entity.Product;
import com.nurserymitra.Repository.ProductsRepository;

@Service
public class ProductService 
{
	@Autowired
	ProductsRepository p1;

	public void saveProducts(Product p) {
		p1.save(p);
	}
	
	public List<Product> getAllProducts()
	{
		return p1.findAll();
	}

    public void deleteProdByID(int id)
	{
		p1.deleteById(id);
    }

//	public Product getProductByID(int id)
//	{
//		return p1.findAllById(id);
//	}
}
