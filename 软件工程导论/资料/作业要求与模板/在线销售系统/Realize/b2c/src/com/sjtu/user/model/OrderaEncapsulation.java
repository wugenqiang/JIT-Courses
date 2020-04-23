/**
 * 
 */
package com.sjtu.user.model;

import com.sjtu.admin.model.Commodity;
import com.sjtu.model.User;
import org.apache.struts.action.ActionServlet;

/**
 * @author wang
 * 
 */
public class OrderaEncapsulation {

	public Ordera ordera = null;

	public User user = null;

	public CartCommodity cartCommodity = null;

	public Commodity commodity = null;

	public ActionServlet servlet = null;

	/**
	 * @return the ordera
	 */
	public Ordera getOrdera() {
		return ordera;
	}

	/**
	 * @param ordera
	 *            the ordera to set
	 */
	public void setOrdera(Ordera ordera) {
		this.ordera = ordera;
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
	 * @return the cartCommodity
	 */
	public CartCommodity getCartCommodity() {
		return cartCommodity;
	}

	/**
	 * @param cartCommodity
	 *            the cartCommodity to set
	 */
	public void setCartCommodity(CartCommodity cartCommodity) {
		this.cartCommodity = cartCommodity;
	}

	/**
	 * @return the commodity
	 */
	public Commodity getCommodity() {
		return commodity;
	}

	/**
	 * @param commodity
	 *            the commodity to set
	 */
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
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

	public OrderaEncapsulation() {
		super();
	}

	public OrderaEncapsulation(Ordera ordera, User user, Commodity commodity,
			CartCommodity cartCommodity, ActionServlet servlet) {
		this.cartCommodity = cartCommodity;
		this.commodity = commodity;
		this.ordera = ordera;
		this.user = user;
		this.servlet = servlet;
	}

}
