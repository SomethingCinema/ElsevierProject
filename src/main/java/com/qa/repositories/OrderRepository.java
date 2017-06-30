package com.qa.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.qa.models.Address;
import com.qa.models.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

//	@Modifying
//	@Transactional
//	@Query("UPDATE Order o set o.order_id = :order_id,o.customer_id = :customer_id,o.items_ordered = :items_ordered")
//	public int updateOrder(
//			@Param("order_id") int order_id,
//			@Param("customer_id") int customer_id,
//			@Param("items_ordered") String items_ordered
//			);
//	
//	@Query("SELECT o from Order_history o WHERE o.customer_id = :customer_id")
//	public Order findCustomerOrderHistory(@Param("customer_id") int customer_id);
}
