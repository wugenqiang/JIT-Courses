package com.clps.oas.sm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.dao.PermissionMapper;
import com.clps.oas.sm.pojo.Permission;
import com.clps.oas.sm.pojo.PermissionVO;
import com.clps.oas.sm.service.IPermissionService;

/** 
* @description this is PermissionServiceImpl
* @author  noah.zhou 
* @date 创建时间：2018年5月11日 上午10:40:00 
* @version 1.0 
*/
@Service("PermissionServiceImpl")
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	PermissionMapper permissionDao;//自动注入对象permissionDao
	
	@Override
	public String deletePermissionById(Integer permissionId) {
		if(this.permissionDao.deletePermissionById(permissionId)>0){
			return ParamCommon.DELETE_SUCCESS;
		}else{
			return ParamCommon.DELETE_FAILURE;
		}
		
		/**
		* @descirption 根据permissionId逻辑删除权限
		* @param permissionId
		* @return 如果返回值等于1则成功，等于0则失败
		*/
	}

	@Override
	public String addPermission(Permission record) {
		if(this.permissionDao.addPermission(record)>0){
			return ParamCommon.ADD_SUCCESS;
		}else{
			return ParamCommon.ADD_FAILURE;
		}
		/**
		* @descirption 插入权限
		* @param record
		* @return 如果返回值等于1则成功，等于0则失败
		*/
	}
	
	@Override
	public String addPermissionVO(PermissionVO record) {
		if(this.permissionDao.addPermissionVO(record)>0){
			return ParamCommon.ADD_SUCCESS;
		}else{
			return ParamCommon.ADD_FAILURE;
		}
		/**
		* @descirption 插入VO权限
		* @param record
		* @return 如果返回值等于1则成功，等于0则失败
		*/
	}

	@Override
	public List<Permission> queryPermissionById(Integer permissionId) {
		return this.permissionDao.queryPermissionById(permissionId);
		/**
		* @descirption 根据permissionId查询单条权限信息
		* @param permissionId
		* @return 如果返回值等于1则成功，等于0则失败
		*/
	}

	@Override
	public String updatePermission(Permission record) {
		if(this.permissionDao.updatePermission(record)>0){
			return ParamCommon.UPDATE_SUCCESS;
		}else{
			return ParamCommon.UPDATE_FAILURE;
		}
		/**
		* @descirption 更新权限
		* @param record
		* @return 如果返回值等于1则成功，等于0则失败
		*/
	}

	@Override
	public List<Permission> queryAllPermissions() {
		return this.permissionDao.queryAllPermissions();
		/**
		* @descirption 查询所有权限
		* @param 
		* @return 如果返回值等于1则成功，等于0则失败
		*/
	}

}
