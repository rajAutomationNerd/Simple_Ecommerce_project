package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registrationObjects {
	
	WebDriver driver;
	public registrationObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id="firstName")
	WebElement firstName;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(id="userEmail")
	WebElement useEmail;
	
	@FindBy(id="userMobile")
	WebElement mobile;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="confirmPassword")
	WebElement cnfpassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkBox;
	
	@FindBy(id="login")
	WebElement registerButton;
	
	@FindBy(css="div[aria-label='User already exisits with this Email Id!']") // Adjust locator based on actual error element
    WebElement emailErrorMessage;

	
	public void enterFname(String Firstname)
	{
		firstName.sendKeys(Firstname);
	}
	
	public void enterlname(String LastName)
	{
		lastName.sendKeys(LastName);
	}
	
	public void enterEmail(String em)
	{
		useEmail.sendKeys(em);
	}
	
	public void enterMobile(String mobN)
	{
		mobile.sendKeys(mobN);
	}
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void confirmPassword(String cpass)
	{
		cnfpassword.sendKeys(cpass);
	}
	
	public void clickCheckbox()
	{
		checkBox.click();
	}
	
	public void clckRegister() 
	{
		registerButton.click();
	}
	
	 public boolean isEmailErrorDisplayed() {
	        // Assuming error message is displayed when present
	        return emailErrorMessage.isDisplayed();
	    }
	
	
	

}
