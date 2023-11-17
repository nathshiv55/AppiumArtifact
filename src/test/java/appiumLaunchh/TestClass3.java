package appiumLaunchh;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestClass3 {

	public static AndroidDriver driver;

	@Test
	public void testMethod() throws InterruptedException, MalformedURLException { 

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Nokia 8.1");
		caps.setCapability(MobileCapabilityType.UDID,"PNXID18121001695");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");

		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		caps.setCapability("appPackage", "com.tiffintom");
		caps.setCapability("appActivity", "com.tiffintom.ui.base.MainActivity");
		//driver = new AndroidDriver (new URL ("http://0.0.0.0:4723/wd/hub"),caps);

		
		boolean IsAppInstalled = driver.isAppInstalled("com.tiffintom");
		if(IsAppInstalled)
		{
			//caps.setCapability("appPackage", "com.tiffintom");
			//caps.setCapability("appActivity", "com.tiffintom.ui.base.MainActivity");


			caps.setCapability(MobileCapabilityType.NO_RESET, "true");      //do not clear cache
			caps.setCapability(MobileCapabilityType.FULL_RESET, "false"); 
			
		}
		else {
			driver.installApp(System.getProperty("user.dir")+"/APK/TiffinTom_5.2.apk");


			driver = new AndroidDriver (new URL ("http://0.0.0.0:4723/wd/hub"),caps);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


			//Select Country
			driver.findElement(By.id("com.tiffintom:id/tvSelectedCountry")).click();
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")).click();
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")).click();
		}
		//Sign up
		driver.findElement(By.id("com.tiffintom:id/signupButton")).click();
		driver.findElement(By.id("com.tiffintom:id/etFirstName")).sendKeys("Shiv");
		driver.findElement(By.id("com.tiffintom:id/etLastName")).sendKeys("Nath");
		driver.findElement(By.id("com.tiffintom:id/etEmail")).sendKeys("testap21@yopmail.com");
		driver.findElement(By.id("com.tiffintom:id/etMobile")).sendKeys("0712345678");
		driver.findElement(By.id("com.tiffintom:id/etPassword")).sendKeys("Shiv@123");
		driver.findElement(By.id("com.tiffintom:id/etConfirmPassword")).sendKeys("Shiv@123");
		driver.findElement(By.id("com.tiffintom:id/btnSignup")).click();
		Thread.sleep(6000);

		//Enter PostCode
		driver.findElement(By.id("com.tiffintom:id/etPostcode")).sendKeys("WS14BA");
		driver.findElement(By.id("com.tiffintom:id/btnConfirm")).click();
		Thread.sleep(3000);

		//Log Out
		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Settings\"]/android.widget.FrameLayout[2]/android.widget.ImageView")).click();
		driver.findElement(By.id("com.tiffintom:id/cvLogout")).click();
		driver.findElement(By.id("com.tiffintom:id/tvConfirm")).click();

		//Sign In
		driver.findElement(By.id("com.tiffintom:id/etEmail")).sendKeys("testap21@yopmail.com");
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



		Thread.sleep(7000);
		driver.quit();
	}

}




