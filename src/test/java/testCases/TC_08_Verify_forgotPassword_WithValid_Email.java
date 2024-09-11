package testCases;

import org.testng.annotations.Test;

import pageObjects.forgotPassword;
import testBase.test_base;

public class TC_08_Verify_forgotPassword_WithValid_Email extends test_base {
	
	
	@Test
	public void Verify_with_valid_email()
	{
		forgotPassword fP= new forgotPassword(driver);
		fP.clckpassword();
		fP.entermail("rajnerd@gmail.com");
		fP.enterpassword("Raj1996@");
		fP.conpassword("Raj1996@");
		fP.clickButton();
	}
	

}
