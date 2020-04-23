package com.sjtu.dao.hibernate;

import com.sjtu.dao.LookupDao;

import java.util.List;

/**
 * Hibernate implementation of LookupDao.
 * 
 * <p>
 * <a href="LookupDaoHibernate.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class LookupDaoHibernate extends BaseDaoHibernate implements LookupDao {

	/**
	 * @see com.sjtu.dao.LookupDao#getRoles()
	 */
	public List getRoles() {
		log.debug("retrieving all role names...");

		return getHibernateTemplate().find("from Role order by name");
	}
}
