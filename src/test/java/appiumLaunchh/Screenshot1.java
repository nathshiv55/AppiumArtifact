package appiumLaunchh;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class Screenshot1  {


	public static String getScreenShot(String imageName, AndroidDriver driver) {

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
}	


