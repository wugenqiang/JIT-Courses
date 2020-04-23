/**
 * 
 */
package com.sjtu.search.webapp.action;

import com.sjtu.admin.model.Commodity;
import com.sjtu.admin.service.CommodityManager;
import com.sjtu.model.User;
import com.sjtu.service.UserManager;
import com.sjtu.user.model.CartCommodity;
import com.sjtu.user.model.Ordera;
import com.sjtu.user.service.CartCommodityManager;
import com.sjtu.user.service.OrderaManager;
import com.sjtu.user.webapp.form.OrderaForm;
import com.sjtu.webapp.action.BaseAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 *
 */
public class OrderaViewAction  extends BaseAction {
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Entering 'viewCommodity' method");
		}
		OrderaForm orderaForm=(OrderaForm)form;
		OrderaManager omgr=(OrderaManager)getBean("orderaManager");
		Ordera ordera=omgr.getOrdera(orderaForm.getOrderaId());		
		request.setAttribute("ordera", ordera);
		
		orderaForm.setOrderaId(ordera.getOrderaId().toString());		
		orderaForm.setCartCommodityId(ordera.getCartCommodityId().toString());		
		orderaForm.setOrderaTime(ordera.getOrderaTime());
		orderaForm.setTotalPrice(ordera.getTotalPrice().toString());
		orderaForm.setTotalDiscount(ordera.getTotalDiscount().toString());		
		orderaForm.setUserId(ordera.getUserId().toString());		
		if(ordera!=null){
			orderaForm=(OrderaForm)convert(ordera);
			//CartCommodity cartCommodity=omgr.getCartCommodity(ordera.getOrderaId().toString());
			String cartCommodityId=ordera.getCartCommodityId().toString();			
			CartCommodityManager cmgr=(CartCommodityManager)getBean("cartCommodityManager");		
			CartCommodity cartCommodity=cmgr.getCartCommodity(cartCommodityId);			
			request.setAttribute("cartCommodity", cartCommodity);
			//String commodityId=cartCommodity.getCommodityId().toString();			
			CommodityManager ccmgr=(CommodityManager)getBean("commodityManager");
			Commodity commodity=ccmgr.getCommodity(cartCommodity.getCommodityId().toString());
			request.setAttribute("commodity", commodity);
			
			UserManager umgr=(UserManager)getBean("userManager");
			User user=umgr.getUser(ordera.getUserId().toString());			
			request.setAttribute("user", user);
			
			
		}
		return mapping.findForward("view");
	}
}
