package com.osetskiy.baby_shop.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.osetskiy.baby_shop.model.Customer;


@Repository
public class CustomerDao extends AbstractDAO<Customer>{
	
     
	public long countCustomers() {
        return entityManager.createQuery("SELECT COUNT(o) FROM Customer o", Long.class).getSingleResult();
    }

	public List<Customer> findAllCustomers() {
        return entityManager.createQuery("SELECT o FROM Customer o", Customer.class).getResultList();
    }

	public Customer findCustomer(String name) {
        if (name == null) return null;
        return entityManager.find(Customer.class, name);
    }

	public List<Customer> findCustomerEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM Customer o", Customer.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	

	@Transactional
    public void remove(Customer customer) {
        if (this.entityManager.contains(customer)) {
            this.entityManager.remove(customer);
        } else {
            Customer attached = findCustomer(customer.getName());
            this.entityManager.remove(attached);
        }
    }

	
	
	public TypedQuery<Customer> findCustomersByNameEquals(String name) {
        if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
        TypedQuery<Customer> q = entityManager.createQuery("SELECT o FROM Customer AS o WHERE o.name = :name", Customer.class);
        q.setParameter("name", name);
        return q;
    }


}
