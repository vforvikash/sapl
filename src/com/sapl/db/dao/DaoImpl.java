package com.sapl.db.dao;



import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public abstract class DaoImpl extends HibernateDaoSupport {
	Class defaultObjectClass=null;
	
	/**
	 * 
	 */
	protected DaoImpl() {
		super();
	}

	/**
	 * @param defObjClass
	 */
	protected DaoImpl(Class defObjClass) {
		super();
		defaultObjectClass=defObjClass;
	}

	//
	// Get List
	//
	/**
	 * returns the List of Objects for a class and ordered by the orderByList 
	 * @param objectClass
	 * @param orderByList
	 * @return
	 * @throws HibernateException
	 * @throws DataAccessException
	 * @throws SaplDaoException
	 */
	protected List getAllObjects(Class objectClass, String orderByList) throws HibernateException, DataAccessException, SaplDaoException {
		if (orderByList==null || "".equals(orderByList.trim())) return getAllObjects(objectClass);
		String hqlStatement;
		hqlStatement="from "+objectClass.getName()+" order by "+orderByList;
		return getHibernateTemplate().find(hqlStatement);
	}
	/**
	 * returns the List of Objects for the default class and ordered by the orderByList 
	 * @param orderByList
	 * @return
	 * @throws HibernateException
	 * @throws DataAccessException
	 * @throws SaplDaoException
	 */
	protected List getAllObjects(String orderByList) throws HibernateException, DataAccessException, SaplDaoException { return getAllObjects(defaultObjectClass,orderByList); }
	
	/**
	 * returns the List of Objects for a class 
	 * @param objectClass
	 * @return
	 * @throws DataAccessException
	 * @throws HibernateException
	 * @throws SaplDaoException
	 */
	protected List getAllObjects(Class objectClass) throws DataAccessException, HibernateException, SaplDaoException {
		return getHibernateTemplate().loadAll(objectClass);
	}
	
	/**
	 * returns the List of Objects for the defaultclass
	 * @return
	 * @throws HibernateException
	 * @throws DataAccessException
	 * @throws SaplDaoException
	 */
	protected List getAllObjects() throws HibernateException, DataAccessException, SaplDaoException { return getAllObjects(defaultObjectClass); }

	/**
	 * returns the List of objects for a class based on the property name and property value
	 * ie. conditions to be added in the where clause of the query
	 * @param objectClass
	 * @param propertyName
	 * @param propertyValue
	 * @param orderByList
	 * @return
	 * @throws DataAccessException
	 */
	protected List selectObjects(Class objectClass, String propertyName, Object propertyValue, String orderByList) throws DataAccessException {
		String hqlStatement;
		hqlStatement="from "+objectClass.getName()+" ent where ent."+propertyName.trim()+"=?";
		if (orderByList!=null && !("".equals(orderByList.trim()))) hqlStatement+=" order by "+addPrefixToOrderByList("ent",orderByList);
		return getHibernateTemplate().find(hqlStatement,propertyValue);
	}
	/**
	 *  * returns the List of objects for the defaultclass based on the property name and property value
	 * ie. conditions to be added in the where clause of the query
	 * @param propertyName
	 * @param propertyValue
	 * @param orderByList
	 * @return
	 * @throws DataAccessException
	 */
	protected List selectObjects(String propertyName, Object propertyValue, String orderByList) throws DataAccessException { return selectObjects(defaultObjectClass,propertyName,propertyValue,orderByList); }
	
	/**
	 *  * returns the List of objects for a class based on the property name and property value
	 * ie. conditions to be added in the where clause of the query
	 * @param objectClass
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * @throws DataAccessException
	 */
	protected List selectObjects(Class objectClass, String propertyName, Object propertyValue) throws DataAccessException {
		return selectObjects(objectClass,propertyName,propertyValue,null);
	}
	
	/**
	 * returns the List of objects based on HQL statement and the records are ordered by orderByList
	 * @param hqlStatement
	 * @param orderByList
	 * @return
	 * @throws DataAccessException
	 * @throws HibernateException
	 */
	protected List selectObjects(
			String hqlStatement,String orderByList)
			throws DataAccessException,HibernateException {
			
			if (orderByList != null && !("".equals(orderByList.trim())))
				hqlStatement += " order by " + orderByList;
			return getHibernateTemplate().find(hqlStatement);
	}
	
	
	/**
	 * returns the List of objects based on class property name and property value. Here instead of value we are having 
	 * a class & we will get the value based on the class
	 * @param objectClass
	 * @param propertyName
	 * @param propertyClass
	 * @param propertyKey
	 * @param orderByList
	 * @return
	 * @throws DataAccessException
	 */
	protected List selectObjects(Class objectClass, String propertyName, Class propertyClass, Serializable propertyKey, String orderByList) throws DataAccessException {
		Object propertyValue=getHibernateTemplate().get(propertyClass,propertyKey);
		return selectObjects(objectClass,propertyName,propertyValue,orderByList);
	}
	
	/**
	 * returns the List of objects based on the default class property name and property value. Here instead of value we are having 
	 * a class & we will get the value based on the class
	 * @param propertyName
	 * @param propertyClass
	 * @param propertyKey
	 * @param orderByList
	 * @return
	 * @throws DataAccessException
	 */
	protected List selectObjects(String propertyName, Class propertyClass, Serializable propertyKey, String orderByList) throws DataAccessException { return selectObjects(defaultObjectClass,propertyName,propertyClass,propertyKey,orderByList); }
	
	/**
	 * returns the List of objects based on class property name and property value. Here instead of value we are having 
	 * a class & we will get the value based on the class
	 * @param objectClass
	 * @param propertyName
	 * @param propertyClass
	 * @param propertyKey
	 * @return
	 * @throws DataAccessException
	 */
	protected List selectObjects(Class objectClass, String propertyName, Class propertyClass, Serializable propertyKey) throws DataAccessException {
		return selectObjects(objectClass,propertyName,propertyClass,propertyKey,null);
	}
	
	/**
	 *  returns the List of objects based on default class property name and property value. Here instead of value we are having 
	 * a class & we will get the value based on the class
	 * @param propertyName
	 * @param propertyClass
	 * @param propertyKey
	 * @return
	 * @throws DataAccessException
	 */
	protected List selectObjects(String propertyName, Class propertyClass, Serializable propertyKey) throws DataAccessException { return selectObjects(defaultObjectClass,propertyName,propertyClass,propertyKey); }
	
	/**
	 * returns the List of objects based on class property name and property value. Here instead of value we are having 
	 * a class & we will get the value based on the class
	 * @param propertyName
	 * @param propertyClass
	 * @param propertyKey
	 * @return
	 * @throws DataAccessException
	 */
	protected List selectObjects(String propertyName, Class propertyClass, long propertyKey) throws DataAccessException { return selectObjects(defaultObjectClass,propertyName,propertyClass,new Long(propertyKey)); }
	/**
	 * returns the List of objects based on class property name and property value. Here instead of value we are having 
	 * a class & we will get the value based on the class
	 * @param propertyName
	 * @param propertyClass
	 * @param propertyKey
	 * @param orderByList
	 * @return
	 * @throws DataAccessException
	 */
	protected List selectObjects(String propertyName, Class propertyClass, long propertyKey, String orderByList) throws DataAccessException { return selectObjects(defaultObjectClass,propertyName,propertyClass,new Long(propertyKey),orderByList); }
	
	//
	// Get Object
	//
	/**
	 * returns the Object for a class based on the Serializable objectId
	 * @param objectClass
	 * @param objectId
	 * @return
	 * @throws DataAccessException
	 */
	protected Object getObject(Class objectClass, Serializable objectId) throws DataAccessException {
		return getHibernateTemplate().get(objectClass,objectId);
	}
	
	/**
	 * returns the Object for the default class based on the objectId
	 * @param objectId
	 * @return
	 * @throws DataAccessException
	 */
	protected Object getObject(Serializable objectId)
            throws DataAccessException {
        return getObject(defaultObjectClass, objectId);
    }
	/**
	 * returns the Object for a class based on the objectId 
	 * @param objectClass
	 * @param objectId
	 * @return
	 * @throws DataAccessException
	 * @throws HibernateException
	 * @throws SaplDaoException
	 */
	protected Object getObject(Class objectClass, long objectId) throws DataAccessException, HibernateException, SaplDaoException {
		return getObject(objectClass,new Long(objectId));
	}
	/**
	 * returns the Object for a default class based on the objectId
	 * @param objectId
	 * @return
	 * @throws HibernateException
	 * @throws DataAccessException
	 * @throws SaplDaoException
	 */
	protected Object getObject(long objectId) throws HibernateException, DataAccessException, SaplDaoException { return getObject(defaultObjectClass,objectId); }
	
	//
	// Persist Object
	//
	/**
	 * persist the Object.
	 * @param object
	 * @return
	 * @throws DataAccessException
	 */
	protected Serializable persistObject(Object object) throws DataAccessException {
		return getHibernateTemplate().save(object);
	}
	
	/**
	 * persist the Object.
	 * @param object
	 * @return
	 * @throws DataAccessException
	 * @throws SaplDaoException 
	 * @throws  
	 */
	protected void persistOrUpdate(Object object) throws DataAccessException {
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	/**
	 * Persist the object & returns the id of the inserted object
	 * @param object
	 * @return
	 * @throws DataAccessException
	 */
	protected long persistObjectReturnLongId(Object object) throws DataAccessException {
		return ((Long)persistObject(object)).longValue();
	}

	//
	// Update Object
	//
	/**
	 * Updates the Object
	 * @param object
	 * @throws DataAccessException
	 */
	protected void updateObject(Object object) throws DataAccessException {
		getHibernateTemplate().update(object);
	}
	
	//
	// Delete Object
	//
	/**
	 * delete the object
	 * @param object
	 * @throws DataAccessException
	 */
	protected void deleteObject(Object object) throws DataAccessException {
		getHibernateTemplate().delete(object);
	}
	/**
	 * delete the object for a class based on the objectId
	 * @param objectClass
	 * @param objectId
	 * @throws DataAccessException
	 */
	protected void deleteObject(Class objectClass, Serializable objectId) throws DataAccessException {
		deleteObject(getObject(objectClass,objectId));
	}
	/**
	 * delete the object for the default class based on the objectId
	 * @param objectId
	 * @throws DataAccessException
	 */
	protected void deleteObject(Serializable objectId) throws DataAccessException { deleteObject(defaultObjectClass,objectId); }
	
	/**
	 * delete the object for a class based on the objectId
	 * @param objectClass
	 * @param objectId
	 * @throws DataAccessException
	 */
	protected void deleteObject(Class objectClass, long objectId) throws DataAccessException {
		deleteObject(objectClass,new Long(objectId));
	}
	/**
	 * delete the object for default class based on the objectId
	 * @param objectId
	 * @throws DataAccessException
	 */
	protected void deleteObject(long objectId) throws DataAccessException { deleteObject(defaultObjectClass,objectId); }
	
	// Utils
	/**
	 * returns the orderby string with prefix attached.
	 * @param prefix
	 * @param orderByList
	 * @return
	 */
	protected String addPrefixToOrderByList(String prefix, String orderByList) {
		if (prefix==null || prefix.trim().length()==0) return orderByList;
		if (orderByList==null) return null;

		prefix=prefix.trim();
		if (!prefix.endsWith(".")) prefix=prefix+".";
		String ret="";
		while(true) {
			int p=orderByList.indexOf(",");
			if (p==-1) {
				ret+=prefix+orderByList.trim();
				break;
			} else {
				if (ret.length()!=0) ret+=",";
				ret+=prefix+orderByList.substring(0,p).trim()+",";
				orderByList=orderByList.substring(p+1);
			}
		};
		return ret;
	}
	
}
