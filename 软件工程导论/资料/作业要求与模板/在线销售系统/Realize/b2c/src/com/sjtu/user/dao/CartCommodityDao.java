package com.sjtu.user.dao;

import com.sjtu.admin.model.Commodity;
import com.sjtu.dao.Dao;
import com.sjtu.model.User;
import com.sjtu.user.model.CartCommodity;

import java.util.List;

public interface CartCommodityDao extends Dao {

	/**
	 * Retrieves all of the cartCommoditys
	 */
	public List getCartCommoditys(CartCommodity cartCommodity);

	/**
	 * Gets cartCommodity's information based on primary key. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 * 
	 * @param cartCommodityId
	 *            the cartCommodity's cartCommodityId
	 * @return cartCommodity populated cartCommodity object
	 */
	public CartCommodity getCartCommodity(final Long cartCommodityId);

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
	public void removeCartCommodity(final Long cartCommodityId);

	public List getCartCommodityById();

	public List getCommodityList();

	public Commodity getCommodity(final Long cartCommodityId);

	public User getUser(final Long cartCommodityId);

	public List getCartCommodityByUser(final Long userId);
}
