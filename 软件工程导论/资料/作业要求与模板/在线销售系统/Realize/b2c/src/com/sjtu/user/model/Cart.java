package com.sjtu.user.model;

// Generated 2007-12-9 10:47:32 by Hibernate Tools 3.1.0.beta4

/**
 * @struts.form include-all="true" extends="BaseForm"
 * @hibernate.class table="cart"
 * 
 */

public class Cart extends com.sjtu.model.BaseObject implements
		java.io.Serializable {

	// Fields

	private Long cartId;

	private Long userId;

	private int cartCommodityNumber;

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** minimal constructor */
	public Cart(int cartCommodityNumber) {
		this.cartCommodityNumber = cartCommodityNumber;
	}

	/** full constructor */
	public Cart(Long userId, int cartCommodityNumber) {
		this.userId = userId;
		this.cartCommodityNumber = cartCommodityNumber;
	}

	// Property accessors
	/**
	 * *
	 * 
	 * @hibernate.id generator-class="native" type="java.lang.Long"
	 *               column="cartId"
	 * 
	 */

	public Long getCartId() {
		return this.cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="userId" length="20"
	 * 
	 */

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="cartCommodityNumber" length="10"
	 *                     not-null="true"
	 * 
	 */

	public int getCartCommodityNumber() {
		return this.cartCommodityNumber;
	}

	public void setCartCommodityNumber(int cartCommodityNumber) {
		this.cartCommodityNumber = cartCommodityNumber;
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(
				Integer.toHexString(hashCode())).append(" [");
		buffer.append("userId").append("='").append(getUserId()).append("' ");
		buffer.append("cartCommodityNumber").append("='").append(
				getCartCommodityNumber()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Cart))
			return false;
		Cart castOther = (Cart) other;

		return ((this.getCartId() == castOther.getCartId()) || (this
				.getCartId() != null
				&& castOther.getCartId() != null && this.getCartId().equals(
				castOther.getCartId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null
						&& castOther.getUserId() != null && this.getUserId()
						.equals(castOther.getUserId())))
				&& (this.getCartCommodityNumber() == castOther
						.getCartCommodityNumber());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCartId() == null ? 0 : this.getCartId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result + this.getCartCommodityNumber();
		return result;
	}

}
