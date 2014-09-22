package com.sapl.services.user;

import java.util.List;

import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Texture;

public interface TextureService {
	public Texture getTexture(int textureId) throws SaplDaoException;
	public void saveNewTexture(Texture texture) throws SaplDaoException;
	public void updateTexture(Texture texture) throws SaplDaoException;
	public void deleteTexture(Texture texture) throws SaplDaoException;
	public List<Texture> getTextures() throws SaplDaoException;
}
