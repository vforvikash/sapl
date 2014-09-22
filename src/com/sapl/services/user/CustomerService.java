package com.sapl.services.user;

import java.util.List;

import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Customer;

public interface CustomerService {
	public Customer getCustomer(int customerId) throws SaplDaoException;
	public void saveNewCustomer(Customer customer) throws SaplDaoException;
	public void updateCustomer(Customer customer) throws SaplDaoException;
	public void deleteCustomer(Customer customer) throws SaplDaoException;
	public List<Customer> getCustomers() throws SaplDaoException;
}
