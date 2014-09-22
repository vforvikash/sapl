package com.sapl.services.userimpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sapl.db.dao.DaoFactory;
import com.sapl.db.dao.HMDao;
import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Type;
import com.sapl.services.user.TypeService;

public class TypeServiceImpl implements TypeService {
	private HMDao dao;

	public TypeServiceImpl(DaoFactory df) throws SaplDaoException {
		this.dao = df.getDao(Type.class);
	}

	@Override
	public Type getType(int typeId) throws SaplDaoException {
		//Type type = (Type)dao.getObject(Type.class, typeId);
		//Type type = (Type)dao.getObject(Type.class, Integer.valueOf(typeId));
		HibernateTemplate ht = dao.getHibernateTemplate();
		Type type = ht.get(Type.class, typeId);
		return type;
	}

	@Override
	public void saveNewType(Type type) throws SaplDaoException {
		dao.save(type);
	}

	@Override
	public void updateType(Type type) throws SaplDaoException {
		dao.update(type);
	}

	@Override
	public List<Type> getTypes() throws SaplDaoException {
		List<Type> types = dao.getAllObjects(Type.class);
		return types;
	}

	@Override
	public void deleteType(Type type) throws SaplDaoException {
		dao.purge(type);
	}

}
