package SmokeTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagsTest {
	WebDriver driver;

	@Test
	public void verifyCheckOutLink() {
		System.out.println("Running Tests");
		boolean checkOutLink = driver.findElement(By.linkText("Check Out")).isDisplayed();
		Assert.assertTrue(checkOutLink);

	}
	@Test
	public void findATags() {
		System.out.println("Running a tag Tests");
		//boolean isWelcomeElementPresent = false;
		List <WebElement> aElements =driver.findElements(By.tagName("a"));
		int aElementsSize = aElements.size();
		System.out.println("The no of a Tag elements:" + aElementsSize);
		for (WebElement aElement : aElements) {
			System.out.println(aElement.getText());

/*			 if (aElement.getText().equals("seleniumframework.com")) {
				  isWelcomeElementPresent=true;
			  }
			  //assertion
			  Assert.assertTrue(isWelcomeElementPresent, "seleniumframework.com text is present");*/
		  }

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

