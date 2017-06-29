package com.qa.controllers;

import java.util.Map;

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

		String msg = Validate.validateShipping(shipping);
		if (msg.isEmpty()) { // all fields are good
			System.out.println("First name " + shipping.getFirstName());
			ModelAndView modelAndView = new ModelAndView("payment_form", "order_total", orderTotal);
			modelAndView.addObject("shipping_address", shipping);
			modelAndView.addObject("order_total", orderTotal);
			modelAndView.addObject("book_counts", bookCounts);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("checkout", "alert", msg);
			modelAndView.addObject("shipping_address", shipping);
			modelAndView.addObject("order_total", orderTotal);
			modelAndView.addObject("book_counts", bookCounts);
			return modelAndView;
		}
	}

	

	@RequestMapping("/loginThroughCheckout")
	public ModelAndView loginThroughCheckout(@ModelAttribute("book_counts") Map<Integer, Integer> bookCounts,
			@RequestParam("order_total") double orderTotal, @RequestParam("email") String email,
			@RequestParam("password") String password) {


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
