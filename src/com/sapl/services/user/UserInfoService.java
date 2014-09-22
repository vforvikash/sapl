package com.sapl.services.user;

import java.util.List;

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

public interface UserInfoService {
	public User getUser(String userId) throws SaplDaoException;

	public Sample getSample(int sampleId) throws SaplDaoException;
	public void saveNewSample(Sample sample) throws SaplDaoException;
	public void updateSample(Sample sample) throws SaplDaoException;
	public void deleteSample(Sample sample) throws SaplDaoException;
	public List<Sample> getSamples() throws SaplDaoException;
	public List<Type> getListOfType(String typeName) throws SaplDaoException;
	public List<GroupSize> getListOfGroupSize(String gsName) throws SaplDaoException;
	public List<ProductType> getListOfProductType(String ptName) throws SaplDaoException;
	public List<Group> getListOfGroup(String gName) throws SaplDaoException;
	public List<Ground> getListOfGround(String gName) throws SaplDaoException;
	public List<Loom> getListOfLoom(String lName) throws SaplDaoException;
	public List<Colour> getListOfColour(String cName) throws SaplDaoException;
	public List<Texture> getListOfTexture(String tName) throws SaplDaoException;
}
