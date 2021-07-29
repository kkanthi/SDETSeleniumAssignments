package seleniumassignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.Browser;
import utils.Constants;

public class TestCase_4_ValidatedashBoardTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		LoginPage loginPage;
		
		Logger logger=Logger.getLogger(TestCase_4_ValidatedashBoardTest.class);
	
		
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
	  String loginPageTitle=driver.getTitle();
	  logger.info("Application title is "+loginPageTitle);
	  System.out.println("Application title is "+loginPageTitle);
	
		loginPage=PageFactory.initElements(driver,LoginPage.class);
		loginPage.enterUserName("Admin");
		loginPage.enterpwd("admin123");
		loginPage.clickloginbtn();
		String homePageTitle=driver.getTitle();
		System.out.println("Application Home Page title is "+homePageTitle);
		Boolean value=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/h1[1]")).isDisplayed();
		System.out.println("Diver control is on Application Home Page : "+value);
		 System.out.println("Login success");
	
		driver.close();
	}
	


}
