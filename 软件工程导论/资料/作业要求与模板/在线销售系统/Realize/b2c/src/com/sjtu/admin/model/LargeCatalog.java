package com.sjtu.admin.model;

// Generated 2007-12-8 17:28:30 by Hibernate Tools 3.1.0.beta4

/**
 * @struts.form include-all="true" extends="BaseForm"
 * @hibernate.class table="largecatalog"
 * 
 */

public class LargeCatalog extends com.sjtu.model.BaseObject implements
		java.io.Serializable {

	// Fields

	private Long largeCatalogId;
	private String largeCatalogName;

	// Constructors

	/** default constructor */
	public LargeCatalog() {
	}

	/** full constructor */
	public LargeCatalog(String largeCatalogName) {
		this.largeCatalogName = largeCatalogName;
	}

	// Property accessors
	/**
	 * *
	 * 
	 * @hibernate.id generator-class="native" type="java.lang.Long"
	 *               column="largeCatalogId"
	 * 
	 */

	public Long getLargeCatalogId() {
		return this.largeCatalogId;
	}

	public void setLargeCatalogId(Long largeCatalogId) {
		this.largeCatalogId = largeCatalogId;
	}

	/**
	 * *
	 * 
	 * @hibernate.property column="largeCatalogName" length="50" not-null="true"
	 * 
	 */

	public String getLargeCatalogName() {
		return this.largeCatalogName;
	}

	public void setLargeCatalogName(String largeCatalogName) {
		this.largeCatalogName = largeCatalogName;
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
		buffer.append("largeCatalogName").append("='").append(
				getLargeCatalogName()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LargeCatalog))
			return false;
		LargeCatalog castOther = (LargeCatalog) other;

		return ((this.getLargeCatalogId() == castOther.getLargeCatalogId()) || (this
				.getLargeCatalogId() != null
				&& castOther.getLargeCatalogId() != null && this
				.getLargeCatalogId().equals(castOther.getLargeCatalogId())))
				&& ((this.getLargeCatalogName() == castOther
						.getLargeCatalogName()) || (this.getLargeCatalogName() != null
						&& castOther.getLargeCatalogName() != null && this
						.getLargeCatalogName().equals(
								castOther.getLargeCatalogName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getLargeCatalogId() == null ? 0 : this.getLargeCatalogId()
						.hashCode());
		result = 37
				* result
				+ (getLargeCatalogName() == null ? 0 : this
						.getLargeCatalogName().hashCode());
		return result;
	}

}
