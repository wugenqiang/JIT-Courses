import junit.framework.TestCase;


public class GCDTest extends TestCase {
	public void testGetGCD(){
		GCD gcd=new GCD();
		assertEquals(6,gcd.getGCD(6,12));
		assertEquals(16,gcd.getGCD(48,32));
		assertEquals(15,gcd.getGCD(45,60));
		assertEquals(4,gcd.getGCD(16,36));	
	}
	public void testMain(){
		
	}

}

