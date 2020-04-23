/**    
* @Title: DepartmentServiceImplTest.java  
* @Package com.clps.oas.service.impl  

* @author ft   
* @date 2018年5月7日 下午2:48:41  
* @version V1.0    
*/
package com.clps.oas.sm.service.impl;



import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



import com.clps.oas.sm.pojo.Department;
import com.clps.oas.sm.service.IDepartmentService;
import com.clps.oas.util.spring.SpringTestBase;


/**  
* @ClassName: DepartmentServiceImplTest  

* @author Aiden
* @date 2018年5月7日 下午2:48:41  
*    
*/
public class DepartmentServiceImplTest extends SpringTestBase{

	/**  
	* @Title: setUp  

	* @param @throws java.lang.Exception    
	* @return void    
	* @throws  
	*/
	@Autowired
	private IDepartmentService ips;
	private Department department;
	private Logger log=Logger.getLogger(DepartmentServiceImplTest.class);
	@Before
	public void setUp() throws Exception {
		
		this.department=new Department();
		department.setDepaName("安保部");
		department.setDepaEmail("2818694679@qq.com");
		department.setDepaLevel("2");
		department.setDepaFatherNumber("111");
		department.setDepaChildNumber("22");
		department.setDepaCreateName("aiden");
		department.setDepaCreateDatetime(new Timestamp(new Date().getTime()));
		department.setDepaUpdatedName("aiden");
		department.setDepaUpdatedDatetime(new Timestamp(new Date().getTime()));
	}

	
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.clps.oas.service.impl.DepartmentServiceImpl#showDepartment()}.
	 */
	@Test
	public void testShowDepartment() {
		
		Iterator<Department> its =ips.showDepartment().iterator();
		log.info("show department");
		while(its.hasNext()){
			System.out.println(its.next());
		}
		
	}
	
	@Test
	public void testqueryDepartmentsById()
	{
		Department department=ips.queryDepartmentsById(3);
		    log.info("query department by depaname");
			System.out.println(department);
		
	}
	
	@Test
	public void testqueryDepartmentsByName()
	{
		Iterator<Department> its =ips.queryDepartmentsByName("人事部").iterator();
		log.info("query department by name");
		while(its.hasNext()){
			System.out.println(its.next());
		}	
		
	}
	
	@Test
	public void testinsertSelective()
	{   log.info("start insert");
		ips.insertSelective(department);
	}
	
	@Test
	public void testdeleteByPrimaryKey()
	{
		log.info("start delete by depaname");
		ips.deleteByPrimaryKey(1);
	}
	
	@Test
	public void testupdateByPrimaryKeySelective()
	{
		log.info("update by depaname");
		department.setDepaNumber(1);
		ips.updateByPrimaryKeySelective(department);
	}

}
