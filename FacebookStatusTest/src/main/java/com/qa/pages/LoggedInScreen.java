package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.BaseClass;

public class LoggedInScreen extends BaseClass {
	
	WebDriver driver;
	
	public LoggedInScreen(WebDriver driver) {
		
		this.driver=driver;
	}
	
	@FindBy(xpath="//div[@className,'linkWrap noCount']")
	WebElement name;
	
	@FindBy(xpath="//div[contains(text(),'News Feed')]")
	WebElement newsFeedLink;
	
	//@FindBy(xpath="//textarea[contains(@name='message')]")
	@FindBy(id="js_8")
	WebElement statusBox;
	
	@FindBy(xpath="//button[contains(.,'Post')]")
	WebElement postBtn;
	
	@FindBy(xpath="//i[@class='img sp_smS1QdUG_pG sx_186835']")
	WebElement cancelBtn;
	
	public String getName() {
		String accName=name.getText();
		return accName;
	}
	
	public void clickNewsFeedLink() {
		newsFeedLink.click();
	}
	
	public void clickonStatusBox() {
		statusBox.click();
	}
	
	public void enterStatusMsg(String text) {
		statusBox.sendKeys(text);
	}
	
	public void clickonPostBtn() {
		postBtn.click();
		try {
			Thread.sleep(5000);
			if(cancelBtn.isDisplayed()) {
				cancelBtn.click();
				Thread.sleep(5000);
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}
