package com.clps.oas.util.spring;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTestBase extends AbstractJUnit4SpringContextTests {
	
}