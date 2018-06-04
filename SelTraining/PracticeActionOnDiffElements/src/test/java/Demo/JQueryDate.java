package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JQueryDate {
	String URL="http://www.seleniumeasy.com/test/jquery-date-picker-demo.html";
	WebDriver driver =null;
	@Test
	public void sendDate() throws InterruptedException {
		
				
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		//Get Chrome driver
		 System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		 driver.get(URL);
		// driver.manage().window().maximize();
		 
		
		 
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 
		// js.executeScript("document.getElementById('from').value='06/01/2018'");
	     js.executeScript("document.querySelector('#from').value='06/01/2018'");
	     System.out.println("this sis  affsfsf");
		 js.executeScript("document.getElementById('to').value='06/02/2018'");
		 //driver.findElement(By.xpath("//*[@id=\"from\"]")).click();
		System.out.println("this sis  affsfsf");
		js.executeScript("document.close");
	}
}
