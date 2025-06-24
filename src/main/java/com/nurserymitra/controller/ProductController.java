package com.nurserymitra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nurserymitra.Entity.Product;
import com.nurserymitra.Services.ProductService;

@Controller
public class ProductController 
{
	@Autowired
	ProductService p1;
	
	@GetMapping("/products")
	public String ProductPage(Model m)
	{
		m.addAttribute("product",new Product());
		return "products";
	}
	@GetMapping("/products/view-product")
	public String viewProductPage(Model m)
	{
		List<Product> list=p1.getAllProducts();
		m.addAttribute("products",list);
		return "view-product";
	}
	@PostMapping("/products")
	public String ProductForm(@ModelAttribute("product")Product p)
	{
		p1.saveProducts(p);
		return "redirect:/productAlert";
	}
	@GetMapping("/productAlert")
	public String productAlert()
	{
		return "productAlert";
	}
	@PostMapping("/orders/delete/{id}")
	public String deleteProductOrder(@PathVariable("id") int id)
	{
		p1.deleteProdByID(id);
		return "redirect:/products/view-product";
	}
//	@PostMapping("/products/update")
//	public String updateProduct(@PathVariable("id") int id,@ModelAttribute("product") Product product,Model m)
//	{
//		Product p=p1.getProductByID(id);
//	}
}
