package com.sjtu.admin.webapp.action;

import com.sjtu.Constants;
import com.sjtu.admin.model.LargeCatalog;
import com.sjtu.admin.service.LargeCatalogManager;
import com.sjtu.admin.webapp.form.LargeCatalogForm;
import com.sjtu.webapp.action.BaseAction;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action class to handle CRUD on a Largecatalog object
 * 
 * @struts.action name="largecatalogForm" path="/largecatalogs" scope="request"
 *                validate="false" parameter="method" input="mainMenu"
 * @struts.action name="largecatalogForm" path="/editLargecatalog"
 *                scope="request" validate="false" parameter="method"
 *                input="list"
 * @struts.action name="largecatalogForm" path="/saveLargecatalog"
 *                scope="request" validate="true" parameter="method"
 *                input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit"
 *                        path="/WEB-INF/pages/admin/largecatalogForm.jsp"
 * @struts.action-forward name="list"
 *                        path="/WEB-INF/pages/admin/largecatalogList.jsp"
 * @struts.action-forward name="search" path="/largecatalogs.html"
 *                        redirect="true"
 */
public final class LargeCatalogAction extends BaseAction {
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
		LargeCatalogForm largeCatalogForm = (LargeCatalogForm) form;

		// Exceptions are caught by ActionExceptionHandler
		LargeCatalogManager mgr = (LargeCatalogManager) getBean("largeCatalogManager");
		mgr.removeLargeCatalog(largeCatalogForm.getLargeCatalogId());

		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"largeCatalog.deleted"));

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

		LargeCatalogForm largeCatalogForm = (LargeCatalogForm) form;

		// if an id is passed in, look up the user - otherwise
		// don't do anything - user is doing an add
		if (largeCatalogForm.getLargeCatalogId() != null) {
			LargeCatalogManager mgr = (LargeCatalogManager) getBean("largeCatalogManager");
			LargeCatalog largeCatalog = mgr.getLargeCatalog(largeCatalogForm
					.getLargeCatalogId());
			largeCatalogForm = (LargeCatalogForm) convert(largeCatalog);
			updateFormBean(mapping, request, largeCatalogForm);
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
		LargeCatalogForm largeCatalogForm = (LargeCatalogForm) form;
		boolean isNew = ("".equals(largeCatalogForm.getLargeCatalogId()) || largeCatalogForm
				.getLargeCatalogId() == null);

		LargeCatalogManager mgr = (LargeCatalogManager) getBean("largeCatalogManager");
		LargeCatalog largeCatalog = (LargeCatalog) convert(largeCatalogForm);
		mgr.saveLargeCatalog(largeCatalog);

		// add success messages
		if (isNew) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"largecatalog.added"));

			// save messages in session to survive a redirect
			saveMessages(request.getSession(), messages);

			return mapping.findForward("search");
		} else {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"largeCatalog.updated"));
			saveMessages(request, messages);

			return mapping.findForward("edit");
		}
	}

	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Entering 'search' method");
		}

		LargeCatalogForm largeCatalogForm = (LargeCatalogForm) form;
		LargeCatalog largeCatalog = (LargeCatalog) convert(largeCatalogForm);

		LargeCatalogManager mgr = (LargeCatalogManager) getBean("largeCatalogManager");
		request.setAttribute(Constants.LARGECATALOG_LIST, mgr
				.getLargeCatalogs(largeCatalog));

		return mapping.findForward("list");
	}

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return search(mapping, form, request, response);
	}
}
