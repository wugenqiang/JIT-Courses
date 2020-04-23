
package com.clps.oas.util.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.clps.oas.util.dao.SendEmailMapper;
import com.clps.oas.util.pojo.SendEmail;
import com.clps.oas.util.mybatis.MyBatisUtil;



public class SendEmailMapperTest {
	
	private SqlSessionFactory sf = null;
	private SqlSession session = null;
	private SendEmailMapper mapper = null;
	private SendEmail sendemail =null;
    private Logger log=Logger.getLogger(SendEmailMapperTest.class);
    

	/** 
	* @Title: setUp 
	* @Description: 测试dao层
	* @param @throws java.lang.Exception 
	* @return void 
	* @throws 
	*/
	@Before
	public void setUp() throws Exception {
		
		this.sf = MyBatisUtil.getSqlSessionFactory();
		this.session = sf.openSession();
		this.mapper = session.getMapper(SendEmailMapper.class);
		this.sendemail =new SendEmail();
		sendemail.setEmailSubject("love");
		sendemail.setEmailRecipient("cwh");
		sendemail.setEmailRecipientId(2);
		sendemail.setEmailSendtime(new Timestamp(new Date().getTime()));
		sendemail.setEmailStatus(true);
		sendemail.setEmailDefault1("");
		sendemail.setEmailDefault2("");
		sendemail.setEmailIsVisable(true);
		sendemail.setEmailContent(" i love you");
	}

	
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testDeleteByEmailId() {
		try {
			int i = mapper.deleteByEmailId(3);
			if(i>0){
				log.info("delete success!");
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			session.rollback();
		}finally{
			if(session!=null)
				session.close();
		}
	}

	
	@Test
	public void testInsertSendEmail() {
		try {
			int i = mapper.insertSendEmail(sendemail);
			if(i>0){
				log.info("insert success!");
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session!=null)
				session.close();
		}
	}


	@Test
	public void testQuerySendEmailByEmailId() {
		try {
			SendEmail sendemail = mapper.querySendEmailByEmailId(1);
		log.info(sendemail);
			session.commit();
		} catch (Exception e) {
			log.error(e.getMessage());
			session.rollback();
		}finally{
			if(session!=null)
				session.close();
		}
		
	}

	
	@Test
	public void testQueryAllSendEmail() {
		try {
			List<SendEmail> listSendEmail = mapper.queryAllSendEmail();
			Iterator<SendEmail> its = listSendEmail.iterator();
			while(its.hasNext()){
				log.info(its.next());
			}
			session.commit();
		} catch (Exception e) {
			log.error(e.getMessage());
			session.rollback();
		}finally{
			if(session!=null)
				session.close();
		}
	}

	
	@Test
	public void testUpdateSendEmail() {
		
		try {
			sendemail.setEmailId(3);
			int  i = mapper.updateSendEmail(sendemail);
			if(i>0){
				log.info("update success!");
			}
			session.commit();
		} catch (Exception e) {
			log.error(e.getMessage());
			session.rollback();
		}finally{
			if(session!=null)
				session.close();
		}
	}


}
