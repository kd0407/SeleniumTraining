package com.PassionTea.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.PassionTea.base.TestBase;
import com.PassionTea.pages.CheckOutPage;
import com.PassionTea.pages.WelcomePage;

public class WelcomePageTest extends TestBase{
	WelcomePage welcomePage ;
	CheckOutPage checkOutPage;
	Logger log = Logger.getLogger(WelcomePageTest.class);
	public WelcomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		log.info("****************************** initialization of Welcome page  *****************************************");
		initialization();
		welcomePage = new WelcomePage();
	}

	@Test(priority=1)
	public void welcomePageTitleTest() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** Validate Welcome PageTitle *****************************************");
		String title = welcomePage.validateWelcomePage();
		Assert.assertEquals(title, "Welcome");

		log.info("****************************** Ending test case *****************************************");
		log.info("****************************** Validate Welcome PageTitle *****************************************");
	}
	@Test(priority=2)
	public void herbalTeaImgTest() {

		log.info("****************************** Starting test case *****************************************");
		log.info("****************************** Herbal Image is Present *****************************************");
		boolean herbalImage= welcomePage.validateHerbalTeaImg();
		Assert.assertTrue(herbalImage);

		log.info("****************************** Ending test case *****************************************");
		log.info("****************************** Herbal Image is Present *****************************************");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
