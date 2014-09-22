/*
 * Created on Jan 11, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.sapl.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;



/**
 * @author Vikash
 * base class for all the Service Class
 *
 *
 */
public class HMServiceImpl {

	/**
	 * Used to set the HibernateTemplate. Values will be set from
	 * Spring configuration file via setterInjection
	 */
	private HibernateTemplate hibernateTemplate;

	protected final transient Log log = LogFactory.getLog(getClass());


	/**
	 * @return HibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	/**
	 * sets the HibernateTemplate from spring xml via setter injection
	 * @param template
	 */
	public void setHibernateTemplate(HibernateTemplate template) {
		hibernateTemplate = template;
	}

}
