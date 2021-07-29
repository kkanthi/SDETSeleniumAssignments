package seleniumassignment;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Browser;
public class TestCase_9_MinimizeWindowTest {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver;
		
		Logger logger=Logger.getLogger(TestCase_9_MinimizeWindowTest.class);
		
	 //launching the browser
		driver=Browser.chrome();
	  logger.info("Browser Launched.");
	  //implicit wait statement
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  logger.info("implicit wait Condition provided.");
	  //window maximize
	  driver.manage().window().maximize();
	  logger.info("Browser Maximized");
		driver.manage().window().setPosition(new Point(0, -1000));
		logger.info("Browser minimized");
		driver.manage().window().maximize();
		logger.info("Browser Maximized");
		driver.close();
	}


}
