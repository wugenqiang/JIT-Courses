package com.sjtu.webapp.action;

import com.sjtu.Constants;
import com.sjtu.model.User;
import com.sjtu.service.MailEngine;
import com.sjtu.service.RoleManager;
import com.sjtu.service.UserExistsException;
import com.sjtu.service.UserManager;
import com.sjtu.util.StringUtil;
import com.sjtu.webapp.form.UserForm;
import com.sjtu.webapp.util.RequestUtil;
import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.ProviderManager;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.apache.struts.action.*;
import org.apache.struts.util.MessageResources;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.mail.SimpleMailMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action class to allow users to self-register.
 * 
 * <p/> <a href="SignupAction.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * 
 * @struts.action name="userForm" path="/signup" scope="request"
 *                validate="false" input="failure"
 * 
 * @struts.action-forward name="failure" path="/WEB-INF/pages/signup.jsp"
 * @struts.action-forward name="success" path="/mainMenu.html" redirect="true"
 */
public final class SignupAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// if it's an HTTP GET, simply forward to jsp
		if (request.getMethod().equals("GET")) {
			return mapping.findForward("failure");
			// user clicked cancel button
		} else if (isCancelled(request)) {
			return new ActionForward("/");
			// run validation
		} else {
			// run validation rules on this form
			ActionMessages errors = form.validate(mapping, request);
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
				return mapping.findForward("failure");
			}
		}

		if (log.isDebugEnabled()) {
			log.debug("registering user...");
		}

		ActionMessages errors = new ActionMessages();
		UserForm userForm = (UserForm) form;
		User user = (User) convert(form);

		// Set the default user role on this new user
		RoleManager roleMgr = (RoleManager) getBean("roleManager");
		user.addRole(roleMgr.getRole(Constants.USER_ROLE));

		try {
			Boolean encrypt = (Boolean) getConfiguration().get(
					Constants.ENCRYPT_PASSWORD);

			if (encrypt != null && encrypt.booleanValue()) {
				String algorithm = (String) getConfiguration().get(
						Constants.ENC_ALGORITHM);
				if (algorithm == null) { // should only happen for test case
					log.debug("assuming testcase, setting algorigthm to 'SHA'");
					algorithm = "SHA";
				}

				user.setPassword(StringUtil.encodePassword(user.getPassword(),
						algorithm));
			}

			user.setEnabled(true);
			UserManager mgr = (UserManager) getBean("userManager");
			mgr.saveUser(user);
		} catch (UserExistsException e) {
			log.warn(e.getMessage());
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.existing.user", userForm.getUsername(), userForm
							.getEmail()));
			saveErrors(request, errors);
			return mapping.getInputForward();
		}

		ActionMessages messages = new ActionMessages();
		MessageResources resources = getResources(request);

		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"user.registered", userForm.getUsername()));

		saveMessages(request.getSession(), messages);
		request.getSession().setAttribute(Constants.REGISTERED, Boolean.TRUE);

		// log user in automatically
		Authentication auth = new UsernamePasswordAuthenticationToken(user
				.getUsername(), user.getConfirmPassword());
		try {
			ProviderManager authenticationManager = (ProviderManager) getBean("authenticationManager");
			SecurityContextHolder.getContext().setAuthentication(
					authenticationManager.doAuthentication(auth));
		} catch (NoSuchBeanDefinitionException n) {
			// ignore, should only happen when testing
		}

		// Send user an e-mail
		if (log.isDebugEnabled()) {
			log.debug("Sending user '" + userForm.getUsername()
					+ "' an account information e-mail");
		}

		SimpleMailMessage message = (SimpleMailMessage) getBean("mailMessage");
		message.setTo(user.getFullName() + "<" + user.getEmail() + ">");

		StringBuffer msg = new StringBuffer();
		msg.append(resources.getMessage("signup.email.message"));
		msg.append("\n\n" + resources.getMessage("userForm.username"));
		msg.append(": " + userForm.getUsername() + "\n");
		msg.append(resources.getMessage("userForm.password") + ": ");
		msg.append(userForm.getPassword());
		msg.append("\n\nLogin at: " + RequestUtil.getAppURL(request));
		message.setText(msg.toString());

		message.setSubject(resources.getMessage("signup.email.subject"));

		MailEngine engine = (MailEngine) getBean("mailEngine");
		engine.send(message);

		return mapping.findForward("success");
	}

}
