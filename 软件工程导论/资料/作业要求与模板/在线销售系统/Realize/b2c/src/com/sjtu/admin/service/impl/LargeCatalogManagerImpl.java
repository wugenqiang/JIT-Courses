package com.sjtu.admin.service.impl;

import com.sjtu.admin.dao.LargeCatalogDao;
import com.sjtu.admin.model.LargeCatalog;
import com.sjtu.admin.service.LargeCatalogManager;
import com.sjtu.service.impl.BaseManager;

import java.util.List;

public class LargeCatalogManagerImpl extends BaseManager implements
		LargeCatalogManager {
	private LargeCatalogDao dao;

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setLargeCatalogDao(LargeCatalogDao dao) {
		this.dao = dao;
	}

	/**
	 * @see com.sjtu.admin.service.LargeCatalogManager#getLargeCatalogs(com.sjtu.admin.model.LargeCatalog)
	 */
	public List getLargeCatalogs(final LargeCatalog largeCatalog) {
		return dao.getLargeCatalogs(largeCatalog);
	}

	/**
	 * @see com.sjtu.admin.service.LargeCatalogManager#getLargeCatalog(String
	 *      largeCatalogId)
	 */
	public LargeCatalog getLargeCatalog(final String largeCatalogId) {
		return dao.getLargeCatalog(new Long(largeCatalogId));
	}

	/**
	 * @see com.sjtu.admin.service.LargeCatalogManager#saveLargeCatalog(LargeCatalog
	 *      largeCatalog)
	 */
	public void saveLargeCatalog(LargeCatalog largeCatalog) {
		dao.saveLargeCatalog(largeCatalog);
	}

	/**
	 * @see com.sjtu.admin.service.LargeCatalogManager#removeLargeCatalog(String
	 *      largeCatalogId)
	 */
	public void removeLargeCatalog(final String largeCatalogId) {
		dao.removeLargeCatalog(new Long(largeCatalogId));
	}
}
