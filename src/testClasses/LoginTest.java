package testClasses;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.testng.annotations.Test;

import BaseConf.BaseConfig;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.LogInObjects;

public class LoginTest {
	static AndroidDriver driver;
	BaseConfig launchapp = new BaseConfig();
	LogInObjects page = new LogInObjects();
	
	@Test
	public void aloginScreenvalidation() throws MalformedURLException
	{
		driver = launchapp.launchApp();
	    page.nextButton_click();
	    Assert.assertEquals(page.noUsernameVal(), "Enter user name");
	}
	
	@Test 
	public void clickOnNext()
	{
		page.mobilenumberfield_sendkeys("test@fisike.com");
		page.nextButton_click();
	}
	

}
