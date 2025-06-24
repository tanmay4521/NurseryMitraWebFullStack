package com.nurserymitra.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nurserymitra.Entity.DeliveredOrder;
import com.nurserymitra.Entity.Orders;
import com.nurserymitra.Services.DeliveredOrderService;
import com.nurserymitra.Services.OrderService;

@Controller
public class OrderController 
{
	@Autowired
	OrderService o1;
	@Autowired 
	DeliveredOrderService d1;
	
	@GetMapping("/orders")
    public String manageorderPage(Model m)
    {
		m.addAttribute("order",new Orders());
    	return "orders";
    }
    @GetMapping("/orders/view-orders")
    public String viewOrderPage(Model m)
    {
    	List<Orders> list=o1.getAllOrders();
    	m.addAttribute("orders",list);
    	return "view-order";
    }
    @GetMapping("/orders/delivered-orders")
    public String deliveredOrderPage(Model m)
    {
    	List<DeliveredOrder> deliveredOrders=o1.getDeliveredOrder();
    	m.addAttribute("deliveredOrders", deliveredOrders);
    	return "delivered-order";
    }
    
    @PostMapping("/orders")
    public String addOrdertoDB(@ModelAttribute("order") Orders order)
    {
    	int total = order.getOrder_productprice() * order.getOrder_productqty();
    	order.setTotalpayment(total);
    	o1.saveOrders(order);
    	return "redirect:/orderalert";
    }
    @GetMapping("/orderalert")
    public String OrderAlert()
    {
    	return "orderAlert";
    }
    @PostMapping("/orders/mark-delivered/{id}")
    @ResponseBody
    public ResponseEntity<String> markAsDelivered(
        @PathVariable int id,
        @RequestBody Map<String, String> body) {

        String paymentMethod = body.get("paymentMethod");

        boolean success = d1.markOrderAsDelivered(id, paymentMethod);

        if (success) {
            return ResponseEntity.ok("Order delivered");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        }
    }
}
