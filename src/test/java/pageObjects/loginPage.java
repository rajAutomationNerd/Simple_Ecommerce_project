package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id="userEmail")
	WebElement Uemail;
	
	@FindBy(id="userPassword")
	WebElement Upassword;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(xpath="//div[@aria-label='Incorrect email or password.']")
	WebElement FieldError;
	
	public void userEmail(String mail)
	{
		Uemail.sendKeys(mail);
	}
	
	public void userPassword(String password)
	{
		Upassword.sendKeys(password);
	}
	
	public void loginButton()
	{
		login.click();
	}
	
	public boolean ErrorMessage()
	{
		return FieldError.isDisplayed();
	}

}
