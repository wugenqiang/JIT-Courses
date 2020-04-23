package com.sjtu.user.dao.hibernate;

import com.sjtu.admin.model.Commodity;
import com.sjtu.dao.hibernate.BaseDaoHibernate;
import com.sjtu.model.User;
import com.sjtu.user.dao.CartCommodityDao;
import com.sjtu.user.model.CartCommodity;
import org.springframework.orm.ObjectRetrievalFailureException;

import java.util.List;

public class CartCommodityDaoHibernate extends BaseDaoHibernate implements
		CartCommodityDao {

	/**
	 * @see com.sjtu.user.dao.CartCommodityDao#getCartCommoditys(com.sjtu.user.model.CartCommodity)
	 */
	public List getCartCommoditys(final CartCommodity cartCommodity) {
		return getHibernateTemplate().find("from CartCommodity");

		/*
		 * Remove the line above and uncomment this code block if you want to
		 * use Hibernate's Query by Example API. if (cartCommodity == null) {
		 * return getHibernateTemplate().find("from CartCommodity"); } else { //
		 * filter on properties set in the cartCommodity HibernateCallback
		 * callback = new HibernateCallback() { public Object
		 * doInHibernate(Session session) throws HibernateException { Example ex =
		 * Example.create(cartCommodity).ignoreCase().enableLike(MatchMode.ANYWHERE);
		 * return session.createCriteria(CartCommodity.class).add(ex).list(); } };
		 * return (List) getHibernateTemplate().execute(callback); }
		 */
	}

	/**
	 * @see com.sjtu.user.dao.CartCommodityDao#getCartCommodity(Long
	 *      cartCommodityId)
	 */
	public CartCommodity getCartCommodity(final Long cartCommodityId) {
		CartCommodity cartCommodity = (CartCommodity) getHibernateTemplate()
				.get(CartCommodity.class, cartCommodityId);
		if (cartCommodity == null) {
			log.warn("uh oh, cartCommodity with cartCommodityId '"
					+ cartCommodityId + "' not found...");
			throw new ObjectRetrievalFailureException(CartCommodity.class,
					cartCommodityId);
		}

		return cartCommodity;
	}

	/**
	 * @see com.sjtu.user.dao.CartCommodityDao#saveCartCommodity(CartCommodity
	 *      cartCommodity)
	 */
	public void saveCartCommodity(final CartCommodity cartCommodity) {
		getHibernateTemplate().saveOrUpdate(cartCommodity);
	}

	/**
	 * @see com.sjtu.user.dao.CartCommodityDao#removeCartCommodity(Long
	 *      cartCommodityId)
	 */
	public void removeCartCommodity(final Long cartCommodityId) {
		getHibernateTemplate().delete(getCartCommodity(cartCommodityId));
	}

	public List getCartCommodityById() {
		return getHibernateTemplate().find(
				"from CartCommodity c order by c.cartCommodityId asc");

	}

	public List getCommodityList() {
		return getHibernateTemplate().find(
				"from Commodity c order by c.commodityId asc");

	}

	public Commodity getCommodity(final Long cartCommodityId) {
		CartCommodity cartCommodity = (CartCommodity) getHibernateTemplate()
				.get(CartCommodity.class, cartCommodityId);
		Commodity commodity = (Commodity) getHibernateTemplate().get(
				Commodity.class, cartCommodity.getCommodityId());
		return commodity;
	}

	public User getUser(final Long cartCommodityId) {
		CartCommodity cartCommodity = (CartCommodity) getHibernateTemplate()
				.get(CartCommodity.class, cartCommodityId);
		User user = (User) getHibernateTemplate().get(User.class,
				cartCommodity.getUserId());
		return user;
	}

	public List getCartCommodityByUser(final Long userId) {
		return getHibernateTemplate().find(
				"from CartCommodity c where c.userId='" + userId
						+ "'order by c.cartCommodityId asc");
	}
}
