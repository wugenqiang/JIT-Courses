package com.clps.oas.sm.service.impl;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.clps.oas.sm.pojo.Permission;
import com.clps.oas.sm.pojo.PermissionVO;
import com.clps.oas.sm.service.IPermissionService;
import com.clps.oas.util.spring.SpringTestBase;

/**
 * @description this is PermissionServiceImplTest
 * @author noah.zhou
 * @date 创建时间：2018年5月11日 上午10:40:00
 * @version 1.0
 */
public class PermissionServiceImplTest extends SpringTestBase {

	@Autowired
	private IPermissionService ips;
	private Logger logger = Logger.getLogger(PermissionServiceImplTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// 测试Service层查询所有权限的方法
	@Test
	public void testQueryAllPermissions() {
		Iterator<Permission> its = ips.queryAllPermissions().iterator();
		while (its.hasNext()) {
			logger.info(its.next());
		}
		logger.info("查找所有成功");
	}

	// 测试Service层查询单条权限的方法
	@Test
	public void testQueryPermissionById() {
		Iterator<Permission> its = ips.queryPermissionById(1).iterator();
		while (its.hasNext()) {
			System.out.println(its.next());
		}
		logger.info("查找单条数据成功");
	}

	// 测试插入权限方法
	@Test
	public void testAddPermission() {
		Permission permission = new Permission();
		permission.setPermissionId(6);
		permission.setPermissionName("leo");
		permission.setPermissionContent(12);
		permission.setPermissionComment("000");
		permission.setPermissionLevel(1);
		permission.setPermissionCreatedDatetime(null);
		permission.setPermissionCreatedName(1);
		permission.setPermissionUpdatedDatetime(null);
		permission.setPermissionUpdatedName(1);
		permission.setMaintenanceTime(null);
		permission.setCheckTime(null);
		permission.setIsVisible(1);
		try {
			String flag = ips.addPermission(permission);
			logger.info(flag);
		} catch (Exception e) {
			logger.error("插入失败");
			e.printStackTrace();
		}
	}

	// 测试插入VO权限方法
	@Test
	public void testAddPermissionVO() {
		PermissionVO permissionVO = new PermissionVO();
		permissionVO.setPermissionName("insert");
		permissionVO.setPermissionContent(12);
		permissionVO.setPermissionComment("这是普通插入权限");
		permissionVO.setPermissionLevel(1);
		try {
			String flag = ips.addPermissionVO(permissionVO);
			logger.info(flag);
		} catch (Exception e) {
			logger.error("插入VO失败");
			e.printStackTrace();
		}
	}

	// 测试删除根据ID逻辑删除权限的方法
	@Test
	public void testDeletePermissionById() {
		try {
			String flag = ips.deletePermissionById(4);
			logger.info(flag);
		} catch (Exception e) {
			logger.error("service delete fail!");
			e.printStackTrace();
		}
	}

	// 测试更新用户的方法
	@Test
	public void testUpdatePermission() {
		Permission permission = new Permission();
		permission.setPermissionId(10);
		permission.setPermissionName("jack");
		permission.setPermissionContent(12);
		permission.setPermissionComment("");
		permission.setPermissionLevel(1);
		permission.setPermissionCreatedDatetime(null);
		permission.setPermissionCreatedName(1);
		permission.setPermissionUpdatedDatetime(null);
		permission.setPermissionUpdatedName(1);
		permission.setMaintenanceTime(null);
		permission.setCheckTime(null);
		permission.setIsVisible(1);
		try {
			String flag = ips.updatePermission(permission);
			logger.info(flag);
		} catch (Exception e) {
			logger.error("service update faliure!");
			e.printStackTrace();
		}
	}
}
