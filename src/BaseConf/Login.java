package BaseConf;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pageObjects.LogInObjects;

public class Login extends BaseConfig{

	BaseConfig launchapp = new BaseConfig();
	static LogInObjects page;
	
	
	public void logintoApp() throws MalformedURLException
	{
		
		driver = launchapp.launchApp();
		String activity = driver.currentActivity();
		System.out.println("activity = "+activity);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		page = PageFactory.initElements(driver, LogInObjects.class);
		page.skipafterlaunch_click();
		page.mobilenumberfield_sendkeys("8586004918");
		page.clickNextButton();
		page.passwordField("test");
		page.signInButtonClick();
		page.continueButtonClick();
	}
}
