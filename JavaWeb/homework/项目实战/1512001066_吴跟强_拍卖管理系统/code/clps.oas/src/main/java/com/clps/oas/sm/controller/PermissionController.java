package com.clps.oas.sm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.pojo.Permission;
import com.clps.oas.sm.pojo.PermissionVO;
import com.clps.oas.sm.service.IPermissionService;

/**
 * @description this is PermissionController
 * @author noah.zhou
 * @date 创建时间：2018年5月14日 下午3:13:14
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/sm") // 控制路径为项目名字加上"/sm"
public class PermissionController {

	@Resource
	private IPermissionService permissionService;// 实例化permissionService

	@RequestMapping(value = "/permissionList") // 控制路径为项目名字加上"/sm/permissionList"
	public String showUser(Model model) {
		List<Permission> permission = permissionService.queryAllPermissions();
		model.addAttribute("permissions", permission);
		return "sm/permission_list";// 返回查询页面
	}

	@RequestMapping(value = "/delPermission", method = RequestMethod.GET)
	public String delPermission(@RequestParam("permissionId") Integer permissionId) { // 获取到permissionId的值作为此函数的参数值

		permissionService.deletePermissionById(permissionId);
		return "sm/permission_delete";// 返回删除页面

	}

	@RequestMapping(value = "/showAddPermission")
	public String showAddPermission() {
		return "sm/permission_add";// 返回添加权限页面
	}
	
	@RequestMapping(value = "/addPermissionVO", method = RequestMethod.POST)
	public String addPermissionVO(PermissionVO permissionVO,Model model) { 

		if (permissionService.addPermissionVO(permissionVO) == ParamCommon.ADD_SUCCESS) {
			List<Permission> permission = permissionService.queryAllPermissions();
			model.addAttribute("permissions", permission);
			return "sm/permission_list";// 返回查询页面
		}
		return "sm/permission_error";// 返回失败页面
	}
	
	@RequestMapping(value = "/showUpdatePermission")
	public String showUpdatePermission() {
		return "sm/permission_update";// 返回更新权限页面
	}
	
	@RequestMapping(value = "/updatePermission")
	public String updatePermission(Permission per,Model model) { 

		if (permissionService.updatePermission(per)== ParamCommon.UPDATE_SUCCESS) {
			List<Permission> permission = permissionService.queryAllPermissions();
			model.addAttribute("permissions", permission);
			return "sm/permission_list";// 返回查询页面
		}
		return "sm/permission_error";// 返回失败页面
	}
}
