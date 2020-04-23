package com.sjtu.user.webapp.action;

import com.sjtu.Constants;
import com.sjtu.admin.model.Commodity;
import com.sjtu.admin.service.CommodityManager;
import com.sjtu.model.User;
import com.sjtu.service.UserManager;
import com.sjtu.user.model.CartCommodity;
import com.sjtu.user.model.Ordera;
import com.sjtu.user.model.OrderaEncapsulation;
import com.sjtu.user.service.CartCommodityManager;
import com.sjtu.user.service.OrderaManager;
import com.sjtu.user.webapp.form.OrderaForm;
import com.sjtu.webapp.action.BaseAction;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Action class to handle CRUD on a Ordera object
 * 
 * @struts.action name="orderaForm" path="/orderas" scope="request"
 *                validate="false" parameter="method" input="mainMenu"
 * @struts.action name="orderaForm" path="/editOrdera" scope="request"
 *                validate="false" parameter="method" input="list"
 * @struts.action name="orderaForm" path="/saveOrdera" scope="request"
 *                validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/user/orderaForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/user/orderaList.jsp"
 * @struts.action-forward name="search" path="/orderas.html" redirect="true"
 */
public final class OrderaAction extends BaseAction {
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
		OrderaForm orderaForm = (OrderaForm) form;

		// Exceptions are caught by ActionExceptionHandler
		OrderaManager mgr = (OrderaManager) getBean("orderaManager");
		mgr.removeOrdera(orderaForm.getOrderaId());

		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"ordera.deleted"));

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

		OrderaForm orderaForm = (OrderaForm) form;

		OrderaManager omgr = (OrderaManager) getBean("orderaManager");
		List cartCommodityList = new ArrayList();
		cartCommodityList = omgr.getCartCommodityList();
		request.setAttribute("cartCommodityList", cartCommodityList);
		// if an id is passed in, look up the user - otherwise
		// don't do anything - user is doing an add
		if (orderaForm.getOrderaId() != null) {
			OrderaManager mgr = (OrderaManager) getBean("orderaManager");
			CommodityManager ccmgr = (CommodityManager) getBean("commodityManager");
			CartCommodityManager cmgr = (CartCommodityManager) getBean("cartCommodityManager");
			UserManager umgr = (UserManager) getBean("userManager");
			Ordera ordera = mgr.getOrdera(orderaForm.getOrderaId());
			orderaForm = (OrderaForm) convert(ordera);
			orderaForm.setCartCommodityId(ordera.getCartCommodityId()
					.toString());
			CartCommodity cartCommodity = mgr.getCartCommodity(ordera
					.getOrderaId().toString());
			Commodity commodity = cmgr.getCommodity(cartCommodity
					.getCartCommodityId().toString());
			float totalDiscount = commodity.getCommodityDiscount()
					* cartCommodity.getCommodityNumber();
			float totalPrice = commodity.getCommodityPrice()
					* cartCommodity.getCommodityNumber();
			orderaForm.setTotalPrice(String.valueOf(totalPrice));
			orderaForm.setTotalDiscount(String.valueOf(totalDiscount));
			Date date = new Date();
			orderaForm.setOrderaTime(date);
			HttpSession session = request.getSession();
			User user = (User) getUser(request);
			orderaForm.setUserId(user.getId().toString());
			String cartCommodityId = cartCommodity.getCartCommodityId()
					.toString();
			request.setAttribute("cartCommodityId", cartCommodityId);

			updateFormBean(mapping, request, orderaForm);
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
		OrderaForm orderaForm = (OrderaForm) form;
		boolean isNew = ("".equals(orderaForm.getOrderaId()) || orderaForm
				.getOrderaId() == null);

		Date date = new Date();
		orderaForm.setOrderaTime(date);
		User user = getUser(request);
		OrderaManager mgr = (OrderaManager) getBean("orderaManager");
		// CartCommodityManager cmgr = (CartCommodityManager)
		// getBean("cartCommodityManager");
		Ordera ordera = new Ordera();
		// ordera.setCartCommodityId(Long.parseLong(orderaForm
		// .getCartCommodityId()));
		// CartCommodity cartCommodity = cmgr.getCartCommodity(ordera
		// .getCartCommodityId().toString());
		// Commodity commodity = cmgr.getCommodity(cartCommodity
		// .getCartCommodityId().toString());
		ordera.setOrderaTime(Timestamp.valueOf(orderaForm.getOrderaTime()));
		ordera.setUserId(user.getId());
		if (!orderaForm.getOrderaId().equals("")) {
			ordera.setOrderaId(Long.parseLong(orderaForm.getOrderaId()));
		}

		// add success messages
		if (isNew) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"ordera.added"));

			// save messages in session to survive a redirect
			saveMessages(request.getSession(), messages);

			// return mapping.findForward("search");
		} else {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"ordera.updated"));
			saveMessages(request, messages);
			// return mapping.findForward("edit");
		}

		String cartCommodityId = request.getParameter("cartCommodityId");
		ordera.setCartCommodityId(Long.parseLong(cartCommodityId));
		CartCommodityManager cmgr = (CartCommodityManager) getBean("cartCommodityManager");
		CartCommodity cartCommodity = cmgr.getCartCommodity(ordera
				.getCartCommodityId().toString());
		Commodity commodity = cmgr.getCommodity(cartCommodity
				.getCartCommodityId().toString());
		float totalDiscount = commodity.getCommodityDiscount()
				* cartCommodity.getCommodityNumber();
		float totalPrice = commodity.getCommodityPrice()
				* cartCommodity.getCommodityNumber();
		ordera.setTotalDiscount(totalDiscount);
		ordera.setTotalPrice(totalPrice);

		mgr.saveOrdera(ordera);
		// String path = "/orderas.html";
		ActionForward af = new ActionForward();
		af.setRedirect(true);
		af.setPath("/orderas.html?cartCommodityId=" + cartCommodityId);
		return af;
	}

	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Entering 'search' method");
		}
		User user = getUser(request);
		OrderaManager mgr = (OrderaManager) getBean("orderaManager");
		// UserManager umgr = (UserManager) getBean("userManager");
		CommodityManager ccmgr = (CommodityManager) getBean("commodityManager");
		CartCommodityManager cmgr = (CartCommodityManager) getBean("cartCommodityManager");
		List list = new ArrayList();
		List result = new ArrayList();
		list = mgr.getOrderaByUser(user.getId());
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Ordera temp = (Ordera) it.next();
			OrderaEncapsulation oe = new OrderaEncapsulation();
			oe.setOrdera(temp);
			CartCommodity cartCommodity = cmgr.getCartCommodity(temp
					.getCartCommodityId().toString());
			oe.setCartCommodity(cartCommodity);
			Commodity commodity = ccmgr.getCommodity(cartCommodity
					.getCommodityId().toString());
			oe.setCommodity(commodity);
			oe.setUser(user);
			result.add(oe);
		}
		request.setAttribute(Constants.ORDERA_LIST, result);
		return mapping.findForward("list");
	}

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return search(mapping, form, request, response);
	}
}
