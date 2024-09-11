package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.registrationObjects;
import testBase.test_base;

public class TC_03_registration_with_empty_details extends test_base {
	
 @Test
public void test()
{
	
	homePage hp = new homePage(driver);
	hp.clckReg();
	
	registrationObjects rg= new registrationObjects(driver);
	rg.enterFname("");
	rg.enterlname("");
	rg.enterEmail("");
	rg.enterMobile("");
	rg.enterPassword("");
	rg.confirmPassword("");
	rg.clickCheckbox();
	
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,100)");
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Register']")));
     
     js.executeScript("arguments[0].scrollIntoView(true);", registerButton);
     js.executeScript("arguments[0].click();", registerButton);	
	Assert.assertTrue(rg.isEmailErrorDisplayed(), "Email error message is not displayed.");
	
	
	
}
}
