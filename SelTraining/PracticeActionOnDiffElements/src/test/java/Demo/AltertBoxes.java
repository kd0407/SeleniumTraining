package Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AltertBoxes {
	 WebDriver driver ;
	 String URL="http://www.seleniumeasy.com/test/javascript-alert-box-demo.html";
	 
	@BeforeTest
	public void setUP() {
			
		driver = new ChromeDriver();
		//Get Chrome driver
		 System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		//driver.get(URL);
		//driver.manage().window().maximize();
		
	}
	

	@Test
	public void getAutoclosableAlertMsg() {
		
		driver.get(URL);
		//driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/button")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
	}
	@Test
	public void clickJSConfirmBox() {
	
		driver.get(URL);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		
		//driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/button")).click();
		//sample xpath= //button[@onclick='myConfirmFunction()']   myPromptFunction()
		
		//Alert alert = driver.switchTo().alert();
		//alert.dismiss();
		System.out.println("accepted/rejected");
		
	}
	@Test
	public void clickJSPromtBox() {
		driver.get(URL);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[3]/div[2]/button")).click();
		
		Alert alert=driver.switchTo().alert();
		driver.switchTo().alert().sendKeys("Helllo");
		alert.accept();
		System.out.println(alert.getText());
		
		//*[@id="easycont"]/div/div[2]/div[3]/div[2]/button
	}
	
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
