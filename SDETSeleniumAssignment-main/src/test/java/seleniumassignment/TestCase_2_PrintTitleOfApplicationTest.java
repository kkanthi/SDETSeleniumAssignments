package seleniumassignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utils.Browser;
import utils.Constants;

public class TestCase_2_PrintTitleOfApplicationTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		
		Logger logger=Logger.getLogger(TestCase_2_PrintTitleOfApplicationTest.class);
		
		
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
	  String title=driver.getTitle();
	  logger.info("Application title is "+title);
	  System.out.println("Application title is "+title);

}
}
