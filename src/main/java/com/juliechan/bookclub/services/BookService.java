package com.juliechan.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliechan.bookclub.models.Book;
import com.juliechan.bookclub.repositories.BookRepo;

@Service
public class BookService {
	// CONNECTING BOOK REPO
	@Autowired
	private BookRepo bRepo;
	
	// ALL BOOKS
	public List<Book> getAll() {
		return bRepo.findAll();
	}
	
	// ONE BOOK
	public Book getOne(Long id) {
		Optional<Book> b = bRepo.findById(id);
		if(b.isPresent()) {
			return b.get();
		}
		return null;
	}
	
	// CREATE OR UPDATE BOOK
	public Book createOrUpdate(Book b) {
		return bRepo.save(b);
	}
	
	// DELETE BOOK
	public void deleteById(Long id) {
		bRepo.deleteById(id);
	}

}
