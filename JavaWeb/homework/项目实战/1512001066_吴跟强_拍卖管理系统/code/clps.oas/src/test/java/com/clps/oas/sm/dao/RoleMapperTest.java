/**
 * 
 */
package com.clps.oas.sm.dao;
/**  
* @Title: RoleMapperTest.java  
* @Package com.clps.oas.sm.dao  
* @Description: TODO 
* @author leo.jiang  
* @date 2018年5月14日  
* @version V1.0  
*/
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.clps.oas.sm.pojo.Role;
import com.clps.oas.util.mybatis.MyBatisUtil;



/**
* @desc: clps.oas
* @author: leo.jiang
* @createTime: 2018年5月14日 下午1:57:16
* @history:
* @version: v1.0
*/
public class RoleMapperTest {

	private SqlSessionFactory sf = null;
	private SqlSession session = null;
	private RoleMapper roleDao = null;
	private List<Role> roles = null;
	private Logger logger = Logger.getLogger(RoleMapperTest.class);
	
	@Before
	public void setUp() throws Exception {
		this.sf = MyBatisUtil.getSqlSessionFactory();
		this.session = sf.openSession();
		this.roleDao = session.getMapper(RoleMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeleteUserById() {
		try {
			int i = this.roleDao.deleteByRoleId(1);
			if (i > 0) {
				logger.info("Delete success!");
				session.commit();
			}
		} catch (Exception e) {
			logger.error("Delete fail");
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}


	@Test
	public void testInsertUser() {
		Role role = new Role();
		role.setRoleName("role");
		role.setRoleComment("233");
		role.setRoleLevel("11");
		role.setRoleDefault1("11");
		role.setRoleDefault2("");
		logger.info("insert start...");
		try {
			logger.info("insert start1111...");
			int i = this.roleDao.insertRole(role);
			System.out.println(i+"       ");
			if (i > 0) {
				logger.info("insert success!");
				session.commit();
			}
		} catch (Exception e) {
			logger.error("insert fail");
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}


	@Test
	public void testQueryRoleByRoleId() {
		Role role = new Role();
		role.setRoleId(2);
		try {
			this.roles = this.roleDao.queryRoleByRoleId(role.getRoleId());
			Iterator<Role> its = roles.iterator();
			while(its.hasNext()){
				logger.info(its.next());
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}		
	}

	@Test
	public void testQueryRoleByRoleName() {
		Role role = new Role();
		role.setRoleName("ztc");
		try {
			this.roles = this.roleDao.queryRoleByRoleName(role.getRoleName());
//            logger.info(roles);
			Iterator<Role> its = roles.iterator();
			while(its.hasNext()){
				logger.info(its.next());
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}
	}

	@Test
	public void testUpdateUser() {
		Role role = new Role();
		role.setRoleId(1);
		role.setRoleName("role");
		role.setRoleComment("23322");
		role.setRoleLevel("1122");
		role.setRoleDefault1("1122");
		role.setRoleDefault2("");
		try {
			int i = this.roleDao.updateByRoleId(role);
			if (i > 0) {
				logger.info("Update success!");
				session.commit();
			} else {
				logger.error("Update failure!");
			}
			
		} catch (Exception e) {
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}


	@Test
	public void testQueryAllUsers() {
		try {
			this.roles = this.roleDao.queryAllRoles();
			Iterator<Role> its = roles.iterator();
			while(its.hasNext()){
				logger.info(its.next());
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}
	}


}
