package com.sapl.services.userimpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sapl.db.dao.DaoFactory;
import com.sapl.db.dao.HMDao;
import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Colour;
import com.sapl.db.data.Ground;
import com.sapl.db.data.Group;
import com.sapl.db.data.GroupSize;
import com.sapl.db.data.Loom;
import com.sapl.db.data.ProductType;
import com.sapl.db.data.Sample;
import com.sapl.db.data.Texture;
import com.sapl.db.data.Type;
import com.sapl.db.data.User;
import com.sapl.services.user.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	private HMDao dao;

	public UserInfoServiceImpl(DaoFactory df) throws SaplDaoException {
		this.dao = df.getDao(User.class);
	}

	@Override
	public User getUser(String userId) throws SaplDaoException {
		User user = (User)dao.getObject(User.class, userId);
		return user;
	}

	@Override
	public Sample getSample(int sampleId) throws SaplDaoException {
		//Sample sample = (Sample)dao.getObject(Sample.class, sampleId);
		//Sample sample = (Sample)dao.getObject(Sample.class, Integer.valueOf(sampleId));
		HibernateTemplate ht = dao.getHibernateTemplate();
		Sample sample = ht.get(Sample.class, sampleId);
		return sample;
	}

	@Override
	public void saveNewSample(Sample sample) throws SaplDaoException {
		dao.save(sample);
	}

	@Override
	public void updateSample(Sample sample) throws SaplDaoException {
		dao.update(sample);
	}

	@Override
	public List<Sample> getSamples() throws SaplDaoException {
		List<Sample> samples = dao.getAllObjects(Sample.class);
		return samples;
	}

	@Override
	public void deleteSample(Sample sample) throws SaplDaoException {
		dao.purge(sample);
	}
	 
	@Override
	public List<Type> getListOfType(String typeName) throws SaplDaoException {
		String hql = "from Type ty where ty.typeName like '"+typeName+"%'";
		List allObjects = dao.getAllObjects(hql , null);
		return allObjects;
	}

	@Override
	public List<GroupSize> getListOfGroupSize(String gsName)
			throws SaplDaoException {
		String hql = "from GroupSize ty where ty.name like '"+gsName+"%'";
		List allObjects = dao.getAllObjects(hql , null);
		return allObjects;
	}

	@Override
	public List<ProductType> getListOfProductType(String ptName)
			throws SaplDaoException {
		String hql = "from ProductType ty where ty.productTypeName like '"+ptName+"%'";
		List allObjects = dao.getAllObjects(hql , null);
		return allObjects;
	}

	@Override
	public List<Group> getListOfGroup(String gName) throws SaplDaoException {
		String hql = "from Group ty where ty.groupName like '"+gName+"%'";
		List allObjects = dao.getAllObjects(hql , null);
		return allObjects;
	}

	@Override
	public List<Ground> getListOfGround(String gName) throws SaplDaoException {
		String hql = "from Ground ty where ty.groundName like '"+gName+"%'";
		List allObjects = dao.getAllObjects(hql , null);
		return allObjects;
	}

	@Override
	public List<Loom> getListOfLoom(String lName) throws SaplDaoException {
		String hql = "from Loom ty where ty.loomName like '"+lName+"%'";
		List allObjects = dao.getAllObjects(hql , null);
		return allObjects;
	}

	@Override
	public List<Colour> getListOfColour(String cName) throws SaplDaoException {
		String hql = "from Colour ty where ty.colourName like '"+cName+"%'";
		List allObjects = dao.getAllObjects(hql , null);
		return allObjects;
	}

	@Override
	public List<Texture> getListOfTexture(String tName) throws SaplDaoException {
		String hql = "from Texture ty where ty.textureName like '"+tName+"%'";
		List allObjects = dao.getAllObjects(hql , null);
		return allObjects;
	}
	
	
}
