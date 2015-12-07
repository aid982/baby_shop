package com.osetskiy.baby_shop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.osetskiy.baby_shop.DAO.ProductDAO;
import com.osetskiy.baby_shop.DAO.ProductItemDAO;
import com.osetskiy.baby_shop.model.Category;
import com.osetskiy.baby_shop.model.Product;
import com.osetskiy.baby_shop.model.ProductItem;

@Service
@Transactional
public class ProductItemService {
	@Autowired
	private ProductItemDAO productItemDAO;
	
	
	public List<ProductItem> findProductSizes(Product product) {         
         return productItemDAO.findProductSizes(product);
    }	

	public void saveProduct(ProductItem productItem) {		
		productItemDAO.persist(productItem);
    }

	public ProductItem updateProductItem(ProductItem productItem) {
        return productItemDAO.merge(productItem);
        }	
}
