package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BootStrapModalBox {
	@Test
	public void singleModalBox() throws InterruptedException {
		
		//Get Chrome driver
				System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
				WebDriver driver= new ChromeDriver();
				String URL="http://www.seleniumeasy.com/test/bootstrap-modal-demo.html#";
				
				driver.get(URL);
				driver.manage().window().maximize();
		
				driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/a")).click();
				//single modal
				
				
				driver.switchTo().activeElement();

				Thread.sleep(3000);
				//Actions action =  new Actions(driver);
				//action.click(driver.findElement(By.xpath("//*[@id=\"myModal0\"]/div/div/div[1]/button"))).perform();
			
				driver.findElement(By.cssSelector("#myModal0 > div > div > div.modal-footer > a:nth-child(1)")).click();
				
	}

}
