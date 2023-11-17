package appiumLaunchh;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class BaseInitClass {
	AndroidDriver driver;
	Properties appDt;

	public String getScreenShot(String imageName, AndroidDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;  //ts will point where driver is pointing

		File scrFile = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\" +imageName+ System.currentTimeMillis() + ".png";

		// System.out.println(path);
		File destination = new File(path);

		try {

			FileUtils.copyFile(scrFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;
	}
	
	
	
	
	public void startUp() throws IOException
	{
	Properties appDt = new Properties();
	FileInputStream fi = new FileInputStream("./src/test/resources/appData/AppData.properties");
	appDt.load(fi);
	
	//appDt.getProperty("username");
	System.out.println(appDt.getProperty("username"));
	
}
	
	
	
	
}

