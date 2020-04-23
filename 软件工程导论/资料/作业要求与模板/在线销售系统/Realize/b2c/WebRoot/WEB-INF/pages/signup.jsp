<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="signup.title" /></title>
<content tag="heading">
<fmt:message key="signup.heading" />
</content>
<body id="signup" />

	<html:form action="/signup" styleId="userForm"
		onsubmit="return validateUserForm(this)">
		<ul>
			<li class="info">
				<fmt:message key="signup.message" />
			</li>
			<li>
				<b2c:label styleClass="desc" key="userForm.username" />
				<html:errors property="username" />
				<html:text styleClass="text large" property="username"
					styleId="username" />
			</li>
			<li>
				<div>
					<div class="left">
						<b2c:label styleClass="desc" key="userForm.password" />
						<html:errors property="password" />
						<html:password styleClass="text medium" property="password"
							styleId="password" redisplay="true" />
					</div>
					<div>
						<b2c:label styleClass="desc" key="userForm.confirmPassword" />
						<html:errors property="confirmPassword" />
						<html:password styleClass="text medium" property="confirmPassword"
							styleId="confirmPassword" redisplay="true" />
					</div>
				</div>
			</li>
			<li>
				<b2c:label styleClass="desc" key="userForm.passwordHint" />
				<html:errors property="passwordHint" />
				<html:text styleClass="text large" property="passwordHint"
					styleId="passwordHint" />
			</li>
			<li>
				<div>
					<div class="left">
						<b2c:label styleClass="desc" key="userForm.lastName" />
						<html:errors property="lastName" />
						<html:text styleClass="text medium" property="lastName"
							styleId="lastName" maxlength="50" />
					</div>
					<div>
						<b2c:label styleClass="desc" key="userForm.firstName" />
						<html:errors property="firstName" />
						<html:text styleClass="text medium" property="firstName"
							styleId="firstName" maxlength="50" />
					</div>

				</div>
			</li>
			<li>
				<div>
					<div class="left">
						<b2c:label styleClass="desc" key="userForm.email" />
						<html:errors property="email" />
						<html:text styleClass="text medium" property="email"
							styleId="email" />
					</div>
					<div>
						<b2c:label styleClass="desc" key="userForm.phoneNumber" />
						<html:errors property="phoneNumber" />
						<html:text styleClass="text medium" property="phoneNumber"
							styleId="phoneNumber" />
					</div>
				</div>
			</li>
			<li>
				<label class="desc">
					<fmt:message key="userForm.addressForm.address" />
				</label>
				<div class="group">
					<div class="left">
						<b2c:label key="userForm.addressForm.province" />
						<html:errors property="addressForm.province" />
						<html:text styleClass="text state" property="addressForm.province"
							styleId="addressForm.province" size="2" />

					</div>
					<div>
						<b2c:label key="userForm.addressForm.city" />
						<html:errors property="addressForm.city" />
						<html:text styleClass="text medium" property="addressForm.city"
							styleId="addressForm.city" />


					</div>
					<div class="left">
						<b2c:label key="userForm.addressForm.address" />
						<html:errors property="addressForm.address" />
						<html:text styleClass="text large" property="addressForm.address"
							styleId="addressForm.address" />
					</div>


					<div class="left">
						<b2c:label key="userForm.addressForm.postalCode" />
						<html:errors property="addressForm.postalCode" />
						<html:text styleClass="text zip" property="addressForm.postalCode"
							styleId="addressForm.postalCode" />

					</div>
				</div>
			</li>
			<br>
			</br>
			<li class="buttonBar bottom">
				<html:submit styleClass="button" onclick="bCancel=false">
					<fmt:message key="button.register" />
				</html:submit>

				<html:cancel styleClass="button" onclick="bCancel=true">
					<fmt:message key="button.cancel" />
				</html:cancel>
			</li>
		</ul>
	</html:form>

	<script type="text/javascript">
    Form.focusFirstElement($('userForm'));
</script>
	<html:javascript formName="userForm" cdata="false"
		dynamicJavascript="true" staticJavascript="false" />
	<script type="text/javascript"
		src="<c:url value="/scripts/validator.jsp"/>"></script>