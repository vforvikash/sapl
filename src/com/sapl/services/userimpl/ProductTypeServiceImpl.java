package com.sapl.services.userimpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sapl.db.dao.DaoFactory;
import com.sapl.db.dao.HMDao;
import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.ProductType;
import com.sapl.services.user.ProductTypeService;

public class ProductTypeServiceImpl implements ProductTypeService {
	private HMDao dao;

	public ProductTypeServiceImpl(DaoFactory df) throws SaplDaoException {
		this.dao = df.getDao(ProductType.class);
	}

	@Override
	public ProductType getProductType(int productTypeId) throws SaplDaoException {
		//ProductType productType = (ProductType)dao.getObject(ProductType.class, productTypeId);
		//ProductType productType = (ProductType)dao.getObject(ProductType.class, Integer.valueOf(productTypeId));
		HibernateTemplate ht = dao.getHibernateTemplate();
		ProductType productType = ht.get(ProductType.class, productTypeId);
		return productType;
	}

	@Override
	public void saveNewProductType(ProductType productType) throws SaplDaoException {
		dao.save(productType);
	}

	@Override
	public void updateProductType(ProductType productType) throws SaplDaoException {
		dao.update(productType);
	}

	@Override
	public List<ProductType> getProductTypes() throws SaplDaoException {
		List<ProductType> productTypes = dao.getAllObjects(ProductType.class);
		return productTypes;
	}

	@Override
	public void deleteProductType(ProductType productType) throws SaplDaoException {
		dao.purge(productType);
	}

}
