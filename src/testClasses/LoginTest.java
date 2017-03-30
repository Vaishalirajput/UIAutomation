package testClasses;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BaseConf.BaseConfig;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.LogInObjects;

public class LoginTest {
	AndroidDriver driver;
	BaseConfig launchapp = new BaseConfig();
	LogInObjects page;
	
	@Test
	public void aloginScreenvalidation() throws MalformedURLException
	{
		
		driver = launchapp.launchApp();
		
		String activity = driver.currentActivity();
		System.out.println("activity = "+activity);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		page = PageFactory.initElements(driver, LogInObjects.class);
		page.skipafterlaunch_click();
	}
	
	@Test(dependsOnMethods={"aloginScreenvalidation"})
	public void EnterMobileNo()
	{
		
		page.mobilenumberfield_sendkeys("1230000000");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		page.clickNextButton();
	}
	
	@Test(dependsOnMethods={"EnterMobileNo"})
	public void enterPassword()
	{
		
		page.passwordField("test@123");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		page.signInButtonClick();
	}	
	
	@Test(dependsOnMethods={"enterPassword"})
	public void acceptHippa()
	{
		
		page.continueButtonClick();
		
	}
	
	

}
