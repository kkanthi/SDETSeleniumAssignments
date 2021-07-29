package seleniumassignment;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Browser;
public class TestCase_10_ReadHeadingTest {
static Properties prop;
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {
		String PropertiesFileLoc ="src//test//resources//properties//orangehrm.properties";
		try 
		{
			FileInputStream fileLoc = new FileInputStream(PropertiesFileLoc);
			prop = new Properties();
			prop.load(fileLoc);
		}
		catch (IOException ie)
		{
			System.out.println(ie.toString());
		}
		 //launching the browser
		driver=Browser.chrome();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		try {
			String  Name = prop.getProperty("username");
			String  Psword = prop.getProperty("password");
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(Name);
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Psword);
			driver.findElement(By.id("btnLogin")).click();
			driver.findElement(By.linkText("Dashboard")).click();
			String reqtext = driver.findElement(By.xpath("//div[@class='head']//child::h1")).getText();
			System.out.println(reqtext);
		}

		catch(Exception e){
			System.out.println(e.toString());
		}
		
		driver.quit();
	}

}
