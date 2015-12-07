package com.osetskiy.baby_shop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osetskiy.baby_shop.DAO.CategoryDAO;
import com.osetskiy.baby_shop.DAO.ProductDAO;
import com.osetskiy.baby_shop.model.Category;
import com.osetskiy.baby_shop.model.Product;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductDAO productDao;
	@Autowired
	private CategoryDAO categoryDao;
	
	
	public List<Product> getFeaturedProducts() {
		return productDao.findProductsByFeatured(true);
	}

	public long countAllProducts() {
        return productDao.countProducts();
    }

	public void deleteProduct(Product product) {
		productDao.remove(product);
    }

	public Product findProduct(String id) {
         Product product = productDao.findEntity(id);
         if (product == null) {
        	  return new Product();
         }
         return product;
    }

	public List<Product> findAllProducts() {
        return productDao.findAllProducts();
    }

	public List<Product> findProductEntries(int firstResult, int maxResults) {
        return productDao.findProductEntries(firstResult, maxResults);
    }
	
	public List<Product> findProductsByCategory(Category category) {
        return productDao.findProductByCategory(category);
    }

	public void saveProduct(Product product) {
		Category category = categoryDao.findEntity(product.getCategory().getId());
		product.setCategory(category);
		productDao.persist(product);
    }

	public Product updateProduct(Product product) {
        return productDao.merge(product);
    }

	public List<Product> findProducts(Product product) {
		return productDao.findProductEntries(product);
	}

}
