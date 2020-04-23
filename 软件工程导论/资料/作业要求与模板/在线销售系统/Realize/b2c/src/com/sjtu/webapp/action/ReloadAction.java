package com.sjtu.webapp.action;

import com.sjtu.webapp.listener.StartupListener;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * This class is used to reload the drop-downs initialized in the
 * StartupListener.
 * 
 * <p>
 * <a href="ReloadAction.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * 
 * @struts.action path="/reload" validate="false" roles="admin"
 */
public final class ReloadAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Entering 'execute' method");
		}

		StartupListener.setupContext(getServlet().getServletContext());

		String referer = request.getHeader("Referer");

		if (referer != null) {
			log.debug("reload complete, reloading user back to: " + referer);

			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"reload.succeeded"));
			saveMessages(request.getSession(), messages);

			response.sendRedirect(response.encodeRedirectURL(referer));
			return null;
		} else {
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Context Reloaded</title>");
			out.println("</head>");
			out.println("<body bgcolor=\"white\">");
			out.println("<script type=\"text/javascript\">");
			out
					.println("alert('Context Reload Succeeded! Click OK to continue.');");
			out.println("history.back();");
			out.println("</script>");
			out.println("</body>");
			out.println("</html>");
		}

		return null;
	}
}
