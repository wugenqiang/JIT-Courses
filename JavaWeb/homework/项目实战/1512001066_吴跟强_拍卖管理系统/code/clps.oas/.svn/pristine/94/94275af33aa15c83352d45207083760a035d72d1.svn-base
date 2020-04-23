package com.clps.oas.sm.dao;


import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.clps.oas.sm.pojo.Position;
import com.clps.oas.util.date.DateUtil;
import com.clps.oas.util.mybatis.MyBatisUtil;

public class PositionMapperTest {

	public static Log log = LogFactory.getLog(PositionMapperTest.class); 
	private SqlSessionFactory sf = null;
	private SqlSession session = null;
	private PositionMapper positionDao = null;
	private List<Position> positions = null;
	
	@Before
	public void setUp() throws Exception {
		this.sf = MyBatisUtil.getSqlSessionFactory();
		this.session = sf.openSession();
		this.positionDao = session.getMapper(PositionMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeletePositionById() {
			try {
				int i = this.positionDao.deletePositionById(1);
				if (i > 0) {
					System.out.println("Delete success!");
					session.commit();
				}
			} catch (Exception e) {
				System.out.println("Delete fail");
				e.printStackTrace();
				session.rollback();
			} finally {
				if (session != null) {
					session.close();
				}
			}
	}

	@Test
	public void testInsertPosition() {
		Position position = new Position();
		position.setPositionName("Alex1");
		DateUtil time =new DateUtil();
		position.setPositionUpdatedDatetime(time.getTimestamp());
		log.info("insert start...");
		try {
			int i = this.positionDao.insertPosition(position);
			System.out.println(i+"       ");
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

	@Test
	public void testQueryPositionById() {
		Position position = new Position();
		try {
			position = this.positionDao.queryPositionById(1);
			log.info(position);
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
	public void testUpdatePosition() {
		Position position = new Position();
		position.setPositionName("leoanrdo1");
		position.setPositionId(13);
		position.setPositionLevel("2");
		try {
			int i = this.positionDao.updatePosition(position);
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

	@Test
	public void testQueryAllPositions() {
		try {
			this.positions = this.positionDao.queryAllPositions();
			Iterator<Position> its = positions.iterator();
			while(its.hasNext()){
				log.info(its.next());
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			if(session !=null){
				session.close();
			}
		}
	}

	@Test
	public void testQueryPositionByName() {
		Position position = new Position();
		position.setPositionName("leonardo");
		try {
			this.positions = this.positionDao.queryPositionByName("leonardo");
			log.info(positions);
			Iterator<Position> its = positions.iterator();
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
