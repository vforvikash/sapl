package com.sapl.services.user;

import java.util.List;

import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.ProductType;

public interface ProductTypeService {
	public ProductType getProductType(int productTypeId) throws SaplDaoException;
	public void saveNewProductType(ProductType productType) throws SaplDaoException;
	public void updateProductType(ProductType productType) throws SaplDaoException;
	public void deleteProductType(ProductType productType) throws SaplDaoException;
	public List<ProductType> getProductTypes() throws SaplDaoException;
}
