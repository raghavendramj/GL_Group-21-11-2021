package com.greatlearning.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.entity.Book;
import com.greatlearning.repository.BookRepository;
import com.greatlearning.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	public Book getBook(Long id) {
		// select * from Book where id = 121; -> Table -> 1, 2, 3, 4
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		}
		return null;
	}

	public List<Book> getBooks(String name) {
		return bookRepository.findByName(name);
	}

	public List<Book> getBooks(String category, String author) {
		return bookRepository.findByCategoryAndAuthor(category, author);
	}

	public void updateBook(Long id, Book book) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			bookRepository.save(book);
		}
	}

	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			bookRepository.delete(optionalBook.get());
		}
	}

}
