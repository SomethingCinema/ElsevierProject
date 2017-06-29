package com.qa.controllers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.qa.models.Address;
import com.qa.models.Book;
import com.qa.models.Customer;
import com.qa.services.BookService;
import com.qa.services.CustomerService;

@Controller
@SessionAttributes(names = { "books", "cart_items", "logged_in_customer", "address" })
public class HomeController {

	@Autowired
	BookService bookService;

	@Autowired
	CustomerService customerService;

	// Initialize default object here so that
	// there are no null pointer exceptions
	// when pressing back -> form resubmission
	// and so that the objects can persist across the session
	@ModelAttribute("logged_in_customer")
	public Customer c() {
		return new Customer();
	}

	@ModelAttribute("books")
	public Iterable<Book> books() {
		return new ArrayList<Book>();
	}

	@ModelAttribute("cart_items")
	public ArrayList<Book> cart_items() {
		return new ArrayList<Book>();
	}

	@ModelAttribute("address")
	public Address address() {
		return new Address();
	}

	@RequestMapping("/")
	public ModelAndView indexPage(HttpServletRequest request) {

		ArrayList<Book> cartItems = null;

		HttpSession session = request.getSession();

		Object items = session.getAttribute("cart_items");

		if (items != null) {
			cartItems = (ArrayList<Book>) items;
		} else {
			cartItems = new ArrayList<Book>();
		}

		Iterable<Book> books = bookService.getAllBooks();

		ModelAndView modelAndView = new ModelAndView("index", "books", books);

		modelAndView.addObject("cart_items", cartItems);
		return modelAndView;

	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");

		return modelAndView;
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("register");

		return modelAndView;
	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView("logout");

		return modelAndView;
	}
	
	@RequestMapping("/registered_user_agreement")
	public ModelAndView template() {
		ModelAndView modelAndView = new ModelAndView("registered_user_agreement");

		return modelAndView;
	}

	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView modelAndView = new ModelAndView("contact");

		return modelAndView;
	}

	@RequestMapping("/about_us")
	public ModelAndView aboutus() {
		ModelAndView modelAndView = new ModelAndView("about_us");

		return modelAndView;
	}

	@RequestMapping("/registerProcess")
	public ModelAndView registerProcess(@ModelAttribute("Customer") Customer customer,
			@RequestParam(value = "agreement", required = false) String agreement) {

		// ModelAndView modelAndView = null;

		// System.out.println("Customer Firstname is " +
		// customer.getFirstName());

		// System.out.println("Customer Password is " + customer.getPassword());

		String msg = Validate.validateRegistration(customer, agreement);
		if (!msg.isEmpty()) {
			return new ModelAndView("register", "alert", msg);
		}

		// if checks are all good, then try to add to database
		Customer c = customerService.add(customer);

		if (c != null) {
			return new ModelAndView("registration_success");
		} 
		else {
			msg = "Registration failed - email taken";
			return new ModelAndView("register", "alert", msg);
		}

		// return modelAndView;
	}

	

	@RequestMapping("/loginProcess")
	public ModelAndView loginProcess(@RequestParam("email") String email, @RequestParam("password") String password) {

		// ModelAndView modelAndView = null;

		// System.out.println("Email is " + email);
		//
		// System.out.println("Password is " + password);
		//
		String msg = Validate.validateLogin(email, password);
		if (!msg.isEmpty()) {
			return new ModelAndView("login", "alert", msg);
			// alert is a request object since its not defined in
			// @SessionAttributes
		}

		Customer c = customerService.loginProcess(email, password);

		if (c != null) {
			System.out.println(c);
			return new ModelAndView("customer_home", "logged_in_customer", c);
		} else {
			msg = "Login failed";
			return new ModelAndView("login", "alert", msg);
		}

		// return modelAndView;
	}

	

	@RequestMapping("/profile")
	public ModelAndView profile(@ModelAttribute("logged_in_customer") Customer loggedInCustomer) {
		ModelAndView modelAndView = new ModelAndView("profile", "logged_in_customer", loggedInCustomer);

		return modelAndView;
	}

	@RequestMapping("/updateProfile")
	public ModelAndView updateProfile(@ModelAttribute("logged_in_customer") Customer loggedInCustomer,
			@ModelAttribute("Customer") Customer customer) {

		ModelAndView modelAndView = null;

		System.out.println("Before update ");

		System.out.println("ID " + loggedInCustomer.getCustomerId());
		System.out.println("Name" + loggedInCustomer.getFirstName());
		System.out.println("Email" + loggedInCustomer.getEmail());

		int recordsUpdated = customerService.updateCustomer(loggedInCustomer.getFirstName(),
				loggedInCustomer.getLastName(), loggedInCustomer.getEmail(), loggedInCustomer.getCustomerId());

		if (recordsUpdated > 0) {
			Customer c = customerService.findOne(loggedInCustomer.getCustomerId());

			System.out.println("After update ");

			System.out.println("ID " + c.getCustomerId());
			System.out.println("Name" + c.getFirstName());
			System.out.println("Email" + c.getEmail());

			modelAndView = new ModelAndView("profile", "logged_in_customer", c);
		} else {
			modelAndView = new ModelAndView("profile", "logged_in_customer", loggedInCustomer);
		}

		return modelAndView;
	}

	@RequestMapping("/addressBook")
	public ModelAndView addressBook(@ModelAttribute("logged_in_customer") Customer loggedInCustomer) {
		ModelAndView modelAndView = new ModelAndView("address_book", "logged_in_customer", loggedInCustomer);

		return modelAndView;
	}

	@RequestMapping("/changePassword")
	public ModelAndView changePassword(@ModelAttribute("logged_in_customer") Customer loggedInCustomer) {
		ModelAndView modelAndView = new ModelAndView("password_change", "logged_in_customer", loggedInCustomer);

		return modelAndView;
	}

	@RequestMapping("/updatePassword")
	public ModelAndView updatePassword(@ModelAttribute("logged_in_customer") Customer loggedInCustomer,
			@ModelAttribute("Customer") Customer customer) {

		ModelAndView modelAndView = null;

		int recordsUpdated = customerService.updatePassword(loggedInCustomer.getPassword(),
				loggedInCustomer.getCustomerId());

		if (recordsUpdated > 0) {
			Customer c = customerService.findOne(loggedInCustomer.getCustomerId());

			System.out.println("Password" + c.getPassword());

			modelAndView = new ModelAndView("password_change", "logged_in_customer", c);
		} 
		else {
			modelAndView = new ModelAndView("password_change", "logged_in_customer", loggedInCustomer);
		}

		return modelAndView;
	}

	@RequestMapping(value = "errors", method = RequestMethod.GET)
	public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

		ModelAndView errorPage = new ModelAndView("errorPage");
		String errorMsg = "";
		int httpErrorCode = getErrorCode(httpRequest);

		switch (httpErrorCode) {
		case 400: {
			errorMsg = "Http Error Code: 400. Bad Request";
			break;
		}
		case 401: {
			errorMsg = "Http Error Code: 401. Unauthorized";
			break;
		}
		case 404: {
			errorMsg = "Http Error Code: 404. Resource not found";
			break;
		}
		case 500: {
			errorMsg = "Http Error Code: 500. Internal Server Error";
			break;
		}
		}
		errorPage.addObject("errorMsg", errorMsg);
		return errorPage;
	}

	private int getErrorCode(HttpServletRequest httpRequest) {
		return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
	}

}
