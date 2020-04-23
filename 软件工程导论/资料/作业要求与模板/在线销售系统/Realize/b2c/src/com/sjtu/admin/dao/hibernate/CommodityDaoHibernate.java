package com.sjtu.admin.dao.hibernate;

import com.sjtu.admin.dao.CommodityDao;
import com.sjtu.admin.model.Commodity;
import com.sjtu.admin.model.SmallCatalog;
import com.sjtu.dao.hibernate.BaseDaoHibernate;
import org.springframework.orm.ObjectRetrievalFailureException;

import java.util.List;

public class CommodityDaoHibernate extends BaseDaoHibernate implements
		CommodityDao {

	/**
	 * @see com.sjtu.admin.dao.CommodityDao#getCommoditys(com.sjtu.admin.model.Commodity)
	 */
	public List getCommoditys(final Commodity commodity) {
		return getHibernateTemplate().find("from Commodity");

		/*
		 * Remove the line above and uncomment this code block if you want to
		 * use Hibernate's Query by Example API. if (commodity == null) { return
		 * getHibernateTemplate().find("from Commodity"); } else { // filter on
		 * properties set in the commodity HibernateCallback callback = new
		 * HibernateCallback() { public Object doInHibernate(Session session)
		 * throws HibernateException { Example ex =
		 * Example.create(commodity).ignoreCase().enableLike(MatchMode.ANYWHERE);
		 * return session.createCriteria(Commodity.class).add(ex).list(); } };
		 * return (List) getHibernateTemplate().execute(callback); }
		 */
	}

	/**
	 * @see com.sjtu.admin.dao.CommodityDao#getCommodity(Long commodityId)
	 */
	public Commodity getCommodity(final Long commodityId) {
		Commodity commodity = (Commodity) getHibernateTemplate().get(
				Commodity.class, commodityId);
		if (commodity == null) {
			log.warn("uh oh, commodity with commodityId '" + commodityId
					+ "' not found...");
			throw new ObjectRetrievalFailureException(Commodity.class,
					commodityId);
		}

		return commodity;
	}

	/**
	 * @see com.sjtu.admin.dao.CommodityDao#saveCommodity(Commodity commodity)
	 */
	public void saveCommodity(final Commodity commodity) {
		getHibernateTemplate().saveOrUpdate(commodity);
	}

	/**
	 * @see com.sjtu.admin.dao.CommodityDao#removeCommodity(Long commodityId)
	 */
	public void removeCommodity(final Long commodityId) {
		getHibernateTemplate().delete(getCommodity(commodityId));
	}

	public List getSmallCatalogList() {
		return getHibernateTemplate().find(
				"from SmallCatalog s order by s.smallCatalogId asc");

	}

	public List getCommodityBySmallCatalog() {
		return getHibernateTemplate().find(
				"from Commodity c order by c.smallCatalogId asc");
	}

	public SmallCatalog getSmallCatalog(final Long commodityId) {
		Commodity commodity = (Commodity) getHibernateTemplate().get(
				Commodity.class, commodityId);
		SmallCatalog smallCatalog = (SmallCatalog) getHibernateTemplate().get(
				SmallCatalog.class, commodity.getSmallCatalogId());
		return smallCatalog;

	}
}
