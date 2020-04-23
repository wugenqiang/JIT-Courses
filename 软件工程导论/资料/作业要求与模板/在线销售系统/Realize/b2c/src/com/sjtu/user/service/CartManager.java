package com.sjtu.user.service;

import com.sjtu.model.User;
import com.sjtu.service.Manager;
import com.sjtu.user.model.Cart;

import java.util.List;

public interface CartManager extends Manager {
	/**
	 * Retrieves all of the carts
	 */
	public List getCarts(Cart cart);

	/**
	 * Gets cart's information based on cartId.
	 * 
	 * @param cartId
	 *            the cart's cartId
	 * @return cart populated cart object
	 */
	public Cart getCart(final String cartId);

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
	public void removeCart(final String cartId);

	public List getCartCommodityList();

	public User getCartUser(final String cartId);
}
