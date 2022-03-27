package com.greatlearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	// By default=>findById,findAll,save,deleteById, delete
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	User findByUsername(String username);
}
