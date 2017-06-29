package com.qa;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.models.Address;
import com.qa.services.AddressService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTest {
	private Address address;
	
	@Autowired 
	private AddressService addressService;
	
	@Before
	public void setUp() throws Exception{

		address = new Address();
		System.out.println("Setup method is called");
	}

	
	@After
	public void tearDown() throws Exception{
		System.out.println("Tear down method is called");
	}
	
	@Test
	public void setAddressTypeTest(){
		address.setAddressType("shipping");
		assertThat(address.getAddressType(),is("shipping"));
	}
	
	@Test
	public void setAddressIdTest(){
		address.setAddressId(1003);
		assertThat(address.getAddressId(), is("1003"));
		
	}
	
	@Test
	public void setAddressLine1Test(){
		address.setAddressLine1("194 Mountainside Road");
		assertThat(address.getAddressLine1(), is("194 Mountainside Road"));
	}
	
	@Test
	public void setAddressLine2Test(){
		address.setAddressLine2("Unit 411B");
		assertThat(address.getAddressLine2(), is("Unit 411B"));
	}
	
	@Test
	public void setCityTest(){	
		address.setCity("Philadelphia");
		assertThat(address.getCity(), is("Philadelphia"));
	}
	
	@Test
	public void setPostCodeTest(){
		address.setPostcode("07945");
		assertThat(address.getPostcode(),is("07945"));
	}

	@Test
	public void setStateTest(){
		address.setState("New Jersey");
		assertThat(address.getState(), is("New Jersey"));
	}
	
	@Test
	public void setCountryTest(){
		address.setCountry("United States");
		assertThat(address.getCountry(),is("United States"));
	}
	
	@Test
	public void setPhoneNumberTest(){
		address.setPhoneNumber("2019102349");
		assertThat(address.getPhoneNumber(),is("2019102349"));
	}
	
	@Test
	public void updateBillingAddressTest(){
		int actualResult = addressService.updateBillingAddress("225 South 18th Street", "Unit 411B", "Philadelphia", "19103", "Pennsylvania", "USA", "2019102349", 101, "billing");
		assertThat(actualResult,is(1));
	}
	
	@Test
	public void findAddressByTypeTest(){
	
		address.setAddressType("shipping");
		address.setCustomerId(3);
		
		Address test = new Address();
		test = addressService.findAddressByType(3, "shipping");
		assertEquals(address.getCustomerId(),test.getCustomerId());
	}
}