/**
 * 
 */
package com.sjtu.admin.model;

import org.apache.struts.action.ActionServlet;

/**
 * @author wang
 * 
 */
public class SmallCatalogEncapsulation {

	public SmallCatalog smallCatalog = null;

	public MidCatalog midCatalog = null;

	public ActionServlet servlet = null;

	/**
	 * @return the smallCatalog
	 */
	public SmallCatalog getSmallCatalog() {
		return smallCatalog;
	}

	/**
	 * @param smallCatalog
	 *            the smallCatalog to set
	 */
	public void setSmallCatalog(SmallCatalog smallCatalog) {
		this.smallCatalog = smallCatalog;
	}

	/**
	 * @return the midCatalog
	 */
	public MidCatalog getMidCatalog() {
		return midCatalog;
	}

	/**
	 * @param midCatalog
	 *            the midCatalog to set
	 */
	public void setMidCatalog(MidCatalog midCatalog) {
		this.midCatalog = midCatalog;
	}

	/**
	 * @return the servlet
	 */
	public ActionServlet getServlet() {
		return servlet;
	}

	/**
	 * @param servlet
	 *            the servlet to set
	 */
	public void setServlet(ActionServlet servlet) {
		this.servlet = servlet;
	}

	public SmallCatalogEncapsulation() {
		super();
	}

	public SmallCatalogEncapsulation(SmallCatalog smallCatalog,
			MidCatalog midCatalog, ActionServlet servlet) {
		this.smallCatalog = smallCatalog;
		this.midCatalog = midCatalog;
		this.servlet = servlet;
	}

}
