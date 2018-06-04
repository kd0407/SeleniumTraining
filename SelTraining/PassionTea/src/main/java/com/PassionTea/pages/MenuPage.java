package com.PassionTea.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.PassionTea.base.TestBase;

public class MenuPage extends TestBase{
	
	//Objects on Menu Page
	@FindBy(xpath="//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914921\"]/div/h1")
	WebElement Menu;		
	@FindBy(xpath="//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span")
	WebElement CheckOut1;
	@FindBy(xpath="//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span")
    WebElement CheckOut2;
	@FindBy(id="wsb-button-00000000-0000-0000-0000-000451961556")
    WebElement CheckOut3;
	
	
	
	//Initializing of all elements /Page Objects
	public MenuPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateMenuPage() {
		return driver.getTitle();
	}
	public boolean verifyMenuHeaderTextPresent() {
	 return Menu.isDisplayed();
	
	
	}
	public boolean verifyCheckout1Present() {
		return CheckOut1.isDisplayed();
	
	}
}
