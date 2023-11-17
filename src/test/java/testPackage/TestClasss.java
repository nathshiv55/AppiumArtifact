package testPackage;

import java.io.File;

import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TestClasss {
      @Test
	 public static void startServer () {
	        AppiumServiceBuilder builder = new AppiumServiceBuilder ();
	        builder.withIPAddress ("127.0.0.1")
	            .usingPort (4723)
	            .withAppiumJS (
	                new File ("C:\\Users\\Windows\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
	            .usingDriverExecutable (new File ("E:\\Program Files\\nodejs\\node.exe"))
	            .withArgument (BASEPATH, "/wd/hub")
	            .withArgument (GeneralServerFlag.SESSION_OVERRIDE)
	            .withArgument (GeneralServerFlag.LOG_LEVEL, "debug");

	        service = AppiumDriverLocalService.buildService (builder);
	        service.start ();
	    }
}
