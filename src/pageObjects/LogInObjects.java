package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInObjects {
	
	@FindBy(id="com.fisike.debug:id/btn_skip")
	public WebElement skipafterlaunch;
	
	@FindBy(className="android.widget.EditText")
	public WebElement usernameField;
	
	@FindBy(id="com.fisike.debug:id/btn_ok")
	public WebElement nextButton;
	
	@FindBy(className="android.widget.TextView")
	public WebElement NoUNvalidationMsg;
	
	public void skipafterlaunch_click()
	{
		skipafterlaunch.click();
	}
	
	public void mobilenumberfield_sendkeys(String x)
	{
		usernameField.sendKeys(x);
	}
	
	public String noUsernameVal()
	{
		return NoUNvalidationMsg.getText();
	}
	
	public void nextButton_click()
	{
		nextButton.click();
	}
	
}
