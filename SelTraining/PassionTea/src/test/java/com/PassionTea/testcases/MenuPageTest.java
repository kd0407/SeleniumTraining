package com.PassionTea.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.PassionTea.base.TestBase;
import com.PassionTea.pages.CheckOutPage;
import com.PassionTea.pages.MenuPage;
import com.PassionTea.pages.WelcomePage;

import junit.framework.Assert;

public class MenuPageTest extends TestBase {

	CheckOutPage checkOutPage;
	WelcomePage welcomePage ;
	MenuPage menuPage;
	Logger log = Logger.getLogger(MenuPageTest.class);
	public MenuPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		log.info("****************************** initialization of MenuPageTest page  *****************************************");
		initialization();
		welcomePage = new WelcomePage();
		checkOutPage= welcomePage.clickOnCheckOutLink();
		menuPage = checkOutPage.clickPlaceOrder();


	}

	@Test(priority=1)
	public void verifyMenuPageTitle() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** verifyMenuPageTitle *****************************************");
		Assert.assertEquals(menuPage.validateMenuPage(),"Menu");
		log.info("****************************** Ending test case *****************************************");
		log.info("****************************** verifyMenuPageTitle *****************************************");

	}
	/*@Test(priority=2)
	public void verifyMenuTextHeader() {
		boolean menu= menuPage.verifyMenuHeaderTextPresent();
		Assert.assertTrue(menu);
	}*/
	@Test(priority=2)
	public void verifyCheckout1Link() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** verifyCheckout1Link *****************************************");
		boolean chekOut1= menuPage.verifyCheckout1Present();
		Assert.assertTrue(chekOut1);
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** verifyCheckout1Link *****************************************");
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
