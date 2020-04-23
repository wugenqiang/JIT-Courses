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
public class CartCommodityForm extends BaseForm implements java.io.Serializable {
	protected String cartCommodityId;
	protected String userId;
	protected String commodityId;
	protected String commodityNumber;

	public CartCommodityForm() {
	}

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
	 * @return the commodityId
	 */
	public String getCommodityId() {
		return commodityId;
	}

	/**
	 * @param commodityId
	 *            the commodityId to set
	 */
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	/**
	 * @return the commodityNumber
	 */
	public String getCommodityNumber() {
		return commodityNumber;
	}

	/**
	 * @param commodityNumber
	 *            the commodityNumber to set
	 */
	public void setCommodityNumber(String commodityNumber) {
		this.commodityNumber = commodityNumber;
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
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping,
	 *      javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// reset any boolean data types to false
		this.cartCommodityId = null;
		this.commodityId = null;
		this.commodityNumber = null;
		this.userId = null;

	}

}
