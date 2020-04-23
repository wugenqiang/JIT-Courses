package com.sjtu.service.impl;

import com.sjtu.dao.Dao;
import com.sjtu.service.Manager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Base class for Business Services - use this class for utility methods and
 * generic CRUD methods.
 * 
 * <p>
 * <a href="BaseManager.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class BaseManager implements Manager {
	protected final Log log = LogFactory.getLog(getClass());
	protected Dao dao = null;

	/**
	 * @see com.sjtu.service.Manager#setDao(com.sjtu.dao.Dao)
	 */
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	/**
	 * @see com.sjtu.service.Manager#getObject(java.lang.Class,
	 *      java.io.Serializable)
	 */
	public Object getObject(Class clazz, Serializable id) {
		return dao.getObject(clazz, id);
	}

	/**
	 * @see com.sjtu.service.Manager#getObjects(java.lang.Class)
	 */
	public List getObjects(Class clazz) {
		return dao.getObjects(clazz);
	}

	/**
	 * @see com.sjtu.service.Manager#removeObject(java.lang.Class,
	 *      java.io.Serializable)
	 */
	public void removeObject(Class clazz, Serializable id) {
		dao.removeObject(clazz, id);
	}

	/**
	 * @see com.sjtu.service.Manager#saveObject(java.lang.Object)
	 */
	public void saveObject(Object o) {
		dao.saveObject(o);
	}
}
