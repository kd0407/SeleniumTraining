package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckOutXLSDDT {
	WebDriver driver;
	@Test(dataProvider="getData")
	public void checkOut(String email,String name,String address,String cardType,String cardNumber,String cardHolderName,String verficationCode) {
		System.out.println("New record:"+" "+ email+" " +" "+name+ " "+address);
		  //driver=utilities.DriverFactory.open("Chrome");
        
	       //Open browser
	       driver.get("http://www.practiceselenium.com/");
	       driver.findElement(By.linkText("Check Out")).click();
	       
	       //Fill out Checkout details
	       
	       driver.findElement(By.id("email")).sendKeys(email);
	       driver.findElement(By.id("name")).sendKeys(name);
	       driver.findElement(By.id("address")).sendKeys(address);
	       
	       new Select(driver.findElement(By.id("card_type"))).selectByVisibleText(cardType);
	       driver.findElement(By.id("card_number")).sendKeys(cardNumber);
	       driver.findElement(By.id("cardholder_name")).sendKeys(cardHolderName);
	       driver.findElement(By.id("verification_code")).sendKeys(verficationCode);
	       driver.findElement(By.xpath(".//*[@id='wsb-element-00000000-0000-0000-0000-000452010925']/div/div/form/div/button")).click();
	       
	       //Get Confirmation
	       String conf = driver.getCurrentUrl();
	       System.out.println(conf);
	       
	       if (conf.contains("menu")) { System.out.println("We are on Menu page"); }
	       
	       else { System.out.println("Test failed");}
	       
	       
   }
	@BeforeMethod
	public void setUp() {
		
		 driver=utilities.DriverFactory.open("Firefox");
		//Open browser
	     driver.get("http://www.practiceselenium.com/");
	
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("Going to Close the browser");
	    driver.quit();

	}
	
	@DataProvider
	public String[][] getData() {
		return utilities.Excel.get("D:\\MBNG\\automation_framework\\Checkout.xls");
		
	}

}