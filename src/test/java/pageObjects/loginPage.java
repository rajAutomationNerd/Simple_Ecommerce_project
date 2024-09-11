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
	
	@FindBy(xpath="//div[text()='*Email is required']")
	WebElement emptyEmail;
	
	@FindBy(xpath="//div[text()='*Password is required']")
	WebElement emptyPassword;
	
	
	
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
	
	public boolean ErrorOrPasswordEMessage()
	{
		return FieldError.isDisplayed();
	}
	
	public boolean EmptyEmailError()
	{
		return emptyEmail.isDisplayed();
	}
	
	public boolean EmptyPasswordError()
	{
		return emptyPassword.isDisplayed();
	}

	

}
