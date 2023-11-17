package appiumLaunchh;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class PropertiesClass {
	public static AndroidDriver driver;
	public static DesiredCapabilities caps;
	Properties appDt;
	@Test
	public void startUp() throws IOException
	    {
		
	appDt = new Properties();
	FileInputStream fi = new FileInputStream("./src/test/resources/appData/AppData.properties");
	appDt.load(fi);
	
	//appDt.getProperty("username");
	System.out.println("userName is :"+appDt.getProperty("username"));
	

	caps = new DesiredCapabilities();
	caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Nokia 8.1");
	caps.setCapability(MobileCapabilityType.UDID,"PNXID18121001695");
	caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
	caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
	caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

	caps.setCapability("appPackage", appDt.getProperty("packageName")); // Replace with the package name of the app you want to uninstall
	caps.setCapability("appActivity", appDt.getProperty("activityName"));
	// Initialize the AndroidDriver

	// Set your Appium server
	driver = new AndroidDriver (new URL ("http://0.0.0.0:4723/wd/hub"),caps);



	// Uninstall the app
	String appPackage = appDt.getProperty("packageName"); // Replace with the package name of the app you want to uninstall
	driver.removeApp(appPackage);
	System.out.println("App uninstalled successfully...");

	// Close the driver
	driver.quit();
	
}
}
