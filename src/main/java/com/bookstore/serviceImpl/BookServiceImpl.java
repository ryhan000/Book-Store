package com.bookstore.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Book findOne(Long id) {
		// TODO Auto-generated method stub
		return  bookRepository.getOne(id);
	}

	

	

}
