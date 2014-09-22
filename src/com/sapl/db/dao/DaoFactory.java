/*
 * Created on Jan 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.sapl.db.dao;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;



/**
 * @author Vikash
 * This class is used to get the Instance of the corresponding DAO.
 * FactoryPattern is followed here to return the instance.
 * There is a baseDAO (HMDao) which supports all the CRUD Operations.
 * If you need to perform any other functionality we need to create our own Dao
 * and return the instance via the factory.
 *
 */
public class DaoFactory {

	/**
	 * Used to set the HibernateTemplate. Values will be set from
	 * Spring configuration file via setterInjection
	 */
	private HibernateTemplate hibernateTemplate = null;

	/**
	 * The base DAO Interface which supports CRUD Operation
	 */
	HMDao hmdao = null;
	public HMDao getHmdao() {
		return hmdao;
	}



	public void setHmdao(HMDao hmdao) {
		this.hmdao = hmdao;
	}



	BasicDataSource basicDataSource;

	/**
	 * constructor. Value set via constructor-arg in spring xml file
	 * @param htl
	 * @throws SaplDaoException
	 */
	public DaoFactory(HibernateTemplate htl) throws SaplDaoException{
		this.hibernateTemplate = htl;
		if(hmdao == null){
			hmdao = new HMDaoImpl(htl);
		}
	}



	/**
	 * If there is a corresponding Dao instance for a class returns that instance
	 * else returns the base Instance
	 * @param cls
	 * @return
	 * @throws SaplDaoException
	 */
	public HMDao getDao(Class cls) throws SaplDaoException{

		//if there is any specific instance of dao use as
		//if(cls.getName().equals("corresponding object name"))
			//return corresponding daoInstance
		// : Note the dao shd extend the HMDao....

		/*AdminDao adminDao = new AdminDaoImpl(hibernateTemplate);
		return adminDao;*/
		return hmdao;

		/*if(cls!=null && cls.getName().equals("com.heymath.util.Tree")) {
			TreeDao treeDao = new TreeDaoImpl(hibernateTemplate);
			return treeDao;
		}else if(cls!=null && cls.getName().equals("com.heymath.webui.command.school.School")) {
			SchoolDao schoolDao = new SchoolDaoImpl(hibernateTemplate);
			return schoolDao;
		}else if(cls!=null
				&& ( cls.getName().equals("com.heymath.webui.command.admin.Board")
				|| cls.getName().equals("com.heymath.webui.command.admin.Country")
				|| cls.getName().equals("com.heymath.webui.command.message.Message")
				|| cls.getName().equals("com.heymath.webui.command.message.MessageUsers")
				|| cls.getName().equals("com.heymath.webui.command.message.MessageAttachments")
				|| cls.getName().equals("com.heymath.webui.command.user.DataUpload")
				|| cls.getName().equals("com.heymath.webui.command.admin.Grade")
				|| cls.getName().equals("com.heymath.webui.command.admin.Role")
				|| cls.getName().equals("com.heymath.webui.command.admin.State")
				|| cls.getName().equals("com.heymath.webui.command.school.District")
				|| cls.getName().equals("com.heymath.webui.command.school.Student")
				|| cls.getName().equals("com.heymath.webui.command.school.Subject")
				|| cls.getName().equals("com.heymath.webui.command.user.Account")
				|| cls.getName().equals("com.heymath.webui.command.user.AccountOrganizationPerson")
				|| cls.getName().equals("com.heymath.webui.command.user.UserInfo")
				|| cls.getName().equals("com.heymath.webui.command.school.SchoolGradeClass")
				|| cls.getName().equals("com.heymath.webui.command.school.SchoolGradeClassSubject")
				|| cls.getName().equals("com.heymath.util.MailProperties"))) {


		}else{
			return hmdao;
		}*/

	}



	/**
	 * returns the HibernateTemplate
	 * @return
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}



	/**
	 * sets the HibernateTemplate
	 * @param hibernateTemplate
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
