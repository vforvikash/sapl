package com.sapl.services.userimpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sapl.db.dao.DaoFactory;
import com.sapl.db.dao.HMDao;
import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Ground;
import com.sapl.services.user.GroundService;

public class GroundServiceImpl implements GroundService {
	private HMDao dao;

	public GroundServiceImpl(DaoFactory df) throws SaplDaoException {
		this.dao = df.getDao(Ground.class);
	}

	@Override
	public Ground getGround(int groundId) throws SaplDaoException {
		//Ground ground = (Ground)dao.getObject(Ground.class, groundId);
		//Ground ground = (Ground)dao.getObject(Ground.class, Integer.valueOf(groundId));
		HibernateTemplate ht = dao.getHibernateTemplate();
		Ground ground = ht.get(Ground.class, groundId);
		return ground;
	}

	@Override
	public void saveNewGround(Ground ground) throws SaplDaoException {
		dao.save(ground);
	}

	@Override
	public void updateGround(Ground ground) throws SaplDaoException {
		dao.update(ground);
	}

	@Override
	public List<Ground> getGrounds() throws SaplDaoException {
		List<Ground> grounds = dao.getAllObjects(Ground.class);
		return grounds;
	}

	@Override
	public void deleteGround(Ground ground) throws SaplDaoException {
		dao.purge(ground);
	}

}
