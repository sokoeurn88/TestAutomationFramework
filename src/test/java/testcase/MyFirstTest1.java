package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class MyFirstTest1 extends BaseTest {
	
	@Test(dataProvider = "testdata")
	public static void LoginTest(String username, String password) {
		
		driver.findElement(By.linkText(locatorsproperties.getProperty("signin_link"))).click();
		driver.findElement(By.id(locatorsproperties.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.xpath(locatorsproperties.getProperty("next_button"))).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//input[@name='PASSWORD']"))).build().perform();	// help when element not interactable
		driver.findElement(By.xpath(locatorsproperties.getProperty("pwd_field"))).sendKeys(password);
		driver.findElement(By.xpath(locatorsproperties.getProperty("login_next_button"))).click();
		
	}
	
//	@DataProvider(name="testdata")
//	public Object[][] testDataProvider(){
//		return new Object[][] {
//			{"sokoeurnc@gmail.com", "#Kem1988#"},	// only this line is correct data
//			{"sokoeuc@gmail.com", "#Kem1988#"},
//			{"sokoeurnc@gmail.com", "#Ke988#"},
//			{"sokoenc@gmail.com", "#Kem18#"}
//		};
//	}

}
