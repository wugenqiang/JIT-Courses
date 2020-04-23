package com.sjtu.admin.dao.hibernate;

import com.sjtu.admin.dao.SmallCatalogDao;
import com.sjtu.admin.model.MidCatalog;
import com.sjtu.admin.model.SmallCatalog;
import com.sjtu.dao.hibernate.BaseDaoHibernate;
import org.springframework.orm.ObjectRetrievalFailureException;

import java.util.List;

public class SmallCatalogDaoHibernate extends BaseDaoHibernate implements
		SmallCatalogDao {

	/**
	 * @see com.sjtu.admin.dao.SmallCatalogDao#getSmallCatalogs(com.sjtu.admin.model.SmallCatalog)
	 */
	public List getSmallCatalogs(final SmallCatalog smallCatalog) {
		return getHibernateTemplate().find("from SmallCatalog");

		/*
		 * Remove the line above and uncomment this code block if you want to
		 * use Hibernate's Query by Example API. if (smallCatalog == null) {
		 * return getHibernateTemplate().find("from SmallCatalog"); } else { //
		 * filter on properties set in the smallCatalog HibernateCallback
		 * callback = new HibernateCallback() { public Object
		 * doInHibernate(Session session) throws HibernateException { Example ex =
		 * Example.create(smallCatalog).ignoreCase().enableLike(MatchMode.ANYWHERE);
		 * return session.createCriteria(SmallCatalog.class).add(ex).list(); } };
		 * return (List) getHibernateTemplate().execute(callback); }
		 */
	}

	/**
	 * @see com.sjtu.admin.dao.SmallCatalogDao#getSmallCatalog(Long
	 *      smallCatalogId)
	 */
	public SmallCatalog getSmallCatalog(final Long smallCatalogId) {
		SmallCatalog smallCatalog = (SmallCatalog) getHibernateTemplate().get(
				SmallCatalog.class, smallCatalogId);
		if (smallCatalog == null) {
			log.warn("uh oh, smallCatalog with smallCatalogId '"
					+ smallCatalogId + "' not found...");
			throw new ObjectRetrievalFailureException(SmallCatalog.class,
					smallCatalogId);
		}

		return smallCatalog;
	}

	/**
	 * @see com.sjtu.admin.dao.SmallCatalogDao#saveSmallCatalog(SmallCatalog
	 *      smallCatalog)
	 */
	public void saveSmallCatalog(final SmallCatalog smallCatalog) {
		getHibernateTemplate().saveOrUpdate(smallCatalog);
	}

	/**
	 * @see com.sjtu.admin.dao.SmallCatalogDao#removeSmallCatalog(Long
	 *      smallCatalogId)
	 */
	public void removeSmallCatalog(final Long smallCatalogId) {
		getHibernateTemplate().delete(getSmallCatalog(smallCatalogId));
	}

	public List getMidCatalogList() {
		return getHibernateTemplate().find(
				"from MidCatalog m order by m.midCatalogId asc");
	}

	public MidCatalog getMidCatalog(final String smallCatalogId) {
		SmallCatalog smallCatalog = (SmallCatalog) getHibernateTemplate().get(
				SmallCatalog.class, smallCatalogId);
		MidCatalog midCatalog = (MidCatalog) getHibernateTemplate().get(
				MidCatalog.class, smallCatalog.getMidCatalogId());
		return midCatalog;
	}

	public List getSmallCatalogByMidCatalogId(final String midCatalogId) {
		return getHibernateTemplate().find(
				"from SmallCatalog s where s.midCatalogId='" + midCatalogId
						+ "'order by s.smallCatalogId asc");
	}
}
