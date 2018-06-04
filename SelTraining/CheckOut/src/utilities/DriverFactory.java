package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory  {
	
	//This method returns an Object
	public static WebDriver open(String browserType){
	
	
	 if (browserType.equalsIgnoreCase("chrome")) 
             {
               System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
	          return new ChromeDriver();
      }
	else if (browserType.equalsIgnoreCase("IE")) {
		 System.setProperty("webdriver.ie.driver", "D:\\Software\\IEDriverServer.exe");
		 return new InternetExplorerDriver();
	 }
	 
     else {
     
        System.setProperty("webdriver.gecko.driver","D:\\Software\\geckodriver.exe");
        return new FirefoxDriver();
          }
	          
     
  }

	
}