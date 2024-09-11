package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class forgotPassword {
	
	public WebDriver driver;

	public forgotPassword(WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Forgot password?']")
	WebElement fpassword;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement usermail;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement userpassword;
	@FindBy(id="confirmPassword")
	WebElement cnfpassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement sbmtButton;
	
	
	
	public void clckpassword()
	{
		fpassword.click();
	}
	
	public void entermail(String email)
	{
		usermail.sendKeys(email);
	}
	
	public void enterpassword(String pass)
	{
		userpassword.sendKeys(pass);
	}
	
	public void conpassword(String cpass)
	{
		cnfpassword.sendKeys(cpass);
	}
	
	public void clickButton()
	{
		sbmtButton.click();
	}
}
	


