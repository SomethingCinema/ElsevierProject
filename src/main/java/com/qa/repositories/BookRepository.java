package com.qa.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qa.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{
	//use class name from book because of ORM (object relational mapping)
	// b.eBookisbn instead of b.e_bookisnb
	// each field is converted from camelcase into _
	
	@Query("SELECT b FROM Book b WHERE b.title = :title")
	public Iterable<Book> findBookByTitle(@Param("title") String title);
	
	@Query("SELECT b FROM Book b WHERE b.bookauthor = :author")
	public Iterable<Book> findBookByAuthor(@Param("author") String author);
	
	@Query("SELECT b FROM Book b WHERE b.eBookISBN = :isbn or b.paperISBN= :isbn")
	public Iterable<Book> findBookByISBN(@Param("isbn") String isbn);
}
