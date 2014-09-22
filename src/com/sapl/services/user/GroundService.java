package com.sapl.services.user;

import java.util.List;

import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Ground;

public interface GroundService {
	public Ground getGround(int groundId) throws SaplDaoException;
	public void saveNewGround(Ground ground) throws SaplDaoException;
	public void updateGround(Ground ground) throws SaplDaoException;
	public void deleteGround(Ground ground) throws SaplDaoException;
	public List<Ground> getGrounds() throws SaplDaoException;
}
