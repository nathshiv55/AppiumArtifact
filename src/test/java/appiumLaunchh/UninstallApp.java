package appiumLaunchh;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

public class UninstallApp {
	public static AndroidDriver driver;
	public static DesiredCapabilities caps;
	@Test
	public  void appUnstall() throws IOException{

		caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Nokia 8.1");
		caps.setCapability(MobileCapabilityType.UDID,"PNXID18121001695");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

		caps.setCapability("appPackage", "com.tiffintom"); // Replace with the package name of the app you want to uninstall
		caps.setCapability("appActivity", "com.tiffintom.ui.base.MainActivity");
		// Initialize the AndroidDriver

		// Set your Appium server
		driver = new AndroidDriver (new URL ("http://0.0.0.0:4723/wd/hub"),caps);



		// Uninstall the app
		String appPackage = "com.tiffintom"; // Replace with the package name of the app you want to uninstall
		driver.removeApp(appPackage);
		System.out.println("App uninstalled successfully...");

		// Close the driver
		driver.quit();
	}
}
