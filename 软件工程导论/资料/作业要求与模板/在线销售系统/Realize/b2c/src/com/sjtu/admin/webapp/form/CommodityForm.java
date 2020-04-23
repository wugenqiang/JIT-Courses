package com.sjtu.admin.webapp.form;

import com.sjtu.webapp.form.BaseForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class CommodityForm extends BaseForm implements Serializable {

	protected FormFile file;

	protected String commodityId;

	protected String smallCatalogId;

	protected String commodityName;

	protected String commodityPrice;

	protected String commodityDiscount;

	protected String description;

	protected String productor;

	protected String picture;

	protected String fileaddress;

	protected String fileName;

	/** Default empty constructor. */
	public CommodityForm() {
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
	 * @return the smallCatalogId
	 */
	public String getSmallCatalogId() {
		return smallCatalogId;
	}

	/**
	 * @param smallCatalogId
	 *            the smallCatalogId to set
	 */
	public void setSmallCatalogId(String smallCatalogId) {
		this.smallCatalogId = smallCatalogId;
	}

	/**
	 * @return the commodityName
	 */
	public String getCommodityName() {
		return commodityName;
	}

	/**
	 * @param commodityName
	 *            the commodityName to set
	 */
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	/**
	 * @return the commodityPrice
	 */
	public String getCommodityPrice() {
		return commodityPrice;
	}

	/**
	 * @param commodityPrice
	 *            the commodityPrice to set
	 */
	public void setCommodityPrice(String commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	/**
	 * @return the commodityDiscount
	 */
	public String getCommodityDiscount() {
		return commodityDiscount;
	}

	/**
	 * @param commodityDiscount
	 *            the commodityDiscount to set
	 */
	public void setCommodityDiscount(String commodityDiscount) {
		this.commodityDiscount = commodityDiscount;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the productor
	 */
	public String getProductor() {
		return productor;
	}

	/**
	 * @param productor
	 *            the productor to set
	 */
	public void setProductor(String productor) {
		this.productor = productor;
	}

	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture
	 *            the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * @return the fileaddress
	 */
	public String getFileaddress() {
		return fileaddress;
	}

	/**
	 * @param fileaddress
	 *            the fileaddress to set
	 */
	public void setFileaddress(String fileaddress) {
		this.fileaddress = fileaddress;
	}

	/**
	 * @return the file
	 */
	public FormFile getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(FormFile file) {
		this.file = file;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void reset(ActionMapping mapping, HttpServletRequest requset) {
		// reset any boolean data types to false
		this.commodityDiscount = null;
		this.commodityId = null;
		this.commodityName = null;
		this.commodityPrice = null;
		this.description = null;
		this.fileaddress = null;
		this.productor = null;
		this.picture = null;
		this.file = null;
		this.smallCatalogId = null;
	}

}
