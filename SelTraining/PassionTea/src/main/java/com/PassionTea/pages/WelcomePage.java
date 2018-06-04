package com.PassionTea.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PassionTea.base.TestBase;

public class WelcomePage extends TestBase{
	
	//Page Obj or Obj Repo
	@FindBy(linkText="Welcome")
	WebElement Welcome;
	@FindBy(linkText="Our Passion")
	WebElement OurPassion;
	@FindBy(linkText="Menu")
	WebElement Menu;
	@FindBy(linkText="Check Out")
	WebElement CheckOut;
	@FindBy(xpath="//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914880\"]/div/div/img")
    WebElement OrganicCertifiedProduct;
	@FindBy(xpath="//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914895\"]/div/div/a/img")
	WebElement HerbalTea;
	@FindBy(xpath="//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914892\"]/div/div/a/img")
	WebElement LooseTea;
	@FindBy(xpath="//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914891\"]/div/div/a/img")
	WebElement FlavouredTea;
	
	
	//Initializing of all elements /Page Objects
	public WelcomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateWelcomePage() {
		return driver.getTitle();
	}
	public boolean validateOrganicLogo() {
		return OrganicCertifiedProduct.isDisplayed();
	}
	public boolean validateHerbalTeaImg() {
		return HerbalTea.isDisplayed();
	}
	public boolean validateLooseTeaImg() {
		return LooseTea.isDisplayed();
	}
	public boolean validateFlavouredTea() {
		return FlavouredTea.isDisplayed();
		
	}
	public CheckOutPage clickOnCheckOutLink() {
		CheckOut.click();
		return new CheckOutPage();
	}
	public MenuPage clickOnMenuLink() {
		Menu.click();
		return new MenuPage();
	}
	
}
