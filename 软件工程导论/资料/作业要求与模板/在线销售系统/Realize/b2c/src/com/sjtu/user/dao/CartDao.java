package com.sjtu.user.dao;

import com.sjtu.dao.Dao;
import com.sjtu.model.User;
import com.sjtu.user.model.Cart;

import java.util.List;

public interface CartDao extends Dao {

	/**
	 * Retrieves all of the carts
	 */
	public List getCarts(Cart cart);

	/**
	 * Gets cart's information based on primary key. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 * 
	 * @param cartId
	 *            the cart's cartId
	 * @return cart populated cart object
	 */
	public Cart getCart(final Long cartId);

	/**
	 * Saves a cart's information
	 * 
	 * @param cart
	 *            the object to be saved
	 */
	public void saveCart(Cart cart);

	/**
	 * Removes a cart from the database by cartId
	 * 
	 * @param cartId
	 *            the cart's cartId
	 */
	public void removeCart(final Long cartId);

	public List getCartCommodityList();

	public User getCartUser(final String cartId);
}
