package com.sjtu.admin.webapp.form;

import com.sjtu.webapp.form.BaseForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Generated by XDoclet/actionform. This class can be further processed with
 * XDoclet/webdoclet/strutsconfigxml and XDoclet/webdoclet/strutsvalidationxml.
 * 
 * @struts.form name="largecatalogForm"
 */
public class LargeCatalogForm extends BaseForm implements java.io.Serializable {

	protected String largeCatalogId;

	protected String largeCatalogName;

	/** Default empty constructor. */
	public LargeCatalogForm() {
	}

	public String getLargeCatalogId() {
		return this.largeCatalogId;
	}

	/**
	 */

	public void setLargeCatalogId(String largeCatalogId) {
		this.largeCatalogId = largeCatalogId;
	}

	public String getLargeCatalogName() {
		return this.largeCatalogName;
	}

	/**
	 */

	public void setLargeCatalogName(String largeCatalogName) {
		this.largeCatalogName = largeCatalogName;
	}

	/*
	 * To add non XDoclet-generated methods, create a file named
	 * xdoclet-LargecatalogForm.java containing the additional code and place it
	 * in your metadata/web directory.
	 */
	/**
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping,
	 *      javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// reset any boolean data types to false

	}

}
