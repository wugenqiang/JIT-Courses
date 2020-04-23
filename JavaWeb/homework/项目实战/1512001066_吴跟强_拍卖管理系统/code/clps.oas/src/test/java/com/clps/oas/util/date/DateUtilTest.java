
/**
  * @Copyright:
  * @Company:
  */

package com.clps.oas.util.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.clps.oas.util.date.DateUtil;

/**
 * 
 * @Title:
 * @Description:
 * @Author:Henery.wu
 * @Since:2018年5月11日上午10:20:24
 * @Version:1.1.0
 */



public class DateUtilTest {
	DateUtil du = new DateUtil();
	Date date = new Date();
	private Logger logger = Logger.getLogger(DateUtilTest.class);

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.clps.mms.util.date.DateUtil#DateToString1(java.util.Date)}.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testDateToString1() {
		logger.info(du.DateToString1(date));
	}

	/**
	 * Test method for
	 * {@link com.clps.oas.util.date.DateUtil#DateToString2(java.util.Date)}.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testDateToString2() {
		logger.info(du.DateToString2(date));
	}

	/**
	 * Test method for
	 * {@link com.clps.oas.util.date.DateUtil#StringToDate1(java.lang.String)}.
	 * 
	 * @throws ParseException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testStringToDate1() throws ParseException {
		String datetime = "2018-05-10 11:11:11.003";
		logger.info(du.StringToDate1(datetime));
	}

	/**
	 * Test method for
	 * {@link com.clps.oas.util.date.DateUtil#StringToDate2(java.lang.String)}.
	 * 
	 * @throws ParseException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testStringToDate2() throws ParseException {
		String datetime = "2018年05月10日 11时19分15秒099毫秒";
		logger.info(du.StringToDate2(datetime));
	}

	
	/**
	 * Test method for 
	 * {@link com.clps.oas.util.date.DateUtil#getTimestamp()}.
	 * @throws ParseException
	 */
	public void testParse() {
		try {
			logger.info("test begin...");
			String pattern = "yyyy年MM月dd日 HH时mm分ss秒SSS毫秒";
			String dateValue = "2018年05月09日 11时09分05秒099毫秒";
			logger.info(DateUtil.parse(dateValue, pattern));
		} catch (Exception e) {
			logger.error("output error!!!");
		}
	}


	/**
	 * Test method for {@link com.clps.oas.util.date.DateUtil#getTimestamp()}.
	 */
	@Test
	public void testGetTimestamp() {
		long currTime = System.currentTimeMillis();
		Timestamp time = new Timestamp(currTime);
		System.out.println(time);
	}

}

	