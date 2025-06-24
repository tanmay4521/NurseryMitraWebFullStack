package com.nurserymitra.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	private String order_cust_name;
	private long order_cust_mobno;
	private String order_productname;
	private int order_productprice;
	private int order_productqty;
	private int totalpayment;
	private int advpayment;
	private int remainingPayment;
	public int getRemainingPayment() {
		return remainingPayment;
	}
	public void setRemainingPayment(int remainingPayment) {
		this.remainingPayment = remainingPayment;
	}
	private String order_date;
	private String delivery_date;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_cust_name() {
		return order_cust_name;
	}
	public void setOrder_cust_name(String order_cust_name) {
		this.order_cust_name = order_cust_name;
	}
	public long getOrder_cust_mobno() {
		return order_cust_mobno;
	}
	public void setOrder_cust_mobno(long order_cust_mobno) {
		this.order_cust_mobno = order_cust_mobno;
	}
	public String getOrder_productname() {
		return order_productname;
	}
	public void setOrder_productname(String order_productname) {
		this.order_productname = order_productname;
	}
	public int getOrder_productprice() {
		return order_productprice;
	}
	public void setOrder_productprice(int order_productprice) {
		this.order_productprice = order_productprice;
	}
	public int getOrder_productqty() {
		return order_productqty;
	}
	public void setOrder_productqty(int order_productqty) {
		this.order_productqty = order_productqty;
	}
	public int getTotalpayment() {
		return totalpayment;
	}
	public void setTotalpayment(int totalpayment) {
		this.totalpayment = totalpayment;
	}
	public int getAdvpayment() {
		return advpayment;
	}
	public void setAdvpayment(int advpayment) {
		this.advpayment = advpayment;
	}
	
}
