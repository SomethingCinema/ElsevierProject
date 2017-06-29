package com.qa.controllers;

import java.util.ArrayList;

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

@Controller
@SessionAttributes(names={"logged_in_customer"})
public class SearchController {

	@Autowired
	private BookService bookService;
	
	@ModelAttribute("logged_in_customer")
	public Customer c() {
		return new Customer();
	}

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam("search") String searchTerm,
			@RequestParam("type") String type,
			@ModelAttribute("logged_in_customer") Customer c) {
//		System.out.println("Searching!");
		
		// check if user is logged in, so that only logged in users can search by author or isbn
		Iterable<Book> results = new ArrayList<Book>();
		boolean loggedIn = false;
		// check if user is logged in
		if(c != null && c.getFirstName() != null){
			loggedIn = true;
		}
		
		String msg = "";
		
		switch(type){
			
		case "title": 
			results = bookService.findBookByTitle(searchTerm);
			
			break;
		case "author":
			if(loggedIn){
				results = bookService.findBookByAuthor(searchTerm);
			}
			else{
				msg = "Please log in or register to search by author";
			}
			break;
		case "isbn":
			if(loggedIn){
				results = bookService.findBookByISBN(searchTerm);
			}
			else{
				msg = "Please log in or register to search by ISBN";
			}
			break;
		default:
			msg = "Invalid search, please try searching again";
			break;
		}
		
		ModelAndView modelAndView = new ModelAndView("search_results");
		modelAndView.addObject("results", results);
		modelAndView.addObject("alert", msg);
		return modelAndView;
		
	}
}