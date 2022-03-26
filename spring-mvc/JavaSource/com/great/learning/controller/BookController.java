package com.great.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.great.learning.entity.Book;
import com.great.learning.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		System.out.println("Inside the book controller");
		theModel.addAttribute("Books", bookService.getBooks());
		return "list-books";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormToAdd(Model theModel) {
		theModel.addAttribute("Book", new Book());
		return "book-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") Long bookId, Model theModel) {
		theModel.addAttribute("Book", bookService.getBook(bookId));
		return "book-form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String saveBook(@RequestParam("id") Long bookId, @RequestParam("name") String name,
			@RequestParam("category") String category, @RequestParam("author") String author) {

		System.out.println("************** \n Trying to Save id : " + bookId);

		Book book;
		if (bookId != 0) {
			// Update Operation
			book = bookService.getBook(bookId);
			book.setAuthor(author);
			book.setCategory(category);
			book.setName(name);
		} else {
			// Create Operation
			book = new Book(name, category, author);
		}
		bookService.saveBook(book);
		return "redirect:/books/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String delete(@RequestParam("bookId") Long bookId) {
		bookService.deleteBook(bookId);
		return "redirect:/books/list";
	}

}
