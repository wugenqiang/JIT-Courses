/**
 * Project Name:clps.oas
 * File Name:ParameterServiceImplTest.java
 * Package Name:com.clps.oas.sm.service.impl
 * Date:2018年5月8日下午1:53:21
 * Copyright (c) 2018, hjq All Rights Reserved.
 *
*/

package com.clps.oas.sm.service.impl;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import com.clps.oas.sm.pojo.Parameter;
import com.clps.oas.sm.service.IParameterService;

import com.clps.oas.util.spring.SpringTestBase;

/**
 * ClassName:ParameterServiceImplTest 
 * Function: ADD FUNCTION. 
 * Reason:ADD REASON.
 * Date:     2018年5月8日 下午1:53:21 
 * @author   hjq
 * @version  v1.0
 * @since    JDK 1.8
 * @see 	 
 */
public class ParameterServiceImplTest extends SpringTestBase{
	
	@Autowired
	@Qualifier("patService")
	private IParameterService patService;
	
	
	private List<Parameter> paramaters=null;
	private Logger logger=Logger.getLogger(ParameterServiceImplTest.class);


	@Before
	public void setUp() throws Exception {
		//this.paramaters= new ArrayList<>();
		//this.patService= new ParameterServiceImpl();
		
	}

	@Test
	public void testInit() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddParameter() {
		String i=null;
		Parameter patameter=new Parameter();
		patameter.setParameterName("province");
		patameter.setParameterConent("随便");
		patameter.setParameterId(0);
		patameter.setParameterComment("全国省份");
		patameter.setParameterCreatedName(1);
		patameter.setParameterCreatedDatetime(new Timestamp(new Date().getTime()));
		patameter.setParameterUpdatedName(1);
		patameter.setParameterUpdatedDatetime(new Timestamp(new Date().getTime()));
		patameter.setParameterIsvariable(1);
		patameter.setUserDefault1("11111");
		patameter.setUserDefault2("11111");
		logger.info(patameter.getParameterName());
		try{
			
			 i=this.patService.addParameter(patameter);
			 if(i=="1"){
				 logger.info("add patameter success!");
			 }
		 }catch(Exception e){
			 logger.info("add patameter fail!");
		 }
	}

	@Test
	public void testShowParameters() {
		try{
			
			this.paramaters = this.patService.showParameters();
			Iterator<Parameter> its=paramaters.iterator();
			while(its.hasNext()){
				System.out.println(its.next());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Test
	public void testDelectParameter() {
		String i=null;
		try{
			i = this.patService.delectParameter(15);
			if(i=="1"){
				 System.out.println("delect patameter success!");
			 }
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("delect patameter fail!");
		}
	}

	@Test
	public void testUpdateParameter() {
		Parameter patameter=new Parameter();
		
		patameter.setParameterName("Province");
		patameter.setParameterConent("南京");
		patameter.setParameterId(0);
		patameter.setParameterComment("全国省份");
		patameter.setParameterCreatedName(1);
		patameter.setParameterCreatedDatetime(new Timestamp(new Date().getTime()));
		patameter.setParameterUpdatedName(1);
		patameter.setParameterUpdatedDatetime(new Timestamp(new Date().getTime()));
		patameter.setParameterIsvariable(1);
		patameter.setUserDefault1("11111");
		patameter.setUserDefault2("11111");
		patameter.setParameterId(14);
		System.out.println(patameter.toString());
		try{
			 
			 String i=this.patService.updateParameter(patameter);
			 if(i=="1"){
				 System.out.println("update patameter success!");
			 }
		 }catch(Exception e){
			 System.out.println("update patameter fail!");
			 e.printStackTrace();
		 }
	}

	@Test
	public void testQueryParameterById() {
		try{
			
			Parameter pat=new Parameter();
			pat = this.patService.queryParameterById(1);
			System.out.println(pat);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

