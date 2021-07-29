package seleniumassignment;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utils.Browser;

public class TestCase_6_BrowserLaunchInBeforeSuite 
{
	WebDriver driver;
	
	static Logger logger=Logger.getLogger(TestCase_6_BrowserLaunchInBeforeSuite.class);
	 

	@BeforeSuite
	public void startup() throws InterruptedException
	{
		//launching the browser
				driver=Browser.chrome();
			  logger.info("Browser Launched.");
			  //implicit wait statement
			  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			  logger.info("implicit wait Condition provided.");
			  //window maximize
			  driver.manage().window().maximize();
			  logger.info("Browser Maximized");
			  //Navigating to the Application
			  driver.get("https://opensource-demo.orangehrmlive.com/");
			  logger.info("Navigating into Application.");
	}
	@AfterSuite
	public void tearDown() throws InterruptedException
	{
		driver.close();
	}
	
	@Test
    public void loginTest()
	{
	System.out.println("before Suite execution");
	}

}
