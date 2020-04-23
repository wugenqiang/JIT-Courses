
/*
* Copyright @ 2018 com.jit
* clps.oas 上午10:45:12
* All right reserved.
*
*/
	
package com.clps.oas.sm.service.impl;
/**  
* @Title: RoleServiceImpl.java  
* @Package com.clps.oas.sm.service.impl  
* @Description: TODO 
* @author leo.jiang  
* @date 2018年5月22日  
* @version V1.0  
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.dao.RoleMapper;
import com.clps.oas.sm.pojo.Role;
import com.clps.oas.sm.service.IRoleService;

/**
* @desc: clps.oas
* @author: leo.jiang
* @createTime: 2018年5月22日 上午10:45:12
* @history:
* @version: v1.0
*/

@Service("RoleServiceImpl")
public class RoleServiceImpl implements IRoleService {

	@Autowired
	RoleMapper roleDao;
	/*
	*(non-Javadoc)
	* @see com.clps.oas.sm.service.IRoleService#addRole(com.clps.oas.sm.pojo.Role)
	*/

	@Override
	public String addRole(Role role) {
		if(this.roleDao.insertRole(role)>0){
			return ParamCommon.ADD_SUCCESS;
		}else{
			return ParamCommon.ADD_FAILURE;
		}
	}

	/*
	*(non-Javadoc)
	* @see com.clps.oas.sm.service.IRoleService#showRoles()
	*/

	@Override
	public List<Role> showRoles() {
		return this.roleDao.queryAllRoles();
	}

	/*
	*(non-Javadoc)
	* @see com.clps.oas.sm.service.IRoleService#deleteRoleById(java.lang.Integer)
	*/

	@Override
	public String deleteRoleById(Integer roleId) {
		if(this.roleDao.deleteByRoleId(roleId)>0){
			return ParamCommon.DELETE_SUCCESS;
		}else{
			return ParamCommon.DELETE_FAILURE;
		}
	}

	/*
	*(non-Javadoc)
	* @see com.clps.oas.sm.service.IRoleService#updateRole(com.clps.oas.sm.pojo.Role)
	*/

	@Override
	public String updateRole(Role role) {
		if(this.roleDao.updateByRoleId(role)>0){
			return ParamCommon.UPDATE_SUCCESS;
		}else{
			return ParamCommon.UPDATE_FAILURE;
		}
	}

	/*
	*(non-Javadoc)
	* @see com.clps.oas.sm.service.IRoleService#showRolesByRoleId(java.lang.Integer)
	*/

	@Override
	public List<Role> showRolesByRoleId(Integer roleId) {
		return this.roleDao.queryRoleByRoleId(roleId);
	}

	/*
	*(non-Javadoc)
	* @see com.clps.oas.sm.service.IRoleService#showRolesByRoleName(java.lang.String)
	*/

	@Override
	public List<Role> showRolesByRoleName(String roleName) {
		return this.roleDao.queryRoleByRoleName(roleName);
	}

}
