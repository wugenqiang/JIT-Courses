package com.sjtu.admin.webapp.action;

import com.sjtu.Constants;
import com.sjtu.admin.model.Commodity;
import com.sjtu.admin.model.CommodityEncapsulation;
import com.sjtu.admin.model.SmallCatalog;
import com.sjtu.admin.service.CommodityManager;
import com.sjtu.admin.service.SmallCatalogManager;
import com.sjtu.admin.webapp.form.CommodityForm;
import com.sjtu.webapp.action.BaseAction;
import org.apache.struts.action.*;
import org.apache.struts.upload.FormFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Action class to handle CRUD on a Commodity object
 * 
 * @struts.action name="commodityForm" path="/commoditys" scope="request"
 *                validate="false" parameter="method" input="mainMenu"
 * @struts.action name="commodityForm" path="/editCommodity" scope="request"
 *                validate="false" parameter="method" input="list"
 * @struts.action name="commodityForm" path="/saveCommodity" scope="request"
 *                validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit"
 *                        path="/WEB-INF/pages/admin/commodityForm.jsp"
 * @struts.action-forward name="list"
 *                        path="/WEB-INF/pages/admin/commodityList.jsp"
 * @struts.action-forward name="search" path="/commoditys.html" redirect="true"
 */
public final class CommodityAction extends BaseAction {
	public ActionForward cancel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("search");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Entering 'delete' method");
		}

		ActionMessages messages = new ActionMessages();
		CommodityForm commodityForm = (CommodityForm) form;

		// Exceptions are caught by ActionExceptionHandler
		CommodityManager mgr = (CommodityManager) getBean("commodityManager");
		Commodity commodity = mgr.getCommodity(commodityForm.getCommodityId());
		mgr.removeCommodity(commodityForm.getCommodityId());

		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"commodity.deleted"));

		// save messages in session, so they'll survive the redirect
		saveMessages(request.getSession(), messages);

		return mapping.findForward("search");
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Entering 'edit' method");
		}
		CommodityForm commodityForm = (CommodityForm) form;
		/*
		 * boolean isNew = ("".equals(commodityForm.getCommodityId()) ||
		 * commodityForm .getCommodityId() == null); if (isNew) {
		 * request.setAttribute("readonly", false); } else { String s = (String)
		 * request.getParameter("readonly"); Boolean readonly; if
		 * (s.equals("false")) { readonly = false; } else { readonly = true; }
		 * 
		 * request.setAttribute("readonly", readonly); }
		 */
		CommodityManager cmgr = (CommodityManager) getBean("commodityManager");
		List smallCatalogList = new ArrayList();
		smallCatalogList = cmgr.getSmallCatalogList();
		request.setAttribute("smallCatalogList", smallCatalogList);
		// if an id is passed in, look up the user - otherwise
		// don't do anything - user is doing an add
		if (commodityForm.getCommodityId() != null) {
			CommodityManager mgr = (CommodityManager) getBean("commodityManager");
			SmallCatalogManager smgr = (SmallCatalogManager) getBean("smallCatalogManager");

			Commodity commodity = mgr.getCommodity(commodityForm
					.getCommodityId());
			commodityForm = (CommodityForm) convert(commodity);
			commodityForm.setSmallCatalogId(commodity.getSmallCatalogId()
					.toString());
			commodityForm.setCommodityName(commodity.getCommodityName());
			commodityForm.setCommodityPrice(String.valueOf(commodity
					.getCommodityPrice()));
			commodityForm.setCommodityDiscount(String.valueOf(commodity
					.getCommodityDiscount()));
			commodityForm.setProductor(commodity.getProductor());
			commodityForm.setDescription(commodity.getDescription());
			commodityForm.setPicture(commodity.getPicture());
			commodityForm.setFileaddress(commodity.getFileaddress());
			commodityForm.setFileName(commodity.getPicture());
			updateFormBean(mapping, request, commodityForm);

			SmallCatalog smallCatalog = smgr.getSmallCatalog(commodity
					.getSmallCatalogId().toString());
			String smallCatalogName = smallCatalog.getSmallCatalogName();
			request.setAttribute("smallCatalogName", smallCatalogName);
		}
		return mapping.findForward("edit");
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Entering 'save' method");
		}

		// Extract attributes and parameters we will need
		ActionMessages messages = new ActionMessages();
		CommodityForm commodityForm = (CommodityForm) form;
		boolean isNew = ("".equals(commodityForm.getCommodityId()) || commodityForm
				.getCommodityId() == null);

		FormFile file = commodityForm.getFile();

		/*
		 * if (log.isDebugEnabled()) { log.debug("Upload a file:" +
		 * file.getFileName()); }
		 */

		if (file == null) {
			return mapping.findForward("edit");
		}
		String picture = file.getFileName();
		// retrieve the file name
		String fileName = file.getFileName();
		// change the file name as time_realfilename
		// retrieve the content type
		// String contentType = file.getContentType();
		// retrieve the file size
		// String size = (file.getFileSize() + "bytes");
		// String fileaddress = null;
		// the directory to upload to
		String uploadDir = servlet.getServletContext()
				.getRealPath("/resources")
				+ "/commodity/";
		// write the file to the file specified
		File dirPath = new File(uploadDir);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		// retrieve the file data
		InputStream stream = file.getInputStream();
		// fileName = fileName;
		// file.setFileName(fileName);
		// write the file to the file specified
		OutputStream bos = new FileOutputStream(uploadDir + fileName);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
			bos.write(buffer, 0, bytesRead);
		}
		bos.close();
		String fileaddress = dirPath.getAbsolutePath() + Constants.FILE_SEP
				+ file.getFileName();
		// close the stream
		stream.close();

		CommodityManager mgr = (CommodityManager) getBean("commodityManager");
		Commodity commodity = new Commodity();
		commodity.setCommodityName(commodityForm.getCommodityName());
		commodity.setCommodityPrice(Float.parseFloat(commodityForm
				.getCommodityPrice()));
		commodity.setDescription(commodityForm.getDescription());
		commodity.setSmallCatalogId(Long.parseLong(commodityForm
				.getSmallCatalogId()));
		commodity.setProductor(commodityForm.getProductor());
		String url = request.getContextPath() + "/resources" + "/commodity/"
				+ file.getFileName();
		picture = fileName;
		if (file.getFileName().equals("")) {
			commodity.setPicture(commodityForm.getPicture());
			commodity.setFileaddress(commodityForm.getFileaddress());
		} else {
			commodity.setPicture(file.getFileName());
			commodity.setFileaddress(fileaddress);
		}

		commodity.setCommodityDiscount(Float.parseFloat(commodityForm
				.getCommodityDiscount()));
		if (!commodityForm.getCommodityId().equals("")) {
			commodity.setCommodityId(Long.parseLong(commodityForm
					.getCommodityId()));
		}
		mgr.saveCommodity(commodity);

		// add success messages
		if (isNew) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"commodity.added"));

			// save messages in session to survive a redirect
			saveMessages(request.getSession(), messages);

			// return mapping.findForward("search");
		} else {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"commodity.updated"));
			saveMessages(request.getSession(), messages);

			// return mapping.findForward("edit");
		}
		String path = "/commoditys.html";
		ActionForward af = new ActionForward();
		af.setRedirect(true);
		af.setPath(path);
		return af;
	}

	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Entering 'search' method");
		}

		CommodityForm commodityForm = (CommodityForm) form;
		Commodity commodity = (Commodity) convert(commodityForm);

		CommodityManager mgr = (CommodityManager) getBean("commodityManager");
		SmallCatalogManager smgr = (SmallCatalogManager) getBean("smallCatalogManager");
		List list = new ArrayList();
		List result = new ArrayList();

		list = mgr.getCommoditys(commodity);
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

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return search(mapping, form, request, response);
	}
}
