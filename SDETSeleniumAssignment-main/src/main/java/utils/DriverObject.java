package utils;

import org.openqa.selenium.WebDriver;

public class DriverObject {
	
	static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		DriverObject.driver = driver;
	}

}
