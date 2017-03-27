package testClasses;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseConf.BaseConfig;
import BaseConf.Login;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.LogInObjects;
import pageObjects.MedicationObjects;

public class MedicationTest extends BaseConfig{

	
	@Test
	public void clickOnMedicationTab() throws MalformedURLException, InterruptedException
	{
		Login login = new Login();
		login.logintoApp();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("com.fisike:id/tv_navigation_drawer_item_title")).click();
		driver.findElement(By.name("Medications")).click();
		//driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='FABMenu'"]))
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='FABMenu']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Add Manually']")).click();
		driver.findElement(By.id("com.fisike:id/etMedicineSearch")).click();
		driver.findElement(By.id("com.fisike:id/et_search")).sendKeys("croc");
	    driver.findElement(By.xpath("//android.widget.TextView[@text='CROCIN-DPS-15ML']")).click();
	//new Select(driver.findElement(By.xpath(""))).selectByVisibleText("");
	
	}
	
}
