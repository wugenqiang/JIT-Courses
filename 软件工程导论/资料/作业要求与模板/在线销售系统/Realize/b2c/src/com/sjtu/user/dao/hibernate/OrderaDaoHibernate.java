package com.sjtu.user.dao.hibernate;

import com.sjtu.dao.hibernate.BaseDaoHibernate;
import com.sjtu.model.User;
import com.sjtu.user.dao.OrderaDao;
import com.sjtu.user.model.CartCommodity;
import com.sjtu.user.model.Ordera;
import org.springframework.orm.ObjectRetrievalFailureException;

import java.util.List;

public class OrderaDaoHibernate extends BaseDaoHibernate implements OrderaDao {

	/**
	 * @see com.sjtu.user.dao.OrderaDao#getOrderas(com.sjtu.user.model.Ordera)
	 */
	public List getOrderas(final Ordera ordera) {
		return getHibernateTemplate().find("from Ordera");

		/*
		 * Remove the line above and uncomment this code block if you want to
		 * use Hibernate's Query by Example API. if (ordera == null) { return
		 * getHibernateTemplate().find("from Ordera"); } else { // filter on
		 * properties set in the ordera HibernateCallback callback = new
		 * HibernateCallback() { public Object doInHibernate(Session session)
		 * throws HibernateException { Example ex =
		 * Example.create(ordera).ignoreCase().enableLike(MatchMode.ANYWHERE);
		 * return session.createCriteria(Ordera.class).add(ex).list(); } };
		 * return (List) getHibernateTemplate().execute(callback); }
		 */
	}

	/**
	 * @see com.sjtu.user.dao.OrderaDao#getOrdera(Long orderaId)
	 */
	public Ordera getOrdera(final Long orderaId) {
		Ordera ordera = (Ordera) getHibernateTemplate().get(Ordera.class,
				orderaId);
		if (ordera == null) {
			log.warn("uh oh, ordera with orderaId '" + orderaId
					+ "' not found...");
			throw new ObjectRetrievalFailureException(Ordera.class, orderaId);
		}

		return ordera;
	}

	/**
	 * @see com.sjtu.user.dao.OrderaDao#saveOrdera(Ordera ordera)
	 */
	public void saveOrdera(final Ordera ordera) {
		getHibernateTemplate().saveOrUpdate(ordera);
	}

	/**
	 * @see com.sjtu.user.dao.OrderaDao#removeOrdera(Long orderaId)
	 */
	public void removeOrdera(final Long orderaId) {
		getHibernateTemplate().delete(getOrdera(orderaId));
	}

	public List getOrderaByUser(final Long userId) {
		return getHibernateTemplate().find(
				"from Ordera o where o.userId='" + userId
						+ "' order by o.orderaId asc");
	}

	public User getUser(final String orderaId) {
		Ordera ordera = (Ordera) getHibernateTemplate().get(Ordera.class,
				orderaId);
		User user = (User) getHibernateTemplate().get(User.class,
				ordera.getUserId());
		return user;
	}

	public CartCommodity getCartCommodity(final String orderaId) {
		Ordera ordera = (Ordera) getHibernateTemplate().get(Ordera.class,
				orderaId);
		CartCommodity cartCommodity = (CartCommodity) getHibernateTemplate()
				.get(CartCommodity.class, ordera.getCartCommodityId());
		return cartCommodity;
	}

	public List getCartCommodityList() {
		return getHibernateTemplate().find(
				"from CartCommodity c order by c.cartCommodityId asc");
	}
}
