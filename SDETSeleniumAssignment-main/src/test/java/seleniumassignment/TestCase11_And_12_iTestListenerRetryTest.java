package seleniumassignment;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import pages.LoginPage;
import utils.Browser;
public class TestCase11_And_12_iTestListenerRetryTest extends Base
{
    public static WebDriver driver;
    LoginPage loginPage;
	public static FileInputStream fileLoc;
	public static Properties prop;
	
    @BeforeClass
	public void setUp() {


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

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("Url"));
        }
	@Test(priority=1)
	public void LogInToApp() throws InterruptedException {
		String  Name = prop.getProperty("username");
		String  password = prop.getProperty("password");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(Name);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
	}
    @Test(priority=2 , retryAnalyzer=listener.RetryAnalyzer.class)
    public void method1() throws Exception
	{
    	loginPage=PageFactory.initElements(driver,LoginPage.class);
        String DashBoardHeader = loginPage.GetDashBoardHeaderText();
		boolean res = DashBoardHeader.equalsIgnoreCase("Dashbard");
		if(res)
		{
			Thread.sleep(4000);
			captureScreenshot(driver,"DashBoard Passed");
			Assert.assertTrue(true); 
			Reporter.log("User is in Dashboard Menu", true);;
		}
		else
		{
			int i = 1; 
			captureScreenshot(driver,"DashBoard Failed Interation = "+ i);
			Assert.assertTrue(false); 
			Reporter.log("User is NOT in Dashboard Menu", true);
			i++;
		} 
	}
    @AfterSuite
	public void tearDown() {
		driver.quit();
	}


}
