package com.clps.oas.sm.dao;
import java.util.List;

import com.clps.oas.sm.pojo.Permission;
import com.clps.oas.sm.pojo.PermissionVO;

/** 
* @description this is PermissionMapper
* @author  noah.zhou 
* @date 创建时间：2018年5月11日 上午10:40:00 
* @version 1.0 
*/


public interface PermissionMapper {
	
	/**
	* @descirption 根据permissionId逻辑删除权限
	* @param permissionId
	* @return 如果返回值大于0则成功，反之失败
	*/
    int deletePermissionById(Integer permissionId);
  
    /**
	* @descirption 插入权限
	* @param record
	* @return 如果返回值大于0则成功，反之失败
	*/
    int addPermission(Permission record);
   
    /**
	* @descirption 插入VO权限
	* @param record
	* @return 如果返回值大于0则成功，反之失败
	*/
    int addPermissionVO(PermissionVO record);
    
    /**
	* @descirption 根据permissionId查询单条权限信息
	* @param permissionId
	* @return 如果返回值大于0则成功，反之失败
	*/
    List<Permission> queryPermissionById(Integer permissionId);
    
    /**
	* @descirption 更新权限
	* @param record
	* @return 如果返回值大于0则成功，反之失败
	*/
    int updatePermission(Permission record);
   
    /**
	* @descirption 查询所有权限
	* @param 
	* @return 如果返回值大于0则成功，反之失败
	*/
    List<Permission> queryAllPermissions();
}