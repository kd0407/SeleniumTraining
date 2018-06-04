package com.PassionTea.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.PassionTea.base.TestBase;
import com.PassionTea.pages.CheckOutPage;
import com.PassionTea.pages.MenuPage;
import com.PassionTea.pages.WelcomePage;
import com.PassionTea.util.TestUtil;



public class CheckOutPageTest extends TestBase{

	CheckOutPage checkOutPage;
	WelcomePage welcomePage ;
	MenuPage menuPage;
	String sheetName="checkout";
	Logger log = Logger.getLogger(CheckOutPageTest.class);
	public CheckOutPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		log.info("****************************** initialization of CheckOutPageTest page  *****************************************");
		initialization();
		welcomePage = new WelcomePage();
		checkOutPage= welcomePage.clickOnCheckOutLink();
	}

	@Test(priority=1)
	public void checkoutPageTitleTest() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** checkoutPageTitleTest *****************************************");
		String title = checkOutPage.validateCheckOutPageTitle();
		Assert.assertEquals(title, "Check Out");
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** checkoutPageTitleTest *****************************************");
	}
	@DataProvider
	public Object[][] getCheckOutTestdata() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** getCheckOutTestdata *****************************************");
		Object dataTable[][]=TestUtil.getTestData(sheetName);
		log.info("****************************** reading from sheetname of excel *****************************************");
		return dataTable;
	}
	@Test(priority=2,dataProvider="getCheckOutTestdata")
	public void validateCreateNewCheckOut(String email1,String name1,String address1,String card_type1,String cardNo,String cardHName,String cvv) {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** validateCreateNewCheckOut *****************************************");
		//checkOutPage.validateCheckOut("KalpanaD@yahoo.com", "Kalpana Dontha", "6225 Branchwoord Trl, Flower Mound TX 75028", "Visa", "768567586746435", "Kalpana Dontha", "678");
		checkOutPage.createCheckOut(email1, name1, address1, card_type1, cardNo, cardHName, cvv);
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** validateCreateNewCheckOut *****************************************");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
