package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.Base.BaseClass;

public class NewsFeedScreen extends BaseClass {
	
	WebDriver driver;
	
	public NewsFeedScreen(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//a[@id='u_ps_0_0_d']")
	public WebElement options;
	
	@FindBy(xpath="//span[contains(text(),'Delete')]")
	public WebElement deletePost;
	
	@FindBy(xpath="//button[@class='_42ft _4jy0 layerConfirm uiOverlayButton _4jy3 _4jy1 selected _51sy']")
	public WebElement deleteButton;
	
	public String postDisplayed(String text) {
		WebElement ele=driver.findElement(By.xpath("//p[contains(text(),'"+text+"')]"));
		String statusText;
		
		statusText=ele.getText();
		
		return statusText;
	}
	
	public void clickOptionsonPost() {
		options.click();
	}
	public void clickDeletePost() {
		deletePost.click();
	}
	
	public void clickDeleteButton() {
		deleteButton.click();
	}

}
