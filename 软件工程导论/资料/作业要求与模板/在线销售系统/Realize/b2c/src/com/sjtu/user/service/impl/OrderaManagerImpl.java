package com.sjtu.user.service.impl;

import com.sjtu.model.User;
import com.sjtu.service.impl.BaseManager;
import com.sjtu.user.dao.OrderaDao;
import com.sjtu.user.model.CartCommodity;
import com.sjtu.user.model.Ordera;
import com.sjtu.user.service.OrderaManager;

import java.util.List;

public class OrderaManagerImpl extends BaseManager implements OrderaManager {
	private OrderaDao dao;

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setOrderaDao(OrderaDao dao) {
		this.dao = dao;
	}

	/**
	 * @see com.sjtu.user.service.OrderaManager#getOrderas(com.sjtu.user.model.Ordera)
	 */
	public List getOrderas(final Ordera ordera) {
		return dao.getOrderas(ordera);
	}

	/**
	 * @see com.sjtu.user.service.OrderaManager#getOrdera(String orderaId)
	 */
	public Ordera getOrdera(final String orderaId) {
		return dao.getOrdera(new Long(orderaId));
	}

	/**
	 * @see com.sjtu.user.service.OrderaManager#saveOrdera(Ordera ordera)
	 */
	public void saveOrdera(Ordera ordera) {
		dao.saveOrdera(ordera);
	}

	/**
	 * @see com.sjtu.user.service.OrderaManager#removeOrdera(String orderaId)
	 */
	public void removeOrdera(final String orderaId) {
		dao.removeOrdera(new Long(orderaId));
	}

	public List getOrderaByUser(final Long userId) {
		return dao.getOrderaByUser(new Long(userId));
	}

	public User getUser(final String orderaId) {
		return dao.getUser(orderaId);
	}

	public CartCommodity getCartCommodity(final String orderaId) {
		return dao.getCartCommodity(orderaId);
	}

	public List getCartCommodityList() {
		return dao.getCartCommodityList();
	}	
}
