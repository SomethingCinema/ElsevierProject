package com.qa.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.qa.models.Book;
import com.qa.models.Customer;
import com.qa.services.BookService;
import com.qa.services.CustomerService;

@Controller
@SessionAttributes(names = { "books", "cart_items", "logged_in_customer", "Address" })
public class HomeController {

	@Autowired
	BookService bookService;

	@Autowired
	CustomerService customerService;

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

	@RequestMapping("/contact")
	public ModelAndView contact()
	{
		ModelAndView modelAndView = new ModelAndView("contact");
	
	    return modelAndView;
	}
	
	@RequestMapping("/about_us")
	public ModelAndView aboutus()
	{
		ModelAndView modelAndView = new ModelAndView("about_us");
	
	    return modelAndView;
	}

	@RequestMapping("/registerProcess")
	public ModelAndView registerProcess(@ModelAttribute("Customer") Customer customer) {

//		ModelAndView modelAndView = null;

//		System.out.println("Customer Firstname is " + customer.getFirstName());

//		System.out.println("Customer Password is " + customer.getPassword());

		// Validate registration
		if (customer.getFirstName().isEmpty()) {
			String msg = "Registration failed - please enter a first name";
			return new ModelAndView("register", "alert", msg);
		} 
		else if(customer.getLastName().isEmpty()){
			String msg = "Registration failed - please enter a last name";
			return new ModelAndView("register", "alert", msg);
		}
		else if(customer.getEmail().isEmpty()){
			String msg = "Registration failed - please enter an email";
			return new ModelAndView("register", "alert", msg);
		}
		else if(customer.getPassword().isEmpty()){
			String msg = "Registration failed - please enter a password";
			return new ModelAndView("register", "alert", msg);
		}
		
		// Validate email
		Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
		Matcher emailMatcher = emailPattern.matcher(customer.getEmail());
		if (!emailMatcher.matches()) {
			String msg = "Registration failed - please enter a valid email";
			return new ModelAndView("register", "alert", msg);
		}
		// Validate names
		Pattern namePattern = Pattern.compile("[a-zA-Z]+");
		Matcher firstNameMatcher = namePattern.matcher(customer.getFirstName());
		Matcher lastNameMatcher = namePattern.matcher(customer.getLastName());
		if (!firstNameMatcher.matches() || !lastNameMatcher.matches()) {
			String msg = "Registration failed - please enter alphabetical characters for names";
			return new ModelAndView("register", "alert", msg);
		}
		
		// if checks are all good
		Customer c = customerService.add(customer);
		
		if (c != null) {
			return new ModelAndView("registration_success");
		} 
		else {
			String msg = "Registration failed - email taken";
			return new ModelAndView("register", "alert", msg);
		}

//		return modelAndView;
	}

	@RequestMapping("/loginProcess")
	public ModelAndView loginProcess(@RequestParam("email") String email, @RequestParam("password") String password) {

//		ModelAndView modelAndView = null;

		System.out.println("Email is " + email);

		System.out.println("Password is " + password);
		
		// Check if email or password fields are empty
		if (email.isEmpty()) {
			String msg = "Please enter an email";
			return new ModelAndView("login", "alert", msg);
		} 
		else if (password.isEmpty()) {
			String msg = "Please enter a password";
			return new ModelAndView("login", "alert", msg);
		} 

		// Validate email
		Pattern emailPattern = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
		Matcher emailMatcher = emailPattern.matcher(email.toUpperCase());
		if (!emailMatcher.matches()) {
			String msg = "Please enter a valid email";
			return new ModelAndView("login", "alert", msg); 
			// alert is a request object since its not defined in @SessionAttributes
		} 
		else {
			Customer c = customerService.loginProcess(email, password);

			if (c != null) {
				// System.out.println("Success");
				return new ModelAndView("customer_home", "logged_in_customer", c);
			} else {
				// System.out.println("Failure");
				// modelAndView = new ModelAndView("login_failed");

				String msg = "Login failed";
				return new ModelAndView("login", "alert", msg);
			}
		}

//		return modelAndView;
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
	
	@RequestMapping("/updatePassword")
	public ModelAndView updatePassword(@ModelAttribute("logged_in_customer") Customer loggedInCustomer){
		ModelAndView modelAndView = new ModelAndView("password_change", "logged_in_customer", loggedInCustomer);
		
		return modelAndView;
	}

}