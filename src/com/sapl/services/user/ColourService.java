package com.sapl.services.user;

import java.util.List;

import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Colour;

public interface ColourService {
	public Colour getColour(int colourId) throws SaplDaoException;
	public void saveNewColour(Colour colour) throws SaplDaoException;
	public void updateColour(Colour colour) throws SaplDaoException;
	public void deleteColour(Colour colour) throws SaplDaoException;
	public List<Colour> getColours() throws SaplDaoException;
}
