package com.PassionTea.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.PassionTea.base.TestBase;

public class CheckOutPage extends TestBase{
	WelcomePage welcomePage ;
	
	//Page Obj or Obj Repo
	@FindBy(id="email")
	WebElement email;
	@FindBy(id="name")
	WebElement name;
	@FindBy(id="address")
	WebElement address;
    //@FindBy(id="card_type")    
	//WebElement Select_card_type;
	@FindBy(id="card_number")
	WebElement cardNumber;
	@FindBy(id="cardholder_name")
	WebElement cardHolderName;
	@FindBy(id="verification_code")
	WebElement verificationCode;
	@FindBy(xpath="//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/div/button")
	WebElement placeOrder;
	@FindBy(xpath="//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/div/a")
	WebElement cancel;
	
	//Initializing of all elements /Page Objects
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	//Input Checkout details
	public String validateCheckOutPageTitle() {
		return driver.getTitle();
	}
	
	public MenuPage clickPlaceOrder() {
		placeOrder.click();
		return new MenuPage();
		
	}
	public void createCheckOut(String email1,String name1,String address1,String card_type1,String cardNo,String cardHName,String cvv) {
		email.clear();name.clear();address.clear();cardNumber.clear();cardHolderName.clear();verificationCode.clear();
		email.sendKeys(email1);
		name.sendKeys(name1);
		address.sendKeys(address1);
		Select select = new Select(driver.findElement(By.id("card_type")));
		select.selectByVisibleText(card_type1);
		cardNumber.sendKeys(cardNo);
		cardHolderName.sendKeys(cardHName);
		verificationCode.sendKeys(cvv);
		placeOrder.click();
		
		//return new MenuPage();
		

	}
	
	
}
