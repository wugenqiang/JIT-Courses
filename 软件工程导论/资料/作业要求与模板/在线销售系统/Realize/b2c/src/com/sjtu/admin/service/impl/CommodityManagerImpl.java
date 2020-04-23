package com.sjtu.admin.service.impl;

import com.sjtu.admin.dao.CommodityDao;
import com.sjtu.admin.model.Commodity;
import com.sjtu.admin.model.SmallCatalog;
import com.sjtu.admin.service.CommodityManager;
import com.sjtu.service.impl.BaseManager;

import java.util.List;

public class CommodityManagerImpl extends BaseManager implements
		CommodityManager {
	private CommodityDao dao;

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setCommodityDao(CommodityDao dao) {
		this.dao = dao;
	}

	/**
	 * @see com.sjtu.admin.service.CommodityManager#getCommoditys(com.sjtu.admin.model.Commodity)
	 */
	public List getCommoditys(final Commodity commodity) {
		return dao.getCommoditys(commodity);
	}

	/**
	 * @see com.sjtu.admin.service.CommodityManager#getCommodity(String
	 *      commodityId)
	 */
	public Commodity getCommodity(final String commodityId) {
		return dao.getCommodity(new Long(commodityId));
	}

	/**
	 * @see com.sjtu.admin.service.CommodityManager#saveCommodity(Commodity
	 *      commodity)
	 */
	public void saveCommodity(Commodity commodity) {
		dao.saveCommodity(commodity);
	}

	/**
	 * @see com.sjtu.admin.service.CommodityManager#removeCommodity(String
	 *      commodityId)
	 */
	public void removeCommodity(final String commodityId) {
		dao.removeCommodity(new Long(commodityId));
	}

	public List getSmallCatalogList() {
		return dao.getSmallCatalogList();
	}

	public List getCommodityBySmallCatalog() {
		return dao.getCommodityBySmallCatalog();
	}

	public SmallCatalog getSmallCatalog(final String commodityId) {
		return dao.getSmallCatalog(new Long(commodityId));
	}
}
