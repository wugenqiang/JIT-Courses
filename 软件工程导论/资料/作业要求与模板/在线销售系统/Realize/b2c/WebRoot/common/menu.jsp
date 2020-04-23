<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity"
	config="WEB-INF/classes/cssHorizontalMenu.vm"
	permissions="rolesAdapter">
	<ul id="primary-nav" class="menuList">
		<li class="pad">
			&nbsp;
		</li>
		<c:if test="${empty pageContext.request.remoteUser}">
			<li>
				<a href="<c:url value="/login.jsp"/>" class="current"><fmt:message
						key="login.title" /> </a>
			</li>
		</c:if>
		<menu:displayMenu name="MainMenu" />
		<menu:displayMenu name="UserMenu" />
		<menu:displayMenu name="AdminMenu" />
		<!--LargeCatalog-START-->
		<menu:displayMenu name="LargeCatalogMenu" />
		<!--LargeCatalog-END-->
		<!--MidCatalog-START-->
		<menu:displayMenu name="MidCatalogMenu" />
		<!--MidCatalog-END-->
		<!--SmallCatalog-START-->
		<menu:displayMenu name="SmallCatalogMenu" />
		<!--SmallCatalog-END-->
		<!--Commodity-START-->
		<menu:displayMenu name="CommodityMenu" />
		<!--Commodity-END-->
		<!--CartCommodity-START-->
		<menu:displayMenu name="CartCommodityMenu" />
		<!--CartCommodity-END-->		
		<!--Ordera-START-->
		<menu:displayMenu name="OrderaMenu" />
		<!--Ordera-END-->
		<menu:displayMenu name="Logout" />
	</ul>
</menu:useMenuDisplayer>
