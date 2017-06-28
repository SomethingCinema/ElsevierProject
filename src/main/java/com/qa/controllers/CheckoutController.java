package com.qa.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.qa.models.Customer;
import com.qa.models.Shipping;
import com.qa.services.CustomerService;

@SessionAttributes(names = { "book_counts" })
@Controller
public class CheckoutController {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/completePayment")
	public ModelAndView completePayment() {
		return new ModelAndView("order_complete");
	}

	@RequestMapping("/checkoutProcess")
	public ModelAndView checkoutProcess(@ModelAttribute("Shipping") Shipping shipping,
			@ModelAttribute("book_counts") Map<Integer, Integer> bookCounts,
			@RequestParam("order_total") double orderTotal) {

		String msg = validateShipping(shipping);
		if (msg.isEmpty()) { // all fields are good
			System.out.println("First name " + shipping.getFirstName());
			ModelAndView modelAndView = new ModelAndView("payment_form", "order_total", orderTotal);
			modelAndView.addObject("shipping_address", shipping);
			modelAndView.addObject("order_total", orderTotal);
			modelAndView.addObject("book_counts", bookCounts);
			return modelAndView;
		} else {
			return null;
		}
	}

	public String validateShipping(Shipping address) {
		String msg = "";

		// Pattern namePattern =

		Pattern addressPattern = Pattern.compile("[a-zA-Z0-9.]+");
		Matcher addressMatcher1 = addressPattern.matcher(address.getAddressLine1());
		Matcher addressMatcher2 = addressPattern.matcher(address.getAddressLine2());
		if (!addressMatcher1.matches() || !addressMatcher2.matches()) {
			msg += "Please enter a valid address\n";
		}

		Pattern cityPattern = Pattern.compile("[a-zA-Z]+");
		Matcher cityMatcher = cityPattern.matcher(address.getCity());
		Matcher stateMatcher = cityPattern.matcher(address.getState());
		Matcher countryMatcher = cityPattern.matcher(address.getCountry());
		if (!cityMatcher.matches()) {
			msg += "Please enter a valid city\n";
		} else if (!stateMatcher.matches()) {
			msg += "Please enter a valid state\n";
		} else if (!countryMatcher.matches()) {
			msg += "Please enter a valid country\n";
		}

		Pattern zipPattern = Pattern.compile("(\\d{5}([-]\\d{4})?)");
		Matcher zipMatcher = zipPattern.matcher(address.getPostcode());
		if (!zipMatcher.matches()) {
			msg += "Please enter a valid zipcode\n";
		}

		Pattern phonePattern = Pattern.compile("\\d{3}[-]\\d{3}[-]\\d{4}");
		Matcher phoneMatcher = phonePattern.matcher(address.getPostcode());
		if (!phoneMatcher.matches()) {
			msg += "Please enter a valid phone number\n";
		}
		return msg;
	}

	@RequestMapping("/loginThroughCheckout")
	public ModelAndView loginThroughCheckout(@ModelAttribute("book_counts") Map<Integer, Integer> bookCounts,
			@RequestParam("order_total") double orderTotal, @RequestParam("email") String email,
			@RequestParam("password") String password) {

		// ModelAndView modelAndView = new
		// ModelAndView("login_through_checkout");
		//
		// modelAndView.addObject("order_total", orderTotal);
		// modelAndView.addObject("book_counts", bookCounts);
		// return modelAndView;

		System.out.println("Email is " + email);

		System.out.println("Password is " + password);

		String msg = Validate.validateLogin(email, password);
		if (!msg.isEmpty()) {
			return new ModelAndView("login_through_checkout", "alertLogin", msg);
		}

		Customer c = customerService.loginProcess(email, password);

		if (c != null) { // Logged in successfully - goto checkout page to enter
							// address
			// System.out.println("Success");

			ModelAndView modelAndView = new ModelAndView("checkout", "logged_in_customer", c);
			modelAndView.addObject("order_total", orderTotal);
			modelAndView.addObject("book_counts", bookCounts);
			return modelAndView;
		} else {
			// System.out.println("Failure");
			// modelAndView = new ModelAndView("login_failed");

			msg = "Login failed";
			return new ModelAndView("login_through_checkout", "alertLogin", msg);
		}
	}

	@RequestMapping("/registerThroughCheckout")
	public ModelAndView registerThroughCheckout(@ModelAttribute("Customer") Customer customer,
			@RequestParam(value = "agreement", required = false) String agreement,
			@ModelAttribute("book_counts") Map<Integer, Integer> bookCounts,
			@RequestParam("order_total") double orderTotal) {

		// ModelAndView modelAndView = null;

		// System.out.println("Customer Firstname is " +
		// customer.getFirstName());

		// System.out.println("Customer Password is " + customer.getPassword());

		String msg = Validate.validateRegistration(customer, agreement);
		if (!msg.isEmpty()) {
			return new ModelAndView("login_through_checkout", "alertRegister", msg);
		}
		

		// if checks are all good, then try to add to database
		Customer c = customerService.add(customer);

		if (c != null) { // registration successful, redirect to checkout page
			msg = "Thanks for registering!";
			ModelAndView modelAndView = new ModelAndView("checkout", "alert", msg);
			modelAndView.addObject("logged_in_customer", c);
			modelAndView.addObject("order_total", orderTotal);
			modelAndView.addObject("book_counts", bookCounts);
			return modelAndView;
		} else {
			msg = "Registration failed - email taken";
			return new ModelAndView("login_through_checkout", "alertRegister", msg);
		}
	}
}
