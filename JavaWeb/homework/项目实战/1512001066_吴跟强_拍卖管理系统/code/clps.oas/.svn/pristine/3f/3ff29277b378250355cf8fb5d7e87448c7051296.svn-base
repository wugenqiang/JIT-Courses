package com.clps.oas.sm.dao;
/**  
* @Title: RoleMapper.java  
* @Package com.clps.oas.sm.dao  
* @Description: TODO 
* @author leo.jiang  
* @date 2018年5月14日  
* @version V1.0  
*/
import java.util.List;

import com.clps.oas.sm.pojo.Role;
/**
* @desc: clps.oas
* @author: leo.jiang
* @createTime: 2018年5月14日 下午1:57:16
* @history:
* @version: v1.0
*/
public interface RoleMapper {
    int deleteByRoleId(Integer roleId);              //通过id查找角色

    int insertRole(Role record);                     //插入角色

    int updateByRoleId(Role record);                 //通过id更新角色
    
    List<Role> queryAllRoles();                      //查询所有角色
    
    List<Role> queryRoleByRoleName(String roleName); //通过姓名查找角色
    
    List<Role> queryRoleByRoleId(Integer roleId);    //通过id查找角色
}