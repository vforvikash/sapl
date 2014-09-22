package com.sapl.db.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sapl.services.SaplServiceException;
import com.sapl.webui.command.HMCommand;



public class AdminDaoImpl implements AdminDao{

	private HibernateTemplate hibernateTemplate;

	public AdminDaoImpl(HibernateTemplate ht) {
		this.hibernateTemplate = ht;
	}

	public List getEntitiesSortedBy_Board(String sortProperty, boolean reverse)
			throws SaplDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(HMCommand hmcommand) throws SaplDaoException {
		// TODO Auto-generated method stub

	}

	public List getAllObjects(Class class1) throws SaplDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public List getAllObjects(String hqlStatement, String str)
			throws SaplDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getObject(Class classObj, String Id) throws SaplDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getObject(Class classObj, long Id) throws SaplDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public List getPagingObjects(int startRecord, int endRecord,
			String hqlStatement, String orderBy) throws SaplDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public void purge(Object obj) throws SaplDaoException {
		// TODO Auto-generated method stub

	}

	public Object save(Object obj) throws SaplDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrUpdate(Object obj) throws SaplDaoException {
		// TODO Auto-generated method stub

	}

	public Object savePersist(Object obj) throws SaplDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Object obj) throws SaplDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public HibernateTemplate getHibernateTemplate() throws SaplDaoException {
		return this.hibernateTemplate;
	}


}