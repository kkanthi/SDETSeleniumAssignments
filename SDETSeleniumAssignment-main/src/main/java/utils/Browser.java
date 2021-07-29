package utils;







import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {


		public static WebDriver Firefox() {

			System.setProperty("WebDriver.gecko.driver", "src//test//resources//supportdrivers//geckodriver.exe");

			DesiredCapabilities desc = DesiredCapabilities.firefox();

			desc.setCapability(FirefoxDriver.MARIONETTE, false);

			WebDriver driver = new FirefoxDriver(desc);
			driver.manage().window().maximize();

			return driver;
		}
		
		public static WebDriver chrome() {
			  	        	
	    		ChromeOptions options = new ChromeOptions();
	    		System.setProperty("webdriver.chrome.driver","src//test//resources//supportdrivers//chromedriver.exe");
	    		WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();

			return driver;
		}

		public static WebDriver InternetExplorer() {

			System.setProperty("WebDriver.gecko.driver", "src//test//resources//supportdrivers//IEDriverServer.exe");

			WebDriver driver = new InternetExplorerDriver();
			driver.manage().window().maximize();

			return driver;
		}

	}