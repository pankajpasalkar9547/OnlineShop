package com.allianz.shopping.DAO;

import java.util.List;

import com.allianz.shopping.model.Customer;

public interface CustomerDAO {
	public boolean addCustomer(Customer customer);
	public boolean login(String username , String password);
	public List<Customer> getAllCustomer();

}
