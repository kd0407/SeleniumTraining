package Demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetPrice {

	@Test	
	public void getPriceFromeCommSite() throws InterruptedException {

		//Want to execute the script in Chrome browser
		//Get Webdiver and get the URL from which we wnat to get the price
		String URL = "http://automationpractice.com/index.php";
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");

		//Create WebDriver object 

		WebDriver driver= new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='product-name'][@title='Printed Chiffon Dress']"))));;
        
        
		//Select Dresses --> select priice option to view = lowest to high
		//(WebElement) driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div/span[1]"))
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"selectProductSort\"]")));
		select.selectByVisibleText("Price: Lowest first");

		//Getting price web elements --which is a list
		 Thread.sleep(60000);
		List<WebElement> price = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div/span[1]"));


		//To print price, you have to iterate thru the price elements
		ArrayList <Integer> array = new ArrayList <Integer>();
		//Iterate thru the price list 
		Iterator<WebElement> itr =price.iterator();

		while(itr.hasNext()) {
			String p = itr.next().getText();
			System.out.println(p);
			//removing/parsing the $ sign
			if(p.contains("$")) {
				String parsedPrice= p.substring(1);//only amount is retrieved but it is of type String
				System.out.println(parsedPrice);
				// convert it to int

				double priceDouble= Double.parseDouble(parsedPrice);
				//typecast it to integer
				Integer productPrice = (int) (priceDouble);
				array.add(productPrice);

			}


		}


		// Retrieve values from array
		for(int i=0; i< array.size()-1;i++) {


			if(array.get(i) < array.get(i+1)) {

				System.out.println("obj.get(i):"+array.get(i));
				System.out.println("obj.get(i+1):"+array.get(i+1));

			} else {
				Assert.assertTrue(false);
			}
		}


	}
}