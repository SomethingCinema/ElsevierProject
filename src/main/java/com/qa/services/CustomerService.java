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

	public void delete(int id) {
		customerRepository.delete(id);
	}

	public Customer add(Customer c) {
		Iterable<Customer> allCustomers = customerRepository.findAll();

		for (Customer current : allCustomers) {
			if (current.getEmail().equalsIgnoreCase(c.getEmail())) {
				return null; // email already exists
			}
		}
		return customerRepository.save(c);

	}

	public Customer loginProcess(String email, String password) {
		return customerRepository.loginProcess(email, password);
	}

	public int updateCustomer(String firstName, String lastName, String email, int customerId) {
		return customerRepository.updateCustomer(firstName, lastName, email, customerId);
	}

	public int updatePassword(String password, int customerId) {
		return customerRepository.updatePassword(password, customerId);
	}

	public Customer findOne(int customerId) {
		return customerRepository.findOne(customerId);
	}

}