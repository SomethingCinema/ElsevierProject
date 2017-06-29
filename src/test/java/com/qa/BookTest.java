package com.qa;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.models.Book;
import com.qa.models.Author;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTest {
	private Book book;
	private Author author1;
	private Author author2;
	private List<Author> authors;
	
	@Before
	public void setUp() throws Exception{
		book = new Book();
		//authors = new List<Author>();
		author1 = new Author();
		author2 = new Author();
		System.out.println("Setup method is called");
	}

	
	@After
	public void tearDown() throws Exception{
		System.out.println("Tear down method is called");
	}
	
	@Test
	public void setBookAuthorTest(){
		book.setBookauthor("Stephen King");
		assertThat(book.getBookauthor(), is("Stephen King"));
	}
	
	//@Test
	//public void setAuthorsTest(){
	//	authors.add
	//	book.setAuthors(authors);
	//}
	
	@Test
	public void setBookIdTest(){
		
		book.setBookId(1003);
		assertThat(book.getBookId(), is(1003));
	}
	
	@Test
	public void setBookTitleTest(){
		book.setTitle("Harry Potter");
		assertThat(book.getTitle(),is("Harry Potter"));
	}
	
	@Test
	public void setDescriptionTest(){
		book.setDescription("About an awesome boy wizard");
		assertThat(book.getDescription(),is("About an awesome boy wizard"));
	}
	
	@Test
	public void setPublisherTest(){
		book.setPublisher("Random House");
		assertThat(book.getPublisher(),is("Random House"));
	}
	
	@Test
	public void setFormatTest(){
		book.setFormat("print");
		assertThat(book.getFormat(), is("print"));
	}
	
	@Test
	public void setPublishedDateTest(){
		book.setPublishedDate("1994");
		assertThat(book.getPublishedDate(),is("1994"));
	}
	
	@Test
	public void setPageCountTest(){
		book.setPageCount(355);
		assertThat(book.getPageCount(),is(355));
	}
	
	@Test
	public void setPriceTest(){
		book.setPrice(19.99);
		assertThat(book.getPrice(),is(19.99));
	}
	
	
}
