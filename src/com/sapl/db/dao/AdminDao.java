package com.sapl.db.dao;

import java.util.List;

/**
 * @author Vikash
 * Interface to interact with admin Modules.
 *
 */
public interface AdminDao extends HMDao {
	
	/**************************Board Dao Starts**************************/
	/**
	 * returns the list of board based on the sortProperty column. 
	 * @param sortProperty
	 * @param reverse
	 * @return
	 * @throws SaplDaoException
	 */
	public List getEntitiesSortedBy_Board(String sortProperty,boolean reverse) throws SaplDaoException;
	 
}
