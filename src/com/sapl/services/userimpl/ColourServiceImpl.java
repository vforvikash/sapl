package com.sapl.services.userimpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sapl.db.dao.DaoFactory;
import com.sapl.db.dao.HMDao;
import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Colour;
import com.sapl.services.user.ColourService;

public class ColourServiceImpl implements ColourService {
	private HMDao dao;

	public ColourServiceImpl(DaoFactory df) throws SaplDaoException {
		this.dao = df.getDao(Colour.class);
	}

	@Override
	public Colour getColour(int colourId) throws SaplDaoException {
		//Colour colour = (Colour)dao.getObject(Colour.class, colourId);
		//Colour colour = (Colour)dao.getObject(Colour.class, Integer.valueOf(colourId));
		HibernateTemplate ht = dao.getHibernateTemplate();
		Colour colour = ht.get(Colour.class, colourId);
		return colour;
	}

	@Override
	public void saveNewColour(Colour colour) throws SaplDaoException {
		dao.save(colour);
	}

	@Override
	public void updateColour(Colour colour) throws SaplDaoException {
		dao.update(colour);
	}

	@Override
	public List<Colour> getColours() throws SaplDaoException {
		List<Colour> colours = dao.getAllObjects(Colour.class);
		return colours;
	}

	@Override
	public void deleteColour(Colour colour) throws SaplDaoException {
		dao.purge(colour);
	}

}
