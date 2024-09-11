package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import testBase.test_base;

public class TC_07_Verify_login_without_credentials extends test_base {
	
	
	
	@Test
	public void loginTest()
	{
		loginPage lp = new loginPage(driver);
		
		lp.loginButton();
        Assert.assertTrue(lp.EmptyEmailError(), "Expected error message for empty email is not displayed.");
        
        // Assert that the empty password error message is displayed
        Assert.assertTrue(lp.EmptyPasswordError(), "Expected error message for empty password is not displayed.");

		
	}

}
