package com.sjtu.user.service;

import com.sjtu.model.User;
import com.sjtu.service.Manager;
import com.sjtu.user.model.CartCommodity;
import com.sjtu.user.model.Ordera;

import java.util.List;

public interface OrderaManager extends Manager {
	/**
	 * Retrieves all of the orderas
	 */
	public List getOrderas(Ordera ordera);

	/**
	 * Gets ordera's information based on orderaId.
	 * 
	 * @param orderaId
	 *            the ordera's orderaId
	 * @return ordera populated ordera object
	 */
	public Ordera getOrdera(final String orderaId);

	/**
	 * Saves a ordera's information
	 * 
	 * @param ordera
	 *            the object to be saved
	 */
	public void saveOrdera(Ordera ordera);

	/**
	 * Removes a ordera from the database by orderaId
	 * 
	 * @param orderaId
	 *            the ordera's orderaId
	 */
	public void removeOrdera(final String orderaId);

	public List getOrderaByUser(final Long userId);

	public User getUser(final String orderaId);

	public CartCommodity getCartCommodity(final String orderaId);

	public List getCartCommodityList();
}
