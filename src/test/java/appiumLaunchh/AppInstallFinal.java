package appiumLaunchh;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
@Test
public class AppInstallFinal {

	AndroidDriver driver;

	@SuppressWarnings("deprecation")
	public void testMethod() throws InterruptedException, MalformedURLException { 

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Nokia 8.1");
		caps.setCapability(MobileCapabilityType.UDID,"PNXID18121001695");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");

		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

		
        caps.setCapability("appPackage", "com.tiffintom");
        caps.setCapability(MobileCapabilityType.NO_RESET, "true"); 
	
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver = new AndroidDriver (new URL ("http://0.0.0.0:4723/wd/hub"),caps);
		boolean IsAppInstalled = driver.isAppInstalled("com.tiffintom");

		if(IsAppInstalled)
		{
			driver.startActivity(new Activity("com.tiffintom", "com.tiffintom.ui.base.MainActivity"));   //package name & ActivityName.
		driver = 	new AndroidDriver (new URL ("http://0.0.0.0:4723/wd/hub"),caps);


		}
		else
		{
			driver.installApp(System.getProperty("user.dir")+"/APK/TiffinTom_5.2.apk");

			driver = new AndroidDriver (new URL ("http://0.0.0.0:4723/wd/hub"),caps);
			try
			{
				driver.startActivity(new Activity("com.tiffintom", "com.tiffintom.ui.base.MainActivity"));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			}
			
			catch(Exception e)
			{
				

			}
			//Select Country
			driver.findElement(By.id("com.tiffintom:id/tvSelectedCountry")).click();
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")).click();
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")).click();

		}
	}

	@AfterTest
	public void teatDown()
	{
	
		driver.quit();

	}
}