
package utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LaunchRemoteDriver {
    private WebDriver currentDriver = null;
    private String browser = null;
    private String baseUrl = null;
    private String os = null;
    private String node = null;
    private File file  = null;
    private FirefoxProfile ffProfile  = null;
    private DesiredCapabilities capability  = null;
    /*
    
    static WebDriver currentDriver;
	static File file ;
	static FirefoxProfile ffProfile;
	static DesiredCapabilities capability;
    
	public static WebDriver launchDriver(String browserName)
	{		
		WebDriver currentDriver = null;
		
		try
		{	
			
			if(browserName.equalsIgnoreCase("firefox")){
				file =new File(Constants.GECKO_DRIVER_SERVER);
				ProfilesIni profile=new ProfilesIni();
				ffProfile=profile.getProfile("SeleniumProfile");
				ffProfile.setAcceptUntrustedCertificates(true);
				ffProfile.setAssumeUntrustedCertificateIssuer(false);
				System.setProperty("webdriver.firefox.marionette", file.getAbsolutePath());
				currentDriver=new FirefoxDriver ((Capabilities) ffProfile);
			}
			else if(browserName.equalsIgnoreCase("chrome"))
			{
			file =new File(Constants.CHROME_DRIVER_SERVER);
			ChromeOptions options = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			currentDriver = new ChromeDriver(options);
			}
			else if(browserName.equalsIgnoreCase("ie")){
				file =new File(Constants.IE_DRIVER_SERVER);
				capability = DesiredCapabilities.internetExplorer();
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				currentDriver = new InternetExplorerDriver(capability);
			}
			
//			switch(browserName)	{
//			case "firefox": 	
//				file =new File(Constants.gecko_driver_server);
//				ProfilesIni profile=new ProfilesIni();
//				ffProfile=profile.getProfile("SeleniumProfile");
//				ffProfile.setAcceptUntrustedCertificates(true);
//				ffProfile.setAssumeUntrustedCertificateIssuer(false);
//				//System.setProperty("webdriver.firefox.marionette", file.getAbsolutePath());
//				currentDriver=new FirefoxDriver ((Capabilities) ffProfile);
//				break;
//				
//			case "ie":
//				file =new File(Constants.ie_driver_server);
//				capability = DesiredCapabilities.internetExplorer();
//				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
//				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//				currentDriver = new InternetExplorerDriver(capability);
//				break;
//		
//		case "chrome":
//			file =new File(Constants.chrome_driver_server);
//			ChromeOptions options = new ChromeOptions();
//			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
//			options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
//			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			currentDriver = new ChromeDriver(options);
//		
//			
////				file =new File(Constants.chrome_driver_server);
////				capability = DesiredCapabilities.chrome ();
////				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
////				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
////				currentDriver = new ChromeDriver(capability);
//				break;
//		default:
//			System.out.println("Given"+browserName+" is not Exist,Go Through with Firefox");
//			file =new File(Constants.gecko_driver_server);
//			capability=DesiredCapabilities.firefox();
//			System.setProperty("webdriver.firefox.marionette", file.getAbsolutePath());
//			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			currentDriver = new FirefoxDriver(capability);
//			break;
//			
//			}
		}
		catch(Exception e)
		{
			e.getMessage();
		//	currentDriver=null;
		}	
		System.out.println("Driver is : "+currentDriver);
//		currentDriver.manage().deleteAllCookies();
//		currentDriver.manage().window().maximize();
		return currentDriver;
	}
	*/

	/*
    public LaunchRemoteDriver(String os, String browser, String baseUrl, String node) throws MalformedURLException {
        this.browser = browser;
        this.os = os;
        this.baseUrl = baseUrl;
        this.node = node;

        Platform platform = Platform.fromString(os.toUpperCase());
        if(browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("platform", platform);
            this.currentDriver = new RemoteWebDriver(new URL(node + "/wd/hub"), chromeOptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("platform", platform);
            this.currentDriver = new RemoteWebDriver(new URL(node + "/wd/hub"), firefoxOptions);
            
        } else {
            InternetExplorerOptions ieOption = new InternetExplorerOptions();
            ieOption.setCapability("platform", platform);
            this.currentDriver = new RemoteWebDriver(new URL(node + "/wd/hub"), ieOption);
        }

        this.currentDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        this.currentDriver.manage().window().maximize();
        this.currentDriver.get(baseUrl);

    }
    
    public LaunchRemoteDriver(String os , String browser , String baseUrl) throws MalformedURLException {
        this.browser = browser;
        this.os = os;
        this.baseUrl = baseUrl;
        
        Platform platform = Platform.fromString(os.toUpperCase());
       
            if(browser.equalsIgnoreCase("chrome")) {
        	file =new File(Constants.CHROME_DRIVER_SERVER);
    		ChromeOptions options = new ChromeOptions();
    		options.setCapability("platform", platform);
    		System.setProperty("webdriver.chrome.Driver", file.getAbsolutePath());
    		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
    		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
    		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            this.currentDriver = new ChromeDriver(options);
            
        } else if (browser.equalsIgnoreCase("firefox")) {
        	file =new File(Constants.GECKO_DRIVER_SERVER);
			ProfilesIni profile=new ProfilesIni();
			ffProfile=profile.getProfile("SeleniumProfile");
			ffProfile.setAcceptUntrustedCertificates(true);
			ffProfile.setAssumeUntrustedCertificateIssuer(false);
			System.setProperty("webdriver.firefox.marionette", file.getAbsolutePath());			
			this.currentDriver =new FirefoxDriver ();
            
        } else {
        	
        	file =new File(Constants.IE_DRIVER_SERVER);
			capability = DesiredCapabilities.internetExplorer();
			System.setProperty("webdriver.ie.currentDriver", file.getAbsolutePath());
			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			this.currentDriver  = new InternetExplorerDriver(capability);
           
        }

        this.currentDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        this.currentDriver.manage().window().maximize();
        this.currentDriver.get(baseUrl);

    }

    public String getOs() {
        return this.os;
    }

    public String getBrowser() {
        return this.browser;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getNode() {
        return this.node;
    }

    public WebDriver getDriver() {
        return this.currentDriver;
    }
    */

    
    public LaunchRemoteDriver(String browser) throws MalformedURLException {
        this.browser = browser;
        this.os = "windows";
        
        
        Platform platform = Platform.fromString(os.toUpperCase());
       
            if(browser.equalsIgnoreCase("chrome")) {
        	file =new File(Constants.CHROME_DRIVER_SERVER);
    		ChromeOptions options = new ChromeOptions();
    		options.setCapability("platform", platform);
    		System.setProperty("webdriver.chrome.Driver", file.getAbsolutePath());
    		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
    		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
    		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            this.currentDriver = new ChromeDriver(options);
            
        } else if (browser.equalsIgnoreCase("firefox")) {
        	file =new File(Constants.GECKO_DRIVER_SERVER);
			ProfilesIni profile=new ProfilesIni();
			ffProfile=profile.getProfile("SeleniumProfile");
			ffProfile.setAcceptUntrustedCertificates(true);
			ffProfile.setAssumeUntrustedCertificateIssuer(false);
			System.setProperty("webdriver.firefox.marionette", file.getAbsolutePath());			
			this.currentDriver =new FirefoxDriver ();
            
        } else {
        	
        	file =new File(Constants.IE_DRIVER_SERVER);
			capability = DesiredCapabilities.internetExplorer();
			System.setProperty("webdriver.ie.currentDriver", file.getAbsolutePath());
			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			this.currentDriver  = new InternetExplorerDriver(capability);
           
        }

        this.currentDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        this.currentDriver.manage().window().maximize();
      //  this.currentDriver.get(baseUrl);

    }

    public String getOs() {
        return this.os;
    }

    public String getBrowser() {
        return this.browser;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getNode() {
        return this.node;
    }

    public WebDriver getDriver() {
        return this.currentDriver;
    }
}