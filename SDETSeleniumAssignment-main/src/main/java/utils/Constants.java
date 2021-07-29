package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public interface Constants {
	
	String LOG4J_PROPERTY_FILE="src//test//resources//properties//Log4j.properties";
	String ENV_PROPERTIES="src//test//resources//properties//base_env_build.properties";
	

	//Support browsers paths
	String IE_DRIVER_SERVER="src//test//resources//supportdrivers//IEDriverServer.exe";
	String GECKO_DRIVER_SERVER="src//test//resources//supportdrivers//geckodriver.exe";
	String CHROME_DRIVER_SERVER="src//test//resources//supportdrivers//chromedriver.exe";
	

}