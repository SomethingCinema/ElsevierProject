package com.qa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.models.Book;
import com.qa.services.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookServiceTest {
	
	private Book book;
	
	@Autowired
	private BookService bookservice;

	@Before
	public void setUp() throws Exception {
		book = new Book();
		book.setBookId(200);
		book.setTitle(" A Raisin in the Sun");
		book.setDescription("Raisins!");
		book.setPublisher(" Some Dude");
		book.setFormat("ebook");
		book.setPublishedDate("06/23/2017");
		book.setPageCount(350);
		book.setBookauthor("Some Author");
		book.setPrice(10.00);
		book.setPaperISBN("1234567");
		book.seteBookISBN("2737834989834");
		book.setTableOfContents("ToC");
		book.setBookImage("BookImage");
		
		System.out.println(book);	
		System.out.println("Setup method is called");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Tear down method is called");
	}
	
	
	@Test
	public void addIntoDB() {
		Book result = bookservice.addBook(book);
		assertNotNull(result);
		System.out.println("Test 1: Added into DB");
	}
	
	@Test
	public void bookByAuthorSearch() {
		
		assertNotNull(bookservice.findBookByAuthor("Some Author"));
		System.out.println("Test 2: Found Book by Author");		
	}
	
	@Test
	public void bookByISBNSearch() {
		
		assertNotNull(bookservice.findBookByISBN("2737834989834"));
		System.out.println("Test 3: Found Book by ISBN");
	}
	
	@Test
	public void bookByTitleSearch() {
		
		assertNotNull(bookservice.findBookByTitle(" A Raisin in the Sun"));
		System.out.println("Test 4: Found Book by Title:");
	}
	@Test
	public void deleteFromDB() {
		bookservice.removeBook(book);
		//bookservice.bookFind(book.getBookId());
		assertNull(bookservice.bookFind(book.getBookId()));
		System.out.println("Test 5: Deleted from DB");
	}
	
	/*@Test 
	public void findAllTest() {
		
	}*/
	

}
