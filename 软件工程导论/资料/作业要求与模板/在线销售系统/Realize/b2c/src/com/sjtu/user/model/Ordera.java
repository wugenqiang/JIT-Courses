package com.sjtu.user.model;

// Generated 2007-12-9 10:47:31 by Hibernate Tools 3.1.0.beta4

import java.sql.Timestamp;

/**
 * @struts.form include-all="true" extends="BaseForm"
 * @hibernate.class table="ordera"
 * 
 */

public class Ordera extends com.sjtu.model.BaseObject implements
		java.io.Serializable {

	// Fields

	private Long orderaId;
	private Long userId;
	private Long cartCommodityId;
	private Float totalPrice;
	private Float totalDiscount;
	private Timestamp orderaTime;

	// Constructors

	/** default constructor */
	public Ordera() {
	}

	/** full constructor */
	public Ordera(Long userId, Long cartCommodityId, Float totalPrice,
			Float totalDiscount, Timestamp orderaTime) {
		this.userId = userId;
		this.cartCommodityId = cartCommodityId;
		this.totalPrice = totalPrice;
		this.totalDiscount = totalDiscount;
		this.orderaTime = orderaTime;
	}

	// Property accessors
	/**
	 * *
	 * 
	 * @hibernate.id generator-class="native" type="java.lang.Long"
	 *               column="orderaId"
	 * 
	 */

	public Long getOrderaId() {
		return this.orderaId;
	}

	public void setOrderaId(Long orderaId) {
		this.orderaId = orderaId;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="userId" length="20" not-null="true"
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
	 * @hibernate.property column="totalPrice" length="8" not-null="true"
	 * 
	 */

	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="totalDiscount" length="8" not-null="true"
	 * 
	 */

	public Float getTotalDiscount() {
		return this.totalDiscount;
	}

	public void setTotalDiscount(Float totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	/**
	 * @return the cartCommodityId
	 */
	public Long getCartCommodityId() {
		return cartCommodityId;
	}

	/**
	 * @param cartCommodityId
	 *            the cartCommodityId to set
	 */
	public void setCartCommodityId(Long cartCommodityId) {
		this.cartCommodityId = cartCommodityId;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="orderaTime" length="19" not-null="true"
	 * 
	 */

	public Timestamp getOrderaTime() {
		return this.orderaTime;
	}

	public void setOrderaTime(Timestamp orderaTime) {
		this.orderaTime = orderaTime;
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
		buffer.append("totalPrice").append("='").append(getTotalPrice())
				.append("' ");
		buffer.append("totalDiscount").append("='").append(getTotalDiscount())
				.append("' ");
		buffer.append("orderaTime").append("='").append(getOrderaTime())
				.append("' ");
		buffer.append("cartCommodityId").append("='").append(
				getCartCommodityId()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Ordera))
			return false;
		Ordera castOther = (Ordera) other;

		return ((this.getOrderaId() == castOther.getOrderaId()) || (this
				.getOrderaId() != null
				&& castOther.getOrderaId() != null && this.getOrderaId()
				.equals(castOther.getOrderaId())))
				&& ((this.getUserId() == castOther.getUserId()) || this
						.getUserId() != null
						&& castOther.getUserId() != null
						&& this.getUserId().equals(castOther.getUserId()))
				&& ((this.getTotalPrice() == castOther.getTotalPrice()) || this
						.getTotalPrice() != null
						&& castOther.getTotalPrice() != null
						&& this.getTotalPrice().equals(
								castOther.getTotalPrice()))
				&& ((this.getTotalDiscount() == castOther.getTotalDiscount()) || this
						.getTotalDiscount() != null
						&& castOther.getTotalDiscount() != null
						&& this.getTotalDiscount().equals(
								castOther.getTotalDiscount()))
				&& ((this.getCartCommodityId() == castOther
						.getCartCommodityId()) || (this.getCartCommodityId() != null
						&& castOther.getCartCommodityId() != null && this
						.getCartCommodityId().equals(
								castOther.getCartCommodityId())))
				&& ((this.getCartCommodityId() == castOther
						.getCartCommodityId()) || (this.getCartCommodityId() != null
						&& castOther.getCartCommodityId() != null && this
						.getCartCommodityId().equals(
								castOther.getCartCommodityId())))
				&& ((this.getOrderaTime() == castOther.getOrderaTime()) || (this
						.getOrderaTime() != null
						&& castOther.getOrderaTime() != null && this
						.getOrderaTime().equals(castOther.getOrderaTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOrderaId() == null ? 0 : this.getOrderaId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37
				* result
				+ (getTotalPrice() == null ? 0 : this.getTotalPrice()
						.hashCode());
		result = 37
				* result
				+ (getTotalDiscount() == null ? 0 : this.getTotalDiscount()
						.hashCode());
		result = 37
				* result
				+ (getCartCommodityId() == null ? 0 : this.getCartCommodityId()
						.hashCode());
		result = 37
				* result
				+ (getCartCommodityId() == null ? 0 : this.getCartCommodityId()
						.hashCode());
		result = 37
				* result
				+ (getOrderaTime() == null ? 0 : this.getOrderaTime()
						.hashCode());
		return result;
	}

}
