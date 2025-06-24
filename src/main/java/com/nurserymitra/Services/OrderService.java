package com.nurserymitra.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurserymitra.Entity.DeliveredOrder;
import com.nurserymitra.Entity.Orders;
import com.nurserymitra.Repository.DeliveredOrderRepository;
import com.nurserymitra.Repository.OrdersRepository;

@Service
public class OrderService 
{
	@Autowired
	OrdersRepository o1;
	@Autowired
	DeliveredOrderRepository d1;

	public void saveOrders(Orders order) 
	{
		o1.save(order);
	}

	public List<Orders> getAllOrders() 
	{
		return o1.findAll();
	}
	public boolean markOrderAsDelivered(int orderId, String paymentMethod) {
	    Optional<Orders> optionalOrder = o1.findById(orderId);
	    if (optionalOrder.isPresent()) {
	        Orders order = optionalOrder.get();
	        DeliveredOrder deliveredOrder = new DeliveredOrder();
	        deliveredOrder.setCust_name(order.getOrder_cust_name());
	        deliveredOrder.setAmount(order.getRemainingPayment());
	        deliveredOrder.setPaymentMethod(paymentMethod);
	        deliveredOrder.setDeliveryDate(LocalDate.now());
	        d1.save(deliveredOrder);
	        o1.delete(order);
	        return true;
	    }
	    return false;
	}

	public List<DeliveredOrder> getDeliveredOrder() {
		return d1.findAll();
	}

}
