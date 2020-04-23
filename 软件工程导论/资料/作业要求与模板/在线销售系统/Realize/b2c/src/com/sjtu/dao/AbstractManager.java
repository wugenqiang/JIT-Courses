/**
 * 
 */
package com.sjtu.dao;

/**
 * @author wang
 *
 */

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.impl.CriteriaImpl;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

public class AbstractManager extends HibernateDaoSupport{
	private boolean cacheQueries = false;

	private String queryCacheRegion;

	public void setCacheQueries(boolean cacheQueries) {
		this.cacheQueries = cacheQueries;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	public void save(final Object entity) {
		getHibernateTemplate().save(entity);
	}

	public void persist(final Object entity) {
		getHibernateTemplate().save(entity);
	}

	public void update(final Object entity) {
		getHibernateTemplate().update(entity);
	}

	public void delete(final Object entity) {
		getHibernateTemplate().delete(entity);
	}

	public Object load(final Class entity, final Serializable id) {
		return getHibernateTemplate().load(entity, id);
	}

	public Object get(final Class entity, final Serializable id) {
		return getHibernateTemplate().get(entity, id);
	}

	public List findAll(final Class entity) {
		return getHibernateTemplate().find("from " + entity.getName());
	}

	public List findByNamedQuery(final String namedQuery) {
		return getHibernateTemplate().findByNamedQuery(namedQuery);
	}

	public List findByNamedQuery(final String query, final Object parameter) {
		return getHibernateTemplate().findByNamedQuery(query, parameter);
	}

	public List findByNamedQuery(final String query, final Object[] parameters) {
		return getHibernateTemplate().findByNamedQuery(query, parameters);
	}

	public List find(final String query) {
		return getHibernateTemplate().find(query);
	}

	public List find(final String query, final Object parameter) {
		return getHibernateTemplate().find(query, parameter);
	}

	
	public List findAllByCriteria(final DetachedCriteria detachedCriteria) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				return criteria.list();
			}
		}, true);
	}

	public int getCountByCriteria(final DetachedCriteria detachedCriteria) {
		Integer count = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				CriteriaImpl impl = (CriteriaImpl) criteria;
				// �Ȱ�Projection���ȡ��?4,������4ִ��Count����
				Projection projection = impl.getProjection();
				int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				criteria.setProjection(projection);
				if (projection == null) {
					criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
				}
				return totalCount;
			}
		}, true);
		return count.intValue();
	}
}
