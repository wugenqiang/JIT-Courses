
		package com.clps.oas.sm.service.impl;

//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.clps.oas.sm.dao.MenuMapper;
import com.clps.oas.sm.pojo.Menu;
import com.clps.oas.util.spring.SpringTestBase;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
* @desc: clps.oas
* @author: lxj
* @createTime: 2018年5月10日 下午1:41:37
* @history:
* @version: v1.0
*/

public class MenuServiceImplTest extends SpringTestBase{

	@Autowired
	private  MenuMapper mm;
	public static Log log = LogFactory.getLog(MenuServiceImplTest.class);
	/**
	* @author: lxj
	* @createTime: 2018年5月10日 下午1:41:37
	* @history:
	* @throws java.lang.Exception void
	*/
	@Before
	public void setUp() throws Exception {
	}

	/**
	* @author: lxj
	* @createTime: 2018年5月10日 下午1:41:37
	* @history:
	* @throws java.lang.Exception void
	*/
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.clps.oas.sm.service.impl.MenuServiceImpl#saveMenu(com.clps.oas.sm.pojo.Menu)}.
	 */
	@Test
	public void testAddMenu() {
		Menu menu = new Menu("menumanage",8,1,0,"menumanage",1,"zzz",new Timestamp(new Date().getTime()),1,
				new Timestamp(new Date().getTime()),1,null,null);
		log.info(mm.addMenu(menu));
	}

	/**
	 * Test method for {@link com.clps.oas.sm.service.impl.MenuServiceImpl#updateMenu(com.clps.oas.sm.pojo.Menu)}.
	 */
	@Test
	public void testUpdateMenu() {
		Menu menu = new Menu(10,"menuman",8,1,0,"menumanage",1,"update",new Timestamp(new Date().getTime()),1,
				new Timestamp(new Date().getTime()),1,null,null);
		log.info(mm.updateMenu(menu));
	}

	/**
	 * Test method for {@link com.clps.oas.sm.service.impl.MenuServiceImpl#changeMenuState(com.clps.oas.sm.pojo.Menu)}.
	 */
	@Test
	public void testUpdateMenuState() {
		Menu menu = new Menu(10,"menumanage",8,1,0,"menumanage",1,"update",new Timestamp(new Date().getTime()),1,
				new Timestamp(new Date().getTime()),1,null,null);
		log.info(mm.updateMenuState(menu));
	}

	/**
	 * Test method for {@link com.clps.oas.sm.service.impl.MenuServiceImpl#queryAllMenu()}.
	 */
	@Test
	public void testQueryAllMenu() {
		log.info(mm.queryAllMenu());
	}

	/**
	 * Test method for {@link com.clps.oas.sm.service.impl.MenuServiceImpl#queryMenuSortIdIsRepeat(int, int, int)}.
	 */
	@Test
	public void testQueryMenuSortIdIsRepeat() {

		log.info(mm.queryMenuSortIdIsRepeat(7, 1, 0));
	}

	/**
	 * Test method for {@link com.clps.oas.sm.service.impl.MenuServiceImpl#queryMenuUrlIsRepeat(java.lang.String)}.
	 */
	@Test
	public void testQueryMenuUrlIsRepeat() {
		
		log.info(mm.queryMenuUrlIsRepeat("menu"));
	}

	/**
	 * Test method for {@link com.clps.oas.sm.service.impl.MenuServiceImpl#queryMenuNameIsRepeat(java.lang.String, int, int)}.
	 */
	@Test
	public void testQueryMenuNameIsRepeat() {
		
		log.info(mm.queryMenuNameIsRepeat("sysmanage", 1, 0));
	}

	/**
	 * Test method for {@link com.clps.oas.sm.service.impl.MenuServiceImpl#selectMenuById(int)}.
	 */
	@Test
	public void testQueryMenuById() {
		
		log.info(mm.queryMenuById(1));
	}

	/**
	 * Test method for {@link com.clps.oas.sm.service.impl.MenuServiceImpl#queryMenuByCondition(java.lang.String, int)}.
	 */
	@Test
	public void testQueryMenuByCondition() {
		
		log.info(mm.queryMenuByCondition("m",30).size());
	}

}

	