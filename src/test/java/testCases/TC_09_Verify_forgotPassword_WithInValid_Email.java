package testCases;

import org.testng.annotations.Test;

import pageObjects.forgotPassword;
import testBase.test_base;

public class TC_09_Verify_forgotPassword_WithInValid_Email extends test_base {
	
	
	@Test
	public void Verify_with_Invalid_email()
	{
		forgotPassword fP= new forgotPassword(driver);
		fP.clckpassword();
		fP.entermail("rajnerd123456788@gmail.com");
		fP.enterpassword("Raj1996@");
		fP.conpassword("Raj1996@");
		fP.clickButton();
	}
	

}
