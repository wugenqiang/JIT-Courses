
package com.clps.oas.sm.dao;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.pojo.Account;
import com.clps.oas.sm.vo.AccountVo;
import com.clps.oas.util.mybatis.MyBatisUtil;

public class AccountMapperTest {

	private SqlSessionFactory sf = null;
	private SqlSession session = null;
	private AccountMapper accountdao = null;

	private Account account1 = new Account();
	private Account account2 = new Account();
	private Account account3 = new Account();
	private Account account = new Account();
	private List<AccountVo> accounts = new ArrayList<AccountVo>();

	private Logger logger = Logger.getLogger(AccountMapper.class);

	@Before
	public void setUp() throws Exception {
		this.sf = MyBatisUtil.getSqlSessionFactory();
		this.session = sf.openSession();
		this.accountdao = session.getMapper(AccountMapper.class);

		account1.setAccountName("jhx1");
		account1.setAccountRealName("金宏潇");
		account1.setAccountPass("123123");
		account1.setAccountMail("2602419977@qq.com");
		account1.setAccountProvince("江苏");
		account1.setAccountCity("南京");
		account1.setAccountDistrict("江宁");
		account1.setAccountAddress("金陵科技学院");
		account1.setAccountPhone("13913836275");
		account1.setAccountTelephone(null);
		account1.setAccountRoleId(1);
		account1.setAccountPositionId(1);
		account1.setAccountDepartmentId(1);
		account1.setAccountCompanyId(1);
		account1.setAccountCreatedDatetime(new Timestamp(new Date().getTime()));
		account1.setAccountUpdatedDatetime(new Timestamp(new Date().getTime()));
		account1.setAccountIsvalid(true);

		account2.setAccountName("jhx2");
		account2.setAccountRealName("金宏潇2");
		account2.setAccountPass("123");
		account2.setAccountMail("969863331@qq.com");
		account2.setAccountProvince("江苏");
		account2.setAccountCity("南京");
		account2.setAccountDistrict("江宁");
		account2.setAccountAddress("金陵科技学院");
		account2.setAccountPhone("13913836275");
		account2.setAccountTelephone(null);
		account2.setAccountRoleId(2);
		account2.setAccountPositionId(2);
		account2.setAccountDepartmentId(2);
		account2.setAccountCompanyId(2);
		account2.setAccountCreatedDatetime(new Timestamp(new Date().getTime()));
		account2.setAccountUpdatedDatetime(new Timestamp(new Date().getTime()));
		account2.setAccountIsvalid(true);

		account3.setAccountName("jhx3");
		account3.setAccountRealName("金宏潇3");
		account3.setAccountPass("1234");
		account3.setAccountMail("2602419977@qq.com");
		account3.setAccountProvince("江苏");
		account3.setAccountCity("南京");
		account3.setAccountDistrict("江宁");
		account3.setAccountAddress("金陵科技学院");
		account3.setAccountPhone("13913836275");
		account3.setAccountTelephone(null);
		account3.setAccountRoleId(3);
		account3.setAccountPositionId(3);
		account3.setAccountDepartmentId(3);
		account3.setAccountCompanyId(3);
		account3.setAccountCreatedDatetime(new Timestamp(new Date().getTime()));
		account3.setAccountUpdatedDatetime(new Timestamp(new Date().getTime()));
		account3.setAccountIsvalid(true);

		account.setAccountId(2);
		account.setAccountMail("jin_hx@163.com");
		account.setAccountUpdatedDatetime(new Timestamp(new Date().getTime()));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeleteById() {
		try {
			int i = this.accountdao.deleteAccountById(4);
			if (i > 0) {
				logger.info(ParamCommon.DELETE_SUCCESS);
				session.commit();
			}
		} catch (Exception e) {
			logger.error(ParamCommon.DELETE_FAILURE);
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Test
	public void testLogicDeleteById() {
		try {
			int i = this.accountdao.logicDeleteAccountById(2);
			if (i > 0) {
				logger.info(ParamCommon.DELETE_SUCCESS);
				session.commit();
			}
		} catch (Exception e) {
			logger.error(ParamCommon.DELETE_FAILURE);
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Test
	public void testInsertAccountInfo() {
		try {
			int i = this.accountdao.insertAccountInfo(account2);
			if (i > 0) {
				logger.info(ParamCommon.ADD_SUCCESS);
				session.commit();
			}
		} catch (Exception e) {
			logger.error(ParamCommon.ADD_FAILURE);
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Test
	public void testQueryAccountsByReq() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryAllAccounts() {

		try {
			this.accounts = this.accountdao.queryAllAccounts();
			Iterator<AccountVo> its = accounts.iterator();
			while (its.hasNext()) {
				System.out.println(its.next());
			}
			session.commit();
		} catch (Exception e) {
			logger.error(e);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Test
	public void queryAccountById() {
		logger.info(accountdao.queryAccountById(1));
	}

	@Test
	public void testUpdateAccountInfo() {
		try {
			int i = this.accountdao.updateAccountInfo(account);
			if (i > 0) {
				logger.info(ParamCommon.UPDATE_SUCCESS);
				session.commit();
			}
		} catch (Exception e) {
			logger.error(ParamCommon.UPDATE_FAILURE);
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
