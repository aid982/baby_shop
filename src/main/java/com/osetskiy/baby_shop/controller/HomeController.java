package com.osetskiy.baby_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.osetskiy.baby_shop.Service.CategoryService;
import com.osetskiy.baby_shop.Service.ProductService;

@Controller
@RequestMapping("/")
public class HomeController {	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCategories(Model model)	
	{	
		System.out.println("eeeeeeeeeeeeeeeee");
		model.addAttribute("categoryList",categoryService.getAllCategories());
		model.addAttribute("productList",productService.getFeaturedProducts());
		return "category/productsList";		
	}

}
