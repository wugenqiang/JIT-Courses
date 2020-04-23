
/*
* Copyright @ 2018 com.jit
* clps.oas 下午2:44:05
* All right reserved.
*
*/
	
package com.clps.oas.sm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.pojo.Role;
import com.clps.oas.sm.service.IRoleService;

/**  
* @Title: RoleController.java  
* @Package com.clps.oas.sm.controller  
* @Description: TODO 
* @author leo.jiang  
* @date 2018年5月14日  
* @version V1.0  
*/

/**
* @desc: clps.oas
* @author: leo.jiang
* @createTime: 2018年5月14日 下午2:44:05
* @history:
* @version: v1.0
*/
@Controller
@RequestMapping(value="/sm")
public class RoleController {

	@Resource
	private IRoleService roleService;
	
	
	//查询角色
	@RequestMapping(value="/roleList")
	public String showRole(Model model){
		List<Role> role= roleService.showRoles();
		model.addAttribute("roles", role);
		
		return "sm/role_list";
	}
	
	//删除角色
	@RequestMapping(value="/delRole", method = RequestMethod.GET)
	public String delRole(@RequestParam("roleId") Integer roleId){
		roleService.deleteRoleById(roleId);
		return "sm/role_delete";
	}

	// 返回添加角色页面
	@RequestMapping(value = "/showAddRole")
	public String showAddRole() {
		return "sm/role_add";
	}	
	
	//增加角色
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public String addRoleVO(Role roles,Model model) { 

		if (roleService.addRole(roles) == ParamCommon.ADD_SUCCESS) {
			List<Role> role = roleService.showRoles();
			model.addAttribute("roles", role);
			return "sm/role_list";// 返回查询页面
		}
		return "sm/role_error";// 返回失败页面
	}
	

	// 返回更新角色页面
	@RequestMapping(value = "/showUpdateRole")
	public String showUpdateRole() {
		return "sm/role_update";
	}
	
	@RequestMapping(value = "/updateRole")
	public String updateRole(Role ro,Model model) { 

		if (roleService.updateRole(ro)== ParamCommon.UPDATE_SUCCESS) {
			List<Role> role = roleService.showRoles();
			model.addAttribute("roles", role);
			return "sm/role_list";// 返回查询页面
		}
		return "sm/role_error";// 返回失败页面
	}
}
