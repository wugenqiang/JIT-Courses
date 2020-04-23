package com.clps.oas.sm.dao;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.clps.oas.sm.pojo.Parameter;
import com.clps.oas.util.mybatis.MyBatisUtil;

public class ParameterMapperTest {
	
	
	private SqlSessionFactory sf= null;
	private ParameterMapper mapper=null;
	private SqlSession session= null;
	private List<Parameter> paramaters=null;

	@Before
	public void setUp() throws Exception {
		sf = MyBatisUtil.getSqlSessionFactory();
		this.session=sf.openSession();
		this.mapper=session.getMapper(ParameterMapper.class);
	}

	@Test
	public void testDelete() {
		Integer i=null;
		Parameter parameter=new Parameter();
		parameter.setParameterId(3);
		try{
			i = this.mapper.deleteParameterById(3);
			if(i>0){
				 System.out.println("delect patameter success!");
				 session.commit();
			 }
			
		}catch(Exception e){
			session.rollback();
			e.printStackTrace();
			System.out.println("delect patameter fail!");
		}finally{
			if(session !=null){
				session.close();
			}
		}
	}

	@Test
	public void testInsert() {
		Integer i=null;
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
		try{
			 
			 i=this.mapper.insertParameter(patameter);
			 
			 if(i>0){
				 System.out.println("add patameter success!");
				 session.commit();
			 }
		 }catch(Exception e){
			 System.out.println("add patameter fail!");
			 session.rollback();
		 }finally{
			 if(session !=null){
					session.close();
				}
		 }
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}


	@Test
	public void testUpdatePatameter() {
		Integer i=null;
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
		patameter.setParameterId(2);
		System.out.println(patameter.toString());
		try{
			 
			 i=this.mapper.updateParameter(patameter);
			 if(i>0){
				 System.out.println("update patameter success!");
				 session.commit();
			 }else{
				 
				 System.out.println("update patameter fail~~!");
			 
			 }
		 }catch(Exception e){
			 System.out.println("update patameter fail!");
			 session.rollback();
		 }finally{
			 if(session !=null){
					session.close();
				}
		 }
	}

	@Test
	public void testQueryAllParameters() {

		try{
			
			this.paramaters = mapper.queryAllParameters();
			Iterator<Parameter> its=paramaters.iterator();
			while(its.hasNext()){
				System.out.println(its.next());
			}
			session.commit();
		}catch(Exception e){
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}
	}
	
	@Test
	public void testQueryParameterById(){
		
		try{
			
			Parameter pat=new Parameter();
			pat = mapper.queryParameterById(1);
			System.out.println(pat);
			session.commit();
		}catch(Exception e){
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}
		
	}

}
