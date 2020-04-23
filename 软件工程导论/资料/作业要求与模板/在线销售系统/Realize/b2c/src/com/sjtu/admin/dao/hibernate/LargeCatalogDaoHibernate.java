package com.sjtu.admin.dao.hibernate;

import com.sjtu.admin.dao.LargeCatalogDao;
import com.sjtu.admin.model.LargeCatalog;
import com.sjtu.dao.hibernate.BaseDaoHibernate;
import org.springframework.orm.ObjectRetrievalFailureException;

import java.util.List;

public class LargeCatalogDaoHibernate extends BaseDaoHibernate implements
		LargeCatalogDao {

	/**
	 * @see com.sjtu.admin.dao.LargeCatalogDao#getLargecatalogs(com.sjtu.admin.model.LargeCatalog)
	 */
	public List getLargeCatalogs(final LargeCatalog largeCatalog) {
		return getHibernateTemplate().find("from LargeCatalog");

		/*
		 * Remove the line above and uncomment this code block if you want to
		 * use Hibernate's Query by Example API. if (largecatalog == null) {
		 * return getHibernateTemplate().find("from Largecatalog"); } else { //
		 * filter on properties set in the largecatalog HibernateCallback
		 * callback = new HibernateCallback() { public Object
		 * doInHibernate(Session session) throws HibernateException { Example ex =
		 * Example.create(largecatalog).ignoreCase().enableLike(MatchMode.ANYWHERE);
		 * return session.createCriteria(Largecatalog.class).add(ex).list(); } };
		 * return (List) getHibernateTemplate().execute(callback); }
		 */
	}

	/**
	 * @see com.sjtu.admin.dao.LargeCatalogDao#getLargecatalog(Long
	 *      largeCatalogId)
	 */
	public LargeCatalog getLargeCatalog(final Long largeCatalogId) {
		LargeCatalog largeCatalog = (LargeCatalog) getHibernateTemplate().get(
				LargeCatalog.class, largeCatalogId);
		if (largeCatalog == null) {
			log.warn("uh oh, largeCatalog with largeCatalogId '"
					+ largeCatalogId + "' not found...");
			throw new ObjectRetrievalFailureException(LargeCatalog.class,
					largeCatalogId);
		}

		return largeCatalog;
	}

	/**
	 * @see com.sjtu.admin.dao.LargeCatalogDao#saveLargecatalog(LargeCatalog
	 *      largecatalog)
	 */
	public void saveLargeCatalog(final LargeCatalog largeCatalog) {
		getHibernateTemplate().saveOrUpdate(largeCatalog);
	}

	/**
	 * @see com.sjtu.admin.dao.LargeCatalogDao#removeLargecatalog(Long
	 *      largeCatalogId)
	 */
	public void removeLargeCatalog(final Long largeCatalogId) {
		getHibernateTemplate().delete(getLargeCatalog(largeCatalogId));
	}
}
