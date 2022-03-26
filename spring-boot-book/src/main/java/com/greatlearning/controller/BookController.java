package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.entity.Book;
import com.greatlearning.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping
	Book saveBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}

	@GetMapping
	List<Book> getBooks() {
		return bookService.getBooks();
	}

	@GetMapping("/search/name/{name}")
	List<Book> getBooks(@PathVariable("name") String name) {
		return bookService.getBooks(name);
	}

	@GetMapping("/search/categoryandauthor")
	List<Book> getBooks(@RequestParam("category") String category, @RequestParam("author") String author) {
		return bookService.getBooks(category, author);
	}

	@GetMapping("/{id}")
	Book getBook(@PathVariable("id") Long id) {
		return bookService.getBook(id);
	}

	@PutMapping("/{id}")
	void updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		bookService.updateBook(id, book);
	}

	@DeleteMapping("/{id}")
	void deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
}
