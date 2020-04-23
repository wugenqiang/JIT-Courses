package com.sjtu.user.webapp.action;

import com.sjtu.Constants;
import com.sjtu.model.User;
import com.sjtu.user.model.Cart;
import com.sjtu.user.service.CartManager;
import com.sjtu.user.webapp.form.CartForm;
import com.sjtu.webapp.action.BaseAction;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action class to handle CRUD on a Cart object
 * 
 * @struts.action name="cartForm" path="/carts" scope="request" validate="false"
 *                parameter="method" input="mainMenu"
 * @struts.action name="cartForm" path="/editCart" scope="request"
 *                validate="false" parameter="method" input="list"
 * @struts.action name="cartForm" path="/saveCart" scope="request"
 *                validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/user/cartForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/user/cartList.jsp"
 * @struts.action-forward name="search" path="/carts.html" redirect="true"
 */
public final class CartAction extends BaseAction {
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
		CartForm cartForm = (CartForm) form;

		// Exceptions are caught by ActionExceptionHandler
		CartManager mgr = (CartManager) getBean("cartManager");
		mgr.removeCart(cartForm.getCartId());

		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"cart.deleted"));

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

		CartForm cartForm = (CartForm) form;

		// if an id is passed in, look up the user - otherwise
		// don't do anything - user is doing an add
		if (cartForm.getCartId() != null) {
			CartManager mgr = (CartManager) getBean("cartManager");
			Cart cart = mgr.getCart(cartForm.getCartId());
			cartForm = (CartForm) convert(cart);
			updateFormBean(mapping, request, cartForm);
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
		CartForm cartForm = (CartForm) form;
		boolean isNew = ("".equals(cartForm.getCartId()) || cartForm
				.getCartId() == null);

		CartManager mgr = (CartManager) getBean("cartManager");
		Cart cart = (Cart) convert(cartForm);
		mgr.saveCart(cart);

		// add success messages
		if (isNew) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"cart.added"));

			// save messages in session to survive a redirect
			saveMessages(request.getSession(), messages);

			return mapping.findForward("search");
		} else {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"cart.updated"));
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
		
		User user=getUser(request);
		
		
		CartForm cartForm = (CartForm) form;
		Cart cart = (Cart) convert(cartForm);

		CartManager mgr = (CartManager) getBean("cartManager");
		
		request.setAttribute(Constants.CART_LIST, mgr.getCarts(cart));

		return mapping.findForward("list");
	}

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return search(mapping, form, request, response);
	}
}
