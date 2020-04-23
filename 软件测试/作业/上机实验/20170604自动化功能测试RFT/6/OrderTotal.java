import com.rational.test.ft.*;
import com.rational.test.ft.object.interfaces.*;
import com.rational.test.ft.script.*;
import com.rational.test.ft.value.*;
import com.rational.test.ft.vp.*;
import resources.OrderTotalHelper;

ordertotal.java

/**
 * Description   : Functional Test Script
 * @author Administrator
 */
public class OrderTotal extends OrderTotalHelper
{
	/**
	 * Script Name   : <b>OrderTotal</b>
	 * Generated     : <b>May 26, 2017 9:26:38 AM</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 5.1  Build 2600 (S)
	 * 
	 * @since  2017/05/26
	 * @author Administrator
	 */
	public void testMain(Object[] args) 
	{
		startApp("ClassicsJavaA");
		
		// Frame: ClassicsCD
		tree2().click(atRow(atPath("Composers->Schubert")), atPoint(13,7));
		tree2().click(atPath("Composers->Schubert->Location(PLUS_MINUS)"));
		tree2().click(atPath("Composers->Schubert->String Quartets Nos. 4 & 14"));
		placeOrder().click();
		
		// Frame: Member Logon
		ok().click();
		// Data Driven Code inserted on May 26, 2017
		
		// Frame: Place an Order
		item().setText(dpString("Item"));
		_1899().setText(dpString("_1899"));
		quantity().setText(dpString("Quantity"));
		cardNumberIncludeTheSpaces().setText(dpString("CardNumberIncludeTheSpaces"));
		creditCombo().setText(dpString("creditCombo"));
		expirationDate().setText(dpString("ExpirationDate"));
		name().setText(dpString("Name"));
		street().setText(dpString("Street"));
		cityStateZip().setText(dpString("CityStateZip"));
		phone().setText(dpString("Phone"));
		cardNumberIncludeTheSpaces().click(atPoint(70,15));
		placeAnOrder().inputChars("1111");
		expirationDate().click(atPoint(39,10));
		placeAnOrder().inputChars("11");
		_1999().performTest(_1999_textVP());
		placeOrder2().click();
		
		// 
		��Ϣ().move(atPoint(438,385));
		��Ϣ().move(atPoint(350,387));
		ȷ��().click();
		
		// Frame: ClassicsCD
		classicsCD(ANY,MAY_EXIT).close();
	}
}
