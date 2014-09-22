/*
 * Created on Jan 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.sapl.db.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sapl.webui.command.HMCommand;

/**
 * @author VasanS
 * This is the base Interface which performs the CRUD operation.
 * If we need to perform any other functionality apart from the CRUD operation
 * we need to write a new Dao which extends the HMDao to implement the custom functionality.
 *
 */
public interface HMDao {

	/**
	 * for persisting the object
	 * @param obj
	 * @return
	 * @throws SaplDaoException
	 */
	public abstract Object save(Object obj) throws SaplDaoException;

	/**
	 * for persisting the object & returns the inserted Id
	 * @param obj
	 * @return
	 * @throws SaplDaoException
	 */
	public abstract Object savePersist(Object obj) throws SaplDaoException;

	/**
	 * for save or update the object
	 * @param obj
	 * @return
	 * @throws SaplDaoException
	 */
	public abstract void saveOrUpdate(Object obj) throws SaplDaoException;

	/**
	 * returns the object for a class based on the Id.
	 * @param classObj
	 * @param Id
	 * @return
	 * @throws SaplDaoException
	 */
	public abstract Object getObject(Class classObj, String Id) throws SaplDaoException;

	/**
	 * Updates the given object
	 * @param obj
	 * @throws SaplDaoException
	 */
	public abstract void update(Object obj) throws SaplDaoException;


	/**
	 * deletes the given object.
	 * Here we are not deleting the record, rather updating the status(Soft Delete)
	 * @param hmcommand
	 * @throws SaplDaoException
	 */
	public abstract void delete(HMCommand hmcommand) throws SaplDaoException;

	/**
	 * used to delete the record from the DB.
	 * @param obj
	 * @throws SaplDaoException
	 */

	public void purge(Object obj) throws SaplDaoException;

	/**
	 * returns the List of records for the class (select * from tablename)
	 * @param class1
	 * @return
	 * @throws SaplDaoException
	 */
	public abstract List getAllObjects(Class class1) throws SaplDaoException;

	/**
	 * returns the List of records based on the HQL statement & orderby clause
	 * @param hqlStatement
	 * @param str
	 * @return
	 * @throws SaplDaoException
	 */
	public abstract List getAllObjects(String hqlStatement, String str) throws SaplDaoException;

	/**
	 * returns the object for the class & id
	 * @param classObj
	 * @param Id
	 * @return
	 * @throws SaplDaoException
	 */
	public abstract Object getObject(Class classObj, long Id) throws SaplDaoException;


	/**
	 * returns the list of records based on the start & end records.
	 * @param startRecord
	 * @param endRecord
	 * @param hqlStatement
	 * @param orderBy
	 * @return
	 * @throws SaplDaoException
	 */
	public abstract List getPagingObjects(int startRecord, int endRecord,String hqlStatement,String orderBy) throws SaplDaoException;

	public HibernateTemplate getHibernateTemplate() throws SaplDaoException;
}
