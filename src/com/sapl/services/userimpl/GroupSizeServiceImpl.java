package com.sapl.services.userimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sapl.db.dao.DaoFactory;
import com.sapl.db.dao.HMDao;
import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.GroupSize;
import com.sapl.db.data.Size;
import com.sapl.services.user.GroupSizeService;

public class GroupSizeServiceImpl implements GroupSizeService {
	private HMDao dao;

	public GroupSizeServiceImpl(DaoFactory df) throws SaplDaoException {
		this.dao = df.getDao(GroupSize.class);
	}

	@Override
	public GroupSize getGroupSize(int groupSizeId) throws SaplDaoException {
		HibernateTemplate ht = dao.getHibernateTemplate();
		GroupSize groupSize = ht.get(GroupSize.class, groupSizeId);
		Set<Size> sizes = groupSize.getSizes();
		ArrayList<Size> sizeList = new ArrayList<Size>();
		sizeList.addAll(sizes);
		groupSize.setSizeList(sizeList);
		return groupSize;
	}

	@Override
	public void saveNewGroupSize(GroupSize groupSize) throws SaplDaoException {
		List<Size> sizeList = groupSize.getSizeList();
		HashSet<Size> sizes = new HashSet<Size>();
		sizes.addAll(sizeList);
		groupSize.setSizes(sizes);
		dao.save(groupSize);
	}

	@Override
	public void updateGroupSize(GroupSize groupSize) throws SaplDaoException {
		dao.update(groupSize);
	}

	@Override
	public List<GroupSize> getGroupSizes() throws SaplDaoException {
		List<GroupSize> groupSizes = dao.getAllObjects(GroupSize.class);
		return groupSizes;
	}

	@Override
	public void deleteGroupSize(GroupSize groupSize) throws SaplDaoException {
		dao.purge(groupSize);
	}

}
