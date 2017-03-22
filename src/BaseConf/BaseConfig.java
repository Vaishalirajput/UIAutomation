package BaseConf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BaseConfig {
	
	static AndroidDriver driver;
	static DesiredCapabilities cabs = new DesiredCapabilities();
	static SystemLocations sysLoc = new SystemLocations();
	static Properties prop= new Properties();
	
	public void launchApp() throws MalformedURLException
	//public static void main(String[] args) throws MalformedURLException
	{
		prop = sysLoc.getConfigLocation();
		//System.out.print(prop.getProperty("deviceName"));
		cabs.setCapability("platformName", prop.getProperty("platform"));
		cabs.setCapability("deviceName",prop.getProperty("deviceName"));
		cabs.setCapability("appActivity",prop.getProperty("activity"));
		cabs.setCapability("appPackage",prop.getProperty("package"));
		cabs.setCapability("fullReset", false);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4720/wd/hub"),cabs);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
}
