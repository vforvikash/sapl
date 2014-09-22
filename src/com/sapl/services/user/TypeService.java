package com.sapl.services.user;

import java.util.List;

import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Type;

public interface TypeService {
	public Type getType(int typeId) throws SaplDaoException;
	public void saveNewType(Type type) throws SaplDaoException;
	public void updateType(Type type) throws SaplDaoException;
	public void deleteType(Type type) throws SaplDaoException;
	public List<Type> getTypes() throws SaplDaoException;
}
