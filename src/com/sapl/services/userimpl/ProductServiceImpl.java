package com.sapl.services.userimpl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.sapl.db.dao.DaoFactory;
import com.sapl.db.dao.HMDao;
import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Ground;
import com.sapl.db.data.Group;
import com.sapl.db.data.GroupSize;
import com.sapl.db.data.Loom;
import com.sapl.db.data.Product;
import com.sapl.db.data.ProductType;
import com.sapl.db.data.Texture;
import com.sapl.db.data.Type;
import com.sapl.services.user.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private HMDao dao;
	private HibernateTemplate ht;

	public ProductServiceImpl(){

	}

	public ProductServiceImpl(DaoFactory df) throws SaplDaoException {
		this.dao = df.getDao(Product.class);
		this.ht = dao.getHibernateTemplate();
	}

	@Override
	public Product getProduct(int productId) throws SaplDaoException {
		//Product product = (Product)dao.getObject(Product.class, productId);
		//Product product = (Product)dao.getObject(Product.class, Integer.valueOf(productId));
		Product product = ht.get(Product.class, productId);
		return product;
	}

	@Override
	public void saveNewProduct(Product product) throws SaplDaoException {
		dao.save(product);
	}

	@Override
	public void updateProduct(Product product) throws SaplDaoException {
		dao.update(product);
	}

	@Override
	public List<Product> getProducts() throws SaplDaoException {
		List<Product> products = dao.getAllObjects(Product.class);
		return products;
	}

	@Override
	public void deleteProduct(Product product) throws SaplDaoException {
		dao.purge(product);
	}

	@Override
	public Product updateProductDependencies(Product product)
			throws SaplDaoException {
		if(product.getType() != null && product.getType().getId() > 0){
			Type type = (Type)ht.get(Type.class, product.getType().getId());
			product.setType(type);
		}else{
			product.setType(null);
		}
		if(product.getGroupSize() != null && product.getGroupSize().getId() > 0){
			GroupSize gs = (GroupSize)ht.get(GroupSize.class, product.getGroupSize().getId());
			product.setGroupSize(gs);
		}else{
			product.setGroupSize(null);
		}
		if(product.getProductType() != null && product.getProductType().getId() > 0){
			ProductType pt = (ProductType)ht.get(ProductType.class, product.getProductType().getId());
			product.setProductType(pt);
		}else{
			product.setProductType(null);
		}
		if(product.getGroup() != null && product.getGroup().getId() > 0){
			Group grp = (Group)ht.get(Group.class, product.getGroup().getId());
			product.setGroup(grp);
		}else{
			product.setGroup(null);
		}
		if(product.getGround() != null && product.getGround().getId() > 0){
			Ground ground = (Ground)ht.get(Ground.class, product.getGround().getId());
			product.setGround(ground);
		}else{
			product.setGround(null);
		}
		if(product.getLoom() != null && product.getLoom().getId() > 0){
			Loom loom = (Loom)ht.get(Loom.class, product.getLoom().getId());
			product.setLoom(loom);
		}else{
			product.setLoom(null);
		}
		//TODO update colours
		if(product.getTexture() != null && product.getTexture().getId() > 0){
			Texture txture = (Texture)ht.get(Texture.class, product.getTexture().getId());
			product.setTexture(txture);
		}else{
			product.setTexture(null);
		}
		return product;
	}

}
