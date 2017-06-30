package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.models.Order;
import com.qa.repositories.OrderRepository;

@Service
public class OrderService {
	

		
		@Autowired
		private OrderRepository orderRepository;
		
		public Order findCustomerOrderHistory(int customerId) {
			Iterable<Order> allOrders = orderRepository.findAll();
			for(Order a: allOrders){
				if(a.getCustome().getCustomerId() == customerId){
					return a;
				}
			}
			return null;
		}
		
	}

