package Demo;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class IEBrowserCapability {

@Test
	public void setIECapabiity() {

		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		  
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
		capabilities.setCapability(InternetExplorerDriver.
		  INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);


		System.setProperty("webdriver.ie.driver", "D:\\Software\\IEDriverServer.exe");
		  
		 //it is used to initialize the IE driver
		 @SuppressWarnings("deprecation")
		WebDriver driver = new InternetExplorerDriver(capabilities);
		  
		 driver.manage().window().maximize();

		 driver.get("http://gmail.com");
		  
		 driver.quit();

	}
}