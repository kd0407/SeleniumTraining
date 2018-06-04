package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RightClick {
    @Test
	public void performRtClick() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");

		//Launching Sample site
		driver.get("http://artoftesting.com/sampleSiteForSelenium.html");

		//Right click in the TextBox
		//WebElement element = driver.findElement(By.id("elementId"));
		//action.contextClick(element).perform();
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='fname'][@type='text']"));
		Actions action = new Actions(driver);
        action.contextClick(searchBox).perform();
		
		//Thread.sleep just for user to notice the event
		Thread.sleep(3000);
		
		//Closing the driver instance
		driver.quit();
	}

}