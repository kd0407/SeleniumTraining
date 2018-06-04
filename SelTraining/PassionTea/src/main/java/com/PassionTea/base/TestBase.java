package com.PassionTea.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.PassionTea.util.TestUtil;
//import com.PassionTea.util.WebEventListener;
import com.PassionTea.util.WebEventListener;

public class TestBase {

	public static Properties property;
	public static FileInputStream fs;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;


	public TestBase() {

		property = new Properties();
		try {
			fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/PassionTea/properties/config.properties");
			property.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.getProperty("user.dir"));
		


	}

	public static void initialization() {
		String browserName = property.getProperty("browser");

		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Software\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}

		else {

			System.setProperty("webdriver.gecko.driver","D:\\Software\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(property.getProperty("url"));
	}

}


