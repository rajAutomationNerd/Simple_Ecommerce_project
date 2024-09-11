package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class test_base {
	public WebDriver driver;
	public Properties prop;
	public Logger logger;
	
	public void loadPropertiesFile()
	{
		 prop= new Properties();
		File propFile= new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		try {
		FileInputStream fis= new FileInputStream(propFile);
		prop.load(fis);
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		logger =LogManager.getLogger(this.getClass()); //for logger
		 loadPropertiesFile();
		
		
		driver= new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
