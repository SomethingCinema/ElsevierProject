package com.qa.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.qa.models.Customer;
@SessionAttributes(names={"book_counts","logged_in_customer"})
@Controller
public class CartController {
	
	@ModelAttribute("book_counts") 
	public Map<Integer,Integer> book_counts(){
		return null;
	}
	@ModelAttribute("logged_in_customer")
	public Customer c() {
		return new Customer();
	}
	

	@RequestMapping("/updatePrice")
	public ModelAndView bookDetails(@RequestParam("price") double price,
			@RequestParam("quantity") int quantity)
	{
		double totalPrice = price * quantity;
		
		System.out.println("Total price is "+price);
		ModelAndView modelAndView = new ModelAndView("return_price","total_price",totalPrice);
		
		return modelAndView;
		
	}
	
	
	
	@RequestMapping("/checkout")
	public ModelAndView checkoutForm(@ModelAttribute("book_counts") Map<Integer,Integer> bookCounts,
			@RequestParam("order_total") double orderTotal,
			@ModelAttribute("logged_in_customer") Customer c)
	{
		
		ModelAndView modelAndView = null;
		System.out.println("Checking out, customer is: ");
		System.out.println(c);
		System.out.println(c.getFirstName());
		// if user is logged in
		if(c.getFirstName()!=null){
			modelAndView = new ModelAndView("checkout","order_total",orderTotal);
			modelAndView.addObject("book_counts", bookCounts);
		}
		else{ // show login page
			modelAndView = new ModelAndView("login_through_checkout","order_total",orderTotal);
			modelAndView.addObject("book_counts", bookCounts);
		}
		
		return modelAndView;
	}
	
	
	
	
	
}
