package com.juliechan.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.juliechan.bookclub.models.User;

public interface UserRepo extends CrudRepository<User, Long>{
	// FIND USER BY EMAIL
	Optional<User> findByEmail(String email);
	
	// ALL USERS
	public List<User> findAll();
}
