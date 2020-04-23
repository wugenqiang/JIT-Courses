package com.sjtu.admin.dao;

import com.sjtu.admin.model.MidCatalog;
import com.sjtu.admin.model.SmallCatalog;
import com.sjtu.dao.Dao;

import java.util.List;

public interface SmallCatalogDao extends Dao {

	/**
	 * Retrieves all of the smallCatalogs
	 */
	public List getSmallCatalogs(SmallCatalog smallCatalog);

	/**
	 * Gets smallCatalog's information based on primary key. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 * 
	 * @param smallCatalogId
	 *            the smallCatalog's smallCatalogId
	 * @return smallCatalog populated smallCatalog object
	 */
	public SmallCatalog getSmallCatalog(final Long smallCatalogId);

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
	public void removeSmallCatalog(final Long smallCatalogId);

	public List getMidCatalogList();

	public MidCatalog getMidCatalog(final String smallCatalogId);

	public List getSmallCatalogByMidCatalogId(final String midCatalogId);
}
