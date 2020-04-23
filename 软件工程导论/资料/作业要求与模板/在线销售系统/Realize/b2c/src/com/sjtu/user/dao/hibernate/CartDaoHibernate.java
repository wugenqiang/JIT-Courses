package com.sjtu.user.dao.hibernate;

import com.sjtu.dao.hibernate.BaseDaoHibernate;
import com.sjtu.model.User;
import com.sjtu.user.dao.CartDao;
import com.sjtu.user.model.Cart;
import org.springframework.orm.ObjectRetrievalFailureException;

import java.util.List;

public class CartDaoHibernate extends BaseDaoHibernate implements CartDao {

	/**
	 * @see com.sjtu.user.dao.CartDao#getCarts(com.sjtu.user.model.Cart)
	 */
	public List getCarts(final Cart cart) {
		return getHibernateTemplate().find("from Cart");

		/*
		 * Remove the line above and uncomment this code block if you want to
		 * use Hibernate's Query by Example API. if (cart == null) { return
		 * getHibernateTemplate().find("from Cart"); } else { // filter on
		 * properties set in the cart HibernateCallback callback = new
		 * HibernateCallback() { public Object doInHibernate(Session session)
		 * throws HibernateException { Example ex =
		 * Example.create(cart).ignoreCase().enableLike(MatchMode.ANYWHERE);
		 * return session.createCriteria(Cart.class).add(ex).list(); } }; return
		 * (List) getHibernateTemplate().execute(callback); }
		 */
	}

	/**
	 * @see com.sjtu.user.dao.CartDao#getCart(Long cartId)
	 */
	public Cart getCart(final Long cartId) {
		Cart cart = (Cart) getHibernateTemplate().get(Cart.class, cartId);
		if (cart == null) {
			log.warn("uh oh, cart with cartId '" + cartId + "' not found...");
			throw new ObjectRetrievalFailureException(Cart.class, cartId);
		}

		return cart;
	}

	/**
	 * @see com.sjtu.user.dao.CartDao#saveCart(Cart cart)
	 */
	public void saveCart(final Cart cart) {
		getHibernateTemplate().saveOrUpdate(cart);
	}

	/**
	 * @see com.sjtu.user.dao.CartDao#removeCart(Long cartId)
	 */
	public void removeCart(final Long cartId) {
		getHibernateTemplate().delete(getCart(cartId));
	}

	public List getCartCommodityList() {
		return getHibernateTemplate().find(
				"from CartCommodity c order by c.cartCommodityId asc");
	}

	public User getCartUser(final String cartId) {
		Cart cart = (Cart) getHibernateTemplate().get(Cart.class, cartId);
		User user = (User) getHibernateTemplate().get(User.class,
				cart.getUserId());
		return user;

	}
}
