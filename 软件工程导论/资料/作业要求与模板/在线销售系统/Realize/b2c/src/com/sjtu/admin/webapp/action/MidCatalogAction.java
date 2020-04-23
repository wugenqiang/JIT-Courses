package com.sjtu.admin.webapp.action;

import com.sjtu.Constants;
import com.sjtu.admin.model.LargeCatalog;
import com.sjtu.admin.model.MidCatalog;
import com.sjtu.admin.model.MidCatalogEncapsulation;
import com.sjtu.admin.service.LargeCatalogManager;
import com.sjtu.admin.service.MidCatalogManager;
import com.sjtu.admin.webapp.form.MidCatalogForm;
import com.sjtu.webapp.action.BaseAction;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Action class to handle CRUD on a MidCatalog object
 * 
 * @struts.action name="midCatalogForm" path="/midCatalogs" scope="request"
 *                validate="false" parameter="method" input="mainMenu"
 * @struts.action name="midCatalogForm" path="/editMidCatalog" scope="request"
 *                validate="false" parameter="method" input="list"
 * @struts.action name="midCatalogForm" path="/saveMidCatalog" scope="request"
 *                validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit"
 *                        path="/WEB-INF/pages/admin/midCatalogForm.jsp"
 * @struts.action-forward name="list"
 *                        path="/WEB-INF/pages/admin/midCatalogList.jsp"
 * @struts.action-forward name="search" path="/midCatalogs.html" redirect="true"
 */
public final class MidCatalogAction extends BaseAction {
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
		MidCatalogForm midCatalogForm = (MidCatalogForm) form;

		// Exceptions are caught by ActionExceptionHandler
		MidCatalogManager mgr = (MidCatalogManager) getBean("midCatalogManager");
		mgr.removeMidCatalog(midCatalogForm.getMidCatalogId());
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"midCatalog.deleted"));

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

		MidCatalogForm midCatalogForm = (MidCatalogForm) form;

		MidCatalogManager mmgr = (MidCatalogManager) getBean("midCatalogManager");
		List largeCatalogList = new ArrayList();
		largeCatalogList = mmgr.getLargeCatalogList();
		request.setAttribute("largeCatalogList", largeCatalogList);
		// if an id is passed in, look up the user - otherwise
		// don't do anything - user is doing an add
		if (midCatalogForm.getMidCatalogId() != null) {
			MidCatalogManager mgr = (MidCatalogManager) getBean("midCatalogManager");
			LargeCatalogManager lmgr = (LargeCatalogManager) getBean("largeCatalogManager");

			MidCatalog midCatalog = mgr.getMidCatalog(midCatalogForm
					.getMidCatalogId());
			midCatalogForm = (MidCatalogForm) convert(midCatalog);
			midCatalogForm.setLargeCatalogId(midCatalog.getLargeCatalogId()
					.toString());
			midCatalogForm.setMidCatalogName(midCatalog.getMidCatalogName());
			LargeCatalog largeCatalog = lmgr.getLargeCatalog(midCatalog
					.getLargeCatalogId().toString());
			String largeCatalogName = largeCatalog.getLargeCatalogName();
			request.setAttribute("largeCatalogName", largeCatalogName);

			updateFormBean(mapping, request, midCatalogForm);
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
		MidCatalogForm midCatalogForm = (MidCatalogForm) form;
		boolean isNew = ("".equals(midCatalogForm.getMidCatalogId()) || midCatalogForm
				.getMidCatalogId() == null);

		MidCatalogManager mgr = (MidCatalogManager) getBean("midCatalogManager");
		// MidCatalog midCatalog = (MidCatalog) convert(midCatalogForm);
		MidCatalog midCatalog = new MidCatalog();
		midCatalog.setMidCatalogName(midCatalogForm.getMidCatalogName());
		midCatalog.setLargeCatalogId(Long.parseLong(midCatalogForm
				.getLargeCatalogId()));
		if (!midCatalogForm.getMidCatalogId().equals("")) {
			midCatalog.setMidCatalogId(Long.parseLong(midCatalogForm
					.getMidCatalogId()));
		}
		mgr.saveMidCatalog(midCatalog);

		// add success messages
		if (isNew) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"midCatalog.added"));

			// save messages in session to survive a redirect
			saveMessages(request.getSession(), messages);

			// return mapping.findForward("search");
		} else {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"midCatalog.updated"));
			saveMessages(request, messages);

			// return mapping.findForward("edit");
		}
		String path = "/midCatalogs.html";
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

		MidCatalogForm midCatalogForm = (MidCatalogForm) form;
		MidCatalog midCatalog = (MidCatalog) convert(midCatalogForm);

		MidCatalogManager mgr = (MidCatalogManager) getBean("midCatalogManager");
		LargeCatalogManager lmgr = (LargeCatalogManager) getBean("largeCatalogManager");
		List list = new ArrayList();
		List result = new ArrayList();
		list = mgr.getMidCatalogs(midCatalog);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			MidCatalog temp = (MidCatalog) it.next();
			MidCatalogEncapsulation se = new MidCatalogEncapsulation();
			se.setMidCatalog(temp);
			LargeCatalog largeCatalog = lmgr.getLargeCatalog(temp
					.getLargeCatalogId().toString());
			se.setLargeCatalog(largeCatalog);
			result.add(se);
		}
		request.setAttribute(Constants.MIDCATALOG_LIST, result);

		return mapping.findForward("list");

	}

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return search(mapping, form, request, response);
	}
}
