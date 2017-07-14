package testClasses;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import BaseConf.BaseConfig;
import BaseConf.Login;
import appUtil.MedicationUtil;
import io.appium.java_client.android.AndroidKeyCode;
import pageObjects.MedicationObjects;
import pageObjects.UpdateObjects;

public class UpdateTest extends BaseConfig {
	
static String nameMyProfile;
static String genderMyProfile;
static String dobMyProfile;
static String maritalSMyProfile;
static String adharValueMyProfile;
UpdateObjects page;
Login login;
SoftAssert sAssert;

public UpdateTest() throws MalformedURLException
{
	login = new Login();
	login.logintoApp();
	page = PageFactory.initElements(driver, UpdateObjects.class);
	sAssert = new SoftAssert();
}

@BeforeTest
public void navigateOnMyPro()
{
	page.navigateOnMyPro();
	sAssert.assertEquals(driver.currentActivity(), "com.engage.debug/com.mphrx.fisike.UserProfileActivity");
}

@Test
public void verifyElementsOnUpdateScreen()
{
	//camera and username test verification remaining
	sAssert.assertEquals(page.firstNameLabel.getText(), "First Name");
	sAssert.assertEquals(page.lastNameLabel.getText(), "Last Name");
	sAssert.assertEquals(page.genderLabel.getText(), "Gender");
	sAssert.assertEquals(page.dateOfBirthLabel.getText(), "Date of Birth");
	sAssert.assertEquals(page.maritalStatusLabel.getText(), "Marital Status");
	sAssert.assertEquals(page.aadharCardLabel.getText(), "Aadhar Card No.");
}

@Test
public void nameUpdate()
{
	checkOtherEntries();
	nameChange("TestFN", "TestLN");
	validateOtherEntries();	
	firstNameChange("TestFirstName");
	validateOtherEntries();	
	lastNameChange("TestLastName");
	removeLastName();
	validateOtherEntries();	
	
}

private void nameChange(String FN, String LN)
{
	page.navigateOnUpdateProfile();
	page.firstNametext.clear();
	page.firstNametext.sendKeys(FN);
	sAssert.assertEquals(page.firstNametext.getText(), FN);
	page.lastNametext.clear();
	page.lastNametext.sendKeys(LN);
	sAssert.assertEquals(page.lastNametext.getText(), LN);
	driver.pressKeyCode(AndroidKeyCode.BACK);
	nameMyProfile = FN + " " + LN;
	driver.swipe(866, 1706, 759, 366, 2000);
	page.updateButton.click();
}

private void firstNameChange(String FN)
{
	page.navigateOnUpdateProfile();
	page.firstNametext.clear();
	page.firstNametext.sendKeys(FN);
	sAssert.assertEquals(page.firstNametext.getText(), FN);
	driver.pressKeyCode(AndroidKeyCode.BACK);
	nameMyProfile = FN + " " + page.lastNametext.getText();
	driver.swipe(866, 1706, 759, 366, 2000);
	page.updateButton.click();
}

private void lastNameChange(String LN)
{
	page.navigateOnUpdateProfile();
	page.lastNametext.clear();
	page.lastNametext.sendKeys(LN);
	sAssert.assertEquals(page.lastNametext.getText(), LN);
	driver.pressKeyCode(AndroidKeyCode.BACK);
	nameMyProfile = page.firstNametext.getText() + " " + LN;
	driver.swipe(866, 1706, 759, 366, 2000);
	page.updateButton.click();
}

private void removeLastName()
{
	page.navigateOnUpdateProfile();
	page.lastNametext.clear();
	driver.pressKeyCode(AndroidKeyCode.BACK);
	nameMyProfile = page.firstNametext.getText();
	driver.swipe(866, 1706, 759, 366, 2000);
	page.updateButton.click();
}

@Test
public void removeFirstName()
{
	page.navigateOnUpdateProfile();
	page.firstNametext.clear();
	driver.pressKeyCode(AndroidKeyCode.BACK);
	driver.swipe(866, 1706, 759, 366, 2000);
	page.updateButton.click();
}

@Test
public void updateAadhar()
{
	checkOtherEntries();
	page.navigateOnUpdateProfile();
	page.genderDropDown.click();
	if(genderMyProfile == "Male")
      page.genderMale.click();
	else if(genderMyProfile == "Female")
	  page.genderFemale.click();
	else
	  page.genderother.click();
	driver.swipe(866, 1706, 759, 366, 2000);
	page.aadharCardText.click();
	page.aadharCardText.clear();
	driver.pressKeyCode(AndroidKeyCode.BACK);
	page.updateButton.click();
	sAssert.assertEquals(page.aadharValidate.getText(), "Aadhar number should be of 12 digits");
	page.aadharCardText.click();
	page.aadharCardText.sendKeys("12345");
	driver.pressKeyCode(AndroidKeyCode.BACK);
	page.updateButton.click();
	sAssert.assertEquals(page.aadharValidate.getText(), "Aadhar number should be of 12 digits");
	page.aadharCardText.click();
	page.aadharCardText.sendKeys("123456712345");
	sAssert.assertEquals(page.aadharCardText.getText(), "123456712345");
	adharValueMyProfile = "123456712345";
	driver.pressKeyCode(AndroidKeyCode.BACK);
	page.updateButton.click();
	validateOtherEntries();
}

@Test
public void genderUpdate()
{	
	checkOtherEntries();
	changeGender("Male");
	validateOtherEntries();
	changeGender("Female");
	validateOtherEntries();
	changeGender("Others");
	validateOtherEntries();	
}


private void changeGender(String gender )
{
	page.navigateOnUpdateProfile();
	sAssert.assertEquals(driver.currentActivity(), "com.engage.debug/com.mphrx.fisike.update_user_profile.UpdateUserProfileActivity");
	page.genderDropDown.click();
	if(gender == "Male")
	  page.genderMale.click();
	else if(gender == "Female")
	  page.genderFemale.click();
	else
      page.genderother.click();
	sAssert.assertEquals(page.genderValueUpdateScreen.getText(), gender);
	genderMyProfile = gender;
	driver.swipe(860, 1335, 805, 555, 2000);
	page.updateButton.click();
	sAssert.assertEquals(driver.currentActivity(), "com.engage.debug/com.mphrx.fisike.UserProfileActivity");
}


@Test
public void maritalStatusUpdate()
{
    checkOtherEntries();
	changeMaritalStatus("Unmarried");
	validateOtherEntries();
	changeMaritalStatus("Annulled");
	validateOtherEntries();
	changeMaritalStatus("Divorced");
	validateOtherEntries();
	changeMaritalStatus("Interlocutory");
	validateOtherEntries();
	changeMaritalStatus("Legally Separated");
	validateOtherEntries();
	changeMaritalStatus("Married");
	validateOtherEntries();
	changeMaritalStatus("Polygamous");
	validateOtherEntries();
	changeMaritalStatus("Never Married");
	validateOtherEntries();
	changeMaritalStatus("Domestic partner");
	validateOtherEntries();
	changeMaritalStatus("Widowed");
	validateOtherEntries();
}

private void changeMaritalStatus(String status)
{
	page.navigateOnUpdateProfile();
	sAssert.assertEquals(driver.currentActivity(), "com.engage.debug/com.mphrx.fisike.update_user_profile.UpdateUserProfileActivity");
	driver.findElementById("com.engage.debug:id/spinnerMaritalStatus").click();
	if(status == "Widowed")
		driver.swipe(520, 799, 545, 279, 2000);
	driver.findElementByXPath("//android.widget.TextView[@text='"+status+"']").click();
	driver.swipe(860, 1335, 805, 555, 2000);
	sAssert.assertEquals(page.maritalValueUpdateScreen.getText(), status);
	maritalSMyProfile = status;
	page.updateButton.click();
	sAssert.assertEquals(driver.currentActivity(), "com.engage.debug/com.mphrx.fisike.UserProfileActivity");

}

/*
@Test
public void addAlternateAdd()
{
	MongoClientURI uri = new MongoClientURI("mongodb://mobqa2_minerva:mobqa2_minerva@10.151.100.129:27018/mobqa2_minervadb");
 	MongoClient mongoClient  = new MongoClient(uri);    
	driver.swipe(860, 1335, 805, 555, 2000);
	driver.findElementById("com.engage.debug:id/btnAddContact").click();
	
	
}*/

private void checkOtherEntries()
{	
	nameMyProfile = page.firstNameValue.getText();
	genderMyProfile = page.genderValue.getText();
	dobMyProfile = page.dateOfBirthValue.getText();
	maritalSMyProfile = page.maritalValue.getText();
	adharValueMyProfile = page.aadharValue.getText();		
}

private void validateOtherEntries()
{
	sAssert.assertEquals(page.firstNameValue.getText(), nameMyProfile);
	sAssert.assertEquals(page.genderValue.getText(), genderMyProfile);
	sAssert.assertEquals(page.dateOfBirthValue.getText(), dobMyProfile);
	sAssert.assertEquals(page.maritalValue.getText(), maritalSMyProfile);
	sAssert.assertEquals(page.aadharValue.getText(), adharValueMyProfile);
}

}