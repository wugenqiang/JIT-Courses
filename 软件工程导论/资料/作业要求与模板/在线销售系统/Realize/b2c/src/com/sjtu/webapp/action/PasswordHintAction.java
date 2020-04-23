package com.sjtu.webapp.action;

import com.sjtu.model.User;
import com.sjtu.service.MailEngine;
import com.sjtu.service.UserManager;
import com.sjtu.webapp.util.RequestUtil;
import org.apache.struts.action.*;
import org.apache.struts.util.MessageResources;
import org.springframework.mail.SimpleMailMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action class to send password hints to registered users.
 * 
 * <p>
 * <a href="PasswordHintAction.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * 
 * @struts.action path="/passwordHint" validate="false"
 * @struts.action-forward name="previousPage" path="/"
 */
public final class PasswordHintAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MessageResources resources = getResources(request);
		ActionMessages errors = new ActionMessages();
		String username = request.getParameter("username");

		// ensure that the username has been sent
		if (username == null) {
			log
					.warn("Username not specified, notifying user that it's a required field.");

			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.required", resources
							.getMessage("userForm.username")));
			saveErrors(request, errors);
			return mapping.findForward("previousPage");
		}

		if (log.isDebugEnabled()) {
			log.debug("Processing Password Hint...");
		}

		ActionMessages messages = new ActionMessages();

		// look up the user's information
		try {
			UserManager userMgr = (UserManager) getBean("userManager");
			User user = userMgr.getUserByUsername(username);

			StringBuffer msg = new StringBuffer();
			msg.append("Your password hint is: " + user.getPasswordHint());
			msg.append("\n\nLogin at: " + RequestUtil.getAppURL(request));

			SimpleMailMessage message = (SimpleMailMessage) getBean("mailMessage");
			message.setTo(user.getEmail());
			String subject = '[' + resources.getMessage("webapp.name") + "] "
					+ resources.getMessage("userForm.passwordHint");
			message.setSubject(subject);
			message.setText(msg.toString());

			MailEngine mailEngine = (MailEngine) getBean("mailEngine");
			mailEngine.send(message);

			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"login.passwordHint.sent", username, user.getEmail()));
			saveMessages(request.getSession(), messages);
		} catch (Exception e) {
			e.printStackTrace();
			// If exception is expected do not rethrow
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"login.passwordHint.error", username));
			saveErrors(request, errors);
		}

		return mapping.findForward("previousPage");
	}
}
