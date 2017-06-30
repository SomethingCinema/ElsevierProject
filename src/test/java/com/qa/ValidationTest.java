package com.qa;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.qa.controllers.Validate;

public class ValidationTest {
	
	//private Customer customer;

//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}

	@Test
	public void validateLoginEmailEmptyTest() {
		String email = "";
		String password = "";
		String result = Validate.validateLogin(email, password);
		assertThat(result, is("Please enter an email"));
	}

}
