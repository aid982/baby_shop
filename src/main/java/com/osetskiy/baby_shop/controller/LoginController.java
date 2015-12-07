package com.osetskiy.baby_shop.controller;

import javax.persistence.Id;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.osetskiy.baby_shop.Service.CustomerService;
import com.osetskiy.baby_shop.model.Customer;

@Controller

public class LoginController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginForm(){
		return "login";		
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String verifyUser(@RequestParam("userId") String login,@RequestParam("password") String password,HttpSession session,
			Model model){
		Customer customer = customerService.loginCustomer(login, password);
		if (customer==null) {
		   model.addAttribute("loginError", "Ошибка ввода , попробуйте еще раз !!");
		   return "login";
		} 
		session.setAttribute("loggedInUser", customer);		
		return "redirect:/";			
	}
	
	@RequestMapping(value="/logOut", method=RequestMethod.GET)
	public String logOut(HttpSession session
			){		 
		session.removeAttribute("loggedInUser");		
		return "redirect:/";			
	}
	

}
