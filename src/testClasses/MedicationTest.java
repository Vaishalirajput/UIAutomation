package testClasses;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseConf.BaseConfig;
import BaseConf.Login;
import appUtil.MedicationUtil;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.LogInObjects;
import pageObjects.MedicationObjects;

public class MedicationTest extends BaseConfig{

	MedicationObjects page;
	Login login;
	SoftAssert sAssert;
	MedicationUtil util;
	
	
	public MedicationTest() throws MalformedURLException
	{
		login = new Login();
		login.logintoApp();
		util = new MedicationUtil();
		page = PageFactory.initElements(driver, MedicationObjects.class);
		sAssert = new SoftAssert();
	}
	@Test
	public void navigateOnAddMedicationAndFrequency() throws  InterruptedException
	{
		
		util.landOnEnterMedicationDeatilsScreen();
		sAssert.assertEquals(page.enterMedicationDetailsHeaderText(), "Add Medication Details");
		
		/*
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.id("com.fisike:id/tv_navigation_drawer_item_title")).click();
		driver.findElement(By.name("Medications")).click();
		//driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='FABMenu'"]))
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='FABMenu']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Add Manually']")).click();
		driver.findElement(By.id("com.fisike:id/etMedicineSearch")).click();
		driver.findElement(By.id("com.fisike:id/et_search")).sendKeys("croc");
	    driver.findElement(By.xpath("//android.widget.TextView[@text='CROCIN-DPS-15ML']")).click();
	    driver.findElement(By.id("com.fisike:id/imgEdit")).click();
	    driver.swipe(314, 811, 314, 498, 2000);
	    driver.swipe(532, 811, 532, 498, 2000);
	    driver.findElement(By.id("com.fisike:id/rbBefore")).click();
	    driver.swipe(933, 1409, 933, 924, 3000);
	    driver.findElement(By.id("com.fisike:id/bt_number_picker")).click();
	    //new Select(driver.findElement(By.xpath(""))).selectByVisibleText("");*/
	
	}
	
	@Test(dependsOnMethods={"navigateOnAddMedicationAndFrequency"})
	public void clickActionOnSearchMedication()
	{
		page.clickMedicationSearchBox();
		sAssert.assertEquals(page.textInSearchMedicineTextBox(), "Enter Medicine Name");
	}
	
	@Test(dependsOnMethods={"clickActionOnSearchMedication"})
	public void verifyElementOnEnterMedicineNameScreen()
	{
		sAssert.assertEquals(true, page.backButton.isDisplayed());
		sAssert.assertEquals(page.textInSearchMedicineTextBox(), "Enter Medicine Name");
		sAssert.assertEquals(true, page.imageOnEnterMedicineScreen.isDisplayed());
		sAssert.assertEquals(page.searchMedicationText(), "Search your medicine" );
	}
	
	@Test(dependsOnMethods={"verifyElementOnEnterMedicineNameScreen"})
	public void enterLessCharInEnterMedicine() //enter less than 3 char in search Medicine text box
	{
		page.clickSearchBox("cr");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		sAssert.assertEquals(page.searchMedicationText(), "Search your medicine");
		
	}
	
	@Test(dependsOnMethods={"enterLessCharInEnterMedicine"})
	public void crossClickActionOnSearchMedicine()
	{
		page.crossButtonClick();
		sAssert.assertEquals(page.textInSearchMedicineTextBox(), "Enter Medicine Name");
	}
	
	@Test(dependsOnMethods={"crossClickActionOnSearchMedicine"})
	public void backArrowClickOnSearchMedicine()
	{
		page.backButtonClick();
		sAssert.assertEquals(page.enterMedicationDetailsHeaderText(), "Add Medication Details");
	} 
	
	@Test(dependsOnMethods={"backArrowClickOnSearchMedicine"})
	public void enterMedicineNameAndSelectAnyMedicine()
	{
		page.clickMedicationSearchBox();
		page.clickSearchBox("croc");
		page.clickOnAnyMedicine();
		sAssert.assertEquals(page.enterMedicationDetailsHeaderText(), "Add Medication Details");
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
