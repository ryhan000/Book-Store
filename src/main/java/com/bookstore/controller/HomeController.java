package com.bookstore.controller;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.security.domain.PasswordResetToken;
import com.bookstore.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService; 
	
	@RequestMapping("/")
	public String index() {
		
		return"index";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("classActiveLogin", true);
		return"myAccount";
	}
	

	@RequestMapping("/forgetPassword")
	public String forgetPassword(Local local,@RequestParam("token") String token,Model model) {
		
		PasswordResetToken passToken=userService.getPasswordResetToken(token);
		model.addAttribute("classActiveForgetPassword", true);
		return"myAccount";
	}
	

	@RequestMapping("/newAccount")
	public String newUser(Model model) {
		model.addAttribute("classActiveNewAccount", true);
		return"myAccount";
	}

}
