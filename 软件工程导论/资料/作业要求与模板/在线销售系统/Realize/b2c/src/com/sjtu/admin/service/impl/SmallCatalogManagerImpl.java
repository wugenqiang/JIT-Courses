package com.sjtu.admin.service.impl;

import com.sjtu.admin.dao.SmallCatalogDao;
import com.sjtu.admin.model.MidCatalog;
import com.sjtu.admin.model.SmallCatalog;
import com.sjtu.admin.service.SmallCatalogManager;
import com.sjtu.service.impl.BaseManager;

import java.util.List;

public class SmallCatalogManagerImpl extends BaseManager implements
		SmallCatalogManager {
	private SmallCatalogDao dao;

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setSmallCatalogDao(SmallCatalogDao dao) {
		this.dao = dao;
	}

	/**
	 * @see com.sjtu.admin.service.SmallCatalogManager#getSmallCatalogs(com.sjtu.admin.model.SmallCatalog)
	 */
	public List getSmallCatalogs(final SmallCatalog smallCatalog) {
		return dao.getSmallCatalogs(smallCatalog);
	}

	/**
	 * @see com.sjtu.admin.service.SmallCatalogManager#getSmallCatalog(String
	 *      smallCatalogId)
	 */
	public SmallCatalog getSmallCatalog(final String smallCatalogId) {
		return dao.getSmallCatalog(new Long(smallCatalogId));
	}

	/**
	 * @see com.sjtu.admin.service.SmallCatalogManager#saveSmallCatalog(SmallCatalog
	 *      smallCatalog)
	 */
	public void saveSmallCatalog(SmallCatalog smallCatalog) {
		dao.saveSmallCatalog(smallCatalog);
	}

	/**
	 * @see com.sjtu.admin.service.SmallCatalogManager#removeSmallCatalog(String
	 *      smallCatalogId)
	 */
	public void removeSmallCatalog(final String smallCatalogId) {
		dao.removeSmallCatalog(new Long(smallCatalogId));
	}

	public List getMidCatalogList() {
		return dao.getMidCatalogList();
	}

	public MidCatalog getMidCatalog(final String smallCatalogId) {
		return dao.getMidCatalog(smallCatalogId);
	}

	public List getSmallCatalogByMidCatalogId(final String midCatalogId) {
		return dao.getSmallCatalogByMidCatalogId(midCatalogId);
	}
}
