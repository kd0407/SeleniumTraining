package Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PaginationAndSort {
	@Test 
	public void  getPagination() throws InterruptedException {

		//Get chrome driver to create chrome driver object
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		String URL = "http://www.seleniumeasy.com/test/table-sort-search-demo.html";

		WebDriver driver = new ChromeDriver();
		//Navigate to the web page
		driver.get(URL);
		driver.manage().window().maximize();
		//Find the pagination elemnets
		List <WebElement> pageNo=driver.findElements(By.xpath("//*[@id=\"example_paginate\"]/span/a"));

		//print the pageno, you have to get the size of pagination
		int p= pageNo.size();
		System.out.println(p);    

		//Find next pagination button
		//WebElement NextButton = driver.findElement(By.xpath("//*[@class='paginate_button next'][@id='example_next']"));
		WebElement NextButton = driver.findElement(By.xpath("//*[@id='example_next']"));
		//boolean nextShow =  driver.findElement(By.xpath("//*[@class='paginate_button next'][@id='example_next']")).isEnabled();
		//System.out.println(nextShow);



		// checkif pagination link exists 
		if (p>0) {
			System.out.println("Pagination exists");
		}
		//click on next link
		for(int i=1; i<p; i++){ 

			//Check if nextbutton is enable or not.
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id=\"example_info\"]")), "of 32 entries"));

			if(NextButton.isEnabled()) 
			{
				//NextButton.click();
				//Pages
				System.out.println("Before click Page "+i);
				System.out.println("I am going to click on Next button");
				int nextPage = i+1;
				//System.out.println(nextPage);
				System.out.println( driver.findElement(By.xpath( "//*[@id='example_paginate']/span/a[" +nextPage+"]")).isEnabled());

				//driver.findElement(By.xpath( "//*[@id='example_paginate']/span/a[" +nextPage+"]")).click();
				//driver.findElement(By.xpath("//[@class='paginate_button'][@data-dt-idx=" + nextPage + "]")).click();
				//NextButton.click();
				System.out.println("I clickedon next and I am sleeping 6000ms");
				Thread.sleep(6000);
				// System.out.println("Page "+i);

			} else {System.out.println("pagination doesn't exists");}
		}


	}

}    
