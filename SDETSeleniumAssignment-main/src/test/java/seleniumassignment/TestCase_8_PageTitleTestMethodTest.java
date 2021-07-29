package seleniumassignment;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.LoginPage;
import utils.Browser;
public class TestCase_8_PageTitleTestMethodTest 
{
    static WebDriver driver ;
   
	public static void main(String[] args) throws InterruptedException {

		
		Logger logger=Logger.getLogger(TestCase_8_PageTitleTestMethodTest.class);
		
		LoginPage loginPage;
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
			
				try {
					loginPage=PageFactory.initElements(driver,LoginPage.class);
					loginPage.enterUserName("Admin");
					loginPage.enterpwd("admin123");
					loginPage.clickloginbtn();
					String homePageTitle=driver.getTitle();
					System.out.println("Application Home Page title is "+homePageTitle);
			
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		@SuppressWarnings("unused")
		LoginPage loginPage1=new LoginPage();
		driver.findElement(By.linkText("Admin"));
	
		String reqtxt = Admin();
		System.out.println(reqtxt);
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
		
		String sPIM = PIM();
		System.out.println(sPIM);
		driver.findElement(By.id("menu_dashboard_index")).click();
		
		String Dboard = LeaveDashBoard();
		System.out.println(Dboard);
		driver.findElement(By.id("menu_directory_viewDirectory")).click();
		
		String Dir = Directory();
		System.out.println(Dir);
		driver.findElement(By.id("menu_maintenance_purgeEmployee")).click();
		
		String Maintai = Maintanence();
		System.out.println(Maintai);
}
	public static String Admin() {
		String ReqText = driver.findElement(By.id("menu_admin_UserManagement")).getText();
		return ReqText;
	}

	public static String PIM() {
		String ReqText = driver.findElement(By.id("menu_pim_viewEmployeeList")).getText();
		return ReqText;
	}

	public static String LeaveDashBoard() {
		String ReqText = driver.findElement(By.id("menu_dashboard_index")).getText();
		return ReqText;
	}

	public static String Directory() {
		String ReqText = driver.findElement(By.id("menu_directory_viewDirectory")).getText();
		return ReqText;
	}

	public static String Maintanence() {
		String ReqText = driver.findElement(By.id("menu_maintenance_purgeEmployee")).getText();
		return ReqText;
	}

}
