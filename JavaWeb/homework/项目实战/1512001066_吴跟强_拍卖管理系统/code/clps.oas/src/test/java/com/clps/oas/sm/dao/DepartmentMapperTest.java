/**    
* @Title: DepartmentMapperTest.java  
* @Package clps.oas.test  

* @author ft   
* @date 2018年5月6日 下午3:21:36  
* @version V1.0    
*/
package com.clps.oas.sm.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.clps.oas.sm.pojo.Department;
import com.clps.oas.util.mybatis.MyBatisUtil;


/**  
* @ClassName: DepartmentMapperTest  

* @author Aiden
* @date 2018年5月6日 下午3:21:36  
*    
*/
public class DepartmentMapperTest {
	private SqlSessionFactory sf = null;
	private SqlSession session = null;
	DepartmentMapper mapper=null;
	List<Department> lists=new ArrayList<Department>();
	private Logger log=Logger.getLogger(DepartmentMapperTest.class);

	/**  
	* @Title: setUp  
	
	* @param @throws java.lang.Exception    
	* @return void    
	* @throws  
	*/
	@Before
	public void setUp() throws Exception {
		this.sf = MyBatisUtil.getSqlSessionFactory();
		this.session = sf.openSession();
		this.mapper = session.getMapper(DepartmentMapper.class);
	}

	/**  
	* @Title: tearDown  
	
	* @param @throws java.lang.Exception    
	* @return void    
	* @throws  
	*/
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.DepartmentMapper#deleteByPrimaryKey(java.lang.Integer)}.
	 */
	@Test
	public void testDeleteByPrimaryKey() {
		Department department=new Department();
		department.setDepaNumber(0);
		log.info("Delete start!");
		try {
			int i = this.mapper.deleteByPrimaryKey(2);
			if (i > 0) {
				log.info("Delete success!");
				session.commit();
			}
		} catch (Exception e) {
			log.info("Delete fail");
			log.error(e);
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.DepartmentMapper#insert(com.clps.oas.sm.pojo.Department)}.
	 */
	@Test
	public void testInsert() {
		
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.DepartmentMapper#insertSelective(com.clps.oas.sm.pojo.Department)}.
	 */
	@Test
	public void testInsertSelective() {
		Department department=new Department();
		department.setDepaName("人事部2");
		department.setDepaLevel("2");
		department.setDepaEmail("55");
		department.setDepaComment("jj");
		department.setDepaFatherNumber("001");
		department.setDepaChildNumber("222");
		department.setDepaCreateName("ft");
		department.setDepaCreateDatetime(null);
		department.setDepaUpdatedName("gg");
		department.setDepaUpdatedDatetime(null);
		log.info("insert start...");
		try {
			
			int i = this.mapper.insert(department);
			
			if (i > 0) {
				log.info("insert success!");
				session.commit();
			}
		} catch (Exception e) {
			
			log.info("insert fail");
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.DepartmentMapper#selectByPrimaryKey(java.lang.Integer)}.
	 */
	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.DepartmentMapper#updateByPrimaryKeySelective(com.clps.oas.sm.pojo.Department)}.
	 */
	@Test
	public void testUpdateByPrimaryKeySelective() {
		Department department=new Department();
		department.setDepaNumber(1);
		department.setDepaName("44");
		department.setDepaLevel("1");
		department.setDepaEmail("888");
		department.setDepaComment("jj");
		department.setDepaFatherNumber("001");
		department.setDepaChildNumber("222");
		department.setDepaCreateName("ft");
		department.setDepaCreateDatetime(null);
		department.setDepaUpdatedName("gg");
		department.setDepaUpdatedDatetime(null);
		try {
			int i = this.mapper.updateByPrimaryKeySelective(department);
			if (i > 0) {
				log.info("Update success!");
				session.commit();
			} else {
				
				log.info("Update failure!");
			}
			
		} catch (Exception e) {
			
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.DepartmentMapper#updateByPrimaryKey(com.clps.oas.sm.pojo.Department)}.
	 */
	@Test
	public void testUpdateByPrimaryKey() {
		
	}

	/**
	 * Test method for {@link com.clps.oas.sm.dao.DepartmentMapper#queryAllDepartments()}.
	 */
	@Test
	public void testQueryAllDepartments() {
		
		try {
			
			lists=mapper.queryAllDepartments();
			
			Iterator<Department> its = lists.iterator();
			while(its.hasNext()){
				log.info(its.next());
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
	public void testqueryDepartmentsById() {
		
		try {
			Department department=new Department();
			department=mapper.queryDepartmentsById(3);
			log.info(department);
			
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
	public void testqueryDepartmentsByName() {
		
		try {
			
			lists=mapper.queryDepartmentsByName("人事部");
			Iterator<Department> its = lists.iterator();
			while(its.hasNext()){
				log.info(its.next());
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
