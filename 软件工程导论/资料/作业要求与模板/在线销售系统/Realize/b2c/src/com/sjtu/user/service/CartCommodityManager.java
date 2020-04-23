package com.sjtu.user.service;

import com.sjtu.admin.model.Commodity;
import com.sjtu.model.User;
import com.sjtu.service.Manager;
import com.sjtu.user.model.CartCommodity;

import java.util.List;

public interface CartCommodityManager extends Manager {
	/**
	 * Retrieves all of the cartCommoditys
	 */
	public List getCartCommoditys(CartCommodity cartCommodity);

	/**
	 * Gets cartCommodity's information based on cartCommodityId.
	 * 
	 * @param cartCommodityId
	 *            the cartCommodity's cartCommodityId
	 * @return cartCommodity populated cartCommodity object
	 */
	public CartCommodity getCartCommodity(final String cartCommodityId);

	/**
	 * Saves a cartCommodity's information
	 * 
	 * @param cartCommodity
	 *            the object to be saved
	 */
	public void saveCartCommodity(CartCommodity cartCommodity);

	/**
	 * Removes a cartCommodity from the database by cartCommodityId
	 * 
	 * @param cartCommodityId
	 *            the cartCommodity's cartCommodityId
	 */
	public void removeCartCommodity(final String cartCommodityId);

	public List getCommodityList();

	public List getCartCommodityById();

	public Commodity getCommodity(final String cartCommodityId);

	public User getUser(final String cartCommodityId);

	public List getCartCommodityByUser(final String userId);
}
