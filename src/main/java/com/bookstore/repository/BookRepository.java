package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	
}

