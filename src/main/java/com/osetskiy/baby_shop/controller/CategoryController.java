package com.osetskiy.baby_shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.osetskiy.baby_shop.Service.CategoryService;
import com.osetskiy.baby_shop.Service.ProductService;
import com.osetskiy.baby_shop.model.Category;
import com.osetskiy.baby_shop.model.Product;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCategories(Model model)	
	{		
		model.addAttribute("categoryList",categoryService.getAllCategories());		
		return "category/list";		
	}
	
	@RequestMapping(value = "/{categoryId}")
	public String getProductsByCategories(@PathVariable String categoryId,@QueryParam("page") Integer page,Model model)	
	{
		if(page == null) page = 0;
		System.out.println(page);		
		List<Product> products = productService.findProductsByCategory(categoryService.findCategory(categoryId));		
		PagedListHolder<Product> pagedListHolder= new PagedListHolder<Product>(products);
		System.out.println(page);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(9);
		model.addAttribute("categoryList",categoryService.getAllCategories());		
		model.addAttribute("productList",pagedListHolder.getPageList());
		model.addAttribute("pagedListHolder",pagedListHolder);		
		
		return "category/productsList";		
	}
	

	

}
