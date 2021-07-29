package seleniumassignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.Browser;

public class TestCase_7_LoginApplicationInTestMethodTest {
	
WebDriver driver;
static Properties prop;
LoginPage loginPage;	
	
	static Logger logger=Logger.getLogger(TestCase_7_LoginApplicationInTestMethodTest.class);
	 

	@BeforeSuite
	public void startup() throws InterruptedException, IOException
	{
		String PropertiesFileLoc ="src//test//resources//properties//orangehrm.properties";
		FileInputStream fileLoc = new FileInputStream(PropertiesFileLoc);
		prop = new Properties();
		prop.load(fileLoc);
		//launching the browser
				driver=Browser.chrome();
			  logger.info("Browser Launched.");
			  //implicit wait statement
			  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			  logger.info("implicit wait Condition provided.");
			  //window maximize
			  driver.manage().window().maximize();
			  logger.info("Browser Maximized");
			  
	}
	@AfterSuite
	public void tearDown() throws InterruptedException
	{
		driver.close();
	}
	
	@Test(priority=1)
    public void loginTest()
	{
		//Navigating to the Application
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  logger.info("Navigating into Application.");
		  String loginPageTitle=driver.getTitle();
		  logger.info("Application title is "+loginPageTitle);
		  System.out.println("Application title is "+loginPageTitle);
		
			loginPage=PageFactory.initElements(driver,LoginPage.class);
			loginPage.enterUserName(prop.getProperty("username"));
			loginPage.enterpwd(prop.getProperty("password"));
			loginPage.clickloginbtn();
			String homePageTitle=driver.getTitle();
			System.out.println("Application Home Page title is "+homePageTitle);
			Boolean value=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/h1[1]")).isDisplayed();
			System.out.println("Diver control is on Application Home Page : "+value);
			 System.out.println("Login success");
	}

}
