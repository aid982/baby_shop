package com.osetskiy.baby_shop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osetskiy.baby_shop.DAO.CustomerDao;
import com.osetskiy.baby_shop.model.Customer;



@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	public long countAllCustomers() {
        return customerDao.countCustomers();
    }

	public void deleteCustomer(Customer customer) {
		customerDao.remove(customer);
    }

	public Customer findCustomer(String name) {
        return customerDao.findCustomer(name);
    }	
	

	public List<Customer> findAllCustomers() {
        return customerDao.findAllCustomers();
    }

	public List<Customer> findCustomerEntries(int firstResult, int maxResults) {
        return customerDao.findCustomerEntries(firstResult, maxResults);
    }

	public void saveCustomer(Customer customer) {
		customerDao.persist(customer);
    }

	public Customer updateCustomer(Customer customer) {
        return customerDao.merge(customer);
    }

	public Customer loginCustomer(String userId, String password) {
		Customer customer = this.findCustomer(userId);
		if (customer != null && customer.getPassword().equals(password)) {
			return customer;
		}
		return null;
	}
}
