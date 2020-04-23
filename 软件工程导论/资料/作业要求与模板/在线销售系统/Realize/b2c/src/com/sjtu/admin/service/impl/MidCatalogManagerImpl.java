package com.sjtu.admin.service.impl;

import com.sjtu.admin.dao.MidCatalogDao;
import com.sjtu.admin.model.LargeCatalog;
import com.sjtu.admin.model.MidCatalog;
import com.sjtu.admin.service.MidCatalogManager;
import com.sjtu.service.impl.BaseManager;

import java.util.List;

public class MidCatalogManagerImpl extends BaseManager implements
		MidCatalogManager {
	private MidCatalogDao dao;

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setMidCatalogDao(MidCatalogDao dao) {
		this.dao = dao;
	}

	/**
	 * @see com.sjtu.admin.service.MidCatalogManager#getMidCatalogs(com.sjtu.admin.model.MidCatalog)
	 */
	public List getMidCatalogs(final MidCatalog midCatalog) {
		return dao.getMidCatalogs(midCatalog);
	}

	/**
	 * @see com.sjtu.admin.service.MidCatalogManager#getMidCatalog(String
	 *      midCatalogId)
	 */
	public MidCatalog getMidCatalog(final String midCatalogId) {
		return dao.getMidCatalog(new Long(midCatalogId));
	}

	/**
	 * @see com.sjtu.admin.service.MidCatalogManager#saveMidCatalog(MidCatalog
	 *      midCatalog)
	 */
	public void saveMidCatalog(MidCatalog midCatalog) {
		dao.saveMidCatalog(midCatalog);
	}

	/**
	 * @see com.sjtu.admin.service.MidCatalogManager#removeMidCatalog(String
	 *      midCatalogId)
	 */
	public void removeMidCatalog(final String midCatalogId) {
		dao.removeMidCatalog(new Long(midCatalogId));
	}

	public List getLargeCatalogList() {
		return dao.getLargeCatalogList();
	}

	public List getMidCatalogByUser() {
		return dao.getMidCatalogByUser();
	}

	public LargeCatalog getLargeCatalog(final String midCatalogId) {
		return dao.getLargeCatalog(midCatalogId);
	}

	public List getMidCatalogByLargeCatalogId(final String largeCatalogId) {
		return dao.getMidCatalogByLargeCatalogId(largeCatalogId);
	}
}
