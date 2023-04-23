package com.juliechan.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.juliechan.bookclub.models.Book;
import com.juliechan.bookclub.models.User;
import com.juliechan.bookclub.services.BookService;
import com.juliechan.bookclub.services.UserService;

@Controller
public class UserController {
	// CONNECTING USER & BOOK SERVICE
	@Autowired
	private UserService uService;
	@Autowired
	private BookService bService;
	
	// READ ALL BOOKS REGARDLESS OF USER ON DASHBOARD
	@GetMapping("/dashboard")
	public String rDash(Model model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		List<Book> books = bService.getAll();
		model.addAttribute("book", books);
		System.out.println(books);
		System.out.println(session.getAttribute("user"));
		return "dashboard.jsp";
	}
	
	// READ ONE BOOK
	@GetMapping("/book/{id}")
	public String rOneBook(@PathVariable("id") Long bookId, Model model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		Book book = bService.getOne(bookId);
		model.addAttribute("book", book);
		return "one_book.jsp";
	}
	
	// CREATE A BOOK
	@GetMapping("/books/new")
	public String rCreateBookPg(Model model, @ModelAttribute("book") Book book, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		model.addAttribute("book");
		return "create.jsp";
	}
	
	// CREATE A BOOK FORM
	@PostMapping("/books/add")
	public String pCreateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
	if(session.getAttribute("user") == null) {
			return "redirect:/";
	}
	
	if(result.hasErrors()) {
		model.addAttribute("book");
		return "create.jsp";
	}
	
	book.setUser((User)session.getAttribute("user"));
	bService.createOrUpdate(book);
	return "redirect:/dashboard";
		
	}
	
	// EDIT BOOK PAGE
	@GetMapping("/book/{id}/edit")
	public String rOneBookPg(@PathVariable("id") Long bookId, Model model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		// IF USER IN SESSION ≠ USER WHO POSTED BOOK, CANNOT EDIT
		User user = (User) session.getAttribute("user");
		Book book = bService.getOne(bookId);
		if(!(user.getId() == book.getUser().getId())) {
		return "redirect:/book/{id}";	
		}
		else {
			System.out.println("Grabbing editing permissions...");
			model.addAttribute("book", book);
			return "edit.jsp";			
		}
	}
	
	// EDIT BOOK FORM
	@PutMapping("/book/{id}/update")
	public String pEdit(@PathVariable("id") Long bookId, @Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			model.addAttribute("book");
			return "edit.jsp";
		}
		else {
			book.setUser((User)session.getAttribute("user"));
			bService.createOrUpdate(book);
			return "redirect:/book/{id}";
		}		
	}
	
	// DELETE BOOK
	@DeleteMapping("/book/{id}")
	public String destroy(@PathVariable("id") Long bookId, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/";
		}
		// IF USER IN SESSION ≠ USER WHO POSTED BOOK, CANNOT DELETE
		User user = (User) session.getAttribute("user");
		Book book = bService.getOne(bookId);
		if(!(user.getId() == book.getUser().getId())) {
		return "redirect:/book/{id}";	
		}
		else {
			System.out.println("Deleting...");
			bService.deleteById(bookId);
			return "redirect:/dashboard";			
		}
	}
	
	// LOGOUT
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		return "redirect:/";
	}	
}
