package Demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {
    @Test
	public void moveFromTo() throws InterruptedException {
    	
    	/*WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");

		//Launching Sample site
		driver.get("http://artoftesting.com/sampleSiteForSelenium.html");
		
		WebElement from= driver.findElement(By.xpath("//*[@id='sourceImage']"));
		
		WebElement to= driver.findElement(By.xpath("//*[@id='targetDiv'][@ondrop='drop(event)']"));
		
		Actions action = new Actions(driver);
		System.out.println("**********************");
		
		Thread.sleep(6000);
		action.dragAndDrop(from, to).build().perform();*/
    	
    		
    	WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");				
             driver.get("http://demo.guru99.com/test/drag_drop.html");	
             
             //Gets all cookies already set in the webdriver.
            System.out.println(driver.manage().getCookies());
    		//Element which needs to drag.    		
            	WebElement From1=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
            	WebElement From2=driver.findElement(By.xpath("//*[@id='credit1']/a"));	
                
             //Element on which need to drop.		
             WebElement To1=driver.findElement(By.xpath("//*[@id='bank']/li"));					
             WebElement To2=driver.findElement(By.xpath("//*[@id='loan']/li"));		
             
             //Using Action class for drag and drop.		
             Actions act1=new Actions(driver);					
             Actions act2=new Actions(driver);	
    	//Dragged and dropped.		
             act1.dragAndDrop(From1, To1).build().perform();		
             act2.dragAndDrop(From2, To2).build().perform();		
             
             
    	}		
	}
	

