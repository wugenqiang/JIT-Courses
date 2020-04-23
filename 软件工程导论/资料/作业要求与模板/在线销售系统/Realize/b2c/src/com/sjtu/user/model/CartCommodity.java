package com.sjtu.user.model;

// Generated 2007-12-9 10:47:31 by Hibernate Tools 3.1.0.beta4

/**
 * @struts.form include-all="true" extends="BaseForm"
 * @hibernate.class table="cartCommodity"
 * 
 */

public class CartCommodity extends com.sjtu.model.BaseObject implements
		java.io.Serializable {

	// Fields

	private Long cartCommodityId;
	private Long commodityId;
	private Long userId;
	private Integer commodityNumber;

	// Constructors

	/** default constructor */
	public CartCommodity() {
	}

	/** full constructor */
	public CartCommodity(Long commodityId, Long orderId, Long userId,
			Integer commodityNumber) {
		this.commodityId = commodityId;
		this.userId = userId;
		this.commodityNumber = commodityNumber;
	}

	// Property accessors
	/**
	 * *
	 * 
	 * @hibernate.id generator-class="native" type="java.lang.Long"
	 *               column="cartCommodityId"
	 * 
	 */

	public Long getCartCommodityId() {
		return this.cartCommodityId;
	}

	public void setCartCommodityId(Long cartCommodityId) {
		this.cartCommodityId = cartCommodityId;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="commodityId" length="20" not-null="true"
	 * 
	 */

	public Long getCommodityId() {
		return this.commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="commodityNumber" length="10" not-null="true"
	 * 
	 */

	public Integer getCommodityNumber() {
		return this.commodityNumber;
	}

	public void setCommodityNumber(Integer commodityNumber) {
		this.commodityNumber = commodityNumber;
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
		buffer.append("commodityId").append("='").append(getCommodityId())
				.append("' ");
		buffer.append("userId").append("='").append(getUserId()).append("' ");
		buffer.append("commodityNumber").append("='").append(
				getCommodityNumber()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CartCommodity))
			return false;
		CartCommodity castOther = (CartCommodity) other;

		return ((this.getCartCommodityId() == castOther.getCartCommodityId()) || (this
				.getCartCommodityId() != null
				&& castOther.getCartCommodityId() != null && this
				.getCartCommodityId().equals(castOther.getCartCommodityId())))
				&& ((this.getCommodityId() == castOther.getCommodityId()) || (this
						.getCommodityId() != null
						&& castOther.getCommodityId() != null && this
						.getCommodityId().equals(castOther.getCommodityId())))
				&& ((this.getUserId() == castOther.getUserId()) || this
						.getUserId() != null
						&& castOther.getUserId() != null
						&& this.getUserId().equals(castOther.getUserId()))
				&& ((this.getCommodityNumber() == castOther
						.getCommodityNumber()) || this.getCommodityNumber() != null
						&& castOther.getCommodityNumber() != null
						&& this.getCommodityNumber().equals(
								castOther.getCommodityNumber()));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCartCommodityId() == null ? 0 : this.getCartCommodityId()
						.hashCode());
		result = 37
				* result
				+ (getCommodityId() == null ? 0 : this.getCommodityId()
						.hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37
				* result
				+ (getCommodityNumber() == null ? 0 : this.getCommodityNumber()
						.hashCode());

		return result;
	}

}
