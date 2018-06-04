package Demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;*/
import org.openqa.selenium.support.ui.Select;

public class PassionTeaCheckOut {

	public static void main(String[] args) {
	   String emailElement = "Testemail.com";	 
	   String nameElement = "Kalpana Dontha";
	   String addressElement = "6225 Branchwood Trl,Flower Mound,TX 75028";
	   String cardTypeElement = "Visa";
	   String cardNumberElement ="787889075643";
	   String cardHolderNameElement = "Kalpana Dontha";
	   String verficationCodeElement = "123";
	   String browserType = "chrome";
	   WebDriver driver=null;
	   
	   
		// Create WebDriver
	  	/* if (browserType.equals("chrome")) 
	      {
          
		      System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
   	          driver= new ChromeDriver();
	       }
	      
          else if (browserType.equals("firefox")) {
          
             System.setProperty("webdriver.firefox.driver","D:\\Software\\geckodrive.exe");
             driver= new FirefoxDriver();
         }	    
                 */
	   
	   driver=utilities.DriverFactory.open(browserType);
         
       //Open browser
       driver.get("http://www.practiceselenium.com/");
       driver.findElement(By.linkText("Check Out")).click();
       
       //Fill out Checkout details
       
       driver.findElement(By.id("email")).sendKeys(emailElement);
       driver.findElement(By.id("name")).sendKeys(nameElement);
       driver.findElement(By.id("address")).sendKeys(addressElement);
       
       new Select(driver.findElement(By.id("card_type"))).selectByVisibleText(cardTypeElement);
       driver.findElement(By.id("card_number")).sendKeys(cardNumberElement);
       driver.findElement(By.id("cardholder_name")).sendKeys(cardHolderNameElement);
       driver.findElement(By.id("verification_code")).sendKeys(verficationCodeElement);
       driver.findElement(By.xpath(".//*[@id='wsb-element-00000000-0000-0000-0000-000452010925']/div/div/form/div/button")).click();
       
       //Get Confirmation
       String conf = driver.getCurrentUrl();
       System.out.println(conf);
       
       if (conf.contains("menu")) { System.out.println("We are on Menu page"); }
       
       else { System.out.println("Test failed");}
       
       System.out.println("Going to Close the browser");
       driver.close();
       
       
	}

}
