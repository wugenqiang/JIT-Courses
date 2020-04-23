package com.sjtu.admin.model;

// Generated 2007-12-9 10:47:31 by Hibernate Tools 3.1.0.beta4

/**
 * @struts.form include-all="true" extends="BaseForm"
 * @hibernate.class table="commodity"
 * 
 */

public class Commodity extends com.sjtu.model.BaseObject implements
		java.io.Serializable {

	// Fields

	private Long commodityId;
	private Long smallCatalogId;
	private String commodityName;
	private Float commodityPrice;
	private Float commodityDiscount;
	private String description;
	private String productor;
	private String picture;
	private String fileaddress;

	// Constructors

	/** default constructor */
	public Commodity() {
	}

	/** minimal constructor */
	public Commodity(String commodityName, Float commodityPrice,
			String productor) {
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.productor = productor;
	}

	/** full constructor */
	public Commodity(Long smallCatalogId, String commodityName,
			float commodityPrice, Float commodityDiscount, String description,
			String productor, String picture, String fileaddress) {
		this.smallCatalogId = smallCatalogId;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.commodityDiscount = commodityDiscount;
		this.description = description;
		this.productor = productor;
		this.picture = picture;
		this.fileaddress = fileaddress;
	}

	// Property accessors
	/**
	 * *
	 * 
	 * @hibernate.id generator-class="native" type="java.lang.Long"
	 *               column="commodityId"
	 * 
	 */

	public Long getCommodityId() {
		return this.commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="smallCatalogId" length="20"
	 * 
	 */

	public Long getSmallCatalogId() {
		return this.smallCatalogId;
	}

	public void setSmallCatalogId(Long smallCatalogId) {
		this.smallCatalogId = smallCatalogId;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="commodityName" length="50" not-null="true"
	 * 
	 */

	public String getCommodityName() {
		return this.commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="commodityPrice" length="8" not-null="true"
	 * 
	 */

	public Float getCommodityPrice() {
		return this.commodityPrice;
	}

	public void setCommodityPrice(Float commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="commodityDiscount" length="8"
	 * 
	 */

	public Float getCommodityDiscount() {
		return this.commodityDiscount;
	}

	public void setCommodityDiscount(Float commodityDiscount) {
		this.commodityDiscount = commodityDiscount;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="description" length="400"
	 * 
	 */

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="productor" length="50" not-null="true"
	 * 
	 */

	public String getProductor() {
		return this.productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="picture" length="100"
	 * 
	 */

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="fileaddress" length="255"
	 * 
	 */

	public String getFileaddress() {
		return this.fileaddress;
	}

	public void setFileaddress(String fileaddress) {
		this.fileaddress = fileaddress;
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
		buffer.append("smallCatalogId").append("='")
				.append(getSmallCatalogId()).append("' ");
		buffer.append("commodityName").append("='").append(getCommodityName())
				.append("' ");
		buffer.append("commodityPrice").append("='")
				.append(getCommodityPrice()).append("' ");
		buffer.append("commodityDiscount").append("='").append(
				getCommodityDiscount()).append("' ");
		buffer.append("description").append("='").append(getDescription())
				.append("' ");
		buffer.append("productor").append("='").append(getProductor()).append(
				"' ");
		buffer.append("picture").append("='").append(getPicture()).append("' ");
		buffer.append("fileaddress").append("='").append(getFileaddress())
				.append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Commodity))
			return false;
		Commodity castOther = (Commodity) other;

		return ((this.getCommodityId() == castOther.getCommodityId()) || (this
				.getCommodityId() != null
				&& castOther.getCommodityId() != null && this.getCommodityId()
				.equals(castOther.getCommodityId())))
				&& ((this.getSmallCatalogId() == castOther.getSmallCatalogId()) || (this
						.getSmallCatalogId() != null
						&& castOther.getSmallCatalogId() != null && this
						.getSmallCatalogId().equals(
								castOther.getSmallCatalogId())))
				&& ((this.getCommodityName() == castOther.getCommodityName()) || (this
						.getCommodityName() != null
						&& castOther.getCommodityName() != null && this
						.getCommodityName()
						.equals(castOther.getCommodityName())))
				&& ((this.getCommodityPrice() == castOther.getCommodityPrice()) || this
						.getCommodityPrice() != null
						&& castOther.getCommodityPrice() != null
						&& this.getCommodityPrice().equals(
								castOther.getCommodityPrice()))
				&& ((this.getCommodityDiscount() == castOther
						.getCommodityDiscount()) || (this
						.getCommodityDiscount() != null
						&& castOther.getCommodityDiscount() != null && this
						.getCommodityDiscount().equals(
								castOther.getCommodityDiscount())))
				&& ((this.getDescription() == castOther.getDescription()) || (this
						.getDescription() != null
						&& castOther.getDescription() != null && this
						.getDescription().equals(castOther.getDescription())))
				&& ((this.getProductor() == castOther.getProductor()) || (this
						.getProductor() != null
						&& castOther.getProductor() != null && this
						.getProductor().equals(castOther.getProductor())))
				&& ((this.getPicture() == castOther.getPicture()) || (this
						.getPicture() != null
						&& castOther.getPicture() != null && this.getPicture()
						.equals(castOther.getPicture())))
				&& ((this.getFileaddress() == castOther.getFileaddress()) || (this
						.getFileaddress() != null
						&& castOther.getFileaddress() != null && this
						.getFileaddress().equals(castOther.getFileaddress())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCommodityId() == null ? 0 : this.getCommodityId()
						.hashCode());
		result = 37
				* result
				+ (getSmallCatalogId() == null ? 0 : this.getSmallCatalogId()
						.hashCode());
		result = 37
				* result
				+ (getCommodityName() == null ? 0 : this.getCommodityName()
						.hashCode());
		result = 37
				* result
				+ (getCommodityPrice() == null ? 0 : this.getCommodityPrice()
						.hashCode());
		result = 37
				* result
				+ (getCommodityDiscount() == null ? 0 : this
						.getCommodityDiscount().hashCode());
		result = 37
				* result
				+ (getDescription() == null ? 0 : this.getDescription()
						.hashCode());
		result = 37 * result
				+ (getProductor() == null ? 0 : this.getProductor().hashCode());
		result = 37 * result
				+ (getPicture() == null ? 0 : this.getPicture().hashCode());
		result = 37
				* result
				+ (getFileaddress() == null ? 0 : this.getFileaddress()
						.hashCode());
		return result;
	}

}
