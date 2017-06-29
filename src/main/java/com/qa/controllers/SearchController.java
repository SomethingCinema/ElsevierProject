package com.qa.controllers;

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
	public ModelAndView search(@RequestParam String search) {
//		System.out.println("Searching!");
		Iterable<Book> results = bookService.findBookByTitle(search);
		return new ModelAndView("search_results", "results", results);
	}
}