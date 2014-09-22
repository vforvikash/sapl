package com.sapl.services.user;

import java.util.List;

import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.GroupSize;

public interface GroupSizeService {
	public GroupSize getGroupSize(int groupSizeId) throws SaplDaoException;
	public void saveNewGroupSize(GroupSize groupSize) throws SaplDaoException;
	public void updateGroupSize(GroupSize groupSize) throws SaplDaoException;
	public void deleteGroupSize(GroupSize groupSize) throws SaplDaoException;
	public List<GroupSize> getGroupSizes() throws SaplDaoException;
}
