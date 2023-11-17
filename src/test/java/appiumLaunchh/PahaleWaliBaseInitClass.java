package appiumLaunchh;

public class PahaleWaliBaseInitClass {

	
	package com.Tc.BasePackage;

	import java.io.FileInputStream;
	import java.net.URL;
	import java.time.Duration;
	import java.util.Properties;

	import org.apache.log4j.Logger;
	import org.openqa.selenium.By;
	import org.openqa.selenium.remote.DesiredCapabilities;

	import io.appium.java_client.android.Activity;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.remote.MobileCapabilityType;

	public class BaseInit {

		public static AndroidDriver driver;   //public static so we can use it anyWhere in Project.
		public static Properties appdata;     //public so we can use it anyWhere in Project. static so we can call it without class name.
		public static DesiredCapabilities caps;
		public static Logger logs;

		
		public  void basicCapabilities() throws Exception

		{
			logs = Logger.getLogger("devpinoyLogger");

			appdata = new Properties();
			FileInputStream fi = new FileInputStream("./src/test/resources/PropertiesData/AppData.properties");
			appdata.load(fi);
			try {
		    caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.DEVICE_NAME,appdata.getProperty("deviceName"));
			caps.setCapability(MobileCapabilityType.UDID,appdata.getProperty("udid"));
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME,appdata.getProperty("platformName"));
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,appdata.getProperty("platformVersion"));
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,appdata.getProperty("automationName"));
			//caps.setCapability("newCommandTimeout", "200");
			
		//caps.setCapability("appPackage", "com.tiffintom");
		//caps.setCapability("appActivity", "com.tiffintom.ui.base.MainActivity");
		//caps.setCapability(MobileCapabilityType.NO_RESET, "true");      //do not clear cache
		//caps.setCapability(MobileCapabilityType.FULL_RESET, "false");   //do not install the app again 
			
				driver = new AndroidDriver (new URL ("http://0.0.0.0:4723/wd/hub"),caps);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			}
			catch(Exception e)
			{
				//When an exception is chained, the getCause method is used to get the original cause. 
				System.out.println("Cause is : "+e.getCause());
				System.out.println("Message is : "+e.getMessage());
				e.printStackTrace();
			}

		}

		@SuppressWarnings("deprecation")
		public void startUp()
		{


			boolean IsAppInstalled = driver.isAppInstalled("com.tiffintom");

			if(IsAppInstalled)
			{
				driver.startActivity(new Activity("com.tiffintom", "com.tiffintom.ui.base.MainActivity"));   //package name & ActivityName.
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				logs.info("App successfully open...");  //ye log me print karega.
				System.out.println("App successfully open...");   //Ye console window me print karega. 



			}
			else
			{
				driver.installApp(System.getProperty("user.dir")+"/APK/TiffinTom_5.2.apk");    //Paste build in APK folder.

				try
				{
					driver.startActivity(new Activity("com.tiffintom", "com.tiffintom.ui.base.MainActivity"));   //this will start the activity.
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					logs.info("App successfully launched...");
					System.out.println("App successfully launched...");

					//when new installation , its need to select country before loginPage
					//Select Country
					driver.findElement(By.id("com.tiffintom:id/tvSelectedCountry")).click();
					driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")).click();
					driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")).click();

				}
				catch(Exception e)
				{
					System.out.println("App not open....");

				}
			}
		}

		


	}

}
