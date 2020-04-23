package com.sjtu.admin.dao;

import com.sjtu.admin.model.LargeCatalog;
import com.sjtu.dao.Dao;

import java.util.List;

public interface LargeCatalogDao extends Dao {

	/**
	 * Retrieves all of the largeCatalogs
	 */
	public List getLargeCatalogs(LargeCatalog largeCatalog);

	/**
	 * Gets largeCatalog's information based on primary key. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 * 
	 * @param largeCatalogId
	 *            the largecatalog's largeCatalogId
	 * @return largecatalog populated largecatalog object
	 */
	public LargeCatalog getLargeCatalog(final Long largeCatalogId);

	/**
	 * Saves a largecatalog's information
	 * 
	 * @param largecatalog
	 *            the object to be saved
	 */
	public void saveLargeCatalog(LargeCatalog largeCatalog);

	/**
	 * Removes a largeCatalog from the database by largeCatalogId
	 * 
	 * @param largeCatalogId
	 *            the largecatalog's largeCatalogId
	 */
	public void removeLargeCatalog(final Long largeCatalogId);
}
