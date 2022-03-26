package com.great.learning.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.great.learning.entity.Book;
import com.great.learning.service.BookService;

@Repository
public class BookServiceImpl implements BookService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public BookServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException ex) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public void saveBook(Book myBook) {
		Transaction transaction = session.beginTransaction();
		session.save(myBook);
		transaction.commit();
	}

	public List<Book> getBooks() {
		List<Book> books = session.createQuery("from Book").list();
		return books;
	}

	public Book getBook(Long bookId) {
		Book myBook = session.get(Book.class, bookId);
		return myBook;
	}

	public List<Book> getBookByAuthorAndName(String author, String name) {

		String hibernateQuery = "";
		if (name.length() != 0 && author.length() != 0) {
			hibernateQuery = "from Book where name like '%" + name + "%' or author like '%" + author + "%'";
		} else if (name.length() != 0) {
			hibernateQuery = "from Book where name like '%" + name + "%'";
		} else if (author.length() != 0) {
			hibernateQuery = "from Book where author like '%" + author + "%'";
		}
		List<Book> books = session.createQuery(hibernateQuery).list();
		return books;
	}

	public void updateBook() {
		// Will implement later
	}

	@Transactional
	public void deleteBook(Long bookId) {
		Transaction transaction = session.beginTransaction();
		Book myBook = session.get(Book.class, bookId);
		session.save(myBook);
		transaction.commit();
	}
}
