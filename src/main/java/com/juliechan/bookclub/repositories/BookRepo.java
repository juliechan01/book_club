package com.juliechan.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.juliechan.bookclub.models.Book;

public interface BookRepo extends CrudRepository<Book, Long>{
	// READ ALL BOOKS
	List<Book> findAll();
	
	// READ ONE BOOK
	Optional<Book> findById(Long bookId);
}
