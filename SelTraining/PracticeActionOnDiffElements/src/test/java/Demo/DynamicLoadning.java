package Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DynamicLoadning {
	@Test
	public void getDynamicValues() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		
		driver.get("http://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
		
		driver.findElement(By.xpath("//*[@id='save'][@class='btn btn-default']")).click();
		
		
	
		WebDriverWait wait = new WebDriverWait(driver,60);
		
		boolean flag= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loading']/img"))).isDisplayed();
		System.out.println(flag);
		Thread.sleep(6000);
		String fname=driver.findElement(By.xpath("//*[@id=\"loading\"]")).getText();
		System.out.println(fname);
		 System.out.println("***************************");
		WebElement demoT=driver.findElement(By.xpath("//*[@id=\"loading\"]"));
		demoT.getAttribute("innerHTML");
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
	     String innerHtml = (String) js.executeScript("return arguments[0].innerHTML",demoT);

	    System.out.println(innerHtml);
	    System.out.println("***************************");
	    demoT.getAttribute("textContent");
	    String textHtml = (String) js.executeScript("return arguments[0].textContent",demoT);
	    System.out.println(textHtml);
	    
	    System.out.println("***************************");
	
	}
}
