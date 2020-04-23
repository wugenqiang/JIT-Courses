/**
 * 
 */
package com.sjtu.search.webapp.action;

import com.sjtu.Constants;
import com.sjtu.admin.model.Commodity;
import com.sjtu.admin.model.CommodityEncapsulation;
import com.sjtu.admin.model.SmallCatalog;
import com.sjtu.admin.service.CommodityManager;
import com.sjtu.admin.service.SmallCatalogManager;
import com.sjtu.admin.webapp.form.CommodityForm;
import com.sjtu.dao.AbstractManager;
import com.sjtu.webapp.action.BaseAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wang
 * 
 */
public class CommoditySearchAction extends BaseAction {
	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Entering 'search' method");
		}
		CommodityForm commodityForm = (CommodityForm) form;
		Commodity commodity = (Commodity) convert(commodityForm);

		CommodityManager cmgr = (CommodityManager) getBean("commodityManager");		
		List smallCatalogList = new ArrayList();
		smallCatalogList = cmgr.getSmallCatalogList();
		request.setAttribute("smallCatalogList", smallCatalogList);

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Commodity.class);
		if (commodityForm.getSmallCatalogId() != null
				&& !commodityForm.getSmallCatalogId().equals(""))
			detachedCriteria.add(Restrictions.eq("smallCatalogId", Long
					.parseLong(commodityForm.getSmallCatalogId())));

		SmallCatalogManager smgr = (SmallCatalogManager) getBean("smallCatalogManager");
		AbstractManager abs = (AbstractManager) getBean("abstractManager");
		List list = new ArrayList();
		list = abs.findAllByCriteria(detachedCriteria);
		List result = new ArrayList();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Commodity temp = (Commodity) it.next();
			CommodityEncapsulation ce = new CommodityEncapsulation();
			ce.setCommodity(temp);
			SmallCatalog smallCatalog = smgr.getSmallCatalog(temp
					.getSmallCatalogId().toString());
			ce.setSmallCatalog(smallCatalog);
			result.add(ce);

		}

		request.setAttribute(Constants.COMMODITY_LIST, result);
		return mapping.findForward("list");
	}

	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Entering 'viewCommodity' method");
		}
		CommodityForm commodityForm = (CommodityForm) form;		
		
		CommodityManager cmgr = (CommodityManager) getBean("commodityManager");
		
		//SmallCatalogManager smgr = (SmallCatalogManager) getBean("smallCatalogManager");
		
		Commodity commodity = cmgr.getCommodity(commodityForm.getCommodityId());
		request.setAttribute("commodity", commodity);
		
		commodityForm.setCommodityId(commodity.getCommodityId().toString());
		commodityForm.setCommodityName(commodity.getCommodityName());
		commodityForm.setCommodityPrice(commodity.getCommodityPrice()
				.toString());
		commodityForm.setCommodityDiscount(commodity.getCommodityDiscount()
				.toString());
		commodityForm.setDescription(commodity.getDescription());
		commodityForm.setSmallCatalogId(commodity.getSmallCatalogId()
				.toString());
		commodityForm.setProductor(commodity.getProductor());
		if (commodity != null) {
			commodityForm = (CommodityForm) convert(commodity);
			SmallCatalog smallCatalog = cmgr.getSmallCatalog(commodity
					.getCommodityId().toString());			
			request.setAttribute("smallCatalog", smallCatalog);
			// request.setAttribute(Constants.SMALLCATALOG_KEY, smallCatalog);
		}
		return mapping.findForward("view");
	}

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return search(mapping, form, request, response);
	}

}
