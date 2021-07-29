package seleniumassignment;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Browser;
public class TestCase_13_Test {

	public static Properties prop; 
	public static FileInputStream fileLoc;
	WebDriver driver;
	@BeforeTest()
	public void BrowserOpen() throws InterruptedException {
		try {
			fileLoc = new FileInputStream("src//test//resources//properties//orangehrm.properties");
			prop = new Properties();
			prop.load(fileLoc);
		}catch(Exception e) {
			e.printStackTrace();
		}

		//launching the browser
				driver=Browser.chrome();
			  System.out.println("Browser Launched.");
			  //implicit wait statement
			  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			  System.out.println("implicit wait Condition provided.");
		driver.get(prop.getProperty("Url"));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
	}
	@Test(priority=1)
	public void Login() throws InterruptedException {
		
		String  Name = prop.getProperty("username");
		String  Psword = prop.getProperty("password");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(Name);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Psword);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
	}
	@Test(priority=2,dependsOnMethods= {"Login"})
	public void Search() throws InterruptedException
	{
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys("Linda Anderson");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void Screenshot() throws Exception
	{
		takeSnapShot(driver,"Scrennshots//Search.png");
	}
	@AfterTest
	public void logout()
	{
		driver.quit();
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

		//Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

		//Call getScreenshotAs method to create image file

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		//Move image file to new destination

		File DestFile=new File(fileWithPath);

		//Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

		}

}
