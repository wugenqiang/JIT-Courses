package com.sjtu.admin.dao.hibernate;

import com.sjtu.admin.dao.MidCatalogDao;
import com.sjtu.admin.model.LargeCatalog;
import com.sjtu.admin.model.MidCatalog;
import com.sjtu.dao.hibernate.BaseDaoHibernate;
import org.springframework.orm.ObjectRetrievalFailureException;

import java.util.List;

public class MidCatalogDaoHibernate extends BaseDaoHibernate implements
		MidCatalogDao {

	/**
	 * @see com.sjtu.admin.dao.MidCatalogDao#getMidCatalogs(com.sjtu.admin.model.MidCatalog)
	 */
	public List getMidCatalogs(final MidCatalog midCatalog) {
		return getHibernateTemplate().find("from MidCatalog");

		/*
		 * Remove the line above and uncomment this code block if you want to
		 * use Hibernate's Query by Example API. if (midCatalog == null) {
		 * return getHibernateTemplate().find("from MidCatalog"); } else { //
		 * filter on properties set in the midCatalog HibernateCallback callback =
		 * new HibernateCallback() { public Object doInHibernate(Session
		 * session) throws HibernateException { Example ex =
		 * Example.create(midCatalog).ignoreCase().enableLike(MatchMode.ANYWHERE);
		 * return session.createCriteria(MidCatalog.class).add(ex).list(); } };
		 * return (List) getHibernateTemplate().execute(callback); }
		 */
	}

	/**
	 * @see com.sjtu.admin.dao.MidCatalogDao#getMidCatalog(Long midCatalogId)
	 */
	public MidCatalog getMidCatalog(final Long midCatalogId) {
		MidCatalog midCatalog = (MidCatalog) getHibernateTemplate().get(
				MidCatalog.class, midCatalogId);
		if (midCatalog == null) {
			log.warn("uh oh, midCatalog with midCatalogId '" + midCatalogId
					+ "' not found...");
			throw new ObjectRetrievalFailureException(MidCatalog.class,
					midCatalogId);
		}

		return midCatalog;
	}

	/**
	 * @see com.sjtu.admin.dao.MidCatalogDao#saveMidCatalog(MidCatalog
	 *      midCatalog)
	 */
	public void saveMidCatalog(final MidCatalog midCatalog) {
		getHibernateTemplate().saveOrUpdate(midCatalog);
	}

	/**
	 * @see com.sjtu.admin.dao.MidCatalogDao#removeMidCatalog(Long midCatalogId)
	 */
	public void removeMidCatalog(final Long midCatalogId) {
		getHibernateTemplate().delete(getMidCatalog(midCatalogId));
	}

	public List getLargeCatalogList() {
		return getHibernateTemplate().find(
				"from LargeCatalog l order by l.largeCatalogId asc");
	}

	public List getMidCatalogByUser() {
		return getHibernateTemplate().find(
				"from MidCatalog m order by m.midCatalogId asc");
	}

	public LargeCatalog getLargeCatalog(final String midCatalogId) {
		MidCatalog midCatalog = (MidCatalog) getHibernateTemplate().get(
				MidCatalog.class, midCatalogId);
		LargeCatalog largeCatalog = (LargeCatalog) getHibernateTemplate().get(
				LargeCatalog.class, midCatalog.getLargeCatalogId());
		return largeCatalog;
	}

	public List getMidCatalogByLargeCatalogId(final String largeCatalogId) {
		return getHibernateTemplate().find(
				"from MidCatalog m where m.largeCatalogId='" + largeCatalogId
						+ "'order by m.midCatalogId asc");

	}
}
