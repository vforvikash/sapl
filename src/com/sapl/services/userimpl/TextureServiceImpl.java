package com.sapl.services.userimpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sapl.db.dao.DaoFactory;
import com.sapl.db.dao.HMDao;
import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Texture;
import com.sapl.services.user.TextureService;

public class TextureServiceImpl implements TextureService {
	private HMDao dao;

	public TextureServiceImpl(DaoFactory df) throws SaplDaoException {
		this.dao = df.getDao(Texture.class);
	}

	@Override
	public Texture getTexture(int textureId) throws SaplDaoException {
		//Texture texture = (Texture)dao.getObject(Texture.class, textureId);
		//Texture texture = (Texture)dao.getObject(Texture.class, Integer.valueOf(textureId));
		HibernateTemplate ht = dao.getHibernateTemplate();
		Texture texture = ht.get(Texture.class, textureId);
		return texture;
	}

	@Override
	public void saveNewTexture(Texture texture) throws SaplDaoException {
		dao.save(texture);
	}

	@Override
	public void updateTexture(Texture texture) throws SaplDaoException {
		dao.update(texture);
	}

	@Override
	public List<Texture> getTextures() throws SaplDaoException {
		List<Texture> textures = dao.getAllObjects(Texture.class);
		return textures;
	}

	@Override
	public void deleteTexture(Texture texture) throws SaplDaoException {
		dao.purge(texture);
	}

}
