package zhengchu357;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;


public class functionTest extends TestCase {
	@Test
	public void testGet(){
		function abc=new function();
		assertEquals(3,abc.get(6));
		assertEquals(5,abc.get(15));
		assertEquals(15,abc.get(105));
		assertEquals(3,abc.get(13));	
	}
	public void testMain(){
		
	}

}