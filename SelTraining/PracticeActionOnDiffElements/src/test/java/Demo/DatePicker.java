package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
	static WebDriver driver=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String URL="http://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html";
				System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get(URL);
        driver.findElement(By.cssSelector("#sandbox-container1 > div > span > i")).click();
        driver.findElement(By.cssSelector("input[type='text'][placeholder='dd/mm/yyyy']")).sendKeys("01/05/2018");
        driver.findElement(By.cssSelector("input[type='text'][placeholder='dd/mm/yyyy']")).sendKeys(Keys.TAB);
        
        
        //input[type='text'][placeholder='dd/mm/yyyy']
	}

}
