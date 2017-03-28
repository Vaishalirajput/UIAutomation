package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MedicationObjects {

		public final WebDriver driver;
		public MedicationObjects(WebDriver d){
			driver = d;
		}
		
		@FindBy(id="com.fisike:id/tv_navigation_drawer_item_title")
		public WebElement myHealth;
		
		@FindBy(name="Medications")
		public WebElement medicationTab;
		
		@FindBy(xpath="//android.widget.ImageButton[@content-desc='FABMenu']")
		public WebElement fabButton;
		
		@FindBy(xpath="//android.widget.TextView[@text='Add Manually']")
		public WebElement uploadManually;
		
		@FindBy(id="com.fisike:id/etMedicineSearch")
		public WebElement searchBoxClick;
		
		@FindBy(id="com.fisike:id/et_search")
		public WebElement searchBox;
		
		@FindBy(xpath="//android.widget.TextView[@text='CROCIN-DPS-15ML']")
		public WebElement clickOnMedicine;
		
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
	    
	    
	
}
