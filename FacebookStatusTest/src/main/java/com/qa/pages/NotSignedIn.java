package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.BaseClass;

public class NotSignedIn extends BaseClass {
	
	LoggedInScreen loggedInScreen;
	WebDriver driver;
	
	public NotSignedIn(WebDriver driver) {
		//super();
		//initDriver();
		
		this.driver=driver;
	}
	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(name="login")
	WebElement loginBtn;
	
	public void enterEmailId(String id) {
		emailId.sendKeys(id);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickLoginbutton() {
		
		loginBtn.click();
		try {
			Thread.sleep(5000);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Clicked");
		
	}

}
