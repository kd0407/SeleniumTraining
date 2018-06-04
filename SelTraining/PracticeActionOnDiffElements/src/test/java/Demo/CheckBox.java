package Demo;


import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckBox {
	

	@Test
	public void selectCheckBox() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");

		//Launching Sample site
		driver.get("http://artoftesting.com/sampleSiteForSelenium.html");

		Thread.sleep(6000);
		List<WebElement> ckBox=driver.findElements(By.cssSelector("input[type='checkbox']"));

		int ckB= ckBox.size();
		System.out.println(ckB);

		for(int i=0;i<ckB;i++) {
			// Store the Check Box name to the string variable, using 'Value' attribute
			String sValue = ckBox.get(i).getAttribute("value");
			System.out.println(sValue);
			//ckBox.get(i).click();
		       
			// Select the Check Box it the value of the Check Box is same what you are looking for
			if (sValue.equalsIgnoreCase("automation"))
			{
				System.out.println("before clicking");
				ckBox.get(i).click();
				// This will take the execution out of for loop
				
			}
		}
		

		// Kill the browser
		//driver.quit()
	}

}


