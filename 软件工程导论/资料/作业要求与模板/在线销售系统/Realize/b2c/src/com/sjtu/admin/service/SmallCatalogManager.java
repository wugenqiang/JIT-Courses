package com.sjtu.admin.service;

import com.sjtu.admin.model.MidCatalog;
import com.sjtu.admin.model.SmallCatalog;
import com.sjtu.service.Manager;

import java.util.List;

public interface SmallCatalogManager extends Manager {
	/**
	 * Retrieves all of the smallCatalogs
	 */
	public List getSmallCatalogs(SmallCatalog smallCatalog);

	/**
	 * Gets smallCatalog's information based on smallCatalogId.
	 * 
	 * @param smallCatalogId
	 *            the smallCatalog's smallCatalogId
	 * @return smallCatalog populated smallCatalog object
	 */
	public SmallCatalog getSmallCatalog(final String smallCatalogId);

	/**
	 * Saves a smallCatalog's information
	 * 
	 * @param smallCatalog
	 *            the object to be saved
	 */
	public void saveSmallCatalog(SmallCatalog smallCatalog);

	/**
	 * Removes a smallCatalog from the database by smallCatalogId
	 * 
	 * @param smallCatalogId
	 *            the smallCatalog's smallCatalogId
	 */
	public void removeSmallCatalog(final String smallCatalogId);

	public List getMidCatalogList();

	public MidCatalog getMidCatalog(final String smallCatalogId);

	public List getSmallCatalogByMidCatalogId(final String midCatalogId);
}
