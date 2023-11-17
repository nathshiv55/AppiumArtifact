package appiumLaunchh;

import org.testng.annotations.Test;

public class TestClass extends BaseInitClass {
    @Test
	public void TestMethod()
	{
		System.out.println(appDt.getProperty("username"));
		System.out.println("dffd\r");
		//System.out.println(" - Your order id is = "+orderId.getText()\r\n " +  "\"- Order Sucessfully Placed\r\n" + "\");
	}
}