package com.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Base.BaseClass;
import com.qa.TestUtils.TestUtils;
import com.qa.pages.LoggedInScreen;
import com.qa.pages.NewsFeedScreen;
import com.qa.pages.NotSignedIn;



public class StatusUploadTest extends BaseClass {
	
	NotSignedIn notSignedIn;
	LoggedInScreen loggedInScreen;
	NewsFeedScreen newsFeedScreen;
	TestUtils testUtils;
	
	
	public StatusUploadTest() {
		super();
		
		
	}

	

	 @BeforeMethod 
	 public void openFacebook() { 
		 initDriver(); }
	 
	@Test
	public void statusUploadSuccess() {
		try {
		notSignedIn=PageFactory.initElements(driver, NotSignedIn.class);
		notSignedIn.enterEmailId(TestUtils.userName);
		notSignedIn.enterPassword(TestUtils.password);
		notSignedIn.clickLoginbutton();
		loggedInScreen=PageFactory.initElements(driver, LoggedInScreen.class);
		//System.out.println(loggedInScreen.getName());
		loggedInScreen.clickNewsFeedLink();
		Thread.sleep(5000);
		loggedInScreen.clickonStatusBox();
		String statusText="Hello World!";
		loggedInScreen.enterStatusMsg(statusText);
		loggedInScreen.clickonPostBtn();
		Thread.sleep(5000);
		newsFeedScreen=PageFactory.initElements(driver, NewsFeedScreen.class);
		if(driver.findElement(By.xpath("//p[contains(text(),'Hello World!')]")).isDisplayed()) {
			String displayedText=newsFeedScreen.postDisplayed(statusText);
			Assert.assertEquals(statusText, displayedText, "Expected and Actual Texts match");
			
		}
		
		newsFeedScreen.clickOptionsonPost();
		newsFeedScreen.clickDeletePost();
		newsFeedScreen.clickDeleteButton();
		}catch(Exception e) {
			
			e.printStackTrace();
			Assert.fail("Status Upload was not successfull");
		}
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
	
	
}
