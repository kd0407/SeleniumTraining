package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	WebDriver driver;
	String browserType="chrome";
	String city="Hyderabad, India";
	String checkIn="21/03/2018";
	String checkOut="28/02/2018";
	String rooms="2";
	String adults ="3";
	String children = "0";
	String startRating = "star5";
	
	
	@Test
	public void hotelReservation() {
		
		//Search
		driver.findElement(By.id("tab-hotel-tab")).click();
		driver.findElement(By.id("hotel-destination")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin")).sendKeys(checkIn);
		driver.findElement(By.id("hotel-checkout")).sendKeys(checkOut);
		new Select(driver.findElement(By.xpath("//*[@id=\"hotel-rooms\"]"))).selectByValue(rooms);
		new Select(driver.findElement(By.xpath("//*[@id=\"hotel-1-adults\"]"))).selectByValue(adults);
		new Select(driver.findElement(By.xpath("//*[@id=\"hotel-1-children\"]"))).selectByValue(children);
		driver.findElement(By.id("search-button")).click();
		
		//Modify the search results , give criteria
		driver.findElement(By.cssSelector("input[name='star'][id='" +startRating+ "']")).click();
		
		//Analyze the results
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				//driver.findElement(By.xpath("//*[@id=\"4732181\"]/div[2]/div[1]/a")).click();
		//driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[2]/div[2]/div[1]/a")).click();
		// explicit wait - to wait for the compose button to be click-able

		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"resultsContainer\"]/section/article[2]/div[2]/div[1]/a")));

		// click on the compose button as soon as the "compose" button is visible
        
		driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[2]/div[2]/div[1]/a")).click();
        // switch window to the pop
        ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
         driver.switchTo().window(windows.get(1));
         
         // Print hotel name 
        String hotelName= driver.findElement(By.id("hotel-name")).getText();
        System.out.println("Hotel name :"+  hotelName);
        
         
		//Book reservation
        
        driver.findElement(By.xpath("//*[@id=\"rooms-and-rates\"]/div/article/table/tbody[1]/tr/td[4]/div/form/div[1]/button")).click();
        String hotelPrice=driver.findElement(By.cssSelector("span[class='summary-total amount-value'][data-price-update='total']")).getText();
		System.out.println("Hotel Price:" + hotelPrice );
		
		//Fill billing / credit details
		
		//Confirmation
		
		String pageTitle = driver.getTitle();
		System.out.println("Current Page Title" + pageTitle);
		Assert.assertTrue(pageTitle.contains("Payment"));
	}
	@BeforeMethod
    public void setUp() {
    	driver=utilities.DriverFactory.open(browserType);
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	driver.get("https://www.expedia.co.in/");
    	
    }
	@AfterMethod
    public void tearDown() {
    	driver.quit();
    	
    }
}


