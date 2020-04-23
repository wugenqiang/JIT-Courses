package com.sjtu.admin.dao;

import com.sjtu.admin.model.LargeCatalog;
import com.sjtu.admin.model.MidCatalog;
import com.sjtu.dao.Dao;

import java.util.List;

public interface MidCatalogDao extends Dao {

	/**
	 * Retrieves all of the midCatalogs
	 */
	public List getMidCatalogs(MidCatalog midCatalog);

	/**
	 * Gets midCatalog's information based on primary key. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 * 
	 * @param midCatalogId
	 *            the midCatalog's midCatalogId
	 * @return midCatalog populated midCatalog object
	 */
	public MidCatalog getMidCatalog(final Long midCatalogId);

	/**
	 * Saves a midCatalog's information
	 * 
	 * @param midCatalog
	 *            the object to be saved
	 */
	public void saveMidCatalog(MidCatalog midCatalog);

	/**
	 * Removes a midCatalog from the database by midCatalogId
	 * 
	 * @param midCatalogId
	 *            the midCatalog's midCatalogId
	 */
	public void removeMidCatalog(final Long midCatalogId);

	public List getLargeCatalogList();

	public List getMidCatalogByUser();

	public LargeCatalog getLargeCatalog(final String midCatalogId);

	public List getMidCatalogByLargeCatalogId(final String largeCatalogId);
}
