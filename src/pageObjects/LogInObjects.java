package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInObjects {
	public final WebDriver driver;
	public LogInObjects(WebDriver d){
		driver = d;
	}
	
	@FindBy(id="com.fisike:id/btn_skip")
	public WebElement skipafterlaunch;
	
	@FindBy(className="android.widget.EditText")
	public WebElement mobileNumber;
	
	@FindBy(id="com.fisike:id/btn_ok")
	public WebElement Nextbutton;
	
	@FindBy(className="android.widget.EditText")
	public WebElement passwordField;
	
	@FindBy(id="com.fisike:id/btn_next")
	public WebElement signInButton;
	
	@FindBy(id="com.fisike:id/continue_action")
	public WebElement continueOnHippa;
	
	
	public void skipafterlaunch_click()
	{
		skipafterlaunch.click();
	}
	
	public void mobilenumberfield_sendkeys(String x)
	{
		mobileNumber.sendKeys(x);
	}
	
	public void clickNextButton()
	{
		Nextbutton.click();
	}
	
	public void passwordField(String x)
	{
		passwordField.sendKeys(x);
	}
	
	public void signInButtonClick()
	{
		signInButton.click();
	}
	
	public void continueButtonClick()
	{
		continueOnHippa.click();
	}
	
}
