/**
 * 
 */
package com.sjtu.admin.model;

import org.apache.struts.action.ActionServlet;

/**
 * @author wang
 * 
 */
public class MidCatalogEncapsulation {

	public MidCatalog midCatalog = null;

	public LargeCatalog largeCatalog = null;

	public ActionServlet servlet = null;

	/**
	 * @return the midCatalog
	 */
	public MidCatalog getMidCatalog() {
		return midCatalog;
	}

	/**
	 * @param midCatalog the midCatalog to set
	 */
	public void setMidCatalog(MidCatalog midCatalog) {
		this.midCatalog = midCatalog;
	}

	/**
	 * @return the largeCatalog
	 */
	public LargeCatalog getLargeCatalog() {
		return largeCatalog;
	}

	/**
	 * @param largeCatalog the largeCatalog to set
	 */
	public void setLargeCatalog(LargeCatalog largeCatalog) {
		this.largeCatalog = largeCatalog;
	}

	/**
	 * @return the servlet
	 */
	public ActionServlet getServlet() {
		return servlet;
	}

	/**
	 * @param servlet the servlet to set
	 */
	public void setServlet(ActionServlet servlet) {
		this.servlet = servlet;
	}

}
