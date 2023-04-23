package com.juliechan.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.juliechan.bookclub.models.LoginUser;
import com.juliechan.bookclub.models.User;
import com.juliechan.bookclub.services.UserService;

@Controller
public class HomeController {
	// CONNECTING USER SERVICE
	@Autowired
	private UserService uService;

	// RENDER REG & LOGIN PAGE
	@GetMapping("/")
	public String rHome(@ModelAttribute("user") User user, @ModelAttribute("loginUser") LoginUser loginUser) {
		return "login.jsp";
	}
	
	// REG FORM
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		// VERIFY IF INPUT IS CORRECT FORMAT
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "login.jsp";
		}
		User info = uService.register(user, result);
		// IF INFO RETRIEVED MATCHES USER INPUT
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "login.jsp";
		}
		session.setAttribute("user", info);
		System.out.println(info);
		return "redirect:/dashboard";
	}
	
	// LOGIN FORM
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		// VERIFY IF INPUT IS CORRECT FORMAT
		if(result.hasErrors()) {
			model.addAttribute("user", new User());
			return "login.jsp";
		}
		User info = uService.login(loginUser, result);
		// IF INFO RETRIEVED MATCHES USER INPUT
		if(result.hasErrors()) {
			model.addAttribute("user", new User());
			return "login.jsp";
		}
		session.setAttribute("user", info);
		System.out.println(info.getName());
		return "redirect:/dashboard";
	}
}
