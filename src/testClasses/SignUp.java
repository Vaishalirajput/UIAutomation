package testClasses;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import BaseConf.BaseConfig;
import BaseConf.Login;

public class SignUp extends BaseConfig{
	
	public void cameraTest() throws MalformedURLException
	{
		Login login = new Login();
		login.logintoApp();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	}

}
