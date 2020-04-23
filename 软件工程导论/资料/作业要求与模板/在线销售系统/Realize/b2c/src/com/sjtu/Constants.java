package com.sjtu;

/**
 * Constant values used throughout the application.
 * 
 * <p>
 * <a href="Constants.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class Constants {
	// ~ Static fields/initializers
	// =============================================

	/** The name of the ResourceBundle used in this application */
	public static final String BUNDLE_KEY = "ApplicationResources";

	/** The encryption algorithm key to be used for passwords */
	public static final String ENC_ALGORITHM = "algorithm";

	/** A flag to indicate if passwords should be encrypted */
	public static final String ENCRYPT_PASSWORD = "encryptPassword";

	/** File separator from System properties */
	public static final String FILE_SEP = System.getProperty("file.separator");

	/** User home from System properties */
	public static final String USER_HOME = System.getProperty("user.home")
			+ FILE_SEP;

	/** The name of the configuration hashmap stored in application scope. */
	public static final String CONFIG = "appConfig";

	/**
	 * Session scope attribute that holds the locale set by the user. By setting
	 * this key to the same one that Struts uses, we get synchronization in
	 * Struts w/o having to do extra work or have two session-level variables.
	 */
	public static final String PREFERRED_LOCALE_KEY = "org.apache.struts.action.LOCALE";

	/**
	 * The request scope attribute under which an editable user form is stored
	 */
	public static final String USER_KEY = "userForm";

	/**
	 * The request scope attribute that holds the user list
	 */
	public static final String USER_LIST = "userList";

	/**
	 * The request scope attribute for indicating a newly-registered user
	 */
	public static final String REGISTERED = "registered";

	/**
	 * The name of the Administrator role, as specified in web.xml
	 */
	public static final String ADMIN_ROLE = "admin";

	/**
	 * The name of the User role, as specified in web.xml
	 */
	public static final String USER_ROLE = "user";

	/**
	 * The name of the user's role list, a request-scoped attribute when
	 * adding/editing a user.
	 */
	public static final String USER_ROLES = "userRoles";

	/**
	 * The name of the available roles list, a request-scoped attribute when
	 * adding/editing a user.
	 */
	public static final String AVAILABLE_ROLES = "availableRoles";

	/**
	 * The name of the CSS Theme setting.
	 */
	public static final String CSS_THEME = "csstheme";

	// LargeCatalog-START
	/**
	 * The request scope attribute that holds the largeCatalog form.
	 */
	public static final String LARGECATALOG_KEY = "largeCatalogForm";

	/**
	 * The request scope attribute that holds the largeCatalog list
	 */
	public static final String LARGECATALOG_LIST = "largeCatalogList";
	// LargeCatalog-END

	// MidCatalog-START
	/**
	 * The request scope attribute that holds the midCatalog form.
	 */
	public static final String MIDCATALOG_KEY = "midCatalogForm";

	/**
	 * The request scope attribute that holds the midCatalog list
	 */
	public static final String MIDCATALOG_LIST = "midCatalogList";
	// MidCatalog-END

	// SmallCatalog-START
	/**
	 * The request scope attribute that holds the smallCatalog form.
	 */
	public static final String SMALLCATALOG_KEY = "smallCatalogForm";

	/**
	 * The request scope attribute that holds the smallCatalog list
	 */
	public static final String SMALLCATALOG_LIST = "smallCatalogList";
	// SmallCatalog-END

	// Commodity-START
	/**
	 * The request scope attribute that holds the commodity form.
	 */
	public static final String COMMODITY_KEY = "commodityForm";

	/**
	 * The request scope attribute that holds the commodity list
	 */
	public static final String COMMODITY_LIST = "commodityList";
	// Commodity-END

	// CartCommodity-START
	/**
	 * The request scope attribute that holds the cartCommodity form.
	 */
	public static final String CARTCOMMODITY_KEY = "cartCommodityForm";

	/**
	 * The request scope attribute that holds the cartCommodity list
	 */
	public static final String CARTCOMMODITY_LIST = "cartCommodityList";
	// CartCommodity-END

	// Cart-START
	/**
	 * The request scope attribute that holds the cart form.
	 */
	public static final String CART_KEY = "cartForm";

	/**
	 * The request scope attribute that holds the cart list
	 */
	public static final String CART_LIST = "cartList";
	// Cart-END

	// Ordera-START
	/**
	 * The request scope attribute that holds the ordera form.
	 */
	public static final String ORDERA_KEY = "orderaForm";

	/**
	 * The request scope attribute that holds the ordera list
	 */
	public static final String ORDERA_LIST = "orderaList";
	// Orderaa-END
}
