package com.osetskiy.baby_shop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osetskiy.baby_shop.DAO.CategoryDAO;
import com.osetskiy.baby_shop.model.Category;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryDAO categoryDao;
	
	public long countAllCategorys() {
        return categoryDao.countEntities();
    }

	public void deleteCategory(Category category) {
		categoryDao.remove(category);
    }

	public Category findCategory(String id) {
        return categoryDao.findEntity(id);
    }
	
	public Category findCategoryEagerly(String id) {
        return categoryDao.findEntityEagerly(id);
    }

	public List<Category> getAllCategories() {
        return categoryDao.findAllEntities();
    }

	public List<Category> findCategoryEntries(int firstResult, int maxResults) {
        return categoryDao.findEntityEntries(firstResult, maxResults);
    }

	public void saveCategory(Category category) {
		categoryDao.persist(category);
    }

	public Category updateCategory(Category category) {
        return categoryDao.merge(category);
    }
}

