package com.sjtu.service.impl;

import com.sjtu.dao.RoleDao;
import com.sjtu.model.Role;
import com.sjtu.service.RoleManager;

import java.util.List;

/**
 * Implementation of RoleManager interface.
 * </p>
 * 
 * <p>
 * <a href="RoleManagerImpl.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 */
public class RoleManagerImpl extends BaseManager implements RoleManager {
	private RoleDao dao;

	public void setRoleDao(RoleDao dao) {
		this.dao = dao;
	}

	public List getRoles(Role role) {
		return dao.getRoles(role);
	}

	public Role getRole(String rolename) {
		return dao.getRoleByName(rolename);
	}

	public void saveRole(Role role) {
		dao.saveRole(role);
	}

	public void removeRole(String rolename) {
		dao.removeRole(rolename);
	}
}
