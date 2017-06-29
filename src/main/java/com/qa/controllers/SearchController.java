package com.qa.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qa.models.Book;
import com.qa.services.BookService;

@Controller
public class SearchController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam("search") String searchTerm,
			@RequestParam("type") String type) {
//		System.out.println("Searching!");
		Iterable<Book> results = new ArrayList<Book>();
		switch(type){
			
		case "title": 
			results = bookService.findBookByTitle(searchTerm);
			break;
		case "author":
			results = bookService.findBookByAuthor(searchTerm);
			break;
		case "isbn":
//			results = bookService.findBookByISBN(searchTerm);
			break;
		default:
			//scold ppl messing with the code :)
			//also check if user is logged in, so that only logged in users can search by author or isbn
			break;
			
		}
		return new ModelAndView("search_results", "results", results);
	}
}