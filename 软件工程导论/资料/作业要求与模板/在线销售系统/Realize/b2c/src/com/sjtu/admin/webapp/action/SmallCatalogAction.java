package com.sjtu.admin.webapp.action;

import com.sjtu.Constants;
import com.sjtu.admin.model.MidCatalog;
import com.sjtu.admin.model.SmallCatalog;
import com.sjtu.admin.model.SmallCatalogEncapsulation;
import com.sjtu.admin.service.MidCatalogManager;
import com.sjtu.admin.service.SmallCatalogManager;
import com.sjtu.admin.webapp.form.SmallCatalogForm;
import com.sjtu.webapp.action.BaseAction;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Action class to handle CRUD on a SmallCatalog object
 * 
 * @struts.action name="smallCatalogForm" path="/smallCatalogs" scope="request"
 *                validate="false" parameter="method" input="mainMenu"
 * @struts.action name="smallCatalogForm" path="/editSmallCatalog"
 *                scope="request" validate="false" parameter="method"
 *                input="list"
 * @struts.action name="smallCatalogForm" path="/saveSmallCatalog"
 *                scope="request" validate="true" parameter="method"
 *                input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit"
 *                        path="/WEB-INF/pages/admin/smallCatalogForm.jsp"
 * @struts.action-forward name="list"
 *                        path="/WEB-INF/pages/admin/smallCatalogList.jsp"
 * @struts.action-forward name="search" path="/smallCatalogs.html"
 *                        redirect="true"
 */
public final class SmallCatalogAction extends BaseAction {
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
		SmallCatalogForm smallCatalogForm = (SmallCatalogForm) form;

		// Exceptions are caught by ActionExceptionHandler
		SmallCatalogManager mgr = (SmallCatalogManager) getBean("smallCatalogManager");
		mgr.removeSmallCatalog(smallCatalogForm.getSmallCatalogId());

		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"smallCatalog.deleted"));

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

		SmallCatalogForm smallCatalogForm = (SmallCatalogForm) form;

		SmallCatalogManager smgr = (SmallCatalogManager) getBean("smallCatalogManager");
		List midCatalogList = new ArrayList();
		midCatalogList = smgr.getMidCatalogList();
		request.setAttribute("midCatalogList", midCatalogList);
		// if an id is passed in, look up the user - otherwise
		// don't do anything - user is doing an add
		if (smallCatalogForm.getSmallCatalogId() != null) {
			SmallCatalogManager mgr = (SmallCatalogManager) getBean("smallCatalogManager");
			MidCatalogManager mmgr = (MidCatalogManager) getBean("midCatalogManager");

			SmallCatalog smallCatalog = mgr.getSmallCatalog(smallCatalogForm
					.getSmallCatalogId());
			smallCatalogForm = (SmallCatalogForm) convert(smallCatalog);
			smallCatalogForm.setMidCatalogId(smallCatalog.getMidCatalogId()
					.toString());
			smallCatalogForm.setSmallCatalogName(smallCatalog
					.getSmallCatalogName());
			MidCatalog midCatalog = mmgr.getMidCatalog(smallCatalog
					.getMidCatalogId().toString());
			String midCatalogName = midCatalog.getMidCatalogName();
			request.setAttribute("midCatalogName", midCatalogName);

			updateFormBean(mapping, request, smallCatalogForm);
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
		SmallCatalogForm smallCatalogForm = (SmallCatalogForm) form;
		boolean isNew = ("".equals(smallCatalogForm.getSmallCatalogId()) || smallCatalogForm
				.getSmallCatalogId() == null);

		SmallCatalogManager mgr = (SmallCatalogManager) getBean("smallCatalogManager");
		SmallCatalog smallCatalog = new SmallCatalog();
		smallCatalog
				.setSmallCatalogName(smallCatalogForm.getSmallCatalogName());
		smallCatalog.setMidCatalogId(Long.parseLong(smallCatalogForm
				.getMidCatalogId()));
		if (!smallCatalogForm.getSmallCatalogId().equals("")) {
			smallCatalog.setSmallCatalogId(Long.parseLong(smallCatalogForm
					.getSmallCatalogId()));
		}
		mgr.saveSmallCatalog(smallCatalog);

		// add success messages
		if (isNew) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"smallCatalog.added"));

			// save messages in session to survive a redirect
			saveMessages(request.getSession(), messages);
			// return mapping.findForward("search");
		} else {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"smallCatalog.updated"));
			saveMessages(request, messages);

			// return mapping.findForward("edit");
		}
		String path = "/smallCatalogs.html";
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

		SmallCatalogForm smallCatalogForm = (SmallCatalogForm) form;
		SmallCatalog smallCatalog = (SmallCatalog) convert(smallCatalogForm);

		SmallCatalogManager mgr = (SmallCatalogManager) getBean("smallCatalogManager");
		MidCatalogManager mmgr = (MidCatalogManager) getBean("midCatalogManager");
		List list = new ArrayList();
		List result = new ArrayList();
		list = mgr.getSmallCatalogs(smallCatalog);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			SmallCatalog temp = (SmallCatalog) it.next();
			SmallCatalogEncapsulation se = new SmallCatalogEncapsulation();
			se.setSmallCatalog(temp);
			MidCatalog midCatalog = mmgr.getMidCatalog(temp.getMidCatalogId()
					.toString());
			se.setMidCatalog(midCatalog);
			result.add(se);
		}
		request.setAttribute(Constants.SMALLCATALOG_LIST, result);

		return mapping.findForward("list");
	}

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return search(mapping, form, request, response);
	}
}
