package com.qa.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.models.Customer;
import com.qa.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer add(Customer c){
		Iterable<Customer> allCustomers = customerRepository.findAll();
		
		for(Customer current: allCustomers){
			if(current.getEmail().equalsIgnoreCase(c.getEmail())){
				return null; //email already exists
			}
		}
		return customerRepository.save(c);

	}
	
	public Customer loginProcess(String email,String password) {
//		Iterable<Customer> allCustomers = customerRepository.findAll();
//		
//		for(Customer c: allCustomers){
//			if(c.getEmail().equalsIgnoreCase(email) && c.getPassword().equals(password)){
//				return c;
//			}
//		}
//		return null;
		return customerRepository.loginProcess(email, password);
	}
	
	public int updateCustomer(String firstName,
			String lastName,
			String email,
			 int customerId){
		
//		Customer c = customerRepository.findOne(customerId);
//		
//		c.setFirstName(firstName);
//		c.setLastName(lastName);
//		c.setEmail(email);
//		
//		if(customerRepository.save(c) != null){ 
//			return 1;
//		}
//		else{
//			return 0;
//		}
		return customerRepository.updateCustomer(firstName, lastName, email, customerId);
	}
	
	public int updatePassword(String password, int customerId){
		
//		Customer c = customerRepository.findOne(customerId);
//		
//		c.setPassword(password);
//		
//		if(customerRepository.save(c) != null){ 
//			return 1;
//		}else{
//			return 0;
//		}
		return customerRepository.updatePassword(password, customerId);
	}
	
	public Customer findOne(int customerId){
		return customerRepository.findOne(customerId);
	}

}