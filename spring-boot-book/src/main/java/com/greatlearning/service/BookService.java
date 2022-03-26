package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Book;

public interface BookService {
	
	//CREATE
	 Book createBook(Book book);

	 //READ
	 List<Book> getBooks();
	 Book getBook(Long id);
	 List<Book> getBooks(String name);
	 List<Book> getBooks(String category, String author);
	 
	 //UPDATE
	 void updateBook(Long id, Book book);
	 
	 //DELETE
	 void deleteBook(Long id);

}
