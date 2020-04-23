/**
 * 
 */
package com.sjtu.user.webapp.form;

import com.sjtu.webapp.form.BaseForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author wang
 * 
 */
public class OrderaForm extends BaseForm implements java.io.Serializable {

	protected String orderaId;

	protected String userId;

	protected String totalPrice;

	protected String totalDiscount;

	protected String orderaTime;

	protected String cartCommodityId;

	/**
	 * @return the cartCommodityId
	 */
	public String getCartCommodityId() {
		return cartCommodityId;
	}

	/**
	 * @param cartCommodityId
	 *            the cartCommodityId to set
	 */
	public void setCartCommodityId(String cartCommodityId) {
		this.cartCommodityId = cartCommodityId;
	}

	/**
	 * @param orderaTime
	 *            the orderaTime to set
	 */
	public void setOrderaTime(String orderaTime) {
		this.orderaTime = orderaTime;
	}

	public OrderaForm() {
	}

	/**
	 * @return the orderaId
	 */
	public String getOrderaId() {
		return orderaId;
	}

	/**
	 * @param orderaId
	 *            the orderaId to set
	 */
	public void setOrderaId(String orderaId) {
		this.orderaId = orderaId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the totalPrice
	 */
	public String getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the totalDiscount
	 */
	public String getTotalDiscount() {
		return totalDiscount;
	}

	/**
	 * @param totalDiscount
	 *            the totalDiscount to set
	 */
	public void setTotalDiscount(String totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	/**
	 * @return the orderaTime
	 */
	public String getOrderaTime() {
		return orderaTime;
	}

	/**
	 * @param orderaTime
	 *            the orderaTime to set
	 */
	public void setOrderaTime(Date date) {
		this.orderaTime = date.toLocaleString();
	}

	/**
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping,
	 *      javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// reset any boolean data types to false
		this.cartCommodityId = null;
		this.orderaId = null;
		this.orderaTime = null;
		this.totalDiscount = null;
		this.totalPrice = null;
		this.userId = null;

	}
}
