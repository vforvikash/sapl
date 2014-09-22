package com.sapl.services.userimpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sapl.db.dao.DaoFactory;
import com.sapl.db.dao.HMDao;
import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Customer;
import com.sapl.services.user.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private HMDao dao;

	public CustomerServiceImpl(DaoFactory df) throws SaplDaoException {
		this.dao = df.getDao(Customer.class);
	}

	@Override
	public Customer getCustomer(int customerId) throws SaplDaoException {
		//Customer customer = (Customer)dao.getObject(Customer.class, customerId);
		//Customer customer = (Customer)dao.getObject(Customer.class, Integer.valueOf(customerId));
		HibernateTemplate ht = dao.getHibernateTemplate();
		Customer customer = ht.get(Customer.class, customerId);
		return customer;
	}

	@Override
	public void saveNewCustomer(Customer customer) throws SaplDaoException {
		dao.save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) throws SaplDaoException {
		dao.update(customer);
	}

	@Override
	public List<Customer> getCustomers() throws SaplDaoException {
		List<Customer> customers = dao.getAllObjects(Customer.class);
		return customers;
	}

	@Override
	public void deleteCustomer(Customer customer) throws SaplDaoException {
		dao.purge(customer);
	}

}
