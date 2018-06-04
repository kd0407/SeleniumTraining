package SmokeTests;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;


public class PageTitleJunit {
	
	WebDriver driver ;
	String URL = "http://www.practiceselenium.com/";
	
	@Test
	public void pageTitleJunit() {
		System.out.println("Running the test");
		driver.get(URL);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle ="Welcome";
		Assert.assertEquals(expectedTitle, actualTitle);

	}
	
	@Before
	public void setUP() {
		System.out.println("Initializing the driver");
		driver = utilities.DriverFactory.open("chrome");
	}
	@After
	public void tearDown() {
		System.out.println("Closing the browser and driver");
		driver.close();
	}
}
