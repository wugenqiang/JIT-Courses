package com.sjtu.admin.service;

import com.sjtu.admin.model.LargeCatalog;
import com.sjtu.service.Manager;

import java.util.List;

public interface LargeCatalogManager extends Manager {
	/**
	 * Retrieves all of the largecatalogs
	 */
	public List getLargeCatalogs(LargeCatalog largeCatalog);

	/**
	 * Gets largecatalog's information based on largeCatalogId.
	 * 
	 * @param largeCatalogId
	 *            the largecatalog's largeCatalogId
	 * @return largecatalog populated largecatalog object
	 */
	public LargeCatalog getLargeCatalog(final String largeCatalogId);

	/**
	 * Saves a largecatalog's information
	 * 
	 * @param largecatalog
	 *            the object to be saved
	 */
	public void saveLargeCatalog(LargeCatalog largeCatalog);

	/**
	 * Removes a largecatalog from the database by largeCatalogId
	 * 
	 * @param largeCatalogId
	 *            the largecatalog's largeCatalogId
	 */
	public void removeLargeCatalog(final String largeCatalogId);
}
