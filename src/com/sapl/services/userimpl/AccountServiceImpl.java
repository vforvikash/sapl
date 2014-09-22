package com.sapl.services.userimpl;

import com.sapl.db.dao.DaoFactory;
import com.sapl.db.dao.HMDao;
import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.User;
import com.sapl.services.user.AccountService;

public class AccountServiceImpl implements AccountService {
	private HMDao dao;

	public AccountServiceImpl(DaoFactory df) throws SaplDaoException {
		this.dao = df.getDao(User.class);
	}
}
