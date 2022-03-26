package com.great.learning.service;

import java.util.List;

import com.great.learning.entity.Book;

public interface BookService {

	// Create + Read + Update + Delete => CRUD

	// Create
	void saveBook(Book myBook);

	// Read
	List<Book> getBooks();
	Book getBook(Long id);
	List<Book> getBookByAuthorAndName(String author, String name);

	// Update
	void updateBook();

	// Delete
	void deleteBook(Long id);
}
