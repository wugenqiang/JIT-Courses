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
public class CartCommodityEncapsulation {

	public CartCommodity cartCommodity = null;

	public Commodity commodity = null;

	public User user = null;

	public ActionServlet servlet = null;

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

	public CartCommodityEncapsulation() {
		super();
	}

	public CartCommodityEncapsulation(CartCommodity cartCommodity,
			Commodity commodity, User user, ActionServlet servlet) {
		this.cartCommodity = cartCommodity;
		this.commodity = commodity;
		this.user = user;
		this.servlet = servlet;
	}

}
