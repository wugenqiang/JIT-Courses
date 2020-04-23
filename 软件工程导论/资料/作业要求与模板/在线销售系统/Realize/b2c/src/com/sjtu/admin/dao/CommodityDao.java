package com.sjtu.admin.dao;

import com.sjtu.admin.model.Commodity;
import com.sjtu.admin.model.SmallCatalog;
import com.sjtu.dao.Dao;

import java.util.List;

public interface CommodityDao extends Dao {

	/**
	 * Retrieves all of the commoditys
	 */
	public List getCommoditys(Commodity commodity);

	/**
	 * Gets commodity's information based on primary key. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 * 
	 * @param commodityId
	 *            the commodity's commodityId
	 * @return commodity populated commodity object
	 */
	public Commodity getCommodity(final Long commodityId);

	/**
	 * Saves a commodity's information
	 * 
	 * @param commodity
	 *            the object to be saved
	 */
	public void saveCommodity(Commodity commodity);

	/**
	 * Removes a commodity from the database by commodityId
	 * 
	 * @param commodityId
	 *            the commodity's commodityId
	 */
	public void removeCommodity(final Long commodityId);

	public List getSmallCatalogList();

	public List getCommodityBySmallCatalog();

	public SmallCatalog getSmallCatalog(final Long commodityId);
}
