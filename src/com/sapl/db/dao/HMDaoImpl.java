/*
 * Created on Jan 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.sapl.db.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sapl.util.Constants;
import com.sapl.webui.command.HMCommand;



/**
 * @author Vikash
 * This is the Implementation of the HMDao base Interface.
 * Here we are extending DaoImpl for DML operations in the DB.
 */
public class HMDaoImpl extends DaoImpl implements HMDao {

	protected final transient Log log = LogFactory.getLog(getClass());
	/**
	 * Constructor
	 */
	public HMDaoImpl() {
		super();
	}

	/**
	 * Constructor set by Spring xml file via constructor-arg tag
	 * @param htl
	 */
	public HMDaoImpl(HibernateTemplate htl) {
		super.setHibernateTemplate(htl);
	}

	/* (non-Javadoc)
	 * @see com.heymath.db.dao.HMDao#save(java.lang.Object)
	 */
	public Object save(Object obj) throws SaplDaoException {
		super.persistObject(obj);
			return obj;
	}

	public void saveOrUpdate(Object obj) throws SaplDaoException {
		super.persistOrUpdate(obj);
	}

	/* (non-Javadoc)
	 * @see com.heymath.db.dao.HMDao#savePersist(java.lang.Object)
	 */
	public Object savePersist(Object obj) throws SaplDaoException {
		long key = super.persistObjectReturnLongId(obj);
		return obj;
	}

	/* (non-Javadoc)
	 * @see com.heymath.db.dao.HMDao#getObject(java.lang.Class, java.lang.String)
	 */
	public Object getObject(Class classObj, String Id) throws SaplDaoException {
		Object obj = super.getObject(classObj, Id);
		return obj;
	}


	/* (non-Javadoc)
	 * @see com.heymath.db.dao.HMDao#update(java.lang.Object)
	 */
	public void update(Object obj) throws SaplDaoException {
		super.updateObject(obj);
	}

	/* (non-Javadoc)
	 * @see com.heymath.db.dao.HMDao#delete(com.heymath.webui.command.HMCommand)
	 */
	public void delete(HMCommand hmcommand) throws SaplDaoException {
		hmcommand.setDeleted(Constants.DELETED);
		super.updateObject(hmcommand);
	}

	/* (non-Javadoc)
	 * @see com.heymath.db.dao.HMDao#purge(java.lang.Object)
	 */
	public void purge(Object obj) throws SaplDaoException {
		super.deleteObject(obj);
	}

	/* (non-Javadoc)
	 * @see com.heymath.db.dao.DaoImpl#getAllObjects(java.lang.Class)
	 */
	public List getAllObjects(Class class1) throws SaplDaoException {
		List list  = null;
		try{
			list = super.getAllObjects(class1);
		}catch(DataAccessException e){
			throw new SaplDaoException(e);
		}catch(HibernateException e){
			throw new SaplDaoException(e);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.heymath.db.dao.HMDao#getAllObjects(java.lang.String, java.lang.String)
	 */
	public List getAllObjects(String HibernateQuery,String Str) throws SaplDaoException
	{
		List list = super.selectObjects(HibernateQuery,Str);
		return list;
	}



	/* (non-Javadoc)
	 * @see com.heymath.db.dao.HMDao#getPagingObjects(int, int, java.lang.String, java.lang.String)
	 */
	public List getPagingObjects(int startRecord, int endRecord,String hqlStatement,String orderBy) throws SaplDaoException
	{

			if (orderBy != null && !("".equals(orderBy.trim())))
				hqlStatement += " order by " + orderBy;

			//List list = super.selectPagingObjects(startRecord,endRecord,hqlStatement);
			//return list;

		return null;
	}

	/* (non-Javadoc)
	 * @see com.heymath.db.dao.DaoImpl#getObject(java.lang.Class, long)
	 */
	public Object getObject(Class classObj, long Id) throws SaplDaoException {
		Object obj = super.getObject(classObj,Id);
		return obj;
	}

}
