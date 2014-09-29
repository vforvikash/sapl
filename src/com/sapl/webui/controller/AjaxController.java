package com.sapl.webui.controller;

import java.util.List;

import org.directwebremoting.annotations.Param;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.spring.SpringCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.sapl.db.dao.SaplDaoException;
import com.sapl.db.data.Sample;
import com.sapl.services.user.UserInfoService;

/**
* A Java controller exposed via DWR
*/
@Controller("ajaxController")
@RemoteProxy(name="ajaxController")
/*@RemoteProxy(
    creator = SpringCreator.class,
    creatorParams ={ @Param(name = "beanName", value = "ajaxController"), @Param(name = "javascript", value="ajaxController") }
)*/
// Spring annotation
public class AjaxController {

	@Autowired
	private UserInfoService userInfoService;
	
	@RemoteMethod
	public String checkOutDwr(){
		System.out.println("Hi this is DWR method execution!!!");
		return "Welcome to DWR!!!";
	}
	
	@RemoteMethod
	public List<Sample> getSamples(String sId) throws SaplCntlException{
		System.out.println("This is from client-----"+sId);
		try {
			List<Sample> samples = userInfoService.getSamples();
			return samples;
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
	}
	
	@RemoteMethod
	public List<?> getListOfDataSearched(String searchString, String dataType) throws SaplCntlException{
		System.out.println("------> getListOfDataSearched----searchString="+searchString+", dataType="+dataType);
		List<?> listOfData = null;
		if(dataType == null)
			return null;
		try {
			if(dataType.equals("TYPE")){
				listOfData = userInfoService.getListOfType(searchString);
			}else if (dataType.equals("GROUPSIZE")) {
				listOfData = userInfoService.getListOfGroupSize(searchString);
			}else if (dataType.equals("PRODUCTTYPE")) {
				listOfData = userInfoService.getListOfProductType(searchString);
			}else if (dataType.equals("GROUP")) {
				listOfData = userInfoService.getListOfGroup(searchString);
			}else if (dataType.equals("GROUND")) {
				listOfData = userInfoService.getListOfGround(searchString);
			}else if (dataType.equals("LOOM")) {
				listOfData = userInfoService.getListOfLoom(searchString);
			}else if (dataType.equals("COLOUR")) {
				listOfData = userInfoService.getListOfColour(searchString);
			}else if (dataType.equals("TEXTURE")) {
				listOfData = userInfoService.getListOfTexture(searchString);
			}
			System.out.println(listOfData);
			return listOfData;
		} catch (SaplDaoException e) {
			throw new SaplCntlException(e);
		}
	}
}
