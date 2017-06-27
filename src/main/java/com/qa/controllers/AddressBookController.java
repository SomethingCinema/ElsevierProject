package com.qa.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qa.models.Address;
import com.qa.models.Customer;
import com.qa.services.AddressService;

@Controller
public class AddressBookController {

	@Autowired
	private AddressService addressService;

	@RequestMapping("/updateAddress")
	public ModelAndView updateAddress(@ModelAttribute("logged_in_customer") Customer loggedInCustomer,
			@ModelAttribute("Address") Address address) {
		
		// Address validation
		
		Pattern addressPattern = Pattern.compile("[a-fA-F0-9.]+");
		Matcher addressMatcher1 = addressPattern.matcher(address.getAddressLine1());
		Matcher addressMatcher2 = addressPattern.matcher(address.getAddressLine2());
		if (!addressMatcher1.matches()|| !addressMatcher2.matches()) {
			String msg = "Please enter a valid address";
			return new ModelAndView("address_book", "alert", msg);
		}
		
		Pattern cityPattern = Pattern.compile("[a-zA-Z]+");
		Matcher cityMatcher = cityPattern.matcher(address.getCity());
		Matcher stateMatcher = cityPattern.matcher(address.getState());
		Matcher countryMatcher = cityPattern.matcher(address.getCountry());
		if (!cityMatcher.matches()) {
			String msg = "Please enter a valid city";
			return new ModelAndView("address_book", "alert", msg);
		}
		else if (!stateMatcher.matches()) {
			String msg = "Please enter a valid state";
			return new ModelAndView("address_book", "alert", msg);
		}
		else if (!countryMatcher.matches()) {
			String msg = "Please enter a valid country";
			return new ModelAndView("address_book", "alert", msg);
		}
		
		Pattern zipPattern = Pattern.compile("(\\d{5}([-]\\d{4})?)");
		Matcher zipMatcher = zipPattern.matcher(address.getPostcode());
		if (!zipMatcher.matches()) {
			String msg = "Please enter a valid zipcode";
			return new ModelAndView("address_book", "alert", msg);
		}
		
		Pattern phonePattern = Pattern.compile("\\d{3}[-]\\d{3}[-]\\d{4}");
		Matcher phoneMatcher = phonePattern.matcher(address.getPostcode());
		if (!phoneMatcher.matches()) {
			String msg = "Please enter a valid phone number";
			return new ModelAndView("address_book", "alert", msg);
		}
		
		
		
		// If all checks are good 
		ModelAndView modelAndView = null;

		Address billingAddress = null;
		Address shippingAddress = null;
		System.out.println("Before update ");

		System.out.println("ID " + loggedInCustomer.getCustomerId());
		System.out.println("Name" + loggedInCustomer.getFirstName());
		System.out.println("Email" + loggedInCustomer.getEmail());

		Address bAddress = addressService.findAddressByType(loggedInCustomer.getCustomerId(), "billing");

		Address sAddress = addressService.findAddressByType(loggedInCustomer.getCustomerId(), "shipping");

		if (bAddress != null || sAddress != null) {

			int recordsUpdated = addressService.updateBillingAddress(address.getAddressLine1(),
					address.getAddressLine2(), address.getCity(), address.getPostcode(), address.getState(),
					address.getCountry(), address.getPhoneNumber(), loggedInCustomer.getCustomerId(),
					address.getAddressType());

			if (recordsUpdated > 0) {
				billingAddress = addressService.findAddressByType(loggedInCustomer.getCustomerId(), "billing");
				shippingAddress = addressService.findAddressByType(loggedInCustomer.getCustomerId(), "shipping");

				System.out.println("After update ");
				modelAndView = new ModelAndView("address_book", "billing_address", billingAddress);
				modelAndView.addObject("shipping_address", shippingAddress);
			} else {
				modelAndView = new ModelAndView("address_book", "billing_address", billingAddress);
				modelAndView.addObject("shipping_address", shippingAddress);

			}

		} else {
			Address savedAddress = addressService.add(address);
			modelAndView = new ModelAndView("address_book", "billing_address", savedAddress);

		}
		return modelAndView;
	}

}