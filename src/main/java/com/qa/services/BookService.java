package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.models.Book;
import com.qa.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	
	
	public Iterable<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	public Iterable<Book> findBookByTitle(String title){
		return bookRepository.findBookByTitle(title);
	}
	public Iterable<Book> findBookByAuthor(String author){
		return bookRepository.findBookByAuthor(author);
	}
	public Iterable<Book> findBookByISBN(String isbn){
		return bookRepository.findBookByISBN(isbn);
	}
	public Book addBook(Book book) {
		
		return bookRepository.save(book);		
		
	}
	
	public void removeBook(Book book) {
		 bookRepository.delete(book);
	}
	
	public Book bookFind(int id) {
		return bookRepository.findOne(id);
	}
} 