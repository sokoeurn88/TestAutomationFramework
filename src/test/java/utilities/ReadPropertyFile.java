package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
		
		FileReader filereader = new FileReader("C:\\Users\\sokoeurn chhay\\Selenium_Java_Review\\TestAutomationFramework\\src\\test\\resources\\configfiles\\confi.properties");
		Properties properties = new Properties();
		properties.load(filereader);
		System.out.println(properties.getProperty("browser"));
		System.out.println(properties.getProperty("testurl"));
		
		
		//read locators properties
		
	}

}
