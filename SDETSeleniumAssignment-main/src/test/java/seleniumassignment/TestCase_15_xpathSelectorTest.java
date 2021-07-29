package seleniumassignment;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Browser;
public class TestCase_15_xpathSelectorTest {

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
	public void XPATh() throws InterruptedException
	{
		String text;
		Boolean ObjectExist;
		ObjectExist= driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		text=driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).getText();
		Reporter.log("Admin Tab text is displaying as:'" + text +"'", true);
		
		Thread.sleep(3000);
		ObjectExist= driver.findElement(By.xpath("//input[@id='MP_link']")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		text=driver.findElement(By.xpath("//input[@id='MP_link']")).getAttribute("value");
		Reporter.log("Market Place text is displaying as :'" + text +"'", true);
		
		Thread.sleep(3000);	
		ObjectExist= driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		text=driver.findElement(By.xpath("//a[@id='welcome']")).getText();
		Reporter.log("Welcome Admin text is displaying as :'" + text +"'", true);
		
		Thread.sleep(3000);
		ObjectExist= driver.findElement(By.xpath("//span[text()='Leave List']/parent::a/parent::div")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		text=driver.findElement(By.xpath("//span[text()='Leave List']/parent::a/parent::div")).getText();
		Reporter.log("Leaves List text is displaying as :'" + text +"'", true);
	}
	
	@AfterTest()
	public void signoff()
	{
		driver.quit();
	}
}

