package com.sjtu.admin.model;

// Generated 2007-12-8 17:28:30 by Hibernate Tools 3.1.0.beta4

/**
 * @struts.form include-all="true" extends="BaseForm"
 * @hibernate.class table="smallCatalog"
 * 
 */

public class SmallCatalog extends com.sjtu.model.BaseObject implements
		java.io.Serializable {

	// Fields

	private Long smallCatalogId;
	private String smallCatalogName;
	private Long midCatalogId;

	// Constructors

	/** default constructor */
	public SmallCatalog() {
	}

	/** full constructor */
	public SmallCatalog(String smallCatalogName, Long midCatalogId) {
		this.smallCatalogName = smallCatalogName;
		this.midCatalogId = midCatalogId;
	}

	// Property accessors
	/**
	 * *
	 * 
	 * @hibernate.id generator-class="native" type="java.lang.Long"
	 *               column="smallCatalogId"
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
	 * @hibernate.property column="sName" length="50" not-null="true"
	 * 
	 */

	public String getSmallCatalogName() {
		return this.smallCatalogName;
	}

	public void setSmallCatalogName(String smallCatalogName) {
		this.smallCatalogName = smallCatalogName;
	}

	/**
	 * @return the midCatalogId
	 */
	public Long getMidCatalogId() {
		return midCatalogId;
	}

	/**
	 * @param midCatalogId
	 *            the midCatalogId to set
	 */
	public void setMidCatalogId(Long midCatalogId) {
		this.midCatalogId = midCatalogId;
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
		buffer.append("smallCatalogName").append("='").append(
				getSmallCatalogName()).append("' ");
		buffer.append("midCatalogId").append("='").append(getMidCatalogId())
				.append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SmallCatalog))
			return false;
		SmallCatalog castOther = (SmallCatalog) other;

		return ((this.getSmallCatalogId() == castOther.getSmallCatalogId()) || (this
				.getSmallCatalogId() != null
				&& castOther.getSmallCatalogId() != null && this
				.getSmallCatalogId().equals(castOther.getSmallCatalogId())))
				&& ((this.getSmallCatalogName() == castOther
						.getSmallCatalogName()) || (this.getSmallCatalogName() != null
						&& castOther.getSmallCatalogName() != null && this
						.getSmallCatalogName().equals(
								castOther.getSmallCatalogName())))
				&& ((this.getMidCatalogId() == castOther.getMidCatalogId()) || (this
						.getMidCatalogId() != null
						&& castOther.getMidCatalogId() != null && this
						.getMidCatalogId().equals(castOther.getMidCatalogId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getSmallCatalogId() == null ? 0 : this.getSmallCatalogId()
						.hashCode());
		result = 37
				* result
				+ (getSmallCatalogName() == null ? 0 : this
						.getSmallCatalogName().hashCode());
		result = 37
				* result
				+ (getMidCatalogId() == null ? 0 : this.getMidCatalogId()
						.hashCode());
		return result;
	}

}
