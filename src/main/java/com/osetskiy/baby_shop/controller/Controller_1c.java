package com.osetskiy.baby_shop.controller;

import java.io.PrintWriter;
import java.nio.channels.GatheringByteChannel;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.osetskiy.baby_shop.Service.CategoryService;
import com.osetskiy.baby_shop.Service.ProductItemService;
import com.osetskiy.baby_shop.Service.ProductService;
import com.osetskiy.baby_shop.model.Category;
import com.osetskiy.baby_shop.model.Product;
import com.osetskiy.baby_shop.model.ProductItem;


/**
 * Handles requests from 1c programm
 */
@Controller

public class Controller_1c {	
	private static final Logger logger = LoggerFactory.getLogger(Controller_1c.class);	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductItemService productItemService;
	
	@RequestMapping(value = "/products", params = "register", method = RequestMethod.POST)	
	public void getProductFrom1c(HttpServletResponse resp, @RequestParam String id, @RequestParam String name,
			@RequestParam String category,@RequestParam String categoryId,@RequestParam String size, @RequestParam String qty,
			@RequestParam String price) throws Exception {
		id = id.trim();
		name = name.trim();
		categoryId = categoryId.trim();
		size = size.trim();
		
		Product productObj = new Product();
		productObj.setId(id);
		productObj.setName(name);				
		productObj.setPrice(new Integer(price));
		productObj = productService.updateProduct(productObj);
					
		
		Category categoryObj = new Category();
		categoryObj.setId(categoryId);
		categoryObj.setName(category);
		productObj.setCategory(categoryObj);
		categoryObj.getProducts().add(productObj);
		categoryObj = categoryService.updateCategory(categoryObj);
		
		
		ProductItem productItem = new ProductItem();
		productItem.setId(id+size);
		productItem.setProduct(productObj);
		productItem.setSize(size);
		productItem.setQty(new Integer(qty));
		productItemService.updateProductItem(productItem);
		
		
	}
	//@RequestMapping(value = "/products", params = "register", method = RequestMethod.POST)
	public void getProductFrom1c_2(HttpServletResponse resp, @ModelAttribute Product prod)	
	{
		
		
	}
	
	
}
