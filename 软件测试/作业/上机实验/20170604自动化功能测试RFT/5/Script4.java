

import com.rational.test.ft.*;
import com.rational.test.ft.object.interfaces.*;
import com.rational.test.ft.script.*;
import com.rational.test.ft.value.*;
import com.rational.test.ft.vp.*;
import resources.Script4Helper;

/**
 * Description   : Functional Test Script
 * @author Administrator
 */
public class Script4 extends Script4Helper
{
	/**
	 * Script Name   : <b>Script4</b>
	 * Generated     : <b>May 25, 2017 4:44:28 PM</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 5.1  Build 2600 (S)
	 * 
	 * @since  2017/05/25
	 * @author Administrator
	 */
	public void testMain(Object[] args) 
	{
		startApp("ClassicsJavaA");
		
		// Frame: ClassicsCD
		placeOrder().click();
		
		// Frame: Member Logon
		rememberPassword().performTest(RememberPassword_textVP());
		password().click(atPoint(61,15));
		memberLogon().inputKeys("{Num1}{Num2}{Num3}");
		ok().click();
		
		// Frame: Place an Order
		_1999().performTest(_1999_textVP());
		cardNumberIncludeTheSpaces().click(atPoint(23,13));
		placeAnOrder().inputChars("1234 1234 1234 1234");
		expirationDate().click(atPoint(8,7));
		placeAnOrder().inputKeys("{Num1}{Num2}/{Num1}{Num5}");
		placeOrder2().click();
		
		// 
		��Ϣ().move(atPoint(345,391));
		ȷ��().click();
		
		// Frame: ClassicsCD
		placeOrder().performTest(PlaceOrder_standardVP());
		classicsJava(ANY,MAY_EXIT).close();
	}
}
