package com.greatlearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	// By default=>findById,findAll,save,deleteById, delete
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

	List<Book> findByName(String name);

	List<Book> findByCategoryAndAuthor(String category, String author);
}
