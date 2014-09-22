package com.sapl.services.user;

import java.util.List;

import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Loom;

public interface LoomService {
	public Loom getLoom(int loomId) throws SaplDaoException;
	public void saveNewLoom(Loom loom) throws SaplDaoException;
	public void updateLoom(Loom loom) throws SaplDaoException;
	public void deleteLoom(Loom loom) throws SaplDaoException;
	public List<Loom> getLooms() throws SaplDaoException;
}
