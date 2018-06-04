package Demo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SingleWindowPopUP {
	
	
	WebDriver driver= new ChromeDriver();
	@Test
	public void getChildWindowPopUp() throws InterruptedException {
		
		//Get Chrome driver
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		//WebDriver driver= new ChromeDriver();
		String URL="http://www.seleniumeasy.com/test/window-popup-modal-demo.html";
		
		driver.get(URL);
		
		System.out.println("Get current title:::" + driver.getTitle());
		driver.findElement(By.linkText("Follow On Twitter")).click();
		
	    Set<String> windowIds1= driver.getWindowHandles();
	    Iterator<String> itr1 = windowIds1.iterator();
	
		String mainWindow = itr1.next();
		String childWindow = itr1.next();
		
		driver.switchTo().window(childWindow);
		
		System.out.println("The title of the child window:::" +driver.getTitle());
		
		driver.close();
		
		Thread.sleep(3000);
		
		driver.switchTo().window(mainWindow);
		
		System.out.println("The title of the child window:::" +driver.getTitle());
	}
	
	/*public void switchtoWindow(int index) {
		
		String windowIds2 = null;
		Set<String> windowIds2 = driver.getWindowHandles();
		Iterator<String> itr2 = windowIds2.iterator();
		for(int i; i<=index;i++) {
			windowIds2=itr2.next();
			
		}
		driver.switchTo().window(index);
		*/
		
	}


