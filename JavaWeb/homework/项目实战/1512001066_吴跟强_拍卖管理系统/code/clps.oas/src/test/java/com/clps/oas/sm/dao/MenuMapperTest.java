
	
		package com.clps.oas.sm.dao;

//import static org.junit.Assert.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.clps.oas.sm.pojo.Menu;
import com.clps.oas.util.mybatis.MyBatisUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
/**
* @desc: clps.oas
* @author:lxj
* @createTime: 2018年5月10日 下午1:32:22
* @history:
* @version: v1.0
*/

public class MenuMapperTest {

	SqlSession session = null;
	SqlSessionFactory sf = null;
	public static Log log = LogFactory.getLog(MenuMapperTest.class); 
	/**
	* @author: lxj
	* @createTime: 2018年5月10日 下午1:32:22
	* @history:
	* @throws java.lang.Exception void
	*/
	@Before
	public void setUp() throws Exception {
		
		sf = MyBatisUtil.getSqlSessionFactory();
		session =sf.openSession();
	}

	/**
	* @author: lxj
	* @createTime: 2018年5月10日 下午1:32:22
	* @history:
	* @throws java.lang.Exception void
	*/
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.MenuMapper#saveMenu(com.clps.oas.sm.pojo.Menu)}.
	 */
	@Test
	public void testAddMenu() {
		Menu menu = new Menu("menumanage",1,1,0,"menumanage",1,"zzz",new Timestamp(new Date().getTime()),1,
				new Timestamp(new Date().getTime()),1,null,null);
		try {
			
			MenuMapper mapper =session.getMapper(MenuMapper.class);
			 int result= mapper.addMenu(menu);
			 log.info(result);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}
		
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.MenuMapper#updateMenu(com.clps.oas.sm.pojo.Menu)}.
	 */
	@Test
	public void testUpdateMenu() {
		
		Menu menu = new Menu(1,"menu",2,1,0,"menu",1,"zzz",new Timestamp(new Date().getTime()),1,
				new Timestamp(new Date().getTime()),1,null,null);
		try {
			
			MenuMapper mapper =session.getMapper(MenuMapper.class);
			 int result= mapper.updateMenu(menu);
			 log.info(result);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}
		
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.MenuMapper#changeMenuState(com.clps.oas.sm.pojo.Menu)}.
	 */
	@Test
	public void testUpdateMenuState() {
		
		Menu menu = new Menu(1,"menumanage",7,1,0,"menu",1,"zzz",new Timestamp(new Date().getTime()),1,
				new Timestamp(new Date().getTime()),1,null,null		);
		try {
			
			MenuMapper mapper =session.getMapper(MenuMapper.class);
			 int result= mapper.updateMenuState(menu);
			 log.info(result);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}
	
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.MenuMapper#queryAllMenu()}.
	 */
	@Test
	public void testQueryAllMenu() {
		
		try {
			
			MenuMapper mapper =session.getMapper(MenuMapper.class);
			List<Menu> listmenu= mapper.queryAllMenu();
			 log.info(listmenu);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.MenuMapper#selectMenuById(int)}.
	 */
	@Test
	public void testQueryMenuById() {
		
		try {
			
			MenuMapper mapper =session.getMapper(MenuMapper.class);
			Menu menu= mapper.queryMenuById(1);
			 log.info(menu);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.MenuMapper#queryMenuSortIdIsRepeat(int, int, int)}.
	 */
	@Test
	public void testQueryMenuSortIdIsRepeat() {
		
		try {
			
			MenuMapper mapper =session.getMapper(MenuMapper.class);
			int result= mapper.queryMenuSortIdIsRepeat(1, 1, 0);
			 log.info(result);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}
	
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.MenuMapper#queryMenuUrlIsRepeat(java.lang.String)}.
	 */
	@Test
	public void testQueryMenuUrlIsRepeat() {
		
		try {
			
			MenuMapper mapper =session.getMapper(MenuMapper.class);
			int result= mapper.queryMenuUrlIsRepeat("menu");
			 log.info(result);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}
		
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.MenuMapper#queryMenuNameIsRepeat(java.lang.String, int, int)}.
	 */
	@Test
	public void testQueryMenuNameIsRepeat() {
		

		try {
			
			MenuMapper mapper =session.getMapper(MenuMapper.class);
			int result= mapper.queryMenuNameIsRepeat("sysmanage", 1, 0);
			 log.info(result);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}
		
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.MenuMapper#queryMenuByCondition(java.lang.String, int)}.
	 */
	@Test
	public void testQueryMenuByCondition() {
		
		try {
			
			MenuMapper mapper =session.getMapper(MenuMapper.class);
			List<Menu> menu1= mapper.queryMenuByCondition(null,30);
			
			 log.info(menu1);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.MenuMapper#selectMenuByParentId(java.lang.String, int)}.
	 */
	@Test
	public void testQueryMenuByParentId() {
		
		try {
			
			MenuMapper mapper =session.getMapper(MenuMapper.class);
			List<Menu> menu1= mapper.queryMenuByParentId(0);
			 log.info(menu1);
			
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

	