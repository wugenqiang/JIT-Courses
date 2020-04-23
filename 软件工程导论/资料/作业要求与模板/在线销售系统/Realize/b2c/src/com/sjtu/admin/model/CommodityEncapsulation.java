package com.sjtu.admin.model;

import org.apache.struts.action.ActionServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class CommodityEncapsulation {

	public Commodity commodity = null;

	public SmallCatalog smallCatalog = null;

	public ActionServlet servlet = null;

	/**
	 * @return the commodity
	 */
	public Commodity getCommodity() {
		return commodity;
	}

	/**
	 * @param commodity
	 *            the commodity to set
	 */
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

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

	public Object getBean(String name) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servlet.getServletContext());
		return ctx.getBean(name);
	}

	public CommodityEncapsulation() {
		super();
	};

	public CommodityEncapsulation(Commodity commodity,
			SmallCatalog smallCatalog, ActionServlet servlet) {
		this.commodity = commodity;
		this.servlet = servlet;
		this.smallCatalog = smallCatalog;
	}

}
