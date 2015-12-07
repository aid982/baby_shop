package com.osetskiy.baby_shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.osetskiy.baby_shop.Service.ProductService;
import com.osetskiy.baby_shop.beans.Cart;
import com.osetskiy.baby_shop.model.Category;
import com.osetskiy.baby_shop.model.Product;
import com.osetskiy.baby_shop.model.PurchaseItem;

@Controller
public class CartController {
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);	
	@Autowired
	private ProductService productService;
	@Autowired
	private Cart cart;
	
	@RequestMapping(value ="/cart/add/{productId}",method =RequestMethod.POST)
	public String addToCart(@PathVariable("productId") String productId,@RequestParam("size") String size,@RequestParam("price") Integer price,@RequestHeader("referer") String referedFrom){		
		Product product = (Product)productService.findProduct(productId);
		PurchaseItem purchaseItem =new PurchaseItem();
		purchaseItem.setProduct(product);
		purchaseItem.setQty(1);
		purchaseItem.setSize(size);
		purchaseItem.setPrice(price);		
		cart.getContents().add(purchaseItem);
		logger.debug("Adding product in car "+product);
		System.out.println("Context size "+cart.getContents().size());
		System.out.println("size : "+size);
		System.out.println("price "+price);		
		return "redirect:"+referedFrom;	
		
	}
	@RequestMapping(value ="/cart", method = RequestMethod.GET)
	public String showCart(Model model){
		model.addAttribute("cartList",cart.getContents());
		model.addAttribute("cartTotal",cart.getTotal());
		
		return "cart/list";		
	}
	

}
