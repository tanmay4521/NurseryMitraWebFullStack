package com.nurserymitra.Services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurserymitra.Entity.DeliveredOrder;
import com.nurserymitra.Entity.Orders;
import com.nurserymitra.Repository.DeliveredOrderRepository;
import com.nurserymitra.Repository.OrdersRepository;

@Service
public class DeliveredOrderService 
{
	@Autowired
	DeliveredOrderRepository d1;
	
	@Autowired
	OrdersRepository o1;
	
	public boolean markOrderAsDelivered(Integer orderId, String paymentMethod) {
        Optional<Orders> optionalOrder = o1.findById(orderId);

        if (optionalOrder.isPresent()) {
            Orders order = optionalOrder.get();

            DeliveredOrder deliveredOrder = new DeliveredOrder();
            deliveredOrder.setCust_name(order.getOrder_cust_name());
            deliveredOrder.setCust_mobno(order.getOrder_cust_mobno());
            deliveredOrder.setProduct(order.getOrder_productname());
            deliveredOrder.setTotalPayment(order.getTotalpayment());
            deliveredOrder.setAmount(order.getRemainingPayment());
            deliveredOrder.setPaymentMethod(paymentMethod);
            deliveredOrder.setDeliveryDate(LocalDate.now());

            d1.save(deliveredOrder);
            o1.delete(order);

            return true;
        }

        return false;
    } 
}
