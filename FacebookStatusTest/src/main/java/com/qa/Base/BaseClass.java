package com.qa.Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.pages.NotSignedIn;

public class BaseClass {
	
	public WebDriver driver;
	public Properties props;
	
	
	//NotSignedIn notSignedIn;
	
	public BaseClass() {
		//notSignedIn=new NotSignedIn();
		try {
		props=new Properties();
		String configFile="C:\\Users\\user\\eclipse-workspace\\FacebookStatusTest\\src\\main\\resources\\com\\qa\\config\\config.properties";
		FileInputStream ip=new FileInputStream(configFile);
		props.load(ip);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
		
	
	public void initDriver() {
String browser=props.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			String path=props.getProperty("browserPath");
			System.setProperty("webdriver.chrome.driver", path);
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options );
		}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(props.getProperty("url"));
			
		}
		
		
	@AfterMethod	
	public void tearDown() {
			driver.quit();
		}

}
