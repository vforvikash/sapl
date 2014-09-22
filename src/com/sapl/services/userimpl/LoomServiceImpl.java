package com.sapl.services.userimpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sapl.db.dao.DaoFactory;
import com.sapl.db.dao.HMDao;
import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Loom;
import com.sapl.services.user.LoomService;

public class LoomServiceImpl implements LoomService {
	private HMDao dao;

	public LoomServiceImpl(DaoFactory df) throws SaplDaoException {
		this.dao = df.getDao(Loom.class);
	}

	@Override
	public Loom getLoom(int loomId) throws SaplDaoException {
		//Loom loom = (Loom)dao.getObject(Loom.class, loomId);
		//Loom loom = (Loom)dao.getObject(Loom.class, Integer.valueOf(loomId));
		HibernateTemplate ht = dao.getHibernateTemplate();
		Loom loom = ht.get(Loom.class, loomId);
		return loom;
	}

	@Override
	public void saveNewLoom(Loom loom) throws SaplDaoException {
		dao.save(loom);
	}

	@Override
	public void updateLoom(Loom loom) throws SaplDaoException {
		dao.update(loom);
	}

	@Override
	public List<Loom> getLooms() throws SaplDaoException {
		List<Loom> looms = dao.getAllObjects(Loom.class);
		return looms;
	}

	@Override
	public void deleteLoom(Loom loom) throws SaplDaoException {
		dao.purge(loom);
	}

}
