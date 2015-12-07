package com.osetskiy.baby_shop.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.osetskiy.baby_shop.model.Category;
import com.osetskiy.baby_shop.model.Product;

@Repository
public class CategoryDAO extends AbstractDAO<Category> {	
	
	public long countEntities() {
		return entityManager.createQuery("SELECT COUNT(o) FROM Category o", Long.class).getSingleResult();
	}

	public List<Category> findAllEntities() {
		return entityManager.createQuery("SELECT o FROM Category o", Category.class).getResultList();
	}

	public Category findEntity(String id) {
		if (id == null)
			return null;
		return entityManager.find(Category.class, id);
	}

	public Category findEntityEagerly(String id) {
		if (id == null)
			return null;
		return entityManager.createQuery("SELECT o FROM Category o LEFT OUTER JOIN FETCH o.products WHERE o.id = (:id)",
				Category.class).setParameter("id", id).getSingleResult();
	}

	public List<Category> findEntityEntries(int firstResult, int maxResults) {
		return entityManager.createQuery("SELECT o FROM Category o", Category.class).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();
	}
	
	
	public void remove(Category category) {
		if (this.entityManager.contains(category)) {
			this.entityManager.remove(category);
		} else {
			Category attached = findEntity(category.getId());
			this.entityManager.remove(attached);		}
	}

}
