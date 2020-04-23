/**
 * 
 */
package com.sjtu.user.model;

import com.sjtu.model.User;
import org.apache.struts.action.ActionServlet;

/**
 * @author wang
 * 
 */
public class CartEncapsulation {

	public Cart cart = null;

	public User user = null;

	public ActionServlet servlet = null;

	/**
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * @param cart
	 *            the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the servlet
	 */
	public ActionServlet getServlet() {
		return servlet;
	}

	/**
	 * @param servlet
	 *            the servlet to set
	 */
	public void setServlet(ActionServlet servlet) {
		this.servlet = servlet;
	}

	public CartEncapsulation() {
		super();
	}

	public CartEncapsulation(Cart cart, User user, ActionServlet servlet) {
		this.cart = cart;
		this.servlet = servlet;
		this.user = user;
	}

}
