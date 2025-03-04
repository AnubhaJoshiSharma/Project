package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;
	private static String filepath="./Configuration/Config.properties";
	public static String readAppUrl() {
		properties = new Properties();
		File file = new File(filepath);
		try {
		FileInputStream fis = new FileInputStream(file);
		properties.load(fis);
		}
		catch(Exception e) {
			System.out.println("Not able to load the config file"+ e.getMessage());
		}
		return properties.getProperty("appUrl");
	}

}
