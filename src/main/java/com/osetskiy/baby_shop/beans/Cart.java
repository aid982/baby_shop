package com.osetskiy.baby_shop.beans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.osetskiy.baby_shop.model.Product;
import com.osetskiy.baby_shop.model.PurchaseItem;

@Component
@Scope (value =WebApplicationContext.SCOPE_SESSION,proxyMode= ScopedProxyMode.TARGET_CLASS)
public class Cart {
	private List<PurchaseItem> contents = new ArrayList<>();

	
	public Integer getTotal(){
		Integer result =0;
		for (PurchaseItem purchaseItem : contents) {
			result += purchaseItem.getPrice();			
		}		
		return result;
		
	}
	public List<PurchaseItem> getContents() {
		return contents;
	}


	public void setContents(List<PurchaseItem> contents) {
		this.contents = contents;
	}


	@Override
	public String toString() {
		String result ="";
		for (PurchaseItem purchaseItem : contents) {
			result += purchaseItem.getProduct()+" "+purchaseItem.getSize()+" "+purchaseItem.getQty();
			
			
		}		
		return result;
	}
	
	

		

}
