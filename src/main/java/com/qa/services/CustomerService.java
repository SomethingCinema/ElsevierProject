package com.qa.services;

import org.mindrot.jbcrypt.BCrypt;
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
		// Hash a password for the first time
		String hashed = BCrypt.hashpw(c.getPassword(), BCrypt.gensalt());
//		c.setPassword(hashed);
		
		return customerRepository.save(c);

	}

	public Customer loginProcess(String email, String password) {
		// Check that the unencypted password matches one that has
		// previously been hashed
		String hashedpw = customerRepository.getHashedPassword(email);
		if (BCrypt.checkpw(password, hashedpw)){
			System.out.println("Password matches!");
			return customerRepository.loginProcess(email, hashedpw);
		}
		else{
			System.out.println("Password does not match");
			return null;
		}
		
	}

	public int updateCustomer(String firstName, String lastName, String email, int customerId) {
		return customerRepository.updateCustomer(firstName, lastName, email, customerId);
	}

	public int updatePassword(String password, int customerId) {
		// Hash a password for the first time
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
		
		return customerRepository.updatePassword(hashed, customerId);
	}

	public Customer findOne(int customerId) {
		return customerRepository.findOne(customerId);
	}

}