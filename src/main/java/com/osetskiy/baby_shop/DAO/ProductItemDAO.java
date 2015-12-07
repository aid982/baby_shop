package com.osetskiy.baby_shop.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.osetskiy.baby_shop.model.Product;
import com.osetskiy.baby_shop.model.ProductItem;


@Repository
public class ProductItemDAO extends AbstractDAO<ProductItem> {		
	public ProductItem findEntity(String id) {
		if (id == null)
			return null;
		return entityManager.find(ProductItem.class, id);
	}

	public void remove(ProductItem productItem) {
		if (this.entityManager.contains(productItem)) {
			this.entityManager.remove(productItem);
		} else {
			ProductItem attached = findEntity(productItem.getId());
			this.entityManager.remove(attached);
		}
	}

	public List<ProductItem> findProductSizes(Product product) {
		Query query;
		query = entityManager.createQuery("SELECT o FROM ProductItem o WHERE o.product = :product ORDER BY o.size", ProductItem.class);
		query.setParameter("product", product);
		return query.getResultList();
	}

}
