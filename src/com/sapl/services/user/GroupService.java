package com.sapl.services.user;

import java.util.List;

import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Group;

public interface GroupService {
	public Group getGroup(int groupId) throws SaplDaoException;
	public void saveNewGroup(Group group) throws SaplDaoException;
	public void updateGroup(Group group) throws SaplDaoException;
	public void deleteGroup(Group group) throws SaplDaoException;
	public List<Group> getGroups() throws SaplDaoException;
}
