package com.sjtu.user.service.impl;

import com.sjtu.admin.model.Commodity;
import com.sjtu.model.User;
import com.sjtu.service.impl.BaseManager;
import com.sjtu.user.dao.CartCommodityDao;
import com.sjtu.user.model.CartCommodity;
import com.sjtu.user.service.CartCommodityManager;

import java.util.List;

public class CartCommodityManagerImpl extends BaseManager implements
		CartCommodityManager {
	private CartCommodityDao dao;

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setCartCommodityDao(CartCommodityDao dao) {
		this.dao = dao;
	}

	/**
	 * @see com.sjtu.user.service.CartCommodityManager#getCartCommoditys(com.sjtu.user.model.CartCommodity)
	 */
	public List getCartCommoditys(final CartCommodity cartCommodity) {
		return dao.getCartCommoditys(cartCommodity);
	}

	/**
	 * @see com.sjtu.user.service.CartCommodityManager#getCartCommodity(String
	 *      cartCommodityId)
	 */
	public CartCommodity getCartCommodity(final String cartCommodityId) {
		return dao.getCartCommodity(new Long(cartCommodityId));
	}

	/**
	 * @see com.sjtu.user.service.CartCommodityManager#saveCartCommodity(CartCommodity
	 *      cartCommodity)
	 */
	public void saveCartCommodity(CartCommodity cartCommodity) {
		dao.saveCartCommodity(cartCommodity);
	}

	/**
	 * @see com.sjtu.user.service.CartCommodityManager#removeCartCommodity(String
	 *      cartCommodityId)
	 */
	public void removeCartCommodity(final String cartCommodityId) {
		dao.removeCartCommodity(new Long(cartCommodityId));
	}

	public List getCartCommodityById() {
		return dao.getCartCommodityById();
	}

	public List getCommodityList() {
		return dao.getCommodityList();
	}

	public Commodity getCommodity(final String cartCommodityId) {
		return dao.getCommodity(new Long(cartCommodityId));
	}

	public User getUser(final String cartCommodityId) {
		return dao.getUser(new Long(cartCommodityId));
	}

	public List getCartCommodityByUser(final String userId) {
		return dao.getCartCommodityByUser(new Long(userId));
	}
}
