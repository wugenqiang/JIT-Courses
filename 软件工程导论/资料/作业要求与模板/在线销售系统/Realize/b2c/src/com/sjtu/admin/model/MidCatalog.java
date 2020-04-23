package com.sjtu.admin.model;

// Generated 2007-12-8 17:28:29 by Hibernate Tools 3.1.0.beta4

/**
 * @struts.form include-all="true" extends="BaseForm"
 * @hibernate.class table="midCatalog"
 * 
 */

public class MidCatalog extends com.sjtu.model.BaseObject implements
		java.io.Serializable {

	// Fields

	private Long midCatalogId;
	private String midCatalogName;
	private Long largeCatalogId;

	/** default constructor */
	public MidCatalog() {
	}

	/** full constructor */
	public MidCatalog(String midCatalogName, Long largeCatalogId) {
		this.midCatalogName = midCatalogName;
		this.largeCatalogId = largeCatalogId;
	}

	// Property accessors
	/**
	 * *
	 * 
	 * @hibernate.id generator-class="native" type="java.lang.Long"
	 *               column="midCatalogId"
	 * 
	 */

	public Long getMidCatalogId() {
		return this.midCatalogId;
	}

	public void setMidCatalogId(Long midCatalogId) {
		this.midCatalogId = midCatalogId;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="midCatalogName" length="50" not-null="true"
	 * 
	 */

	public String getMidCatalogName() {
		return this.midCatalogName;
	}

	public void setMidCatalogName(String midCatalogName) {
		this.midCatalogName = midCatalogName;
	}

	// Constructors

	/**
	 * @return the largeCatalogId
	 */
	public Long getLargeCatalogId() {
		return largeCatalogId;
	}

	/**
	 * @param largeCatalogId
	 *            the largeCatalogId to set
	 */
	public void setLargeCatalogId(Long largeCatalogId) {
		this.largeCatalogId = largeCatalogId;
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
		buffer.append("midCatalogName").append("='")
				.append(getMidCatalogName()).append("' ");
		buffer.append("largeCatalogId").append("='")
				.append(getLargeCatalogId()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MidCatalog))
			return false;
		MidCatalog castOther = (MidCatalog) other;

		return ((this.getMidCatalogId() == castOther.getMidCatalogId()) || (this
				.getMidCatalogId() != null
				&& castOther.getMidCatalogId() != null && this
				.getMidCatalogId().equals(castOther.getMidCatalogId())))
				&& ((this.getMidCatalogName() == castOther.getMidCatalogName()) || (this
						.getMidCatalogName() != null
						&& castOther.getMidCatalogName() != null && this
						.getMidCatalogName().equals(
								castOther.getMidCatalogName())))
				&& (this.getLargeCatalogId() == castOther.getLargeCatalogId() || (this
						.getLargeCatalogId() != null
						&& castOther.getLargeCatalogId() != null && castOther
						.getLargeCatalogId().equals(this.getLargeCatalogId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getMidCatalogId() == null ? 0 : this.getMidCatalogId()
						.hashCode());
		result = 37
				* result
				+ (getMidCatalogName() == null ? 0 : this.getMidCatalogName()
						.hashCode());
		result = 37
				* result
				+ (getLargeCatalogId() == null ? 0 : this.getLargeCatalogId()
						.hashCode());
		return result;
	}

}
