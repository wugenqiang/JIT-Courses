/**
 * 
 */
package com.sjtu.user.webapp.form;

import com.sjtu.webapp.form.BaseForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wang
 * 
 */
public class CartForm extends BaseForm implements java.io.Serializable {
	protected String cartId;
	protected String userId;
	protected String cartCommodityNumber;

	public CartForm() {
	}

	/**
	 * @return the cartId
	 */
	public String getCartId() {
		return cartId;
	}

	/**
	 * @param cartId
	 *            the cartId to set
	 */
	public void setCartId(String cartId) {
		this.cartId = cartId;
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
	 * @return the cartCommodityNumber
	 */
	public String getCartCommodityNumber() {
		return cartCommodityNumber;
	}

	/**
	 * @param cartCommodityNumber
	 *            the cartCommodityNumber to set
	 */
	public void setCartCommodityNumber(String cartCommodityNumber) {
		this.cartCommodityNumber = cartCommodityNumber;
	}

	/**
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping,
	 *      javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// reset any boolean data types to false

	}
}
