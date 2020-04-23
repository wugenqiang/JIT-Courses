package com.sjtu.user.service.impl;

import com.sjtu.model.User;
import com.sjtu.service.impl.BaseManager;
import com.sjtu.user.dao.CartDao;
import com.sjtu.user.model.Cart;
import com.sjtu.user.service.CartManager;

import java.util.List;

public class CartManagerImpl extends BaseManager implements CartManager {
	private CartDao dao;

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setCartDao(CartDao dao) {
		this.dao = dao;
	}

	/**
	 * @see com.sjtu.user.service.CartManager#getCarts(com.sjtu.user.model.Cart)
	 */
	public List getCarts(final Cart cart) {
		return dao.getCarts(cart);
	}

	/**
	 * @see com.sjtu.user.service.CartManager#getCart(String cartId)
	 */
	public Cart getCart(final String cartId) {
		return dao.getCart(new Long(cartId));
	}

	/**
	 * @see com.sjtu.user.service.CartManager#saveCart(Cart cart)
	 */
	public void saveCart(Cart cart) {
		dao.saveCart(cart);
	}

	/**
	 * @see com.sjtu.user.service.CartManager#removeCart(String cartId)
	 */
	public void removeCart(final String cartId) {
		dao.removeCart(new Long(cartId));
	}

	public List getCartCommodityList() {
		return dao.getCartCommodityList();
	}

	public User getCartUser(final String cartId) {
		return dao.getCartUser(cartId);
	}
}
