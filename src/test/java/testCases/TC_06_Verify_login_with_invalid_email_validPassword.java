package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import testBase.test_base;

public class TC_06_Verify_login_with_invalid_email_validPassword extends test_base {
	
	
	
	@Test
	public void loginTest()
	{
		loginPage lp = new loginPage(driver);
		lp.userEmail("rajnerd@gmail.com");
		lp.userPassword("123456");
		lp.loginButton();
		Assert.assertTrue(lp.ErrorOrPasswordEMessage(), "Email error message is not displayed.");
		
	}

}
