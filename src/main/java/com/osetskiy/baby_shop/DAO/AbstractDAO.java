package com.osetskiy.baby_shop.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.osetskiy.baby_shop.model.AbstractEntity;
import com.osetskiy.baby_shop.model.Category;

public abstract class AbstractDAO<E extends AbstractEntity> {
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Transactional
	public void persist(E entity) {
		entityManager.persist(entity);
	}	
	@Transactional
	public void flush() {
		entityManager.flush();
	}
	@Transactional
	public void clear() {
		entityManager.clear();
	}
	@Transactional
	public E merge(E entity) {
		E merged = entityManager.merge(entity);
		entityManager.flush();
		return merged;
	}

}
