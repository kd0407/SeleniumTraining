package Demo;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JqueryDateCalendar {

	@Test
	public void fromSelectDate() throws InterruptedException {


		//Navigate to the Web page
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String URL = "https://www.skyscanner.co.in";

		driver.get(URL);
		//driver.manage().window().maximize();
		String expMonYear="July 2018" ;
		String expdate="20";
		driver.findElement(By.cssSelector("input#depart-fsc-datepicker-input")).click();
		//return-fsc-datepicker-input
		Select selectMonthYear = new Select(driver.findElement(By.id("depart-calendar__bpk_calendar_nav_select")));
		selectMonthYear.selectByVisibleText(expMonYear);

		Thread.sleep(3000);
		//Get all the dates to select

		//WebElement datePicker = driver.findElement(By.cssSelector("#depart-fsc-datepicker-input-popover > div > div.fsc-datepicker__container-3azq_ > div > table > tbody"));

		List<WebElement> dates = driver.findElements(By.tagName("td"));

		Iterator<WebElement> i = dates.iterator();
		while(i.hasNext()) {
			WebElement date = i.next();
			//System.out.println(date.getText());
			if(expdate.equals(date.getText())) {
				date.click();
				System.out.println("date selected");
				//date.sendKeys(Keys.ENTER);
				driver.findElement(By.cssSelector("input#depart-fsc-datepicker-input")).sendKeys(Keys.TAB);
				
				break;		
			}
			
			else {
				
				System.out.println("date  not selected");
			}
			

		}
		



	}
}