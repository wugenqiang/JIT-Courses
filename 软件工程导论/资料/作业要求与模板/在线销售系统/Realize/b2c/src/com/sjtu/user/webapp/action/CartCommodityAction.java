package com.sjtu.user.webapp.action;

import com.sjtu.Constants;
import com.sjtu.admin.model.Commodity;
import com.sjtu.admin.service.CommodityManager;
import com.sjtu.model.User;
import com.sjtu.service.UserManager;
import com.sjtu.user.model.CartCommodity;
import com.sjtu.user.model.CartCommodityEncapsulation;
import com.sjtu.user.service.CartCommodityManager;
import com.sjtu.user.webapp.form.CartCommodityForm;
import com.sjtu.webapp.action.BaseAction;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Action class to handle CRUD on a CartCommodity object
 * 
 * @struts.action name="cartCommodityForm" path="/cartCommoditys"
 *                scope="request" validate="false" parameter="method"
 *                input="mainMenu"
 * @struts.action name="cartCommodityForm" path="/editCartCommodity"
 *                scope="request" validate="false" parameter="method"
 *                input="list"
 * @struts.action name="cartCommodityForm" path="/saveCartCommodity"
 *                scope="request" validate="true" parameter="method"
 *                input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit"
 *                        path="/WEB-INF/pages/user/cartCommodityForm.jsp"
 * @struts.action-forward name="list"
 *                        path="/WEB-INF/pages/user/cartCommodityList.jsp"
 * @struts.action-forward name="search" path="/cartCommoditys.html"
 *                        redirect="true"
 */
public final class CartCommodityAction extends BaseAction {
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
		CartCommodityForm cartCommodityForm = (CartCommodityForm) form;

		// Exceptions are caught by ActionExceptionHandler
		CartCommodityManager mgr = (CartCommodityManager) getBean("cartCommodityManager");
		mgr.removeCartCommodity(cartCommodityForm.getCartCommodityId());

		String commodityId = request.getParameter("commodityId");

		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"cartCommodity.deleted"));

		// save messages in session, so they'll survive the redirect
		saveMessages(request.getSession(), messages);

		ActionForward af = new ActionForward();
		af.setPath("/cartCommoditys.html?commodityId=" + commodityId);
		af.setRedirect(true);

		return af;
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Entering 'edit' method");
		}

		CartCommodityForm cartCommodityForm = (CartCommodityForm) form;

		CartCommodityManager ccmgr = (CartCommodityManager) getBean("cartCommodityManager");
		List commodityList = new ArrayList();
		commodityList = ccmgr.getCommodityList();
		request.setAttribute("commodityList", commodityList);
		// if an id is passed in, look up the user - otherwise
		// don't do anything - user is doing an add
		if (cartCommodityForm.getCartCommodityId() != null) {
			CartCommodityManager mgr = (CartCommodityManager) getBean("cartCommodityManager");
			CommodityManager cmgr = (CommodityManager) getBean("commodityManager");
			UserManager umgr = (UserManager) getBean("userManager");
			CartCommodity cartCommodity = mgr
					.getCartCommodity(cartCommodityForm.getCartCommodityId());
			cartCommodityForm = (CartCommodityForm) convert(cartCommodity);
			cartCommodityForm.setCommodityId(cartCommodity.getCommodityId()
					.toString());
			cartCommodityForm.setCommodityNumber(cartCommodity
					.getCommodityNumber().toString());

			HttpSession session = request.getSession();
			User user = (User) getUser(request);

			cartCommodityForm.setUserId(user.getId().toString());

			Commodity commodity = cmgr.getCommodity(cartCommodity
					.getCommodityId().toString());
			String commodityName = commodity.getCommodityName();
			request.setAttribute("commodityName", commodityName);

			updateFormBean(mapping, request, cartCommodityForm);
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
		CartCommodityForm cartCommodityForm = (CartCommodityForm) form;
		boolean isNew = ("".equals(cartCommodityForm.getCartCommodityId()) || cartCommodityForm
				.getCartCommodityId() == null);

		User user = getUser(request);
		CartCommodityManager mgr = (CartCommodityManager) getBean("cartCommodityManager");
		CartCommodity cartCommodity = new CartCommodity();

		cartCommodity.setCommodityNumber(Integer.valueOf(cartCommodityForm
				.getCommodityNumber()));
		cartCommodity.setUserId(user.getId());

		if (!cartCommodityForm.getCartCommodityId().equals("")) {
			cartCommodity.setCartCommodityId(Long.parseLong(cartCommodityForm
					.getCartCommodityId()));
		}
		// add success messages
		if (isNew) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"cartCommodity.added"));

			// save messages in session to survive a redirect
			saveMessages(request.getSession(), messages);

			// return mapping.findForward("search");
		} else {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"cartCommodity.updated"));
			saveMessages(request, messages);

			// return mapping.findForward("edit");
		}
		String commodityId = request.getParameter("commodityId");
		cartCommodity.setCommodityId(Long.parseLong(commodityId));
		mgr.saveCartCommodity(cartCommodity);
		// String path = "/cartCommoditys.html";
		ActionForward af = new ActionForward();
		af.setRedirect(true);
		af.setPath("/cartCommoditys.html?commodityId=" + commodityId);
		return af;
	}

	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Entering 'search' method");
		}

		CartCommodityForm cartCommodityForm = (CartCommodityForm) form;
		CartCommodity cartCommodity = (CartCommodity) convert(cartCommodityForm);
		User user = getUser(request);
		CartCommodityManager mgr = (CartCommodityManager) getBean("cartCommodityManager");
		CommodityManager cmgr = (CommodityManager) getBean("commodityManager");
		// UserManager umgr = (UserManager) getBean("userManager");
		List list = new ArrayList();
		List result = new ArrayList();
		list = mgr.getCartCommodityByUser(user.getId().toString());
		Iterator it = list.iterator();
		while (it.hasNext()) {
			CartCommodity temp = (CartCommodity) it.next();
			CartCommodityEncapsulation ce = new CartCommodityEncapsulation();
			ce.setCartCommodity(temp);
			Commodity commodity = (Commodity) cmgr.getCommodity(temp
					.getCommodityId().toString());
			ce.setCommodity(commodity);
			ce.setUser(user);
			result.add(ce);

		}

		request.setAttribute(Constants.CARTCOMMODITY_LIST, result);

		return mapping.findForward("list");
	}

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return search(mapping, form, request, response);
	}
}
