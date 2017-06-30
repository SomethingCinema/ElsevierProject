package com.qa;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.qa.controllers.Validate;
import com.qa.models.Address;
import com.qa.models.Customer;
import com.qa.models.Shipping;

public class ValidationTest {
	
	private Customer c;
	private Address addr;
	private Shipping ship;

	@Before
	public void setUp() throws Exception {
		c = new Customer();
		c.setCustomerId(20);
		c.setEmail("hello@gmail.com");
		c.setFirstName("First");
		c.setLastName("Last");
		c.setPassword("password");
		
		addr = new Address();
		addr.setAddressId(100);
		addr.setAddressLine1("1200 Market St");
		addr.setAddressLine2("Room 1001");
		addr.setAddressType("shipping");
		addr.setCity("Philadelphia");
		addr.setCountry("USA");
		addr.setCustomerId(120);
		addr.setPhoneNumber("111-111-2345");
		addr.setPostcode("10101");
		addr.setState("PA");
		
		
//		ship = new Shipping();
		
	}
//
//	@After
//	public void tearDown() throws Exception {
//	}

	@Test
	public void validateLoginEmailEmptyTest() {
		String email = "";
		String password = "password";
		String result = Validate.validateLogin(email, password);
		assertThat(result, is("Please enter an email"));
	}
	@Test
	public void validateLoginPasswordEmptyTest() {
		String email = "hello@gmail.com";
		String password = "";
		String result = Validate.validateLogin(email, password);
		assertThat(result, is("Please enter a password"));
	}
	@Test
	public void validateLoginEmailFailTest() {
		String email = "emailhere";
		String password = "password";
		String result = Validate.validateLogin(email, password);
		assertThat(result, is("Please enter a valid email"));
	}
	@Test
	public void validateLoginEmailSuccessTest() {
		String email = "hello@gmail.com";
		String password = "password";
		String result = Validate.validateLogin(email, password);
		assertThat(result, is(""));
	}
	
	@Test
	public void validateRegistrationFirstNameEmpty(){
		c.setFirstName("");
		String agreement = "agree";
		String result = Validate.validateRegistration(c, agreement);
		assertThat(result, is("Registration failed - please enter a first name"));
	}
	@Test
	public void validateRegistrationLastNameEmpty(){
		c.setLastName("");
		String agreement = "agree";
		String result = Validate.validateRegistration(c, agreement);
		assertThat(result, is("Registration failed - please enter a last name"));
	}
	@Test
	public void validateRegistrationEmailEmpty(){
		c.setEmail("");
		String agreement = "agree";
		String result = Validate.validateRegistration(c, agreement);
		assertThat(result, is("Registration failed - please enter an email"));
	}
	@Test
	public void validateRegistrationPasswordEmpty(){
		c.setPassword("");
		String agreement = "agree";
		String result = Validate.validateRegistration(c, agreement);
		assertThat(result, is("Registration failed - please enter a password"));
	}
	@Test
	public void validateRegistrationEmailFail(){
		c.setEmail("emailtest");
		String agreement = "agree";
		String result = Validate.validateRegistration(c, agreement);
		assertThat(result, is("Registration failed - please enter a valid email"));
	}
	@Test
	public void validateRegistrationFirstNameFail(){
		c.setFirstName("1111");
		String agreement = "agree";
		String result = Validate.validateRegistration(c, agreement);
		assertThat(result, is("Registration failed - please enter alphabetical characters for names"));
	}
	@Test
	public void validateRegistrationLastNameFail(){
		c.setLastName("1111");
		String agreement = "agree";
		String result = Validate.validateRegistration(c, agreement);
		assertThat(result, is("Registration failed - please enter alphabetical characters for names"));
	}
	@Test
	public void validateRegistrationAgreementNotChecked(){
		String agreement = null;
		String result = Validate.validateRegistration(c, agreement);
		assertThat(result, is("Registration failed - please check the User Agreement box"));
	}
	@Test
	public void validateRegistrationSuccess(){
		String agreement = "agree";
		String result = Validate.validateRegistration(c, agreement);
		assertThat(result, is(""));
	}
	
	
	@Test
	public void validateAddressLine1Fail(){
		addr.setAddressLine1("");
		String result = Validate.validateAddress(addr);
		assertThat(result, is("Please enter a valid address"));
	}
	@Test
	public void validateAddressLine2Fail(){
		addr.setAddressLine2("");
		String result = Validate.validateAddress(addr);
		assertThat(result, is("Please enter a valid address"));
	}
	@Test
	public void validateAddressCityFail(){
		addr.setCity("");
		String result = Validate.validateAddress(addr);
		assertThat(result, is("Please enter a valid city"));
	}
	@Test
	public void validateAddressStateFail(){
		addr.setState("");
		String result = Validate.validateAddress(addr);
		assertThat(result, is("Please enter a valid state"));
	}
	@Test
	public void validateAddressCountryFail(){
		addr.setCountry("");
		String result = Validate.validateAddress(addr);
		assertThat(result, is("Please enter a valid country"));
	}
	@Test
	public void validateAddressZipcodeFail(){
		addr.setPostcode("2222-1");
		String result = Validate.validateAddress(addr);
		assertThat(result, is("Please enter a valid zipcode"));
	}
	@Test
	public void validateAddressPhoneFail(){
		addr.setPhoneNumber("2343");
		String result = Validate.validateAddress(addr);
		assertThat(result, is("Please enter a valid phone number"));
	}
	
	@Test
	public void validateAddressZipcodeSuccess(){
		addr.setPostcode("22221-1234");
		String result = Validate.validateAddress(addr);
		assertThat(result, is(""));
	}
	@Test
	public void validateAddressSuccess(){
		String result = Validate.validateAddress(addr);
		assertThat(result, is(""));
	}


}
