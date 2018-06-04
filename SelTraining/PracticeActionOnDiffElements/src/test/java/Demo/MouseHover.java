package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MouseHover {
	static WebDriver driver=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String URL="http://www.seleniumeasy.com/test/basic-first-form-demo.html";
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
	          driver= new ChromeDriver();
	    driver.get(URL);      
		//css=<HTML tag><#><Value of ID attribute>
		driver.findElement(By.className("form-control")).sendKeys("Kalpana, this is a test");
		driver.findElement(By.xpath("//*[@id=\"get-input\"]/button")).click();
		String msg= driver.findElement(By.cssSelector("#display")).getText();
		System.out.println(msg);
		
		//Second form
		
		driver.findElement(By.id("sum1")).sendKeys("1");
		driver.findElement(By.id("sum2")).sendKeys("2");
		driver.findElement(By.cssSelector("#gettotal > button")).click();
		String total= driver.findElement(By.cssSelector("#displayvalue")).getText();
		System.out.println(total);
	}

}
