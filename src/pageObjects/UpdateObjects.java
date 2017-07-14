package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

public class UpdateObjects {
	public final WebDriver driver;
	public UpdateObjects(WebDriver d){
		driver = d;
	}
	
	@FindBy(className="android.widget.ImageButton")
	private WebElement sideDrawer;
	
	public void navigateOnMyPro()
	{
		sideDrawer.click();
		sideDrawerArrow.click();
	}
	
	@FindBy(id="com.engage.debug:id/carrot")
	private WebElement sideDrawerArrow;
	
	@FindBy(className="android.widget.ImageView")
	private WebElement overflow;
	
	@FindBy(id="update_profile")
	private WebElement updateProfile;
	
	public void navigateOnUpdateProfile()
	{
		overflow.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TouchAction touch = new TouchAction((PerformsTouchActions) driver);
		touch.tap(553, 172).perform();
		//updateProfile.click();
	}
	
	@FindBy(id="change_password")
	private WebElement changePassword;
	
	@FindBy(id="com.engage.debug:id/edFirstName")
	public WebElement firstNameLabel;
	
	@FindBy(id="com.engage.debug:id/edLastName")
	public WebElement lastNameLabel;
	
	@FindBy(xpath="//android.widget.LinearLayout[contains(@resource-id,'com.engage.debug:id/edFirstName')]/android.widget.EditText[@index='0']")
	public WebElement firstNametext;
	
	@FindBy(xpath="//android.widget.LinearLayout[contains(@resource-id,'com.engage.debug:id/edLastName')]/android.widget.EditText[@index='0']")
	public WebElement lastNametext;
	
	@FindBy(id="gender_label")
	public WebElement genderLabel;
	
	@FindBy(id="com.engage.debug:id/spinnerGenderHeader")
	public WebElement genderDropDown;
	
	@FindBy(xpath="//android.widget.TextView[@text='Male']")
	public WebElement genderMale;
	
	@FindBy(xpath="//android.widget.TextView[@text='Female']")
	public WebElement genderFemale;
	
	@FindBy(xpath="//android.widget.TextView[@text='Others']")
	public WebElement genderother;
	
	@FindBy(id="com.engage.debug:id/txtGender")
	public WebElement genderValueUpdateScreen;
	
	@FindBy(id="com.engage.debug:id/txtMaritalStatus")
	public WebElement maritalValueUpdateScreen;
	
	
	@FindBy(id="com.engage.debug:id/txtUserStatus")
	public WebElement maritalValue;

	
	@FindBy(id="date_of_birth")
	public WebElement dateOfBirthLabel;
	
	@FindBy(id="date_of_birth_button")
	public WebElement dateOfBirthButton;
	
	@FindBy(id="marital_status_label")
	public WebElement maritalStatusLabel;
	
	@FindBy(id="marital_status_drop_down")
	WebElement maritalStatusDropDown;
	
	@FindBy(id="aadhar_card_label")
	public WebElement aadharCardLabel;
	
	@FindBy(xpath="//android.widget.LinearLayout[contains(@resource-id,'com.engage.debug:id/edAadhar')]/android.widget.EditText[@index='0']")
	public WebElement aadharCardText;
	
	@FindBy(xpath="//android.widget.LinearLayout[contains(@resource-id,'com.engage.debug:id/edAadhar')]/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='0']")
	public WebElement aadharValidate;
	
	@FindBy(id="com.engage.debug:id/txtAadhar")
	public WebElement aadharValue;
	
	
	@FindBy(id="com.engage.debug:id/btnUpdate")
	public WebElement updateButton;
	
	@FindBy(id="com.engage.debug:id/txtUserName")
	public WebElement firstNameValue;
	
	@FindBy(id="com.engage.debug:id/txtUserGender")
	public WebElement genderValue;

	@FindBy(id="com.engage.debug:id/txtUserDOB")
	public WebElement dateOfBirthValue;
	
	
	
	
	
	
	
	
	
}
