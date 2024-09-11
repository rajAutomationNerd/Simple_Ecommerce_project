package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import testBase.test_base;

public class TC_04_Verify_login_with_valid_cred extends test_base {
	
	
	
	@Test
	public void loginTest()
	{
		loginPage lp = new loginPage(driver);
		lp.userEmail("rajnerd@gmail.com");
		lp.userPassword("Raj1995@");
		lp.loginButton();
		
	}

}
