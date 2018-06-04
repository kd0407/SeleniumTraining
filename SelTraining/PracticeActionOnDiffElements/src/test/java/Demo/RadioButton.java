package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RadioButton {
	@Test
	public void selectRadioButton() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");

		//Launching Sample site
		driver.get("http://artoftesting.com/sampleSiteForSelenium.html");
		
		WebElement radioBtn=driver.findElement(By.xpath("//input[@id='male'][@type='radio']"));
		
		radioBtn.click();
		Thread.sleep(5000);
		
		//driver.quit();
		
	}

}
