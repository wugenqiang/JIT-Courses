
/*
* Copyright @ 2018 com.jit
* clps.oas 下午2:56:41
* All right reserved.
*
*/
	
package com.clps.oas.sm.service.impl;
/**  
* @Title: RoleServiceImplTest.java  
* @Package com.clps.oas.sm.service.impl  
* @Description: TODO 
* @author leo.jiang  
* @date 2018年5月14日  
* @version V1.0  
*/


import java.util.Iterator;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.clps.oas.sm.pojo.Role;
import com.clps.oas.sm.service.IRoleService;
import com.clps.oas.util.spring.SpringTestBase;



/**
* @desc: clps.oas
* @author: leo.jiang
* @createTime: 2018年5月14日 下午2:56:41
* @history:
* @version: v1.0
*/

public class RoleServiceImplTest extends SpringTestBase{

	
	@Autowired
	private IRoleService irs;
	private Logger logger = Logger.getLogger(RoleServiceImplTest.class);
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQueryAllRoles() {
		Iterator<Role> its = irs.showRoles().iterator();
		while (its.hasNext()) {
			logger.info(its.next());
		}
		logger.info("查找所有成功");
	}
	
	//测试Service层查询单条权限的方法
	@Test
	public void testQueryRoleById() {
		Iterator<Role> its = irs.showRolesByRoleId(1).iterator();
		while (its.hasNext()) {
			System.out.println(its.next());
		}
		logger.info("查找单条数据成功");
	}
	
	//测试插入权限方法
		@Test
		public void testInsertRole() {
			Role role=new Role();
			role.setRoleId(1);
			role.setRoleName("wzj");
			role.setRoleComment("111");
			role.setRoleLevel("111");
			role.setRoleCreatedName("11");
			role.setRoleUpdatedName("22");
			role.setRoleDefault1("22222");
			role.setRoleDefault2("2222");
			role.setRoleIsvaild(1);
			try{
				String flag=irs.addRole(role);
				logger.info(flag);
			}catch(Exception e){
				logger.error("插入失败");
				e.printStackTrace();
			}
		}
	
		//测试删除根据ID逻辑删除权限的方法
		@Test
		public void testDeleteRoleById() {
			try{
				String flag=irs.deleteRoleById(1);
				logger.info(flag);
			}catch(Exception e){
				logger.error("service delete fail!");
				e.printStackTrace();
			}
		}
		
		//测试更新用户的方法
		@Test
		public void testUpdateRole() {
			Role role=new Role();
			role.setRoleId(1);
			role.setRoleName("wzj");
			role.setRoleComment("111");
			role.setRoleLevel("111");
			role.setRoleCreatedDatetime(null);
			role.setRoleCreatedName("11");
			role.setRoleUpdatedDatetime(null);
			role.setRoleUpdatedName("22");
			role.setRoleDefault1("22222");
			role.setRoleDefault2("2222");
			role.setRoleIsvaild(1);
			try{
				String flag=irs.updateRole(role);
				logger.info(flag);
			}catch(Exception e){
				logger.error("service update faliure!");
				e.printStackTrace();
			}
		}

}
