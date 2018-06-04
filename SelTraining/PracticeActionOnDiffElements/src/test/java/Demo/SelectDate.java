package Demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectDate {
	WebDriver driver=null;
	@SuppressWarnings("deprecation")
	@Test
	public void selectDate() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//String URL="http://www.seleniumeasy.com/test/jquery-date-picker-demo.html";
		//driver.get(URL);
            driver.get("https://www.goibibo.com/");	
            driver.manage().window().maximize();
            Thread.sleep(1000);
          //  driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]")).sendKeys("Bangalore (BLR)");
             
           //driver.findElement(By.cssSelector("#searchWidgetCommon > div > div:nth-child(4) > div.shCalenderBox.col-md-5.col-sm-5.col-xs-12.pad0.marginTB10.marginAdjust > div:nth-child(1) > div > input.form-control inputTxtLarge widgetCalenderTxt")).click();
            driver.findElement(By.xpath("//*[@id=\"searchWidgetCommon\"]/div/div[3]/div[1]/div[1]/div/input")).click();
            
             
		/*String startDate = "06/02/2018";
		
		//Creating date object of startdate
		
		Date d = new Date(startDate);
		
		//converting dt to a format
		
		SimpleDateFormat dt = new SimpleDateFormat("MMM/dd/YYYY");
		String date = dt.format(d);
		
		System.out.println(date);
		
		String[] splitDt= date.split("/");
		String month = splitDt[0];//+ "   " +splitDt[2];
		System.out.println(month);*/
		
		
	}

}
