package com.sapl.services.userimpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sapl.db.dao.DaoFactory;
import com.sapl.db.dao.HMDao;
import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Group;
import com.sapl.services.user.GroupService;

public class GroupServiceImpl implements GroupService {
	private HMDao dao;

	public GroupServiceImpl(DaoFactory df) throws SaplDaoException {
		this.dao = df.getDao(Group.class);
	}

	@Override
	public Group getGroup(int groupId) throws SaplDaoException {
		//Group group = (Group)dao.getObject(Group.class, groupId);
		//Group group = (Group)dao.getObject(Group.class, Integer.valueOf(groupId));
		HibernateTemplate ht = dao.getHibernateTemplate();
		Group group = ht.get(Group.class, groupId);
		return group;
	}

	@Override
	public void saveNewGroup(Group group) throws SaplDaoException {
		dao.save(group);
	}

	@Override
	public void updateGroup(Group group) throws SaplDaoException {
		dao.update(group);
	}

	@Override
	public List<Group> getGroups() throws SaplDaoException {
		List<Group> groups = dao.getAllObjects(Group.class);
		return groups;
	}

	@Override
	public void deleteGroup(Group group) throws SaplDaoException {
		dao.purge(group);
	}

}
