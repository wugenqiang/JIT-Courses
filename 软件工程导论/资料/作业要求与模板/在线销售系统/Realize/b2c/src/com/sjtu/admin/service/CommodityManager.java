package com.sjtu.admin.service;

import com.sjtu.admin.model.Commodity;
import com.sjtu.admin.model.SmallCatalog;
import com.sjtu.service.Manager;

import java.util.List;

public interface CommodityManager extends Manager {
	/**
	 * Retrieves all of the commoditys
	 */
	public List getCommoditys(Commodity commodity);

	/**
	 * Gets commodity's information based on commodityId.
	 * 
	 * @param commodityId
	 *            the commodity's commodityId
	 * @return commodity populated commodity object
	 */
	public Commodity getCommodity(final String commodityId);

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
	public void removeCommodity(final String commodityId);

	public List getSmallCatalogList();

	public List getCommodityBySmallCatalog();

	public SmallCatalog getSmallCatalog(final String commodityId);

}
