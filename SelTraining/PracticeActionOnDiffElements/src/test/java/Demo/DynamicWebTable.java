package Demo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicWebTable {
	
	    @Test
		public void readDataTableValues(){
			
			
			//Navigate to the Web page
			System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();
			driver.get("http://www.seleniumeasy.com/test/table-search-filter-demo.html");
			driver.manage().window().maximize();
			//Identify the table
			WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover'][@id='task-table']"));
			String queryStr="tro";
			driver.findElement(By.xpath("//*[@id=\"task-table-filter\"]")).sendKeys(queryStr);
			//Fetching all rows WebElements of tag tr
			List<WebElement> rows = new ArrayList<>();
			//rows = table.findElements(By.tagName("tr"));
			rows = table.findElements(By.xpath("//*[@id=\"task-table\"]/tbody/tr"));
			
			//Get row count
			int r =rows.size();
			System.out.println(r);
			
			//Iterate thru the rows and cols  and hearder row=1, so we need to start reading from 2nd row
			//rows reading
			for (int i=0;i<r;i++) {
			     //Fetch # of columns in a row
				//List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
				
				List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
				int c=columns.size();
				//System.out.println(c);
				//Iterate through the columns within particular row
					for(int j=0;j<c;j++) {
						
					String colValue=columns.get(j).getText();
					System.out.println(colValue);
				}
			}
			System.out.println("*******");
			
		}
	    
	    
	    
	}




