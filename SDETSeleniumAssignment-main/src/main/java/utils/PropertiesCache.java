package utils;
	
	import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
	import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
	import java.util.Set;
	import org.apache.commons.configuration.ConfigurationException;
	import org.apache.commons.configuration.PropertiesConfiguration;
	 
	public class PropertiesCache
	{   
	
		File file = new File(Constants.ENV_PROPERTIES);

		PropertiesConfiguration config = null;
		
		public void setPropertyCache(String key , String value){
		try {
			config = new PropertiesConfiguration(file);
			config.setProperty(key,value);

			OutputStream out = new FileOutputStream(file);
			config.save(out);
		}
		catch (ConfigurationException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}
	
	}
	 	


