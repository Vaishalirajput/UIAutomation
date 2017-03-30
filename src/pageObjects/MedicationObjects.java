package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MedicationObjects {

		public final WebDriver driver;
		public MedicationObjects(WebDriver d){
			driver = d;
		}
		
		@FindBy(id="com.fisike:id/tv_navigation_drawer_item_title")
		private WebElement myHealth;
		
		@FindBy(name="Medications")
		private WebElement medicationTab;
		
		@FindBy(xpath="//android.widget.ImageButton[@content-desc='FABMenu']")
		private WebElement fabButton;
		
		@FindBy(xpath="//android.widget.TextView[@text='Add Manually']")
		private WebElement uploadManually;
		
		@FindBy(id="com.fisike:id/etMedicineSearch")
		private WebElement searchBoxClick;
		
		@FindBy(id="com.fisike:id/et_search")
		private WebElement searchBox;
		
		@FindBy(xpath="//android.widget.TextView[@text='CROCIN-DPS-15ML']")
		private WebElement clickOnMedicine;
		
		@FindBy(id="com.fisike:id/tv_no_data_msg")
		private WebElement searchMedicationText;
		
		@FindBy(id="com.fisike:id/toolbar_title")
		private WebElement enterMedicationDetailsHeaderText;
		
		@FindBy(id="com.fisike:id/btn_back")
		public WebElement backButton;
		
		@FindBy(id="com.fisike:id/no_data_image")
		public WebElement imageOnEnterMedicineScreen;
		
		@FindBy(id="com.fisike:id/btnCross")
		private WebElement crossButton;
		
		public void crossButtonClick()
		{
			crossButton.click();
		}
		
		public String textInSearchMedicineTextBox()
		{
			return searchBox.getText();
		}
		
		public void backButtonClick()
		{
			backButton.click();
		}
		
		public String enterMedicationDetailsHeaderText()
		{
			return enterMedicationDetailsHeaderText.getText();
		}
		
	    public void clickMyHealth()
	    {
	    	myHealth.click();
	    }
	    
	    public void clickOnMedicationTab()
	    {
	    	medicationTab.click();
	    }
	    
	    public void clickFabButton()
	    {
	    	fabButton.click();
	    }
	    
	    public void clickOnUploadManually()
	    {
	    	uploadManually.click();
	    }
	    
	    public void clickMedicationSearchBox()
	    {
	    	searchBoxClick.click();
	    }
	    
	    public void clickSearchBox(String x)
	    {
	    	searchBox.sendKeys(x);
	    }
	    
	    public void clickOnAnyMedicine()
	    {
	    	clickOnMedicine.click();
	    }
	    
	    public String searchMedicationText()
	    {
	    	return searchMedicationText.getText();
	    	
	    }
	    
	    
	
}
