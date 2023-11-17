package appiumLaunchh;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestClass4 {


	public static AndroidDriver driver;
	DesiredCapabilities caps;
	@BeforeTest
	public void testMethod1() throws InterruptedException, IOException { 

		caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Nokia 8.1");
		caps.setCapability(MobileCapabilityType.UDID,"PNXID18121001695");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");

		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		try {
			caps.setCapability("appPackage", "com.tiffintom");
			caps.setCapability("appActivity", "com.tiffintom.ui.base.MainActivity");


			caps.setCapability(MobileCapabilityType.NO_RESET, "true");      //do not clear cache
			caps.setCapability(MobileCapabilityType.FULL_RESET, "false");   //do not install the app again 

			driver = new AndroidDriver (new URL ("http://0.0.0.0:4723/wd/hub"),caps);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			try

			{
				//Select Country
				driver.findElement(By.id("com.tiffintom:id/tvSelectedCountry")).click();
				driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")).click();
				driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")).click();

			}
		catch(Exception e1)
			{
			System.out.println("App open...");
			}
			
		}



		catch(Exception e) {


			//driver.installApp(System.getProperty("user.dir")+"/APK/TiffinTom_5.2.apk");
			caps.setCapability(MobileCapabilityType.APP, new File("C:\\Users\\Lenovo\\Documents\\apkFiles\\TiffinTom_5.2.apk").getAbsolutePath());


			//	driver.startActivity(new Activity("com.tiffintom", "com.tiffintom.ui.base.MainActivity"));
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


			driver = new AndroidDriver (new URL ("http://0.0.0.0:4723/wd/hub"),caps);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


			//Select Country
			driver.findElement(By.id("com.tiffintom:id/tvSelectedCountry")).click();
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")).click();
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")).click();

		}
	}
	@Test
	public static void logIn() throws Exception
	{

		//Sign In
		driver.findElement(By.id("com.tiffintom:id/etEmail")).sendKeys("testap24@yopmail.com");
		driver.findElement(By.id("com.tiffintom:id/etPassword")).sendKeys("Shiv@123");
		driver.findElement(By.id("com.tiffintom:id/btnSignin")).click();


		//Enter PostCode
		driver.findElement(By.id("com.tiffintom:id/etPostcode")).sendKeys("WS14BA");
		driver.findElement(By.id("com.tiffintom:id/btnConfirm")).click();
		Thread.sleep(4000);

		//Log Out
		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Settings\"]/android.widget.FrameLayout[2]/android.widget.ImageView")).click();
		driver.findElement(By.id("com.tiffintom:id/cvLogout")).click();
		driver.findElement(By.id("com.tiffintom:id/tvConfirm")).click();




	}

	@AfterTest
	public static void tearDown() throws Exception
	{
		Thread.sleep(2000);
		driver.quit();
	}
}

