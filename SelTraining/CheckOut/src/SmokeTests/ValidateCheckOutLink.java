package SmokeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateCheckOutLink {
	WebDriver driver ;
	
	
	@Test
	public void verifyCheckOutLink() {
		System.out.println("Running Tests");
		boolean checkOutLink = driver.findElement(By.linkText("Check Out")).isDisplayed();
		Assert.assertTrue(checkOutLink);
		
	}
	@BeforeMethod
	public void setUp() {
		System.out.println("Setting up the Driver");
		driver = utilities.DriverFactory.open("chrome");
		String URL = "http://www.practiceselenium.com/";
		driver.get(URL);
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("Clsoing the driver");
		driver.close();
	}
}
