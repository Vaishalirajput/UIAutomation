package appUtil;

import org.openqa.selenium.support.PageFactory;

import BaseConf.BaseConfig;
import pageObjects.MedicationObjects;

public class MedicationUtil extends BaseConfig{

	MedicationObjects page;
	
	public MedicationUtil()
	{
		page = PageFactory.initElements(driver, MedicationObjects.class);
	}
	
	public void landOnEnterMedicationDeatilsScreen()
	{
		page.clickMyHealth();
		page.clickOnMedicationTab();
		page.clickFabButton();
		page.clickOnUploadManually();
	}
	
	public void landOnSearchMedicineScreen()
	{
		
	}
	
}
