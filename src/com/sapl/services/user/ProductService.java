package com.sapl.services.user;

import java.util.List;

import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Product;

public interface ProductService {
	public Product getProduct(int productId) throws SaplDaoException;
	public Product updateProductDependencies(Product product) throws SaplDaoException;
	public void saveNewProduct(Product product) throws SaplDaoException;
	public void updateProduct(Product product) throws SaplDaoException;
	public void deleteProduct(Product product) throws SaplDaoException;
	public List<Product> getProducts() throws SaplDaoException;
}
