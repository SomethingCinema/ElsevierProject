package com.qa.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Order {
	
	@Id
	@GeneratedValue
	private int orderId;
	
	private String itemsOrdered;
	
	
	@ManyToOne
	private Customer customer;


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getItemsOrdered() {
		return itemsOrdered;
	}


	public void setItemsOrdered(String itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}


	public Customer getCustome() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", itemsOrdered="
				+ itemsOrdered + ", custome=" + customer + "]";
	}
	
	

//	public int getOrder_id() {
//		return order_id;
//	}
//
//	public void setOrder_id(int order_id) {
//		this.order_id = order_id;
//	}
//
//	public String getItems_ordered() {
//		return items_ordered;
//	}
//
//	public void setItems_ordered(String items_ordered) {
//		this.items_ordered = items_ordered;
//	}
//
//	public int getCustomer_id() {
//		return customer_id;
//	}
//
//	public void setCustomer_id(int customer_id) {
//		this.customer_id = customer_id;
//	}
//
//	@Override
//	public String toString() {
//		return "Order [order_id=" + order_id + ", items_ordered="
//				+ items_ordered + ", customer_id=" + customer_id + "]";
//	}

}
