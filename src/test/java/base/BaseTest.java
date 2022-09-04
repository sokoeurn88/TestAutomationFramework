package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadPropertyFile;

public class BaseTest extends ReadPropertyFile {

	public static WebDriver driver;
	public static Properties properties = new Properties();
	public static Properties locatorsproperties = new Properties();		// read property file from locators.properties
	public static FileReader filereader;
	public static FileReader locatorsfilereader;

	@BeforeMethod
	public void setUp() throws IOException {

		if (driver == null) {
			
			System.out.println(System.getProperty("user.dir"));
			FileReader filereader = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\confi.properties");		// get user directory, it will be easy when we share code with team mate
			FileReader locatorsfilereader = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");		// get locators properties file directory
			properties.load(filereader);
			locatorsproperties.load(locatorsfilereader);
		}

		if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(properties.getProperty("testurl"));
		}

		else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(properties.getProperty("testurl"));
		}
		
		
		

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
