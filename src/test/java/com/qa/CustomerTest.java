package com.qa;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.models.Customer;
import com.qa.services.CustomerService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {
	private Customer customer;
	private Customer customer2;
	
	@Autowired
	private CustomerService customerService;
	
	
	
	@Before
	public void setUp() throws Exception{
		customer = new Customer();
		customer.setFirstName("a");
		customer.setLastName("a");
//		customer.setCustomerId(20);
		customer.setEmail("a@gmail.com");
		customer.setPassword("aaa");
		
		customer2 = new Customer();
		customer2.setFirstName("Bobby");
		customer2.setLastName("Smith");
//		customer2.setCustomerId(4);
		customer2.setEmail("bob@gmail.com");
		customer2.setPassword("123");
		customer2 = customerService.add(customer2);
		
		System.out.println("Setup method is called");
	}

	
	@After
	public void tearDown() throws Exception{
		customerService.delete(customer2.getCustomerId());
		System.out.println("Tear down method is called");
	}
	
	
//	@Test
//	public void setCustomerIDTest(){
//		customer.setCustomerId(2);
//		assertThat(customer.getCustomerId(),is(2));
//	}
	
//	@Test
//	public void setCustomerFirstNameTest(){
//		customer.setFirstName("Grace");
//		assertThat(customer.getFirstName(),is("Grace"));
//	}
//	
//	@Test
//	public void setCustomerLastNameTest(){
//		customer.setLastName("Alfieri");
//		assertThat(customer.getLastName(),is("Alfieri"));
//		
//	}
//	
//	@Test 
//	public void setEmailTest(){
//		customer.setEmail("g.alfieri@gmail.com");
//		assertThat(customer.getEmail(), is("g.alfieri@gmail.com"));
//	}
//	
//	@Test
//	public void setPasswordTest(){
//		customer.setPassword("Alfieri4");
//		assertThat(customer.getPassword(),is("Alfieri4"));
//	}
//	
	@Test
	public void changePasswordServiceTest(){
		int result = customerService.updatePassword("Mendham22", customer2.getCustomerId());
		assertThat(result, is(1));
	}
	
	@Test
	public void updateCustomerServiceTest(){
		int result = customerService.updateCustomer("Grace", "Alfieri", "g@gmail.com" , customer2.getCustomerId());
		assertThat(result, is(1));
	}
	
	
	@Test
	public void loginCustomerServiceFailsTest(){
		//login in with wrong password
		Customer testCustomer = new Customer();
		testCustomer = customerService.loginProcess("bob@gmail.com", "122");
		assertNull(testCustomer);
	}
	
	@Test
	public void loginCustomerServiceTest(){
		Customer result = new Customer();
		result = customerService.loginProcess("bob@gmail.com", "123");
		assertNotNull(result);
	}
	
	@Test
	public void addCustomerServiceTest(){
		assertNotNull(customerService.add(customer));
	}
	
	
	
	
	

}
